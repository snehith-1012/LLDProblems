package com.LLD.LLD.zeptoStoreLocater;

import com.LLD.LLD.zeptoStoreLocater.Warehouse;

import java.util.List;

public interface WareHouseSelectionStratergy {

    Warehouse selectWarehouse(User user, List<Warehouse> wareHouses);
}
