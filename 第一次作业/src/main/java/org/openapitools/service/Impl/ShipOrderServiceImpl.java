package org.openapitools.service.Impl;

import org.openapitools.model.CreateoderOrder;
import org.openapitools.model.Order;
import org.openapitools.service.ShipOrderService;
import org.springframework.stereotype.Service;

@Service
public class ShipOrderServiceImpl implements ShipOrderService {

    @Override
    public boolean addShipOrder(int id , CreateoderOrder order){
        if(findShipOrder(id, order)){
            return true;
        }
        return false;
    }

    @Override
    public boolean findShipOrder(int id, CreateoderOrder order) {
        if(id>3500){
            return false;
        }
        return true;
    }

    ;
}
