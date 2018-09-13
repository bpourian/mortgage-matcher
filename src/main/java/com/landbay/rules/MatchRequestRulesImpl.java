package com.landbay.rules;

import com.landbay.dao.LoanCsvDaoImpl;
import com.landbay.model.Loan;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MatchRequestRulesImpl implements MatchRequestRules {

    private LoanCsvDaoImpl loanCsvDaoImp = new LoanCsvDaoImpl();;
    private List<Loan> dateSortedLoanList;

    public List<Loan> sortLoansByOldestFirst() {
        return sortLoansByOldestFirst(loanCsvDaoImp.listLoan());
    }

    public List<Loan> sortLoansByOldestFirst(List<Loan> unsortedList)
    {
        dateSortedLoanList = unsortedList.stream()
                .sorted(Comparator.comparing(Loan::getCompletedDate))
                .collect(Collectors.toList());
        for (Loan ln : dateSortedLoanList)
         System.out.println(ln.getCompletedDate());

        return dateSortedLoanList;
    }
}
