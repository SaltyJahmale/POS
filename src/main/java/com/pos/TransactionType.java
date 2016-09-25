package com.pos;

/**
 * Created by dewi on 21.09.16.
 */
public enum TransactionType {

    SALE, REFUND, RESERVATION;

    public String typeOfTransaction() {
        switch (this) {
            case SALE:
                return "SALE";
            case REFUND:
                return "REFUND";
            case RESERVATION:
                return "RESERVATION";
            default:
                return "UNKNOWN TRANSACTION TYPE";
        }
    }
}
