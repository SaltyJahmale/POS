package com.pos;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by dewi on 19.09.16.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationSession applicationSession = new ApplicationSession();
        Inventory inventory = Inventory.getTheInventory();
        Transaction transaction = new Sale();

        System.out.println("This is the reservation menu.");
        System.out.println("Please enter one of the following options to start a transaction.");
        System.out.println("'SALE', 'REFUND', 'RESERVATION'");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        switch(input) {
            case "SALE":

                Employee employee = new Employee("Marin", 12);

                ProductSpec productSpec1 = new ProductSpec("Fanta", "Best refreshment drink");
                Product product2 = new Product("89012", 25.25, productSpec1);

                applicationSession.createReceit(product2, employee);

                System.out.println("The search result with the digitcode 4567 \n" + transaction.searchProductDigitcode("4567"));

                break;
            case "REFUND":

                System.out.println("Refunding the product with the digit number 4567");
                System.out.println("");

                ProductSpec productSpec3 = new ProductSpec("Tonic", "Water refreshment drink");
                Product product3 = new Product("8912", 25.25, productSpec3);
                inventory.getInventoryList().add(product3);

                System.out.println("The inventory before " + inventory.getInventoryList());

                applicationSession.createRefund(product3);
                System.out.println("The inventory after " + inventory.getInventoryList());
                System.out.println("The search result with the digitcode 8912 \n" + transaction.searchProductDigitcode("8912"));

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
                System.out.println("Please enter one of the three opnions 'SALE', 'REFUND', 'RESERVATION' ");
        }

    }
    public static void initializeInventory(Inventory inventory) {

        ProductSpec productSpec = new ProductSpec("Spa Blue", "Finest mineral water");
        Product product = new Product("0123", 12.50, productSpec);

        ProductSpec productSpec1 = new ProductSpec("Coca Cola", "Best refreshment drink");
        Product product1 = new Product("4567", 25.25, productSpec1);

        inventory.getInventoryList().add(product);
        inventory.getInventoryList().add(product1);

    }

}
