package com.landbay.model;

import java.util.HashMap;

public class FundedLoan {

    private int loanId;
    private String product;
    private int loanAmount;
    private String completedDate;
    private int amountUnfunded;
    private boolean fundedStatus = false;
    private int term;
    private HashMap<String, Integer > investors = new HashMap<>();

    public FundedLoan(FundedLoan fundedLoan)
    {
        this(
                fundedLoan.loanId,
                fundedLoan.product,
                fundedLoan.loanAmount,
                fundedLoan.term,
                fundedLoan.completedDate
        );
    }

    public FundedLoan(int loanId, String product, int loanAmount, int term, String completedDate)
    {
        this.loanId = loanId;
        this.product = product;
        this.loanAmount = loanAmount;
        this.term = term;
        this.completedDate = completedDate;
        this.amountUnfunded = loanAmount;
    }

    // public getters and setters

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public HashMap<String, Integer> getInvestors() {
        return investors;
    }

    public void setInvestors(String name, int amount) {
        this.investors.put(name, amount);
    }

    public boolean getFundedStatus() {
        return fundedStatus;
    }

    public void setFundedStatus(boolean fundedStatus) {
        this.fundedStatus = fundedStatus;
    }

    public int getAmountUnfunded() {
        return amountUnfunded;
    }

    public void setAmountUnfunded(int amountUnfunded) {
        this.amountUnfunded = amountUnfunded;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "FundedLoan{" +
                "loanId=" + loanId +
                ", product='" + product + '\'' +
                ", loanAmount=" + loanAmount +
                ", term=" + term +
                ", completedDate='" + completedDate + '\'' +
                ", amountUnfunded=" + amountUnfunded +
                ", fundedStatus=" + fundedStatus +
                ", investors=" + investors +
                '}';
    }
}
