package edu.nju.dao;

import edu.nju.model.User;

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
	public User find(String column, String value);
	
	
	/*
	 * ����id����user���һ����¼
	 */
	public void updateByUserid(User user);
	
}
