package com.OligarchRating.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OligarchRequest {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("personInformation")
    private PersonInformation personInformation;
    @JsonProperty("financialAssets")
    private FinancialAssets financialAssets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonInformation getPersonInformation() {
        return personInformation;
    }

    public void setPersonInformation(PersonInformation personInformation) {
        this.personInformation = personInformation;
    }

    public FinancialAssets getFinancialAssets() {
        return financialAssets;
    }

    public void setFinancialAssets(FinancialAssets financialAssets) {
        this.financialAssets = financialAssets;
    }
}
