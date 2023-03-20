package cafeDB.vo;

public class OrderVO {
    private int orderId;
    private String orderDate;
    private int customerId;
    private String customerName;
    private String orderName;
    private int orderPrice;
    private String optionName;
    private int optionPrice;
    private int orderCnt;
    private int totalPrice;
    private String payment;
    private int csPoint;

    public OrderVO(int orderId, String orderDate, int customerId, String customerName, String orderName, int orderPrice, String optionName, int optionPrice, int orderCnt, int totalPrice, String payment, int csPoint) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        this.orderCnt = orderCnt;
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.csPoint = csPoint;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
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

    public int getOrderCnt() {
        return orderCnt;
    }

    public void setOrderCnt(int orderCnt) {
        this.orderCnt = orderCnt;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getCsPoint() {
        return csPoint;
    }

    public void setCsPoint(int csPoint) {
        this.csPoint = csPoint;
    }
}
