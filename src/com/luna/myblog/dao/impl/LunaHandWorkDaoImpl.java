package com.luna.myblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luna.myblog.dao.LunaHandWorkDaoI;
import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.LunaHandWork;
import com.luna.myblog.entity.Pager;


public class LunaHandWorkDaoImpl implements LunaHandWorkDaoI{
	Configuration conf;
	SessionFactory sessionFactory;
	Session session;
	@Override
	public int totalPage(){
		session= new Configuration().configure().buildSessionFactory().openSession();
		String countHql = "from LunaHandWork";
		Query query = session.createQuery(countHql);
		int page=((Long)query.uniqueResult()).intValue();
		session.close();
		return page;
	}
	@Override
	public List<LunaHandWork> queryLunaHandWorkPage(Pager pager) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		List<LunaHandWork> ldlist=null;
		String hql ="from LunaHandWork";
		Query query = session.createQuery(hql);
		query.setFirstResult(pager.getPageSize()*(pager.getCurPage()-1));
		query.setMaxResults(pager.getPageSize());
		ldlist = query.list();
		session.close();
		return ldlist;
	}
	@Override
	public void addLunaHandWork(LunaHandWork ludan){
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(ludan);
		tx.commit();
		
	}
	@Override
	public void deleteLunaHandWork(LunaHandWork lunahandwork) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(lunahandwork);
		tx.commit();
		session.close();
		
	}
	
}
