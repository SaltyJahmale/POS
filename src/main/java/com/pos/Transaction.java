package com.pos;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by dewi on 19.09.16.
 */
public abstract class Transaction {
    Inventory inventory = Inventory.getTheInventory();
    TransactionType transactionType;

    public Product searchProductDigitcode(String digitcode) {
        for (Product product : inventory.getInventoryList()) {
            if (product.getDigitcode().equals(digitcode)) {
                return product;
            }
        }
        return null;
    }

}

class Sale extends Transaction {

    public Sale() {
        transactionType = TransactionType.SALE;
        System.out.println(transactionType);
    }

    public void addProduct(Product product) {
        inventory.getInventoryList().add(product);
    }

}

class Refund extends Transaction {

    public Refund() {
        transactionType = TransactionType.REFUND;
        System.out.println(transactionType);
    }

    public void refundProduct(Product product) {
        inventory.getInventoryList().remove(product);
    }

}

class Reservation extends Transaction {

    private double sum;
    private double totalPayment;
    private double advancePayment;
    private Map<Customer, Product> reservedProduct = new HashMap<>();


    public Reservation() {
        transactionType = TransactionType.RESERVATION;
        System.out.println(transactionType);
    }

    public double reserveProduct(Product product) {

        if (product.getPrice() > 25) {

            totalPayment = product.getPrice();
            advancePayment = product.getPrice() * 0.1;

            sum = totalPayment - advancePayment;
//           TODO: reserved = true;
        }
        return sum;
    }

    public void setMap(Map reservedProduct) {
        this.reservedProduct = reservedProduct;
    }


    public void reservateProduct(Customer customer, Product product ) {
        reservedProduct.put(customer, product);
    }
}

