package com.landbay.dao;

import com.landbay.model.Loan;

import java.util.List;

/**
 * Interface to access loan request data
 */
public interface LoanDao {

    List<Loan> getLoans();
}
