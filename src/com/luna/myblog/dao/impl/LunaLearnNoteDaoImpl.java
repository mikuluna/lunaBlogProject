package com.luna.myblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.luna.myblog.dao.LunaLearnNoteDaoI;
import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.LunaLearnNote;
import com.luna.myblog.entity.Pager;


public class LunaLearnNoteDaoImpl implements LunaLearnNoteDaoI{
	Configuration conf;
	SessionFactory sessionFactory;
	Session session;

	@Override
	public List<LunaLearnNote> queryLearnNotePage(Pager pager){
		session= new Configuration().configure().buildSessionFactory().openSession();
		List<LunaLearnNote> ldlist=null;
		String hql ="from LunaLearnNote order by id desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(pager.getPageSize()*(pager.getCurPage()-1));
		query.setMaxResults(pager.getPageSize());
		ldlist = query.list();
		session.close();
		return ldlist;
	}
	@Override
	public int totalPage(){
		session= new Configuration().configure().buildSessionFactory().openSession();
		String countHql = "select count(*) from LunaLearnNote";
		Query query = session.createQuery(countHql);
		int page=((Long)query.uniqueResult()).intValue();
		session.close();
		return page;
	}

	@Override
	public void addLunaLearnNote(LunaLearnNote luln) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(luln);
		tx.commit();
		session.close();
	}
	@Override
	public void deleteLunaLearnNote(LunaLearnNote luln) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(luln);
		tx.commit();
		session.close();
		
	}
	@Override
	public List<LunaLearnNote> queryAll() {
		session= new Configuration().configure().buildSessionFactory().openSession();
		String hql="from LunaLearnNote";
		Query query = session.createQuery(hql);
		List<LunaLearnNote> list = query.list();
		return list;
	}
	@Override
	public LunaLearnNote query(Integer id) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		LunaLearnNote lunaDance = (LunaLearnNote)session.createCriteria(LunaLearnNote.class)
				.add(Restrictions.eqOrIsNull("id", id)).uniqueResult();
		return lunaDance;
	}

	@Override
	public List<LunaLearnNote> queryLearnNotePage(Pager pager, Integer zoneId) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		List<LunaLearnNote> ldlist=null;
		String hql ="from LunaLearnNote where zoneId=:zoneId order by id desc";
		Query query = session.createQuery(hql);
		query.setParameter("zoneId", zoneId);
		query.setFirstResult(pager.getPageSize()*(pager.getCurPage()-1));
		query.setMaxResults(pager.getPageSize());
		ldlist = query.list();
		session.close();
		return ldlist;
	}
	@Override
	public int totalPage(Integer zoneId) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		String countHql = "select count(*) from LunaLearnNote where zoneId=:zoneId";
		Query query = session.createQuery(countHql);
		query.setParameter("zoneId", zoneId);
		int page=((Long)query.uniqueResult()).intValue();
		session.close();
		return page;
	}
	
}
