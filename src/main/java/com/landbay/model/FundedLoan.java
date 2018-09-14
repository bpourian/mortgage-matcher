package com.landbay.model;

import java.util.HashMap;

public class FundedLoan {

    private int loanId;
    private int loanAmount;
    private String completedDate;
    private int amountUnfunded;
    private boolean fundedStatus = false;
    private HashMap<String, Integer > investors = new HashMap<>();

    public FundedLoan(){}

    public FundedLoan(int loanId, int loanAmount, String completedDate)
    {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
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

    @Override
    public String toString() {
        return "FundedLoan{" +
                "loanId=" + loanId +
                ", loanAmount=" + loanAmount +
                ", completedDate='" + completedDate + '\'' +
                ", investors=" + investors +
                '}';
    }
}
