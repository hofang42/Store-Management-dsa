/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orderprocessingsystem;

/**
 *
 * @author hoang
 */
public class OrderDetail {

    protected String orderName;
    protected boolean orderStatus;
    protected OrderDetail nextOrder;

    public OrderDetail() {
    }

    public OrderDetail(String orderName) {
        this.orderName = orderName;
    }

    public OrderDetail(String orderName, boolean orderStatus) {
        this.orderName = orderName;
        this.orderStatus = orderStatus;
    }

    public OrderDetail(String orderName, boolean orderStatus, OrderDetail nextOrder) {
        this.orderName = orderName;
        this.orderStatus = orderStatus;
        this.nextOrder = nextOrder;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderDetail getNextOrder() {
        return nextOrder;
    }

    public void setNextOrder(OrderDetail nextOrder) {
        this.nextOrder = nextOrder;
    }

    public String getStatusInString() {
        String statusStr = "";
        if (isOrderStatus() == true) {
            statusStr = "Done";
        }
        if (isOrderStatus() == false) {
            statusStr = "Pending";
        }
        return statusStr;
    }

    @Override
    public String toString() {
        System.out.printf("%-15s %-10s %-15s%n", "Product name", "|", "Status");
        return String.format("%-15s %-9s  %-15s%n", orderName, "|", getStatusInString());
    }

}
