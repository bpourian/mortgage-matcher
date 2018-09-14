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

    private int loanAmount;

    private String product; // i.e. Tracker or Fixed

    private int term;

    private String completedDate; // format DD/MM/YYYY

    private int amountUnfunded = loanAmount;

    private boolean fundedStatus = false;

    public Loan(){}

    public Loan(int loanId, int loanAmount, String product, int term, String completedDate)
    {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.product = product;
        this.term = term;
        this.completedDate = completedDate;
    }


    // public getters

    public int getLoanId() {
        return loanId;
    }

    public int getLoanAmount() {
        return loanAmount;
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

    public int getAmountUnfunded() {
        return amountUnfunded;
    }

    public boolean getfundedStatus() {
        return fundedStatus;
    }

    // public setters

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
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

    public void setAmountUnfunded(int amountUnfunded) {
        this.amountUnfunded = amountUnfunded;
    }

    public void setFundedStatus(boolean fundingStatus) {
        this.fundedStatus = fundingStatus;
    }



    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanAmount=" + loanAmount +
                ", product='" + product + '\'' +
                ", term=" + term +
                ", completedDate='" + completedDate + '\'' +
                ", amountUnfunded=" + amountUnfunded +
                '}';
    }
}
