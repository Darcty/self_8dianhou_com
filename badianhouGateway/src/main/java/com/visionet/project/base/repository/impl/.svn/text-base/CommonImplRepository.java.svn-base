package com.visionet.project.base.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.visionet.project.base.repository.CommonRepository;

/**
 * 
 * @author liuxs
 * @since 0.0.1
 *
 * @param <T>
 */
@Repository
public class CommonImplRepository<T> implements CommonRepository<T>
{
	
	//private Class<T> type;
	
	@PersistenceContext
    private EntityManager em;
	
	public CommonImplRepository() throws Exception
	{
		 //((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
		 super();
	}
	

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> clz) throws Exception {
		//hql语句
		String hql = "from " + clz.getSimpleName();
		return em.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getListBySearch(String hql, int start, int size)
	{
		Query q = em.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(size);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getListBySearchAll(String hql)
	{
		Query q = em.createQuery(hql);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getListBySql(String sql, int start, int size)
	{
		Query q = em.createNativeQuery(sql);
		q.setFirstResult(start);
		q.setMaxResults(size);
		return q.getResultList();		
	}
	
	/**
	 * 根据hql查询记录数
	 * @param hql
	 * @return
	 */
	public int getCountBySearch(String hql)
	{
		return (int)em.createQuery(hql).getResultList().get(0).hashCode();
	}
	
	public double getSumBySearch(String hql)
	{
		return (Double)em.createQuery(hql).getSingleResult();
	}
	
	public double getSumBySearchsql(String sql)
	{
		Double d = 0.0;
		Object o = em.createNativeQuery(sql).getSingleResult();
		if(o != null)
		{
			try {
				BigDecimal  b = (BigDecimal)o;
				d = b.doubleValue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				d = (double)o;
			}
		}
		return d;
	}
	
	
	public int getCountBySql(String sql)
	{
		
		try {
			return (int)em.createNativeQuery(sql).getResultList().get(0).hashCode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
	}

	
	/**
	 * 添加或更新
	 */
	public T save(T t)
	{
		em.persist(t);
		//em.merge(person);
		return t;
	}
	
	/**
	 * 更新
	 */
	public T update(T t)
	{
		em.merge(t);
		//em.merge(person);
		return t;
	}
	
	/**
	 * 根据id查询记录
	 */
	public T findById(Class<T> clz,String id)
	{
		return em.find(clz, id);
	}
	
	/**
	 * 根据id删除记录
	 */
	public void delete(Class<T> clz,String id)
	{
		em.remove(findById(clz,id));
	}
	
	@SuppressWarnings("unchecked")
	public T findOneByQuery(String query) {
		List<T> list=em.createQuery(query).getResultList();
		if(list!=null && list.size()>0)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public T findOneBySQL(String sql){
		List<T> list=em.createNativeQuery(sql).getResultList();
		if(list!=null && list.size()>0)
			return list.get(0);
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public String findbysqlstr(String sql){
		List list = em.createNativeQuery(sql).getResultList();
		if(list!=null && list.size()>0)
			return list.get(0).toString();
		return null;
	}
	
	
	@SuppressWarnings("rawtypes")
	public String findStringListbysqlstr(String sql){
		List list = em.createNativeQuery(sql).getResultList();
		String s=null;
		if(list!=null && list.size()>0){
			for(Object o : list){
				s+=(s==null?"":",")+o+"";
			}
		}
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findListBySQL(String sql,Map<String,Object> parameter, int start, int size){
		  Query query =  em.createNativeQuery(sql);
		  query.setFirstResult(start);
		  query.setMaxResults(size);
		  if(parameter!=null){
			  for(String key:parameter.keySet()){
				  query.setParameter(key, parameter.get(key));
			  }
		  }
		  return query.getResultList();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findListBySQL(String sql,Map<String,Object> parameter,Class c, int start, int size){
		  Query query =  em.createNativeQuery(sql,c);	
		  if(start>=0)
			 query.setFirstResult(start);
		 if(size>0)
			 query.setMaxResults(size);
		  if(parameter!=null){
			  for(String key:parameter.keySet()){
				  query.setParameter(key, parameter.get(key));
			  }
		  }
		  return query.getResultList();
	}
	@SuppressWarnings("rawtypes")
	public List	findBeanBySQL(String sql,Class clz,Map<String,Object> parameter, int start, int size){
		Query q = (Query) em.createNativeQuery(sql);
		 if(start>=0)
			 q.setFirstResult(start);
		 if(size>0)
			 q.setMaxResults(size);
		 q.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(clz));
		 return q.getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	public List	findBeanBySQL(String sql,Class c,int start,int size)
	{
		Query q = (Query) em.createNativeQuery(sql);
		if(start>=0)
			q.setFirstResult(start);
		if(size>0)
			q.setMaxResults(size);
		 q.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(c));
		 return q.getResultList();
	}
	
	/**
	 * 根据SQL和参数查询复杂结构数据
	 */
	@SuppressWarnings("rawtypes")
	public List<Object[]> findObjectsBySQL(String sql,Map<String,Object> parameter, int start, int size) {
		List<Object[]> result=new ArrayList<Object[]>();
		Query query =  em.createNativeQuery(sql); 
		 if(start>=0)
			 query.setFirstResult(start);
		 if(size>0)
			 query.setMaxResults(size);
		if(parameter!=null){
			  for(String key:parameter.keySet()){
				  query.setParameter(key, parameter.get(key));
			  }
		  }
        List objecArraytList = query.getResultList();
        for(int i=0;i<objecArraytList.size();i++) {      
            Object[] obj = (Object[]) objecArraytList.get(i);
            result.add(obj);
        }      
		return result;
	}
	
	public Integer executeUpdate(String sql,Map<String,Object> parameter){
		Query query =  em.createNativeQuery(sql); 
		if(parameter!=null){
			for(String key:parameter.keySet()){
				query.setParameter(key, parameter.get(key));
			}
		}
		return query.executeUpdate();
	}
}
