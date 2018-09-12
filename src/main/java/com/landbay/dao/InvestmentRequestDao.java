package com.landbay.dao;

import com.landbay.model.InvestmentRequest;

import java.io.IOException;
import java.util.List;

public interface InvestmentRequestDao {

    List<InvestmentRequest> listInvestmentRequests();

}
