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


    // public getters

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

    // public setters

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setLoandAmount(int loandAmount) {
        this.loandAmount = loandAmount;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }
}
