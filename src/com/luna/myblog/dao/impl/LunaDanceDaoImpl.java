package com.luna.myblog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luna.myblog.dao.LunaDanceDaoI;
import com.luna.myblog.entity.LunaDance;
import com.luna.myblog.entity.Pager;


public class LunaDanceDaoImpl implements LunaDanceDaoI{
	Configuration conf;
	SessionFactory sessionFactory;
	Session session;
	public LunaDanceDaoImpl(){
		session= new Configuration().configure().buildSessionFactory().openSession();
	}
	@Override
	public List<LunaDance> queryDancePage(Pager pager) throws Exception {
		
		return null;
	}
	@Override
	public void addLunaDance(LunaDance ludan) throws Exception {
		
		
	}
	@Override
	public int totalPage() throws Exception {
		String countHql = "select count(*) from LunaDance";
		Query query = session.createQuery(countHql);
		int page=((Long)query.uniqueResult()).intValue();
		return page;
	}
	
}
