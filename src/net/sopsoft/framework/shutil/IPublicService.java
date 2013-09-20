package net.sopsoft.framework.shutil;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sopsoft.framework.shutil.ConditionManager.Page;
import net.sopsoft.framework.shutil.ConditionManager.PageCondition;

import org.hibernate.SessionFactory;

public interface IPublicService{
	/**
	 * 向表中添加一条数据
	 * @param o	由hibernate映射出来的实体对象
	 */
	public void add(Object o);
	/**
	 * 由表中删除一条数据
	 * @param o	由hibernate映射出来的实体对象
	 */
	public void delete(Object o);
	/**
	 * 向表中更新一条数据
	 * @param o	由hibernate映射出来的实体对象
	 */
	public void update(Object o);
	/**
	 * 根据id由表中读取一条数据
	 * @param clz	由hibernate映射出来的实体对象的类型
	 * @param id	要查询的id
	 * @return		符合查询条件id的，由hibernate映射出来的实体对象
	 */
	public Object load(Class clz,Serializable id);
	/**
	 * 条件查询，返回有分页数据的 Page 类型的对象 （有数据）
	 * @param clz	由hibernate映射出来的实体对象的类型
	 * @param conditionOfSearchs	可变参数，ConditionOfSearch类型的查询条件，可任意个数
	 * @return	有分页数据的 Page 类型的对象 （有数据）
	 */
	public Page normalPublicSearch(Class clz,ConditionOfSearch... conditionOfSearchs);
	/**
	 * 条件查询，返回有分页数据的 Page 类型的对象 （有数据）
	 * @param clz	由hibernate映射出来的实体对象的类型
	 * @param list	List<ConditionOfSearch>类型的参数，里面装有查询条件
	 * @return	有分页数据的 Page 类型的对象 （有数据）
	 */
	public Page normalPublicSearch(Class clz,List<ConditionOfSearch> list);
	/**
	 * 条件查询，返回有分页数据的 Page 类型的对象 （有数据）
	 * @param clz	由hibernate映射出来的实体对象的类型
	 * @return	有分页数据的 Page 类型的对象 （有数据）
	 */
	public Page normalPublicSearch(Class clz);
	/**
	 * 条件查询，返回 List类型的对象 
	 * @param clz			由hibernate映射出来的实体对象的类型
	 * @param pagination	是否有分页条件对象
	 * @param list			List<ConditionOfSearch>类型的参数，里面装有查询条件
	 * @return				List类型的对象
	 */
	public  List normalPublicSearch(Class clz,Boolean pagination,List<ConditionOfSearch> list);
	/**
	 * 条件查询，返回 List类型的对象 
	 * @param clz					由hibernate映射出来的实体对象的类型
	 * @param pagination			是否有分页条件对象
	 * @param conditionOfSearchs	可变参数，ConditionOfSearch类型的查询条件，可任意个数
	 * @return						List类型的对象
	 */
	public List normalPublicSearch(Class clz,Boolean pagination,ConditionOfSearch... conditionOfSearchs);
	/**
	 * 执行纯sql语句的方法,不可执行查询语句(由executeSqlSearch(String sql)方法执行查询),可以由多条sql语句组成，在同一个事物中执行，出现异常将回滚
	 * @param sqls	可变参数，可以由多条sql语句组成
	 * @return		List<Integer> 类型的对象，记录相同位置的sql语句执行后影响的行数
	 */
	public List<Integer> executeSql(String... sqls);
	/**
	 * 执行纯sql语句查询的方法,不可执行除查询外的其他语句(由executeSql(String... sqls)方法执行查询)
	 * @param sql	要执行的sql查询语句
	 * @return		List 类型的 对象
	 */
	public List executeSqlSearch(String sql);

	public Page paginationSearch(HttpServletRequest request,Class clz,ConditionOfSearch... conditionOfSearchs);
	
	public Page paginationSearch(HttpServletRequest request,Class clz,List<ConditionOfSearch> list);
}
