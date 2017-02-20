package edu.nju.onlinestock.dao;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface StockDao {

	public List find();
}
