package com.landbay.rules;

import com.landbay.model.Investor;
import com.landbay.model.Loan;

import java.util.List;

/**
 * Interface to define set of domain rules
 * that must be implemented
 */
public interface MatchingRules {

    List<Loan> sortLoansByOldestFirst(List<Loan> unsortedList);

    void sortProductTypesIntoLists(List<Investor> unsortedList);

    List<Investor> investorTermFilter(Loan loan, List<Investor> investors);

}
