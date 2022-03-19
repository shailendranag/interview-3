package com.shailendra.completeItem.complete.dao;


public class itemInventory {

        private int itemId;
        private int supplyQty;
        private int demandQty;

        public itemInventory() {
        }

        public itemInventory(int itemId, int supplyQty, int demandQty) {
            this.itemId = itemId;
            this.supplyQty = supplyQty;
            this.demandQty = demandQty;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public int getSupplyQty() {
            return supplyQty;
        }

        public void setSupplyQty(int supplyQty) {
            this.supplyQty = supplyQty;
        }

        public int getDemandQty() {
            return demandQty;
        }

        public void setDemandQty(int demandQty) {
            this.demandQty = demandQty;
        }


}
