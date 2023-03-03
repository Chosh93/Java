package com.cafeDB.vo;

public class BasketMenuVO {
    private int basketId;
    private String basketName;
    private String basketOption;

    public BasketMenuVO(int basketId, String basketName, String basketOption) {
        this.basketId = basketId;
        this.basketName = basketName;
        this.basketOption = basketOption;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public String getBasketName() {
        return basketName;
    }

    public void setBasketName(String basketName) {
        this.basketName = basketName;
    }

    public String getBasketOption() {
        return basketOption;
    }

    public void setBasketOption(String basketOption) {
        this.basketOption = basketOption;
    }
}
