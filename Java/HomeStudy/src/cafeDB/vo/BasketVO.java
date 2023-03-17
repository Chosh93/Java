package cafeDB.vo;

public class BasketVO {
    private int basketid;
    private String menuName;
    private int menuPrice;
    private String optionName;
    private int optionPrice;
    private int menuCnt;
    private int totalPrice;

    public BasketVO(int basketid, String menuName, int menuPrice, String optionName, int optionPrice, int menuCnt, int totalPrice) {
        this.basketid = basketid;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        this.menuCnt = menuCnt;
        this.totalPrice = totalPrice;
    }

    public int getBasketid() {
        return basketid;
    }

    public void setBasketid(int basketid) {
        this.basketid = basketid;
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

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(int optionPrice) {
        this.optionPrice = optionPrice;
    }

    public int getMenuCnt() {
        return menuCnt;
    }

    public void setMenuCnt(int menuCnt) {
        this.menuCnt = menuCnt;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
