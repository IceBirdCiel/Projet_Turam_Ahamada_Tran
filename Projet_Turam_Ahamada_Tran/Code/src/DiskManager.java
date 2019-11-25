package manager;

import java.io.IOException;
import java.io.RandomAccessFile;
public class DiskManager {

	private DiskManager() {
	}
	
	private static DiskManager INSTANCE = new DiskManager();

	public void createFile(int fileIdx) {
		String nomfichier = "Data_"+fileIdx+".rf";
		try { 
			RandomAccessFile rf = new RandomAccessFile(nomfichier,"rw");
			rf.close();
		}
	    catch(IOException e) {e.printStackTrace();}
	}
	
	public PageId addPage(int fileIdx) {
		
		String nomfichier = "Data_"+fileIdx+".rf";
		PageId pageid  = null;
		try { 
			RandomAccessFile rf = new RandomAccessFile(nomfichier,"rw");
		
			long taille = rf.length();
			rf.setLength(taille+ Constants.pageSize);
			// .seek si besoin
			pageid = new PageId(fileIdx,((int)taille/Constants.pageSize)-1);
			rf.close();
		}
	    catch(IOException e) {e.printStackTrace();}
		return pageid;
	}
	
	public void readPage(PageId PageId, byte[] buff) {
		String nomfichier = PageId.getFileName();
		try { 
			RandomAccessFile rf = new RandomAccessFile(nomfichier,"rw");
			for(int i=0;i<buff.length;i++) {
				buff[i] = rf.readByte();
			}
			rf.close();
		}
	    catch(IOException e) {e.printStackTrace();}
	}
	public void writePage(PageId PageId, byte[] buff) {
		String nomfichier = PageId.getFileName();
		try { 
			RandomAccessFile rf = new RandomAccessFile(nomfichier,"rw");
			rf.seek(Constants.pageSize*PageId.getPageIdx());
			rf.write(buff);
			rf.close();
		}
	    catch(IOException e) {e.printStackTrace();}
	}
	public static DiskManager getInstance() {
		return INSTANCE;
	}
}
