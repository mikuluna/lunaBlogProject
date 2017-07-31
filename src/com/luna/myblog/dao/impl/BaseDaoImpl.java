package com.luna.myblog.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.luna.myblog.dao.BaseDaoI;
import com.luna.myblog.entity.Pager;

public class BaseDaoImpl<T> implements BaseDaoI<T> {
	private Class<T> entityClass;
	private SessionFactory sessionFactory;
	
	
	
	public BaseDaoImpl(){
		entityClass=(Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T instances) {
		getSession().save(instances);
		
	}

	
	public void delete(String className,Integer id) {
		getSession().beginTransaction();
		getSession().delete(id);
		
		getSession().beginTransaction().commit();
	}
	
	public void delete(T instance) {
		getSession().delete(instance);
	}

	@Override
	public void update(T instance) {
		getSession().update(instance);
		
	}

	@Override
	public Object findById(Class className, Integer id) {
		Object object = getSession().get(className, id);
		return object;
	}

	@Override
	public List<T> findAll() {
		String hql = "from "+entityClass.getSimpleName()+" order by id desc";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<T> findByProperty(String className, String propertyName, Object value) {
		String hql = "from "+className+" where 1=1 and "+propertyName+"=:propertyName";
		Query query = getSession().createQuery(hql);
		query.setParameter("propertyName", value);
		return query.list();
	}

	@Override
	public Integer totalPage(String className, String propertyName, Object value,Integer pageSize) {
		StringBuffer hql=new StringBuffer("select count(*) from "+className+" where 1=1");
		if(propertyName!=null){
			hql.append(" and "+propertyName+"=:propertyName");
		}
		Query query = getSession().createQuery(hql.toString());
		if(propertyName!=null){
			query.setParameter("propertyName", value);
		}
		int page=((Long)query.uniqueResult()).intValue();
		int totalPage = page%pageSize==0?page/pageSize:page/pageSize+1;
		return totalPage;
	}

	@Override
	public List<T> findByPage(String className, Pager pager, String propertyName, Object value) {
		StringBuffer hql = new StringBuffer("from ");
		hql.append(className);
		hql.append(" where 1=1 ");
		if(propertyName!=null){
			hql.append("and "+propertyName+"=:propertyName ");
		}
		hql.append("order by id desc");
		Query query = getSession().createQuery(hql.toString());
		if(propertyName!=null){
			query.setParameter("propertyName", value);
		}
		query.setFirstResult(pager.getPageSize()*(pager.getCurPage()-1));
		query.setMaxResults(pager.getPageSize());
		return query.list();
	}

	@Override
	public List<T> findByHql(String hql) {
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	

}
