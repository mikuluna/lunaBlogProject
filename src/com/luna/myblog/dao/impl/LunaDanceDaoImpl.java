package com.luna.myblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luna.myblog.dao.LunaDanceDaoI;
import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;


public class LunaDanceDaoImpl implements LunaDanceDaoI{
	Configuration conf;
	SessionFactory sessionFactory;
	Session session;
	/**
	 * pageSize每页显示数量
	 * CurPage当前页
	 */
	@Override
	public List<LunaDance> queryDancePage(Pager pager){
		session= new Configuration().configure().buildSessionFactory().openSession();
		List<LunaDance> ldlist=null;
		String hql ="from LunaDance  order by id desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(pager.getPageSize()*(pager.getCurPage()-1));
		query.setMaxResults(pager.getPageSize());
		ldlist = query.list();
		session.close();
		return ldlist;
	}
	@Override
	public void addLunaDance(LunaDance ludan){
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(ludan);
		tx.commit();
		session.close();
		
	}
	@Override
	public int totalPage(){
		session= new Configuration().configure().buildSessionFactory().openSession();
		String countHql = "select count(*) from LunaDance";
		Query query = session.createQuery(countHql);
		int page=((Long)query.uniqueResult()).intValue();
		int totalPage = page%9==0?page/9:page/9+1;
		session.close();
		return totalPage;
	}
	@Override
	public void deleteLunaDancd(LunaDance ludan) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(ludan);
		tx.commit();
		session.close();
	}
	
}
