package com.luna.myblog.dao;

import java.util.List;

import org.hibernate.Session;

import com.luna.myblog.entity.Pager;

/**
 * 
 * @author luna
 *
 * @param <T>
 */
public interface BaseDaoI<T> {
	public Session getSession();
	public void save(T instances);
	public void delete(T instance);
	public void update(T instance);
	public Object findById(Class className,Integer id);
	public List<T> findAll();
	/**
	 * 根据条件查询所有
	 * @param className
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findByProperty(String className,String propertyName,Object value);
	/**
	 * 查询一共多少条记录
	 * @param className
	 * @param propertyName（如果为空，则不带参数）
	 * @param value参数设置
	 * @return 总记录数
	 */
	public Integer totalPage(String className,String propertyName,Object value,Integer pageSize);

	/**
	 * 分页查询
	 * @param className
	 * @param pager
	 * @param propertyName（如果为空，则不带参数）
	 * @param value
	 * @return
	 */
	public List<T> findByPage(String className,Pager pager,String propertyName,Object value);
	/**
	 * 根据hql语句查找list
	 * @param hql
	 * @return
	 */
	public List<T> findByHql(String hql);
}
