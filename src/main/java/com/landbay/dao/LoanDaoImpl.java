package com.landbay.dao;

import com.landbay.model.Loan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoanDaoImpl implements Dao<Loan> {

    @Override
    public List<Loan> listData(Iterator<Loan> iterator) {
        List<Loan> list = new ArrayList<>();
        while (iterator.hasNext())
        {
            Loan loan = iterator.next();
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
