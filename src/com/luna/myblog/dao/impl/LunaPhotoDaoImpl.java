package com.luna.myblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.luna.myblog.dao.LunaDanceDaoI;
import com.luna.myblog.dao.LunaPhotoDaoI;
import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.LunaPhoto;
import com.luna.myblog.entity.Pager;


public class LunaPhotoDaoImpl implements LunaPhotoDaoI{
	Configuration conf;
	SessionFactory sessionFactory;
	Session session;

	@Override
	public int totalPage(){
		session= new Configuration().configure().buildSessionFactory().openSession();
		String countHql = "from LunaPhoto";
		Query query = session.createQuery(countHql);
		int page=((Long)query.uniqueResult()).intValue();
		session.close();
		return page;
	}

	@Override
	public List<LunaPhoto> queryLunaPhotoPage(Pager pager) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		List<LunaPhoto> ldlist=null;
		String hql ="from LunaPhoto order by id desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(pager.getPageSize()*(pager.getCurPage()-1));
		query.setMaxResults(pager.getPageSize());
		ldlist = query.list();
		session.close();
		return ldlist;
	}
	@Override
	public void addLunaPhoto(LunaPhoto lup) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(lup);
		tx.commit();
		session.close();
	}
	@Override
	public void deleteLunaPhoto(LunaPhoto lup) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(lup);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<LunaPhoto> queryAll() {
		session= new Configuration().configure().buildSessionFactory().openSession();
		String hql="from LunaPhoto";
		Query query = session.createQuery(hql);
		List<LunaPhoto> list = query.list();
		return list;
	}

	@Override
	public LunaPhoto query(Integer id) {
		session= new Configuration().configure().buildSessionFactory().openSession();
		LunaPhoto lunaDance = (LunaPhoto)session.createCriteria(LunaPhoto.class)
				.add(Restrictions.eqOrIsNull("id", id)).uniqueResult();
		return lunaDance;
	}
	
}
