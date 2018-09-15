package com.landbay.dao;

import com.landbay.model.Investor;
import com.landbay.util.CsvHelper;

import java.util.List;

/**
 * Interface to access investment request data
 */
public interface InvestorDao {

    List<Investor> getInvestors(CsvHelper csvHelper);

}
