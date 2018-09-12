package com.landbay.model;

/**
 * This class creates an investor object with
 * the following instance variables:
 *  - investor
 *  - investmentAmount
 *  - productType
 *  - term
 */
public class InvestmentRequest {

    private String investor;

    private String investmentAmount;

    private String productType;

    private String term;


    // public getters

    public String getInvestor() { return investor; }

    public String getInvestmentAmount() { return investmentAmount; }

    public String getProductType() { return productType; }

    public String getTerm() { return term; }

    // public setters

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
