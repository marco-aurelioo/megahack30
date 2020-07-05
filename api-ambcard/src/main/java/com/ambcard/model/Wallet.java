package com.ambcard.model;

import java.util.UUID;

public class Wallet {

    private UUID id;
    private String cpf;
    private String cadrNum;
    private Double balance;

    public String getCadrNum() {
        return cadrNum;
    }

    public void setCadrNum(String cadrNum) {
        this.cadrNum = cadrNum;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
