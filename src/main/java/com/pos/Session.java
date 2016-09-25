package com.pos;

/**
 * Created by dewi on 20.09.16.
 */
public interface Session {
    //TODO: Mediator

    void createReceit(Product product, Employee employee);
    void createRefund(Product product);
    void createReservation(Product product, Customer customer);

}
