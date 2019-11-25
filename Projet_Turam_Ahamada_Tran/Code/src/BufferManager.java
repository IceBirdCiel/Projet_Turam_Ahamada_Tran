package manager;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BufferManager {

	private Frame[] frames = new Frame[Constants.frameCount];
	
	private BufferManager() {
	}
	
	private static BufferManager INSTANCE = new BufferManager();

	public static BufferManager getInstance(){
		return INSTANCE;
	}

	public byte[] getPage(PageId pageId) {
		byte[] buff = new byte[(int)Constants.pageSize];
		boolean modifie = false;
		for (int i=0; (i<frames.length);i++){
			if(frames[i].getPageId()==null){
				frames[i].setPinCount(frames[i].getPinCount() + 1);
				DiskManager.getInstance().ReadPage(pageId,buff);
				frames[i].setBuff(buff);
				frames[i].setPageId(pageId);
				modifie = true;
			}

			if(frames[i].getPageId()==pageId){
				frames[i].setPinCount(frames[i].getPinCount() + 1);
				modifie = true;
			}
		}
		if(modifie){
			// faire la clock ou lru mdr

		}
		return buff;
	}

	public void freePage(PageId pageId,boolean valdirty) {

		for (int i=0; (i<frames.length);i++) {
			if (pageId.getPageIdx() == frames[i].getPageId().getPageIdx()) {
				if (valdirty) {
					frames[i].setPinCount(frames[i].getPinCount()-1);
					frames[i].setFlagDirty(true);
				}
				else {
					frames[i].setPinCount(frames[i].getPinCount()-1);
				}

			}
		}
	}
	
	public void flushAll() {
		for(int i = 0; i<frames.length; i++)
		{
			if(!frames[i].isFlagDirty()) {
				frames[i].setPinCount(0);
				frames[i].setFlagDirty(true);
				frames[i].setBuff(null);
			}
		}
	}
}