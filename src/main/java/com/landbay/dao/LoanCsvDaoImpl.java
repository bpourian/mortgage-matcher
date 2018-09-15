package com.landbay.dao;

import com.landbay.model.Loan;
import com.landbay.util.CsvHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class implements LoanDao interface
 * and lists all loan requests from the csv file
 */
public class LoanCsvDaoImpl implements LoanDao
{
    public List<Loan> getLoans(CsvHelper csvHelper)
    {
        Iterator<Loan> investmentRequestIterator = csvHelper.csvToBeanIterator();
        List<Loan> list = new ArrayList<>();
        while (investmentRequestIterator.hasNext())
        {
            Loan loan = investmentRequestIterator.next();
            Loan newLoan = new Loan(loan.getLoanId(),
                    loan.getLoanAmount(),
                    loan.getProduct(),
                    loan.getTerm(),
                    loan.getCompletedDate());
            list.add(newLoan);
        }
        return list;
    }
}
