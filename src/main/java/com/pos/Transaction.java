package com.pos;

import java.util.Map;


/**
 * Created by dewi on 19.09.16.
 */
public abstract class Transaction {
    Inventory inventory = Inventory.getTheInventory();
    TransactionType transactionType;

    public Product searchProductDigitcode(String digicode) {
        for (Product product : inventory.getInventoryList()) {
            if (product.getDigitcode().equals(digicode)) {
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
    private boolean reserved = false;
    protected Map<Product, Double> reservedProduct;


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

    public void reservateProduct(Product product, Double price ) {
        reservedProduct.put(product, price);
    }

}

