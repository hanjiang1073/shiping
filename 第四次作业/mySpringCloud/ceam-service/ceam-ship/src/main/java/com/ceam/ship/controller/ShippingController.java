package com.ceam.ship.controller;

import com.ceam.ship.config.myJwt.JwtUtils;
import com.ceam.ship.pojo.ShipOrder;
import com.ceam.ship.producer.ShipProducer;
import com.ceam.ship.service.ShipOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jianghan
 */
@RestController
@RequestMapping("/ShipOrder")
public class ShippingController {

    @Resource
    ShipOderService shipOderService;

    @Autowired
    ShipProducer shipProducer;

    @PostMapping("/createOrder")
    public Map<String, Object> addOrder(@RequestBody  Map<String,Object>map, @RequestHeader("Authorization") String token){

        String str = JwtUtils.getUsernameFromToken(token);
        int id = Integer.parseInt(str);
        System.out.println(map);
        ShipOrder shipOrder = new ShipOrder(id, (String) map.get("positionstart"),(String) map.get("positionend"));
        System.out.println(shipOrder);

        boolean result = false;

        while (!result){
            shipOrder.setShiporderid(ThreadLocalRandom.current().nextInt(10000, 99999 + 1));
            shipOrder.setBill(ThreadLocalRandom.current().nextFloat()+
                    ThreadLocalRandom.current().nextInt(0, 1000 + 1) );
            result = shipOderService.addShipOrder(shipOrder);
        }

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("msg","添加成功");
        returnMap.put("bill", shipOrder.getBill());
        returnMap.put("shiporderid", shipOrder.getShiporderid());

        return returnMap;
    }


    @PostMapping("/retrieveBill")
    public Map<String, Object> selectOrder(@RequestBody  Map<String,Object>map, @RequestHeader("Authorization") String token){

        System.out.println("156");
        System.out.println(map);
        System.out.println(map.get("shiporderid"));
        int shipOrderID = (int) map.get("shiporderid");
        String str = JwtUtils.getUsernameFromToken(token);
        int id = Integer.parseInt(str);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("shiporderid",shipOrderID);
        if(!shipOderService.checkOrder(id, shipOrderID)){
             returnMap.put("msg","查询失败");
        }
        else {
            returnMap.put("msg","查询成功");
            returnMap.put("bill",shipOderService.getBill(shipOrderID));
        }
        return returnMap;
    }


    @PostMapping("/tracking")
    public Map<String, Object> trackingShipment(@RequestBody Map<String,Object>map, @RequestHeader("Authorization") String token){
        System.out.println(map);
        int shipOrderID = (int) map.get("shiporderid");
        String str = JwtUtils.getUsernameFromToken(token);
        int id = Integer.parseInt(str);
        Map<String,Object> returnmap = new HashMap<>();

        if(!shipOderService.checkOrder(id, shipOrderID)){
            returnmap.put("msg","不匹配") ;
        }
        else {
            returnmap.put("msg","匹配") ;
            returnmap.put("result",shipOderService.getPlaces(shipOrderID));
        }


        return returnmap;
    }

    @GetMapping ("/getOrders")
    public Map<String, Object> gerOrders(@RequestHeader("Authorization") String token){
        String str = JwtUtils.getUsernameFromToken(token);
        int id = Integer.parseInt(str);

        System.out.println("id="+id);
        return shipOderService.getAllOrder(id);
    }



}
