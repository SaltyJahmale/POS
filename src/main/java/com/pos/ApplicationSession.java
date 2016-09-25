package com.pos;

/**
 * Created by Bogust on 25-9-2016.
 */
public class ApplicationSession implements Session {

    Inventory inventory = Inventory.getTheInventory();

    @Override
    public void createReceit(Product product, Employee employee) {
        inventory.addProduct(product);
        System.out.println(inventory.getInventoryList());
        System.out.println("You have been helped by " + employee);
    }

    @Override
    public void createRefund(Product product) {
        inventory.refundProduct(product);
    }

    @Override
    public void createReservation(Product product, Customer customer) {

    }
}
