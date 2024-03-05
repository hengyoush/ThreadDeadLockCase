package cloud.deadlock.order.entity;

import java.util.List;

public class OrderNotifyRequest {
    private List<String> orderNo;
    private String orderStatus;
    private String orderType;
    private long orderTime;
    private String orderDesc;
    private String orderRemark;
    private double  orderAmount;
    private String orderCurrency;
    private String orderNotifyUrl;


    public List<String> getOrderNoList() {
        return orderNo;
    }

    public void setOrderNo(List<String> orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public String getOrderNotifyUrl() {
        return orderNotifyUrl;
    }

    public void setOrderNotifyUrl(String orderNotifyUrl) {
        this.orderNotifyUrl = orderNotifyUrl;
    }
}
