package com.landbay.util;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * This class utilises the Reader and opencsv libraries
 * to create a helper methods for the code base
 */
public class CsvHelper<T> {

    private Class myClass;
    private Reader reader;
    private String[] memberFieldsToBind;

    public CsvHelper(Class type, String filePath, String... memberFieldsToBind)
    {
        this.myClass = type;
        this.reader = readFile(filePath);
        this.memberFieldsToBind = memberFieldsToBind;
    }

    public Iterator<T> csvToBeanIterator()
    {
        // Using below strategy to decouple
        // this library from the model and
        // avoid using annotations
        ColumnPositionMappingStrategy<T> strategy;
        strategy = new ColumnPositionMappingStrategy<>();

        strategy.setType(myClass);
        String[] memberFieldsToBindTo = memberFieldsToBind;
        strategy.setColumnMapping(memberFieldsToBindTo);

        CsvToBean<T> csvToBean; // creating a bean collection with type of specified class
        csvToBean = new CsvToBeanBuilder<T>(reader)
                .withMappingStrategy(strategy)
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvToBean.iterator();
    }

    private Reader readFile(String CSV_FILE_PATH) {
        Reader returnReader;
        try {
            returnReader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return returnReader;
    }
}
