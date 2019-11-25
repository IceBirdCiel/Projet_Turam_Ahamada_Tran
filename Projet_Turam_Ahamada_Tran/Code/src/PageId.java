
public class PageId {
	private long FileIdx;
	private long PageIdx;
	private long pinCount = 0;
	private long flagDirty = 0;
	
	
	public PageId(long FileIdx,long PageIdx) {
		this.PageIdx = PageIdx;
		this.FileIdx = FileIdx;
	}

	public long getFlagDirty() {
		return flagDirty;
	}

	public void setFlagDirty(long flagDirty) {
		this.flagDirty = flagDirty;
	}

	public long getPinCount() {
		return pinCount;
	}

	public void setPinCount(long pinCount) {
		this.pinCount = pinCount;
	}

	public long getFileIdx() {
		return FileIdx;
	}

	public String getFileName() {
		String nomfichier = "Data_"+FileIdx+".rf";
		return nomfichier;
	}
	
	public void setFileIdx(long fileIdx) {
		FileIdx = fileIdx;
	}

	public long getPageIdx() {
		return PageIdx;
	}

	public void setPageIdx(long pageIdx) {
		PageIdx = pageIdx;
	}

	public void setPageIdx(int pageIdx) {
		PageIdx = pageIdx;
	}
	
	public void setFileIdx(int fileIdx) {
		FileIdx = fileIdx;
	}
}