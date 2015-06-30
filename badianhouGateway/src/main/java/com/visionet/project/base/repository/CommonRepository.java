package com.visionet.project.base.repository;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuxs
 * @since 0.0.1
 *
 * @param <T>
 */
public interface CommonRepository<T> {
	/**
	 * 查询所有记录
	 * @return
	 * @throws Exception 
	 */
	public List<T> findAll(Class<T> clz) throws Exception;
	
	/**
	 * 根据hql查询记录数
	 * @param hql
	 * @return
	 */
	public int getCountBySearch(String hql);
	
	/**
	 * 求和
	 * @param hql
	 * @return
	 */
	public double getSumBySearch(String hql);
	
	/**
	 * 根据hql分页查询数据
	 * @param hql
	 * @param strat
	 * @param size
	 * @return
	 */
	public List<T> getListBySearch(String hql, int start, int size);
	
	/**
	 * 根据hql查询所有记录
	 * @param hql
	 * @return
	 */
	public List<T> getListBySearchAll(String hql);
	
	/**
	 * 根据sql查询记录数
	 * @param sql
	 * @return
	 */
	public int getCountBySql(String sql);
	
	/**
	 * 根据sql分页查询数据
	 * @param hql
	 * @param strat
	 * @param size
	 * @return
	 */
	public List<T> getListBySql(String hql, int start, int size);
	
	/**
	 * 新增
	 * @param person
	 * @return
	 */
	public T save(T t);
	
	/**
	 * 编辑
	 * @param person
	 * @return
	 */
	public T update(T t);
	
	/**
	 * 根据id查询记录
	 * @param id
	 * @return
	 */
	public T findById(Class<T> clz,String id);
	
	public double getSumBySearchsql(String sql);
	
	/**
	 * 根据id删除记录
	 * @param id
	 */
	public void delete(Class<T> clz,String id);
	
	public T findOneByQuery(String query);
	
	public T findOneBySQL(String sql);
	
	public String findbysqlstr(String sql);
	
	
	public String findStringListbysqlstr(String sql);

	@SuppressWarnings("rawtypes")
	public List	findBeanBySQL(String sql,Class c,Map<String,Object> parameter, int start, int size);
	
	@SuppressWarnings("rawtypes")
	public List	findBeanBySQL(String sql,Class c,int start,int size);
	
	public List<T> findListBySQL(String sql,Map<String,Object> parameter, int start, int size);
	
	@SuppressWarnings("rawtypes")
	public List<T> findListBySQL(String sql,Map<String,Object> parameter,Class c, int start, int size);
	/**
	 * 根据SQL和参数查询复杂结构数据
	 * @param sql
	 * @param 参数
	 * @return
	 */
	public List<Object[]> findObjectsBySQL(String sql,Map<String,Object> parameter, int start, int size);
	/**
	 * 根据sql执行添加更新删除操作
	 * @param sql
	 * @param parameter
	 * @return
	 */
	public Integer executeUpdate(String sql,Map<String,Object> parameter);
	
}
