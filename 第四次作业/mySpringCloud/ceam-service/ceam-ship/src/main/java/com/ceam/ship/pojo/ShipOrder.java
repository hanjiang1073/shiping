package com.ceam.ship.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("shiporder")
@Data
public class ShipOrder {

    private int id;

    @TableId("shiporderid")
    private int shiporderid;

    private float bill;

    private String positionnow;

    private String positionstart;

    private String positionend;

    public ShipOrder(int id, int shiporderid, float bill, String position_now, String position_start, String position_end) {
        this.id = id;
        this.shiporderid = shiporderid;
        this.bill = bill;
        this.positionnow = position_now;
        this.positionstart = position_start;
        this.positionend = position_end;
    }

    public ShipOrder(int id, String positionstart, String positionend) {
        this.id = id;
        this.positionstart = positionstart;
        this.positionend = positionend;
    }
}
