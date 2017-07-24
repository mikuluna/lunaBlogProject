package com.luna.myblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.luna.myblog.dao.LunaLogDaoI;
import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.LunaLog;
import com.luna.myblog.entity.Pager;


public class LunaLogDaoImpl implements LunaLogDaoI{
	Configuration conf;
	SessionFactory sessionFactory;
	Session session;

	@Override
	public int totalPage(){
		session= new Configuration().configure().buildSessionFactory().openSession();
		String countHql = "from LunaLog";
		Query query = session.createQuery(countHql);
		int page=((Long)query.uniqueResult()).intValue();
		session.close();
		return page;
	}

	@Override
	public void addLunaLog(LunaLog lul) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(lul);
		tx.commit();
		session.close();
		
	}
	@Override
	public void deleteLunaLog(LunaLog lul) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(lul);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<LunaLog> queryDancePage(Pager pager) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		List<LunaLog> ldlist=null;
		String hql ="from LunaLog order by id desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(pager.getPageSize()*(pager.getCurPage()-1));
		query.setMaxResults(pager.getPageSize());
		ldlist = query.list();
		session.close();
		return ldlist;
	}

	@Override
	public List<LunaLog> queryAll() {
		session= new Configuration().configure().buildSessionFactory().openSession();
		String hql="from LunaLog ";
		Query query = session.createQuery(hql);
		List<LunaLog> list = query.list();
		return list;
	}

	@Override
	public LunaLog query(Integer id) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		LunaLog lunaDance = (LunaLog)session.createCriteria(LunaLog.class)
				.add(Restrictions.eqOrIsNull("id", id)).uniqueResult();
		return lunaDance;

	}
	
}
