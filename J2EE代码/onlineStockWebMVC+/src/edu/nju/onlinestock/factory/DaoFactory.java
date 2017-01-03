package edu.nju.onlinestock.factory;

import edu.nju.onlinestock.dao.StockDao;

import edu.nju.onlinestock.dao.impl.StockDaoImpl;


public class DaoFactory {
/*	public static UserDao getUserDao()
	{
		return UserDaoImpl.getInstance();
	}*/
	public static StockDao getStockDao()
	{
		return StockDaoImpl.getInstance();
	}
	
/*	public static TradeDao getTradeDao()
	{
		return TradeDaoImpl.getInstance();
	}*/
}
