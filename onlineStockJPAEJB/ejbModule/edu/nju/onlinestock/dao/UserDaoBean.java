package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserDaoBean implements UserDao
{
	@PersistenceContext
	protected EntityManager em;

	
	//protected Logger log = Logger.getLogger(this.getClass());

   
	/*
	 * �����ݿ��в���һ��user��¼
	 */
	public void save(User user)
	{
		try {
			em.persist(user); //����Entity�����ݿ���
		}catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	/*
	 * ���ݲ���������������ϵ�ֵ����user����,����ҵ��򷵻��������,���򷵻�null
	 * column ����
	 * value ��ֵ
	 */
	public User find(String column,String value)
	{
	//
		return null;
	}
	
	/*
	 * ����id����user���һ����¼
	 */
	public void updateByUserid(User user)
	{
	//
		
	}

}
