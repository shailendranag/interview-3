package com.shailendra.completeItem.complete.controller;

import com.shailendra.completeItem.complete.entity.completeItem;
import com.shailendra.completeItem.complete.service.completeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemCompleteDetails")
public class completeItemController {

    private completeItemService completeItemService;

    @Autowired
    public completeItemController(completeItemService completeItemService) {
        this.completeItemService = completeItemService;
    }

    @GetMapping("/{itemId}")
    public completeItem getcompleteDetails(@PathVariable int itemId){
        return completeItemService.getCompleteitemDetails(itemId);
    }
}
