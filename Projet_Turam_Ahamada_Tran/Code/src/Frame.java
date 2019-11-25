package manager;

public class Frame {

    private int pinCount = 0;
    private boolean flagDirty = false;
    private byte[] buff = new byte[(int)Constants.pageSize];
    private PageId pageId = null;

    public int getPinCount() {
        return pinCount;
    }

    public void setPinCount(int pinCount) {
        this.pinCount = pinCount;
    }

    public boolean isFlagDirty() {
        return flagDirty;
    }

    public void setFlagDirty(boolean flagDirty) {
        this.flagDirty = flagDirty;
    }

    public byte[] getBuff() {
        return buff;
    }

    public void setBuff(byte[] buff) {
        this.buff = buff;
    }

    public PageId getPageId() {
        return pageId;
    }

    public void setPageId(PageId pageId) {
        this.pageId = pageId;
    }
}
