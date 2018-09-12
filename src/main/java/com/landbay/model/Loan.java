package com.landbay.model;

/**
 * This class creates a loan object with
 * the following instance variables:
 *  - loanId
 *  - loanAmount
 *  - product
 *  - term
 *  - completedDate
 */
public class Loan {

    private int loanId;

    private int loandAmount;

    private String product; // i.e. Tracker or Fixed

    private int term;

    private String completedDate; // format DD/MM/YYYY


    // public getters and setters

    public int getLoanId() {
        return loanId;
    }

    public int getLoandAmount() {
        return loandAmount;
    }

    public String getProduct() {
        return product;
    }

    public int getTerm() {
        return term;
    }

    public String getCompletedDate() {
        return completedDate;
    }
}
