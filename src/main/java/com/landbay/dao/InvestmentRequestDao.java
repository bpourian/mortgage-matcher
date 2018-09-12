package com.landbay.dao;

import com.landbay.model.InvestmentRequest;

import java.util.List;

/**
 * Interface to access investment request data
 */
public interface InvestmentRequestDao {

    List<InvestmentRequest> listInvestmentRequests();

}
