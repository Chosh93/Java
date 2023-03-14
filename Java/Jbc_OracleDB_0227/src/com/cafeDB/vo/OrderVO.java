package com.cafeDB.vo;

public class OrderVO {
    private int orderId;
    private String orderDate;
    private String menuName;
    private int menuPrice;
    private String opName;
    private int opPrice;
    private int orderQuantity;
    private int totalPrice;

    public OrderVO(int orderId, String orderDate, String menuName, int menuPrice, String opName, int opPrice, int orderQuantity, int totalPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.opName = opName;
        this.opPrice = opPrice;
        this.orderQuantity = orderQuantity;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public int getOpPrice() {
        return opPrice;
    }

    public void setOpPrice(int opPrice) {
        this.opPrice = opPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}