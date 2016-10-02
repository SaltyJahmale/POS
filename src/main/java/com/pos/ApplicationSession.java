package com.pos;

import javax.xml.crypto.dsig.TransformService;

/**
 * Created by Bogust on 25-9-2016.
 */
public class ApplicationSession  {

    Inventory inventory = Inventory.getTheInventory();

    public void createReceit(Product product, Employee employee) {
        Sale sale = new Sale();
        sale.addProduct(product);
        System.out.println(inventory.getInventoryList());
        System.out.println("You have been helped by " + employee);
    }

    public void createRefund(Product product) {
        Refund refund = new Refund();
        refund.refundProduct(product);
    }

    public void createReservation(Product product, Customer customer) {
        
    }
}
