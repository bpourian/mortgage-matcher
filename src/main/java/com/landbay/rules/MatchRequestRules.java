package com.landbay.rules;

import com.landbay.model.InvestmentRequest;
import com.landbay.model.Loan;

import java.util.List;

/**
 * Interface to define set of domain rules
 * that must be implemented
 */
public interface MatchRequestRules {

    List<Loan> sortLoansByOldestFirst(List<Loan> unsortedList);

    void sortProductTypesIntoLists(List<InvestmentRequest> unsortedList);

    List<InvestmentRequest> investmentRequestTermFilter(Loan loan, List<InvestmentRequest> investmentRequests);


}
