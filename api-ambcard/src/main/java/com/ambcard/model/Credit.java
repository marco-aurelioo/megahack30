package com.ambcard.model;

import java.util.UUID;

public class Credit {

    private double value;
    private UUID storeId;
    private UUID walletId;

    public Credit(UUID walletId,double value){
        this.walletId = walletId;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public UUID getStoreId() {
        return storeId;
    }

    public void setStoreId(UUID storeId) {
        this.storeId = storeId;
    }

    public UUID getWalletId() {
        return walletId;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }
}
