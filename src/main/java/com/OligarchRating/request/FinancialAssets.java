package com.OligarchRating.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialAssets {

    @JsonProperty("id")
    private long id;
    @JsonProperty("cashAmount")
    private double cashAmount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("bitcoinAmount")
    private int bitcoinAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getBitcoinAmount() {
        return bitcoinAmount;
    }

    public void setBitcoinAmount(int bitcoinAmount) {
        this.bitcoinAmount = bitcoinAmount;
    }
}
