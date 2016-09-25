package com.pos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dewi on 20.09.16.
 */
public class Inventory {

    private static Inventory inventory;
    private List<Product> inventoryList = new ArrayList();

    private Inventory() {}

    public static Inventory getTheInventory() {
            if(inventory == null) {
                inventory = new Inventory();
                Main.initializeInventory(inventory);
            }
            return inventory;
    }

    public boolean addProduct(Product product) {
        inventoryList.add(product);
        return true;
    }


    public void refundProduct(Product product) {
        inventoryList.remove(product);
    }

    public Product searchProductDigitcode(String digicode) {
        for (Product product : inventoryList) {
            if (product.getDigitcode().equals(digicode)) {
                return product;
            }
        }
        return null;
    }

}
