package cafeDB.vo;

public class MenuVO {
    private int menuId;
    private String menuName;
    private int menuPrice;
    private String menuCategory;
    private String menuSel;

    public MenuVO(int menuId, String menuName, int menuPrice, String menuCategory, String menuSel) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCategory = menuCategory;
        this.menuSel = menuSel;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public String getMenuSel() {
        return menuSel;
    }

    public void setMenuSel(String menuSel) {
        this.menuSel = menuSel;
    }
}
