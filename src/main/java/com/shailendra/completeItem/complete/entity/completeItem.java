package com.shailendra.completeItem.complete.entity;

import org.springframework.stereotype.Component;

@Component
public class completeItem {

    private int itemId;

    private int availQty;

    private int unitPrice;

    private String desc;

    public completeItem() {
    }

    public completeItem(int itemId, int availQty, int unitPrice, String desc) {
        this.itemId = itemId;
        this.availQty = availQty;
        this.unitPrice = unitPrice;
        this.desc = desc;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getAvailQty() {
        return availQty;
    }

    public void setAvailQty(int availQty) {
        this.availQty = availQty;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
