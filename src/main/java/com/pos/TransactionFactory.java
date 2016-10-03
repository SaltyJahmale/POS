package com.pos;

/**
 * Created by dewi on 03.10.16.
 */
public class TransactionFactory {

    public Sale getSalesTransaction() {
        return new Sale();
    }

    public Reservation getReservationTransaction() {
        return new Reservation();
    }

    public Refund getRefundTransaction() {
        return new Refund();
    }

}
