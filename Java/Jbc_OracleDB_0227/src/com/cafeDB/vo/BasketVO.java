package com.cafeDB.vo;

public class BasketVO {
    private String menuName;
    private int menuprice;
    private String optionName;
    private int opPrice;
    private int menuCnt;
    private int totalPrice;

    public BasketVO(String menuName, int menuprice, String optionName, int opPrice, int menuCnt, int totalPrice) {
        this.menuName = menuName;
        this.menuprice = menuprice;
        this.optionName = optionName;
        this.opPrice = opPrice;
        this.menuCnt = menuCnt;
        this.totalPrice = totalPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuprice() {
        return menuprice;
    }

    public void setMenuprice(int menuprice) {
        this.menuprice = menuprice;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOpPrice() {
        return opPrice;
    }

    public void setOpPrice(int opPrice) {
        this.opPrice = opPrice;
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