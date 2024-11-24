public class PageFrame {
    private final int pageNumber;
    private boolean referenceBit;

    public PageFrame(int pageNumber) {
        this.pageNumber = pageNumber;
        this.referenceBit = true; // За замовчуванням активний
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public boolean isReferenced() {
        return referenceBit;
    }

    public void setReferenced(boolean referenced) {
        this.referenceBit = referenced;
    }
}
