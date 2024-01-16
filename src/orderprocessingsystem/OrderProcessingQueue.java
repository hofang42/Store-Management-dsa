/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package orderprocessingsystem;

import java.util.Iterator;
import org.w3c.dom.Node;

/**
 *
 * @author hoang
 */
public class OrderProcessingQueue {

    protected OrderDetail head = null, tail = null;
    
    public OrderProcessingQueue() {
        head = tail = null;
    }

    public void enQueue(OrderDetail order) {
        if (isEmpty()) {
            head = tail = new OrderDetail(order.getOrderName(), false);
        } else {
            tail.nextOrder = new OrderDetail(order.getOrderName(), false);
            tail = tail.nextOrder;
        }

    }

    public OrderDetail deQueue() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("No order processing");
        }
        OrderDetail order = head;
        head = head.nextOrder;
        if (head == null) {
            tail = null;
        }
        return order;
    }

    public OrderDetail peek() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("No order processing");
        }
        return head;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        OrderDetail order = head;
        while (order != null) {
            count++;
            order = order.nextOrder;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void processOrder() {
        if (isEmpty()) {
            System.out.println("No order processing");
            return;
        }
        OrderDetail order = peek();
        while (order.isOrderStatus()) {
            order = order.nextOrder;
        }
        order.setOrderStatus(true);        
    }

    public void clearSuccessOrder() {
        if (isEmpty()) {
            System.out.println("No order processing");
            return;
        }
        OrderDetail order = peek();
        while (order != null && order.isOrderStatus() ) {
            deQueue();
            order = order.nextOrder;
        }
    }
    
    public void print() {
        OrderDetail temp = head;
        System.out.printf("%-15s %-10s %-15s%n", "Product name", "|", "Status");
        while (temp != null) {
            System.out.printf("%-15s %-9s  %-15s%n", temp.getOrderName(), "|", temp.getStatusInString());
            temp = temp.nextOrder;
        }
    }

    
}
