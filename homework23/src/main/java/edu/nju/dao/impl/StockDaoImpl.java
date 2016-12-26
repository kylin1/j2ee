package edu.nju.dao.impl;

import edu.nju.dao.StockDao;
import edu.nju.dao.util.MyConnection;
import edu.nju.model.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDaoImpl implements StockDao {
    //protected Logger log = Logger.getLogger(this.getClass());
    private static StockDaoImpl stockDao = new StockDaoImpl();

    public static StockDaoImpl getInstance() {
        return stockDao;
    }

    public List find() {
        Connection con = MyConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        ArrayList list = new ArrayList();
        try {
            stmt = con.prepareStatement("select * from stock");
            result = stmt.executeQuery();
            while (result.next()) {
                Stock stock = new Stock();
                stock.setId(result.getInt(1));
                stock.setCompanyName(result.getString(2));
                stock.setType(result.getString(3));
                stock.setPrice(result.getDouble(4));
                stock.setDate(result.getDate(5));
                list.add(stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyConnection.close(result, stmt, con);

        }
        return list;
    }


}
