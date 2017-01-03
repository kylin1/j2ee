package edu.nju.onlinestock.dao;

import javax.ejb.Local;
import javax.ejb.Remote;

import edu.nju.onlinestock.model.User;
@Remote
public interface UserDao
{
	/*
	 * �����ݿ��в���һ��user��¼
	 */
	public void save(User user);
	
	
	/*
	 * ���ݲ���������������ϵ�ֵ����user����,����ҵ��򷵻��������,���򷵻�null
	 * column ����
	 * value ��ֵ
	 */
	public User find(String column,String value);
	
	
	/*
	 * ����id����user���һ����¼
	 */
	public void updateByUserid(User user);
	
}
