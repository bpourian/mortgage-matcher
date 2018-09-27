package com.landbay.dao;

import java.util.Iterator;
import java.util.List;

/**
 * General DAO
 */
public interface Dao<T> {

    List<T> listData(Iterator<T> iterator);

}
