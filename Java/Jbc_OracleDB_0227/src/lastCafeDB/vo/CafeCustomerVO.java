package lastCafeDB.vo;

public class CafeCustomerVO {
    private int customerId;
    private String customerName;
    private String customerPhone;
    private int customerMil;

    public CafeCustomerVO(int customerId, String customerName, String customerPhone, int customerMil) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerMil = customerMil;
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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getCustomerMil() {
        return customerMil;
    }

    public void setCustomerMil(int customerMil) {
        this.customerMil = customerMil;
    }
}
