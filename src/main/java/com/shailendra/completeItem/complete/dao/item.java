package com.shailendra.completeItem.complete.dao;

import javax.persistence.Column;

public class item {

    private int itemId;

    private int unitPrice;

    private String description;

    public item() {
    }

    public item(int itemId, int unitPrice, String description) {
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

