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

    public void addProduct(Product product) {
        inventoryList.add(product);
    }

    public List<Product> getInventoryList() {
        return inventoryList;
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
