package com.shailendra.completeItem.complete.service;

import com.netflix.discovery.EurekaClient;
import com.shailendra.completeItem.complete.dao.item;
import com.shailendra.completeItem.complete.dao.itemInventory;
import com.shailendra.completeItem.complete.entity.completeItem;
import com.shailendra.completeItem.complete.exception.noSupplyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

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
    public completeItemService(RestTemplate restTemplate, EurekaClient eurekaClient , completeItem completeitem) {
        this.restTemplate = restTemplate;
        this.eurekaClient = eurekaClient;
        this.completeitem = completeitem;
    }

    public completeItem getCompleteitemDetails(int itemId) throws Exception {
        //Item = getItem(itemId);
        inventory = getInventoryDetails(itemId);
        Item = getItem(itemId);
        mapping(Item,inventory);
        return completeitem;
    }

    public itemInventory getInventoryDetails(int itemId) {

        String url = "http://localhost:8100/itemInventory/"+itemId;
        itemInventory itemInventoryResponse = restTemplate.getForObject(url,itemInventory.class);
        if(itemInventoryResponse == null)
            throw new IllegalArgumentException("Illegal Argument passed : " + itemInventoryResponse);
        return itemInventoryResponse;
    }

    public item getItem(int itemId){
        String url = "http://localhost:8200/item/"+itemId;
        item itemResponse = restTemplate.getForObject(url,item.class);
        return itemResponse;
    }

    public void mapping(item Item, itemInventory inventory) throws noSupplyException {
        this.completeitem.setItemId(Item.getItemId());
        this.completeitem.setDesc(Item.getDescription());
        this.completeitem.setUnitPrice(Item.getUnitPrice());
        if(inventory.getSupplyQty()-inventory.getDemandQty() < 0 )
            throw new noSupplyException("Demand is greater than Supply");
        this.completeitem.setAvailQty(inventory.getSupplyQty()-inventory.getDemandQty());
    }
}
