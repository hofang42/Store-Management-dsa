/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orderprocessingsystem;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class OnlineShopOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderProcessingQueue queue = new OrderProcessingQueue();
        OrderProcessingQueue doneQueue = new OrderProcessingQueue();        
        while (true) {
            System.out.println("============ONLINE SHOP====================");
            System.out.println("1. Place an orders");
            System.out.println("2. Processing order");
            System.out.println("3. Print out list of order");
            System.out.println("4. Clear success processing order");
            System.out.print("===========================================\nEnter Selection: ");
            int choice = sc.nextInt();
            sc.nextLine();
            String orderName;
            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    orderName = sc.nextLine();
                    queue.enQueue(new OrderDetail(orderName));
                    break;
                case 2:
                    queue.processOrder();
                    break;
                case 3:
                    queue.print();
                    break;
                case 4:
                    queue.clearSuccessOrder();
                    System.out.println("Clear successful !!");
                    break;
            }
        }

    }
}
