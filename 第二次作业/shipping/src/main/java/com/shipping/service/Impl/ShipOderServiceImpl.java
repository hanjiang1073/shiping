package com.shipping.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shipping.mapper.ShipOrderMapper;
import com.shipping.pojo.ShipOrder;
import com.shipping.service.ShipOderService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianghan
 */
@Service("shipOrderService")
public class ShipOderServiceImpl extends ServiceImpl<ShipOrderMapper, ShipOrder> implements ShipOderService {

    @Resource
    ShipOrderMapper shipOrderMapper;

    @Override
    public boolean addShipOrder(ShipOrder shipOrder) {

        if(selectShipOrder(shipOrder)){
            return false;
        }
        shipOrderMapper.insert(shipOrder);
        return true;
    }

    @Override
    public boolean selectShipOrder(ShipOrder shipOrder) {
        ShipOrder tempOrder = shipOrderMapper.selectById(shipOrder.getShiporderid());

        System.out.println(tempOrder + "123");

        return tempOrder != null;
    }

    @Override
    public Map<String, Object> getPlaces(int orderID) {
        ShipOrder tempOrder = shipOrderMapper.selectById(orderID);
        Map<String,Object> oderMap = new HashMap<>();
        if(tempOrder == null){
            oderMap.put("msg","查询失败");
        }
        else {
            oderMap.put("msg","查询成功");
            oderMap.put("positionnow", tempOrder.getPositionnow());
        }

        return oderMap;
    }

    @Override
    public float getBill(int orderID) {
        ShipOrder tempOrder = shipOrderMapper.selectById(orderID);
        if(tempOrder == null){
            return -1;
        }
        return tempOrder.getBill();
    }

    @Override
    public boolean checkOrder(int id, int orderID) {
        ShipOrder tempOrder = shipOrderMapper.selectById(orderID);
        if(tempOrder == null){
            return false;
        }
        else {
            if(tempOrder.getId()==id){
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, Object> getAllOrder(int id) {
        QueryWrapper<ShipOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("shiporderid", "positionstart", "positionend");
        queryWrapper.eq("id", id);
        System.out.println("123456");
        List<ShipOrder> list =  shipOrderMapper.selectList(queryWrapper);
        System.out.println(list);
        Map <String, Object>returnMap = new HashMap<>();
        if(list.isEmpty()){
            returnMap.put("msg","没有订单");
            return returnMap;
        }
        returnMap.put("allOrder" , shipOrderMapper.selectList(queryWrapper));
        returnMap.put("msg","查询成功");
        return returnMap;
    }
}
