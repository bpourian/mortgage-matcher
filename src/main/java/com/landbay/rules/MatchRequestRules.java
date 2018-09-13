package com.landbay.rules;

import com.landbay.model.Loan;

import java.util.List;

public interface MatchRequestRules {

    List<Loan> sortLoansByOldestFirst();
}
