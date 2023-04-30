package org.openapitools.service;

import org.openapitools.model.CreateoderOrder;
import org.openapitools.model.Order;

public interface ShipOrderService {
    public boolean addShipOrder(int id , CreateoderOrder order);
    public boolean findShipOrder(int id, CreateoderOrder order);
}
