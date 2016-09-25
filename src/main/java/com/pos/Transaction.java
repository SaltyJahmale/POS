package com.pos;

import java.util.Map;


/**
 * Created by dewi on 19.09.16.
 */
public abstract class Transaction {
    Inventory inventory = Inventory.getTheInventory();
    TransactionType transactionType;

    public void addProduct(Product product) {
        inventory.addProduct(product);
    }

    public void refundProduct(Product product) {
        inventory.refundProduct(product);
    }
}

class Sale extends Transaction {

    public Sale() {

        transactionType = TransactionType.SALE;
    }

}

class Refund extends Transaction {

    public Refund() {
        transactionType = TransactionType.REFUND;
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

