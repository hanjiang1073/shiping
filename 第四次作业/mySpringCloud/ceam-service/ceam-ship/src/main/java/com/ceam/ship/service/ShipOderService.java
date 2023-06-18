package com.ceam.ship.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.ship.pojo.ShipOrder;

import java.util.Map;

/**
 * @author jianghan
 */
public interface ShipOderService extends IService<ShipOrder> {

    boolean addShipOrder(ShipOrder shipOrder);

    boolean selectShipOrder(ShipOrder shipOrder);

    Map<String,Object> getPlaces(int orderID);

    float getBill(int orderID);

    boolean checkOrder(int id, int orderID);

    Map<String,Object> getAllOrder(int id);

}
