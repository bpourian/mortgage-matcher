package com.landbay.model;

/**
 * This class creates an investor object with
 * the following properties:
 *  - investor
 *  - investmentAmount
 *  - productType
 *  - term
 */
public class InvRequest {

    private String investor;

    private String investmentAmount;

    private String productType;

    private String term;


    // public getters and setters
    public String getInvestor() { return investor; }

    public String getInvestmentAmount() { return investmentAmount; }

    public String getProductType() { return productType; }

    public String getTerm() { return term; }

}
