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

    private int investmentAmount;

    private String productType;

    private int term;

    public  InvestmentRequest(){};

    public InvestmentRequest(String investor, int investmentAmount, String productType, int term)
    {
        this.investor = investor;
        this.investmentAmount = investmentAmount;
        this.productType = productType;
        this.term = term;
    }


    // public getters

    public String getInvestor() { return investor; }

    public int getInvestmentAmount() { return investmentAmount; }

    public String getProductType() { return productType; }

    public int getTerm() { return term; }

    // public setters

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public void setInvestmentAmount(int investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
