package edu.nju.dao.impl;

import edu.nju.dao.IStockDao;

import java.util.List;

public class StockDaoImpl implements IStockDao {
    //protected Logger log = Logger.getLogger(this.getClass());
    private static StockDaoImpl stockDao = new StockDaoImpl();

    public static StockDaoImpl getInstance() {
        return stockDao;
    }

    public List find() {
        return null;
    }


}
