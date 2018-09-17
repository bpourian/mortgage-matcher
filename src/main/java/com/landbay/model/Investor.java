package com.landbay.model;

public class Investor {

    private String investor;

    private int investmentAmount;

    private String productType;

    private int term;

    private int fundRemaining;

    public Investor(){};

    public Investor(String investor, int investmentAmount, String productType, int term)
    {
        this.investor = investor;
        this.investmentAmount = investmentAmount;
        this.productType = productType;
        this.term = term;
        this.fundRemaining = this.investmentAmount;
    }

    public String getInvestor() { return investor; }

    public int getInvestmentAmount() { return investmentAmount; }

    public String getProductType() { return productType; }

    public int getTerm() { return term; }

    public int getFundRemaining() {
        return fundRemaining;
    }

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

    public void setFundRemaining(int fundRemaining) {
        this.fundRemaining = fundRemaining;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "investor='" + investor + '\'' +
                ", investmentAmount=" + investmentAmount +
                ", productType='" + productType + '\'' +
                ", term=" + term +
                ", fundRemaining=" + fundRemaining +
                '}';
    }
}
