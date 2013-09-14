package net.sopsoft.utils.shutil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sopsoft.utils.shutil.ConditionManager.OrderCondition;
import net.sopsoft.utils.shutil.ConditionManager.Page;
import net.sopsoft.utils.shutil.ConditionManager.PageCondition;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PublicServiceImpl implements IPublicService {
	private Hibernate4CommonDao dao = new Hibernate4CommonDao();
	private ConditionManager cm = new ConditionManager();
	/**
	 * 条件查询，返回有分页数据的 Page 类型的对象 （有数据）
	 * @param clz	由hibernate映射出来的实体对象的类型
	 * @param conditionOfSearchs	可变参数，ConditionOfSearch类型的查询条件，可任意个数
	 * @return	有分页数据的 Page 类型的对象 （有数据）
	 */
	public  Page normalPublicSearch(Class clz,
			ConditionOfSearch... conditionOfSearchs) {

		Boolean pageFlag = false; // 是否有PageCondition对象传入
		PageCondition pageCondition = null;
		OrderCondition orderCondition = null;
		// 创建PaginationDetachedCriteria对象,用于分页和条件查询
		PaginationDetachedCriteria paginationDetachedCriteria = new PaginationDetachedCriteria(
				clz);
		// 迭代每个ConditionOfSearch对象,向criteria和criteria2添加除分页外的所有元素
		for (ConditionOfSearch conditionOfSearch : conditionOfSearchs) {
			if (conditionOfSearch instanceof PageCondition) {
				pageCondition = (PageCondition) conditionOfSearch;
				pageFlag = true;
			}else if(conditionOfSearch instanceof OrderCondition){
				orderCondition = (OrderCondition)conditionOfSearch;
			}else {
				conditionOfSearch
						.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
			}
		}
		// 查询总记录数
		paginationDetachedCriteria.getDetachedCriteria().setProjection(
				Projections.rowCount());
		int i = Integer.parseInt(dao.SearchByCriteria(
				paginationDetachedCriteria).get(0).toString());
		// 取消查询条件中的聚合函数count(*)
		paginationDetachedCriteria.getDetachedCriteria().setProjection(null);
		//加入Order By 排序对象
		if(orderCondition !=null){
			orderCondition.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		}
		// 如果没有创建分页对象,在此创建
		if (pageFlag != true)
			pageCondition = cm.getNewPage();
		// 设置分页总记录数
		pageCondition.setTotalSize(i);
		// 添加分页查询条件
		pageCondition
				.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		// 获取符合条件的对象List
		pageCondition.setDataList(dao
				.SearchByCriteria(paginationDetachedCriteria));
		// 设置总页数
		pageCondition.setTotalPage((pageCondition.getTotalSize()
				+ pageCondition.getPageSize() - 1)
				/ pageCondition.getPageSize());
		return pageCondition;
	}
	/**
	 * 条件查询，返回有分页数据的 Page 类型的对象 （有数据）
	 * @param clz	由hibernate映射出来的实体对象的类型
	 * @param list	List<ConditionOfSearch>类型的参数，里面装有查询条件
	 * @return	有分页数据的 Page 类型的对象 （有数据）
	 */
	public Page normalPublicSearch(Class clz,
			List<ConditionOfSearch> list) {

		Boolean pageFlag = false; // 是否有PageCondition对象传入
		PageCondition pageCondition = null;
		OrderCondition orderCondition = null;
		// 创建PaginationDetachedCriteria对象,用于分页和条件查询
		PaginationDetachedCriteria paginationDetachedCriteria = new PaginationDetachedCriteria(
				clz);
		// 迭代每个ConditionOfSearch对象,向criteria和criteria2添加除分页外的所有元素
		for (ConditionOfSearch conditionOfSearch : list) {
			if (conditionOfSearch instanceof PageCondition) {
				pageCondition = (PageCondition) conditionOfSearch;
				pageFlag = true;
			}else if(conditionOfSearch instanceof OrderCondition){
				orderCondition = (OrderCondition)conditionOfSearch;
			} else {
				conditionOfSearch
						.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
			}
		}
		// 查询总记录数
		paginationDetachedCriteria.getDetachedCriteria().setProjection(
				Projections.rowCount());
		int i = Integer.parseInt(dao.SearchByCriteria(
				paginationDetachedCriteria).get(0).toString());
		// 取消查询条件中的聚合函数count(*)
		paginationDetachedCriteria.getDetachedCriteria().setProjection(null);
		//加入Order By 排序对象
		if(orderCondition !=null){
			orderCondition.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		}
		// 如果没有创建分页对象,在此创建
		if (pageFlag != true)
			pageCondition = cm.getNewPage();
		// 设置分页总记录数
		pageCondition.setTotalSize(i);
		// 添加分页查询条件
		pageCondition
				.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		// 获取符合条件的对象List
		pageCondition.setDataList(dao
				.SearchByCriteria(paginationDetachedCriteria));
		// 设置总页数
		pageCondition.setTotalPage((pageCondition.getTotalSize()
				+ pageCondition.getPageSize() - 1)
				/ pageCondition.getPageSize());
		return pageCondition;
	}
	/**
	 * 条件查询，返回有分页数据的 Page 类型的对象 （有数据）
	 * @param clz	由hibernate映射出来的实体对象的类型
	 * @return	有分页数据的 Page 类型的对象 （有数据）
	 */
	public Page normalPublicSearch(Class clz) {

		// 创建DetachedCriteria对象,用于分页和条件查询
		PaginationDetachedCriteria paginationDetachedCriteria = new PaginationDetachedCriteria(clz);

		PageCondition pageCondition = cm.getNewPage();
		pageCondition.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		// 获取符合条件的对象List
		List list = dao.SearchByCriteria(paginationDetachedCriteria.getDetachedCriteria());
		pageCondition.setDataList(list);
		// 设置总页数
		pageCondition.setTotalPage(1);
		pageCondition.setPageNumber(1);
		int size = list.size();
		pageCondition.setPageSize(size);
		pageCondition.setTotalSize(size);
		return pageCondition;
	}
	/**
	 * 向表中添加一条数据
	 * @param o	由hibernate映射出来的实体对象
	 */
	public void add(Object o) {
		dao.add(o);
	}
	/**
	 * 由表中删除一条数据
	 * @param o	由hibernate映射出来的实体对象
	 */
	public void delete(Object o) {
		dao.delete(o);
	}
	/**
	 * 根据id由表中读取一条数据
	 * @param clz	由hibernate映射出来的实体对象的类型
	 * @param id	要查询的id
	 * @return		符合查询条件id的，由hibernate映射出来的实体对象
	 */
	public Object load(Class clz, Serializable id) {
		return dao.load(clz, id);
	}
	/**
	 * 向表中更新一条数据
	 * @param o	由hibernate映射出来的实体对象
	 */
	public void update(Object o) {
		dao.update(o);
	}
	/**
	 * 条件查询，返回 List类型的对象 
	 * @param clz			由hibernate映射出来的实体对象的类型
	 * @param pagination	是否有分页条件对象
	 * @param list			List<ConditionOfSearch>类型的参数，里面装有查询条件
	 * @return				List类型的对象
	 */
	public List normalPublicSearch(Class clz, Boolean pagination,
			List<ConditionOfSearch> list) {
		if (pagination) {
			return normalPublicSearch(clz, list).getDataList();
		} else {
			// 创建PaginationDetachedCriteria对象,用于条件查询
			PaginationDetachedCriteria paginationDetachedCriteria = new PaginationDetachedCriteria(
					clz);
			// 迭代每个ConditionOfSearch对象,向criteria和criteria2添加除分页外的所有元素
			for (ConditionOfSearch conditionOfSearch : list) {
				conditionOfSearch
						.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
			}
			// 获取符合条件的对象List
			return dao.SearchByCriteria(paginationDetachedCriteria
					.getDetachedCriteria());
		}
	}
	/**
	 * 条件查询，返回 List类型的对象 
	 * @param clz					由hibernate映射出来的实体对象的类型
	 * @param pagination			是否有分页条件对象
	 * @param conditionOfSearchs	可变参数，ConditionOfSearch类型的查询条件，可任意个数
	 * @return						List类型的对象
	 */
	public List normalPublicSearch(Class clz, Boolean pagination,
			ConditionOfSearch... conditionOfSearchs) {
		if (pagination) {
			return normalPublicSearch(clz, conditionOfSearchs).getDataList();
		} else {
			// 创建PaginationDetachedCriteria对象,用于条件查询
			PaginationDetachedCriteria paginationDetachedCriteria = new PaginationDetachedCriteria(
					clz);
			// 迭代每个ConditionOfSearch对象,向criteria和criteria2添加除分页外的所有元素
			for (ConditionOfSearch conditionOfSearch : conditionOfSearchs) {
				conditionOfSearch
						.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
			}
			// 获取符合条件的对象List
			return dao.SearchByCriteria(paginationDetachedCriteria
					.getDetachedCriteria());
		}
	}
	
	
	
	/**
	 * 执行纯sql语句的方法,不可执行查询语句(由executeSqlSearch(String sql)方法执行查询),可以由多条sql语句组成，在同一个事物中执行，出现异常将回滚
	 * @param sqls	可变参数，可以由多条sql语句组成
	 * @return		List<Integer> 类型的对象，记录相同位置的sql语句执行后影响的行数
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> executeSql(final String... sqls) {
			Session session = dao.getSession();
			Transaction tx = null;
			List<Integer> counts = new ArrayList<Integer>();
			try {
				tx = session.beginTransaction();
				for (String sql : sqls) {
					counts.add(session.createSQLQuery(sql)
							.executeUpdate());
				}
				tx.commit();
				return counts;
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
				return null;
			}
	}

	
	/**
	 * 执行纯sql语句查询的方法,不可执行除查询外的其他语句(由executeSql(String... sqls)方法执行查询)
	 * @param sql	要执行的sql查询语句
	 * @return		List 类型的 对象
	 */
	public List executeSqlSearch(final String sql) {
		return  dao.getSession().createSQLQuery(sql).list();
	}
	/**
	 * 由spring向该对象注入sessionFactory对象的方法
	 * @param sessionFactory org.hibernate.SessionFactory类型的对象，由spring注入，慎用 
	 */
	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		dao.setSessionFactory(sessionFactory);		
	}
	@Override
	public Page paginationSearch(HttpServletRequest request, Class clz,
			ConditionOfSearch... conditionOfSearchs) {

		Boolean pageFlag = false; // 是否有PageCondition对象传入
		PageCondition pageCondition = null;
		OrderCondition orderCondition = null;
		// 创建PaginationDetachedCriteria对象,用于分页和条件查询
		PaginationDetachedCriteria paginationDetachedCriteria = new PaginationDetachedCriteria(
				clz);
		// 迭代每个ConditionOfSearch对象,向criteria和criteria2添加除分页外的所有元素
		for (ConditionOfSearch conditionOfSearch : conditionOfSearchs) {
			if (conditionOfSearch instanceof PageCondition) {
				pageCondition = (PageCondition) conditionOfSearch;
				pageFlag = true;
			}else if(conditionOfSearch instanceof OrderCondition){
				orderCondition = (OrderCondition)conditionOfSearch;
			}else {
				conditionOfSearch
						.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
			}
		}
		// 查询总记录数
		paginationDetachedCriteria.getDetachedCriteria().setProjection(
				Projections.rowCount());
		int i = Integer.parseInt(dao.SearchByCriteria(
				paginationDetachedCriteria).get(0).toString());
		// 取消查询条件中的聚合函数count(*)
		paginationDetachedCriteria.getDetachedCriteria().setProjection(null);
		//加入Order By 排序对象
		if(orderCondition !=null){
			orderCondition.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		}
		// 如果没有创建分页对象,在此创建
		if (pageFlag != true){
			String pageSize = request.getParameter("pageSize");
			String pageNumber = request.getParameter("pageNumber");
			if (pageSize == null || pageSize.equals("")) {
				pageSize="20";
			}
			if (pageNumber == null || pageNumber.equals("")) {
				pageNumber="1";
			}		
			pageCondition = cm.getNewPage(Integer.parseInt(pageNumber), Integer.parseInt(pageSize));		
		}
		// 设置分页总记录数
		pageCondition.setTotalSize(i);
		// 添加分页查询条件
		pageCondition
				.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		// 获取符合条件的对象List
		pageCondition.setDataList(dao
				.SearchByCriteria(paginationDetachedCriteria));
		// 设置总页数
		pageCondition.setTotalPage((pageCondition.getTotalSize()
				+ pageCondition.getPageSize() - 1)
				/ pageCondition.getPageSize());
		request.setAttribute("page", pageCondition);
		return pageCondition;
	}
	@Override
	public Page paginationSearch(HttpServletRequest request, Class clz,
			List<ConditionOfSearch> list) {

		Boolean pageFlag = false; // 是否有PageCondition对象传入
		PageCondition pageCondition = null;
		OrderCondition orderCondition = null;
		// 创建PaginationDetachedCriteria对象,用于分页和条件查询
		PaginationDetachedCriteria paginationDetachedCriteria = new PaginationDetachedCriteria(
				clz);
		// 迭代每个ConditionOfSearch对象,向criteria和criteria2添加除分页外的所有元素
		for (ConditionOfSearch conditionOfSearch : list) {
			if (conditionOfSearch instanceof PageCondition) {
				pageCondition = (PageCondition) conditionOfSearch;
				pageFlag = true;
			}else if(conditionOfSearch instanceof OrderCondition){
				orderCondition = (OrderCondition)conditionOfSearch;
			}else {
				conditionOfSearch
						.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
			}
		}
		// 查询总记录数
		paginationDetachedCriteria.getDetachedCriteria().setProjection(
				Projections.rowCount());
		int i = Integer.parseInt(dao.SearchByCriteria(
				paginationDetachedCriteria).get(0).toString());
		// 取消查询条件中的聚合函数count(*)
		paginationDetachedCriteria.getDetachedCriteria().setProjection(null);
		//加入Order By 排序对象
		if(orderCondition !=null){
			orderCondition.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		}
		// 如果没有创建分页对象,在此创建
		if (pageFlag != true){
			String pageSize = request.getParameter("pageSize");
			String pageNumber = request.getParameter("pageNumber");
			if (pageSize == null || pageSize.equals("")) {
				pageSize="20";
			}
			if (pageNumber == null || pageNumber.equals("")) {
				pageNumber="1";
			}		
			pageCondition = cm.getNewPage(Integer.parseInt(pageNumber), Integer.parseInt(pageSize));		
		}
		// 设置分页总记录数
		pageCondition.setTotalSize(i);
		// 添加分页查询条件
		pageCondition
				.addConditionToPaginationDetachedCriteria(paginationDetachedCriteria);
		// 获取符合条件的对象List
		pageCondition.setDataList(dao
				.SearchByCriteria(paginationDetachedCriteria));
		// 设置总页数
		pageCondition.setTotalPage((pageCondition.getTotalSize()
				+ pageCondition.getPageSize() - 1)
				/ pageCondition.getPageSize());
		request.setAttribute("page", pageCondition);
		return pageCondition;
	}

	// public PageCondition simplePublicSearchCrm(Class clz,
	// ConditionOfSearch... conditionOfSearchs) {
	// Boolean pageFlag = false; // 是否有PageCondition对象传入
	// PageCondition pageCondition = null;
	// // 创建Criteria实例
	// Criteria criteria = dao.getHibernateCriteria(clz);
	// // 创建Criteria实例2用于查询总记录数
	// // Criteria criteria2 = dao.getHibernateCriteria(clz);
	// // 迭代每个ConditionOfSearch对象,向criteria和criteria2添加除分页外的所有元素
	// for (ConditionOfSearch conditionOfSearch : conditionOfSearchs) {
	// if (conditionOfSearch.getClass() == PageCondition.class) {
	// pageCondition = (PageCondition) conditionOfSearch;
	// pageFlag = true;
	// } else {
	// conditionOfSearch.addConditionToCriteria(criteria);
	// // conditionOfSearch.addConditionToCriteria(criteria2);
	// }
	// }
	// // 查询总记录数
	// // criteria2.setProjection(Projections.rowCount());
	// criteria.setProjection(Projections.rowCount());
	// List l = criteria.list();
	// int i = 0;
	// i = Integer.parseInt(l.get(0).toString());
	// criteria.setProjection(null);
	// // 如果没有创建分页对象,在此创建
	// if (pageFlag != true)
	// pageCondition = new PageCondition();
	// pageCondition.setTotalSize(i); // 设置分页总记录数
	// pageCondition.addConditionToCriteria(criteria); // 添加分页查询条件
	// pageCondition.setDataList(criteria.list()); // 获取符合条件的对象List
	// pageCondition.setTotalPage( // 设置总页数
	// (pageCondition.getTotalSize() + pageCondition.getPageSize() - 1)
	// / pageCondition.getPageSize());
	// return pageCondition;
	// }
	//
	// public PageCondition simplePublicSearchCrm(Class clz,
	// List<ConditionOfSearch> list) {
	// Boolean pageFlag = false; // 是否有PageCondition对象传入
	// PageCondition pageCondition = null;
	// // 创建Criteria实例
	// Criteria criteria = dao.getHibernateCriteria(clz);
	// // 创建Criteria实例2用于查询总记录数
	// // Criteria criteria2 = dao.getHibernateCriteria(clz);
	// // 迭代每个ConditionOfSearch对象,向criteria和criteria2添加除分页外的所有元素
	// for (ConditionOfSearch conditionOfSearch : list) {
	// if (conditionOfSearch.getClass() == PageCondition.class) {
	// pageCondition = (PageCondition) conditionOfSearch;
	// pageFlag = true;
	// } else {
	// conditionOfSearch.addConditionToCriteria(criteria);
	// // conditionOfSearch.addConditionToCriteria(criteria2);
	// }
	// }
	// // 查询总记录数
	// // criteria2.setProjection(Projections.rowCount());
	// criteria.setProjection(Projections.rowCount());
	// List l = criteria.list();
	// int i = 0;
	// i = Integer.parseInt(l.get(0).toString());
	// criteria.setProjection(null);
	// // 如果没有创建分页对象,在此创建
	// if (pageFlag != true)
	// pageCondition = new PageCondition();
	// pageCondition.setTotalSize(i); // 设置分页总记录数
	// pageCondition.addConditionToCriteria(criteria); // 添加分页查询条件
	// pageCondition.setDataList(criteria.list()); // 获取符合条件的对象List
	// pageCondition.setTotalPage( // 设置总页数
	// (pageCondition.getTotalSize() + pageCondition.getPageSize() - 1)
	// / pageCondition.getPageSize());
	// return pageCondition;
	// }
}
