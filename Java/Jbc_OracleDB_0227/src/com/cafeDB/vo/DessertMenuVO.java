package com.cafeDB.vo;

public class DessertMenuVO {
    private int dessertMenuID;
    private String dessertMenuName;
    private int dessertMenuPrice;
    private String dessertMenuCategory;

    public DessertMenuVO(int dessertMenuID, String dessertMenuName, int dessertMenuPrice, String dessertMenuCategory) {
        this.dessertMenuID = dessertMenuID;
        this.dessertMenuName = dessertMenuName;
        this.dessertMenuPrice = dessertMenuPrice;
        this.dessertMenuCategory = dessertMenuCategory;
    }

    public int getDessertMenuID() {
        return dessertMenuID;
    }

    public void setDessertMenuID(int dessertMenuID) {
        this.dessertMenuID = dessertMenuID;
    }

    public String getDessertMenuName() {
        return dessertMenuName;
    }

    public void setDessertMenuName(String dessertMenuName) {
        this.dessertMenuName = dessertMenuName;
    }

    public int getDessertMenuPrice() {
        return dessertMenuPrice;
    }

    public void setDessertMenuPrice(int dessertMenuPrice) {
        this.dessertMenuPrice = dessertMenuPrice;
    }

    public String getDessertMenuCategory() {
        return dessertMenuCategory;
    }

    public void setDessertMenuCategory(String dessertMenuCategory) {
        this.dessertMenuCategory = dessertMenuCategory;
    }
}