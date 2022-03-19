package com.shailendra.completeItem.complete.service;

import com.netflix.discovery.EurekaClient;
import com.shailendra.completeItem.complete.dao.item;
import com.shailendra.completeItem.complete.dao.itemInventory;
import com.shailendra.completeItem.complete.entity.completeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class completeItemService {

    private RestTemplate restTemplate;
    private EurekaClient eurekaClient;
    private item Item;
    private itemInventory inventory;
    private completeItem completeitem;

    public completeItemService() {
    }

    @Autowired
    public completeItemService(RestTemplate restTemplate, EurekaClient eurekaClient) {
        this.restTemplate = restTemplate;
        this.eurekaClient = eurekaClient;
    }

    public completeItem getCompleteitemDetails(int itemId){
        Item = getItem(itemId);
        inventory = getInventoryDetails(itemId);
        return completeitem;
    }

    public itemInventory getInventoryDetails(int itemId){

        String url = "http://localhost:8100/itemInventory/"+itemId;
        itemInventory itemInventory1 = restTemplate.getForObject(url,itemInventory.class);
        return itemInventory1;
    }

    public item getItem(int itemId){
        String url = "http://localhost:8100/item/"+itemId;
        item item1 = restTemplate.getForObject(url,item.class);
        return item1;
    }

    public void mapping(item Item, itemInventory inventory){
        this.completeitem.setItemId(Item.getItemId());
        this.completeitem.setDesc(Item.getDescription());
        this.completeitem.setUnitPrice(Item.getUnitPrice());
        this.completeitem.setAvailQty(inventory.getSupplyQty()-inventory.getDemandQty());
    }
}
