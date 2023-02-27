package cafeDB.vo;

public class CafeMenuVO {
    private int cafeMenuNo;
    private String cafeMenuName;
    private int cafeMenuPrice;
    private String cafeMenuCategory;

    public CafeMenuVO(int cafeMenuNo, String cafeMenuName, int cafeMenuPrice, String cafeMenuCategory) {
        this.cafeMenuNo = cafeMenuNo;
        this.cafeMenuName = cafeMenuName;
        this.cafeMenuPrice = cafeMenuPrice;
        this.cafeMenuCategory = cafeMenuCategory;
    }

    public int getCafeMenuNo() {
        return cafeMenuNo;
    }

    public void setCafeMenuNo(int cafeMenuNo) {
        this.cafeMenuNo = cafeMenuNo;
    }

    public String getCafeMenuName() {
        return cafeMenuName;
    }

    public void setCafeMenuName(String cafeMenuName) {
        this.cafeMenuName = cafeMenuName;
    }

    public int getCafeMenuPrice() {
        return cafeMenuPrice;
    }

    public void setCafeMenuPrice(int cafeMenuPrice) {
        this.cafeMenuPrice = cafeMenuPrice;
    }

    public String getCafeMenuCategory() {
        return cafeMenuCategory;
    }

    public void setCafeMenuCategory(String cafeMenuCategory) {
        this.cafeMenuCategory = cafeMenuCategory;
    }
}
