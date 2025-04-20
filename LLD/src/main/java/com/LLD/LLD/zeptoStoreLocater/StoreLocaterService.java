package com.LLD.LLD.zeptoStoreLocater;

import com.LLD.LLD.zeptoStoreLocater.warehouseselectionstratergy.MaxInventoryStratergy;
import com.LLD.LLD.zeptoStoreLocater.warehouseselectionstratergy.nearestStoreStratergy;

import java.util.*;

public class StoreLocaterService {
    private Map<String, List<Warehouse>> mp = new HashMap<>();

    private static StoreLocaterService instance = null;

    private WareHouseSelectionStratergy wareHouseSelectionStratergy = null;

    private Random random = new Random();

    private StoreLocaterService() {
        // created users
        User user1 = new User(1, new Cart(new HashMap<>()), new Location(random.nextInt(10), random.nextInt(10)));
        User user2 = new User(2, new Cart(new HashMap<>()), new Location(random.nextInt(10), random.nextInt(10)));

        // created warehouses
        Warehouse warehouse1 = new Warehouse(new Location(random.nextInt(10), random.nextInt(10)), 1, new HashMap<>());
        Warehouse warehouse2 = new Warehouse(new Location(random.nextInt(10), random.nextInt(10)), 2, new HashMap<>());
        Warehouse warehouse3 = new Warehouse(new Location(random.nextInt(10), random.nextInt(10)), 3, new HashMap<>());
        Warehouse warehouse4 = new Warehouse(new Location(random.nextInt(10), random.nextInt(10)), 4, new HashMap<>());

        // create products
        Product product1 = new Product(1, "chips");
        Product product2 = new Product(2, "popcorn");
        Product product3 = new Product(3, "cooldrink");
        Product product4 = new Product(4, "icecream");

        // add products in warehouses
        warehouse1.addProduct(product1, 10);
        warehouse1.addProduct(product2, 10);
        warehouse1.addProduct(product3, 10);
        warehouse1.addProduct(product4, 10);

        warehouse2.addProduct(product1, 2);
        warehouse2.addProduct(product2, 1);
        warehouse2.addProduct(product3, 1);
        warehouse2.addProduct(product4, 3);

        warehouse3.addProduct(product1, 1);
        warehouse3.addProduct(product2, 10);
        warehouse3.addProduct(product3, 6);
        warehouse3.addProduct(product4, 2);

        warehouse4.addProduct(product1, 1);
        warehouse4.addProduct(product2, 20);
        warehouse4.addProduct(product3, 3);
        warehouse4.addProduct(product4, 2);

        // add warehouses to user
        Map<Product, Integer> cartProducts = new HashMap<>();
        cartProducts.put(product1, 1);
        cartProducts.put(product2, 2);
        cartProducts.put(product3, 10);
        cartProducts.put(product4, 3);
        user1.setCart(new Cart(cartProducts));

        // added warehouses to map
        mp.put("BGLR", new ArrayList<>(List.of(warehouse1, warehouse2)));
        mp.put("HYD", new ArrayList<>(List.of(warehouse3)));

        Warehouse nearestWarehouse = findNearestStoreForUser(user1, List.of(warehouse1, warehouse2, warehouse3, warehouse4));
        Warehouse maxInventoryWareHouse = findWareHouseWithMaxItems(user1, List.of(warehouse1, warehouse2, warehouse3, warehouse4));
    }

    private Warehouse findNearestStoreForUser(User user, List<Warehouse> warehouses) {
        wareHouseSelectionStratergy = new nearestStoreStratergy();
        return wareHouseSelectionStratergy.selectWarehouse(user, warehouses);
    }

    private Warehouse findWareHouseWithMaxItems(User user, List<Warehouse> warehouses) {
        wareHouseSelectionStratergy = new MaxInventoryStratergy();
        return wareHouseSelectionStratergy.selectWarehouse(user, warehouses);
    }

    public static StoreLocaterService getInstance() {
        if (instance == null) {
            instance = new StoreLocaterService();
        }
        return instance;
    }

}
