package edu.nju.dao.impl;

import edu.nju.dao.StockDao;
import java.util.List;

public class StockDaoImpl implements StockDao {
    //protected Logger log = Logger.getLogger(this.getClass());
    private static StockDaoImpl stockDao = new StockDaoImpl();

    public static StockDaoImpl getInstance() {
        return stockDao;
    }

    public List find() {
        return null;
    }


}
