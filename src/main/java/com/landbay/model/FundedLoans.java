package com.landbay.model;

import java.util.HashMap;

public class FundedLoans {

    private int loanId;
    private int loanAmount;
    private String completedDate;
    private HashMap<String, Integer > investors;

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

    public void setInvestors(HashMap<String, Integer> investors) {
        this.investors = investors;
    }

    @Override
    public String toString() {
        return "FundedLoans{" +
                "loanId=" + loanId +
                ", loanAmount=" + loanAmount +
                ", completedDate='" + completedDate + '\'' +
                ", investors=" + investors +
                '}';
    }
}
