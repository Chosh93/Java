package cafeDB.vo;

public class AdeMenuVO {
    private int adeMenuId;
    private String adeMenuName;
    private int adeMenuPrice;
    private String adeMenuCategory;

    public AdeMenuVO(int adeMenuId, String adeMenuName, int adeMenuPrice, String adeMenuCategory) {
        this.adeMenuId = adeMenuId;
        this.adeMenuName = adeMenuName;
        this.adeMenuPrice = adeMenuPrice;
        this.adeMenuCategory = adeMenuCategory;
    }

    public int getAdeMenuId() {
        return adeMenuId;
    }

    public void setAdeMenuId(int adeMenuId) {
        this.adeMenuId = adeMenuId;
    }

    public String getAdeMenuName() {
        return adeMenuName;
    }

    public void setAdeMenuName(String adeMenuName) {
        this.adeMenuName = adeMenuName;
    }

    public int getAdeMenuPrice() {
        return adeMenuPrice;
    }

    public void setAdeMenuPrice(int adeMenuPrice) {
        this.adeMenuPrice = adeMenuPrice;
    }

    public String getAdeMenuCategory() {
        return adeMenuCategory;
    }

    public void setAdeMenuCategory(String adeMenuCategory) {
        this.adeMenuCategory = adeMenuCategory;
    }
}