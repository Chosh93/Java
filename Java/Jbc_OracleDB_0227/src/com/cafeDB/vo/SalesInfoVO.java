package com.cafeDB.vo;


public class SalesInfoVO {
    private String orderDate;
    private int totoalCount;
    private int sales;

    public SalesInfoVO(String orderDate, int totoalCount, int sales) {
        this.orderDate = orderDate;
        this.totoalCount = totoalCount;
        this.sales = sales;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotoalCount() {
        return totoalCount;
    }

    public void setTotoalCount(int totoalCount) {
        this.totoalCount = totoalCount;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}