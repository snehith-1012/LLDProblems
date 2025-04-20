package com.LLD.LLD.zeptoStoreLocater.warehouseselectionstratergy;

import com.LLD.LLD.zeptoStoreLocater.Product;
import com.LLD.LLD.zeptoStoreLocater.User;
import com.LLD.LLD.zeptoStoreLocater.WareHouseSelectionStratergy;
import com.LLD.LLD.zeptoStoreLocater.Warehouse;

import java.util.List;
import java.util.Map;

public class MaxInventoryStratergy implements WareHouseSelectionStratergy {
    @Override
    public Warehouse selectWarehouse(User user, List<Warehouse> wareHouses) {
        Warehouse requiredWarehouse = null;
        Map<Product, Integer> cartProducts = user.getCart().getProducts();
        for (Warehouse warehouse : wareHouses) {
            boolean eligible = true;
            for (Product product : cartProducts.keySet()) {
                if (!warehouse.getProducts().containsKey(product) || (warehouse.getProducts().containsKey(product) && warehouse.getProducts().get(product) < cartProducts.get(product))) {
                    eligible = false;
                    break;
                }
            }
            if (eligible) {
                requiredWarehouse = warehouse;
            }
        }
        return requiredWarehouse;
    }
}
