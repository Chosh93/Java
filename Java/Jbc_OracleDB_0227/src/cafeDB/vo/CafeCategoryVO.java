package cafeDB.vo;

public class CafeCategoryVO {
    private int categoryNo;
    private String categoryName;

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CafeCategoryVO(int categoryNo, String categoryName) {
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
    }
}