package com.ambcard.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name="transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="uuid-char")
    private UUID id;

    private double value;
    private TYPE_TRANSACTION type;

    @Type(type="uuid-char")
    private UUID storeId;

    @Type(type="uuid-char")
    private UUID walletId;

    private Date data;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public TYPE_TRANSACTION getType() {
        return type;
    }

    public void setType(TYPE_TRANSACTION type) {
        this.type = type;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @PrePersist
    public void ajustsPrePersist(){
        this.data = new Date(System.currentTimeMillis());
    }
}
