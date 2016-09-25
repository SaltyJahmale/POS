package com.pos;

import java.util.Scanner;

/**
 * Created by dewi on 19.09.16.
 */
public class Main {

    public static void main(String[] args) {

        Inventory inventory = Inventory.getTheInventory();
        System.out.println("This is the reservation menu.");
        System.out.println("Please enter one of the following options to start a transaction.");
        System.out.println("'SALE', 'REFUND', 'RESERVATION'");

        Scanner in = new Scanner(System.in);
        String ads = in.nextLine();
        switch(ads) {
            case "SALE":

                System.out.println("The search result with the digitcode 4567 \n" + inventory.searchProductDigitcode("4567"));

                break;
            case "REFUND":

                ProductSpec productSpec3 = new ProductSpec("Spa Blue", "Finest mineral water");
                Product product3 = new Product("0123", 12.50, productSpec3);
                System.out.println("Product in the receipt\n" + product3);

                ProductSpec productSpec4 = new ProductSpec("Coca Cola", "Best refreshment drink");
                Product product4 = new Product("4567", 25.25, productSpec4);
                System.out.println("Product in the receipt\n" + product4);
                System.out.println("");

                System.out.println("Refunding the product with the digit number 4567");
                System.out.println("");

                System.out.println("The search result with the digitcode 4567 \n" + inventory.searchProductDigitcode("4567"));

                break;
            case "RESERVATION":
                Customer customer = new Customer("0123", "Marti");

                ProductSpec productSpec5 = new ProductSpec("Spa Blue", "Finest mineral water");
                Product product5 = new Product("0123", 12.50, productSpec5);
                System.out.println("Product in the receipt\n" + product5);

                ProductSpec productSpec6 = new ProductSpec("Coca Cola", "Best refreshment drink");
                Product product6 = new Product("4567", 25.25, productSpec6);
                System.out.println("Product in the receipt\n" + product6);
                System.out.println("");

                break;
            default:
                System.out.println("Please enter one of the three opnions 'SALE', 'REFUND', 'RESERVATION' ");;
        }

    }
    public static void initializeInventory(Inventory inventory) {

        ProductSpec productSpec = new ProductSpec("Spa Blue", "Finest mineral water");
        Product product = new Product("0123", 12.50, productSpec);

        ProductSpec productSpec1 = new ProductSpec("Coca Cola", "Best refreshment drink");
        Product product1 = new Product("4567", 25.25, productSpec1);

        inventory.addProduct(product);
        inventory.addProduct(product1);

    }

}
