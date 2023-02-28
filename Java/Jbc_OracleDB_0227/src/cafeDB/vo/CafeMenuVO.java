package cafeDB.vo;

public class CafeMenuVO {
    private String cafeMenuName;
    private int cafeMenuPrice;
    private String cafeMenuCategory;

    public CafeMenuVO(String cafeMenuName, int cafeMenuPrice, String cafeMenuCategory) {
        this.cafeMenuName = cafeMenuName;
        this.cafeMenuPrice = cafeMenuPrice;
        this.cafeMenuCategory = cafeMenuCategory;
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
