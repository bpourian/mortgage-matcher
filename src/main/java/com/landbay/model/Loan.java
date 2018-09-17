package com.landbay.model;

public class Loan {

    private int loanId;

    private int loanAmount;

    private String product; // i.e. Tracker or Fixed

    private int term;

    private String completedDate; // format DD/MM/YYYY

    public Loan(){}

    public Loan(int loanId, int loanAmount, String product, int term, String completedDate)
    {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.product = product;
        this.term = term;
        this.completedDate = completedDate;
    }

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

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanAmount=" + loanAmount +
                ", product='" + product + '\'' +
                ", term=" + term +
                ", completedDate='" + completedDate + '\'' +
                '}';
    }
}
