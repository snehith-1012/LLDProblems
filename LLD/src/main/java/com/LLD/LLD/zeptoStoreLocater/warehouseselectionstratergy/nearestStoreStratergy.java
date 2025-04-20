package com.LLD.LLD.zeptoStoreLocater.warehouseselectionstratergy;

import com.LLD.LLD.zeptoStoreLocater.Location;
import com.LLD.LLD.zeptoStoreLocater.User;
import com.LLD.LLD.zeptoStoreLocater.WareHouseSelectionStratergy;
import com.LLD.LLD.zeptoStoreLocater.Warehouse;

import java.util.List;

public class nearestStoreStratergy implements WareHouseSelectionStratergy {
    @Override
    public Warehouse selectWarehouse(User user, List<Warehouse> wareHouses) {
        int nearestDistance = Integer.MAX_VALUE;
        Warehouse nearestWarehouse = null;
        for (Warehouse warehouse : wareHouses) {
            int distance = getDistance(warehouse.getLocation(), user.getLocation());
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestWarehouse = warehouse;
            }
        }
        return nearestWarehouse;
    }

    private int getDistance(Location loc1, Location loc2) {
        return Math.abs(loc1.getLatitude() - loc2.getLatitude()) + Math.abs(loc2.getLongitude() - loc1.getLongitude());
    }
}
