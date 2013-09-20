package net.sopsoft.framework.shutil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ConditionManager {
	/**
	 * 返回聚合函数对象，通过聚合函数对象下的方法添加聚合函数条件，最后把聚合函数对象加入查询条件
	 * 
	 * @return RelationCondition 类型的聚合函数对象
	 */
	public AggregateCondition aggregate(){
		return new AggregateCondition();		
	}
	/**
	 * 别名
	 * @param conditionName 要起别名的条件名
	 * @param aliasName		给条件起的别名
	 * @return	RelationCondition 类型的别名对象
	 */	 
	public AliasCondition alias(String conditionName,String aliasName){
		return new AliasCondition(conditionName, aliasName);
	}
	/**
	 * between
	 * @param conditionName  	条件名
	 * @param lowValue			低的值
	 * @param highValue			高的值
	 * @return	SimpleCondition	类型的对象
	 */
		 
	public BetweenAndGeLeCondition between(String conditionName, Object lowValue,
			Object highValue){
		return new BetweenAndGeLeCondition(conditionName, lowValue, highValue);
	}
	/**
	 * 大于等于
	 * @param conditionName  	条件名
	 * @param lowValue			要大于等于的值
	 * @return	SimpleCondition	类型的对象
	 */
	public BetweenAndGeLeCondition ge(String conditionName, Object lowValue){
		return new BetweenAndGeLeCondition(conditionName, lowValue);
	}
	/**
	 * 小于等于
	 * @param conditionName  	条件名
	 * @param lowValue			要小于等于的值
	 * @return	SimpleCondition	类型的对象
	 */
	public BetweenAndGeLeCondition le(String conditionName,Object highValue){
		return new BetweenAndGeLeCondition(conditionName, null,highValue);
	}
	/**
	 * 等于
	 * @param conditionName		条件名
	 * @param conditionValue	要等于的值
	 * @return	SimpleCondition	类型的对象
	 */
	public EqualCondition eq(String conditionName, Object conditionValue){
		return new EqualCondition(conditionName, conditionValue);
	}
	/**
	 * 大于
	 * @param conditionName		条件名
	 * @param conditionValue	要大于的值
	 * @return	SimpleCondition	类型的对象
	 */
	public GtCondition gt(String conditionName, Object conditionValue){
		return new GtCondition(conditionName, conditionValue);
	}

	/**
	 * 小于
	 * @param conditionName		条件名
	 * @param conditionValue	要小于的值
	 * @return	SimpleCondition	类型的对象
	 */
	public LtCondition lt(String conditionName, Object conditionValue){
		return new LtCondition(conditionName, conditionValue);
	}
	/**
	 * 内联接
	 * @param conditionName		条件名
	 * @param conditionList		联接条件组成的list，类型为 List<RelationCondition>
	 * @return	RelationCondition	类型的对象
	 */
	public JoinCondition join(String conditionName,List<RelationCondition> conditionList){
		return new JoinCondition(conditionName, conditionList);
	}
	/**
	 * 内联接
	 * @param conditionName		条件名
	 * @param relationConditions	可变参数，联接条件（可多个），类型为 RelationCondition
	 * @return	RelationCondition	类型的对象
	 */
	public JoinCondition join(String conditionName,RelationCondition...relationConditions){
		return new JoinCondition(conditionName, relationConditions);
	}
	/**
	 * 模糊查询
	 * @param conditionName		条件名
	 * @param conditionValue	模糊查询的值
	 * @return	SimpleCondition	类型的对象
	 */
	public LikeCondition like(String conditionName, Object conditionValue){
		return new LikeCondition(conditionName, conditionValue);
	}
	
	/**
	 * 或条件查询，当传入参数中任意一个符合条件时，数据将被查出。
	 * @param simpleCondition	第一个条件
	 * @param simpleCondition2	第二个条件
	 * @param simpleConditions	更多条件
	 * @return	ComplexCondition 类型的对象
	 */
	public OrCondition or(SimpleCondition simpleCondition,SimpleCondition simpleCondition2,SimpleCondition... simpleConditions){
		OrCondition orCondition = new OrCondition();
		orCondition.add(simpleCondition).add(simpleCondition2);
		for (SimpleCondition simpleCondition3 : simpleConditions) {
			orCondition.add(simpleCondition3);
		}
		return orCondition;
	}
	
	/**
	 * 创建一个分页对象，将分页对象作为条件传入查询方法，
	 * 可返回一个当前页数为 1，显示10条记录的分页对象
	 * @return	ConditionOfSearch	类型的分页对象（无具体数据）
	 */
	public Page page(){
		return new OriginalPageCondition();
	}
	/**
	 * 创建一个分页对象，将分页对象作为条件传入查询方法，
	 * 可返回一个当前页数为 pageNumber，显示  pageSize 条记录的分页对象 
	 * @param pageNumber	当前页数
	 * @param pageSize		每页记录条数
	 * @return	ConditionOfSearch	类型的分页对象（无具体数据）
	 */
	public Page page(int pageNumber,int pageSize){
		return new OriginalPageCondition(pageNumber,pageSize);
	}
	
	PageCondition getNewPage(){
		return new OriginalPageCondition();
	}
	
	PageCondition getNewPage(int pageNumber,int pageSize){
		return new OriginalPageCondition(pageNumber,pageSize);
	}
	
	public OrderCondition asc(String conditionName) {
		return new OrderCondition(true, conditionName);
	}
	public OrderCondition desc(String conditionName) {
		return new OrderCondition(false, conditionName);
	}
	
	public NullCondition isNull(String conditionName) {
		return new NullCondition(false, conditionName);
	}
	
	public NullCondition isNotNull(String conditionName){
		return new NullCondition(true, conditionName);
	}
	
	public EmptyCondition isEmpty(String conditionName){
		return new EmptyCondition(false, conditionName);
	}
	
	public EmptyCondition isNotEmpty(String conditionName) {
		return new EmptyCondition(true, conditionName);
	}
	
    public NotCondition not(SimpleCondition simpleCondition){
    	return new NotCondition(simpleCondition);
    }
    
    
	public AndCondition and(SimpleCondition simpleCondition,SimpleCondition simpleCondition2,SimpleCondition... simpleConditions){
		
		AndCondition andCondition = new AndCondition();
		andCondition.add(simpleCondition).add(simpleCondition2);
		for (SimpleCondition simpleCondition3 : simpleConditions) {
			andCondition.add(simpleCondition3);
		}
		return andCondition;
	}
	
	private class AndCondition extends ComplexCondition{
		
		@Override
		public Criterion toComplexCondition() {
			try {
				if(getCriterionList().size()<2){
					throw new SizeException();
				}
				if (getCriterionList().size() > 2) {
					Criterion criterion = Expression.and(getCriterionList().get(0),
							getCriterionList().get(1));
					if (getCriterionList().size() > 3) {
						for (int i = 3; i < getCriterionList().size(); i++) {
							criterion = Expression.and(getCriterionList().get(i),
									criterion);
						}
						return Expression.and(criterion, getCriterionList().get(2));
					} else {
						return Expression.and(criterion, getCriterionList().get(2));
					}
				} else {
					return Expression.and(getCriterionList().get(0),
							getCriterionList().get(1));
				}
			} catch (Exception e) {

				e.printStackTrace();
				return null;
			}
		}

		@Override
		public void addConditionToDetachedCriteria(
				DetachedCriteria detachedCriteria) {
			try {
				if(getCriterionList().size()<2){
					throw new SizeException();
				}
				if (getCriterionList().size() > 2) {
					Criterion criterion = Expression.and(getCriterionList().get(0),
							getCriterionList().get(1));
					if (getCriterionList().size() > 3) {
						for (int i = 3; i < getCriterionList().size(); i++) {
							criterion = Expression.and(getCriterionList().get(i),
									criterion);
						}
						detachedCriteria.add(Expression.and(criterion, getCriterionList()
								.get(2)));
					} else {
						detachedCriteria.add(Expression.and(criterion, getCriterionList()
								.get(2)));
					}

				} else {
					detachedCriteria.add(Expression.and(getCriterionList().get(0),
							getCriterionList().get(1)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void addConditionToCriteria(Criteria criteria) {
			try {
				if(getCriterionList().size()<2){
					throw new SizeException();
				}
				if (getCriterionList().size() > 2) {
					Criterion criterion = Expression.and(getCriterionList().get(0),
							getCriterionList().get(1));
					if (getCriterionList().size() > 3) {
						for (int i = 3; i < getCriterionList().size(); i++) {
							criterion = Expression.and(getCriterionList().get(i),
									criterion);
						}
						criteria.add(Expression.and(criterion, getCriterionList()
								.get(2)));
					} else {
						criteria.add(Expression.and(criterion, getCriterionList()
								.get(2)));
					}

				} else {
					criteria.add(Expression.and(getCriterionList().get(0),
							getCriterionList().get(1)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			try {
				if(getCriterionList().size()<2){
					throw new SizeException();
				}
				if (getCriterionList().size() > 2) {
					Criterion criterion = Expression.and(getCriterionList().get(0),
							getCriterionList().get(1));
					if (getCriterionList().size() > 3) {
						for (int i = 3; i < getCriterionList().size(); i++) {
							criterion = Expression.and(getCriterionList().get(i),
									criterion);
						}
						paginationDetachedCriteria.getDetachedCriteria().add(Expression.and(criterion, getCriterionList()
								.get(2)));
					} else {
						paginationDetachedCriteria.getDetachedCriteria().add(Expression.and(criterion, getCriterionList()
								.get(2)));
					}

				} else {
					paginationDetachedCriteria.getDetachedCriteria().add(Expression.and(getCriterionList().get(0),
							getCriterionList().get(1)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	private class NotCondition implements SimpleCondition {
		SimpleCondition condition;
		private NotCondition(SimpleCondition condition){
			this.condition = condition;
		}
		@Override
		public void addConditionToDetachedCriteria(
				DetachedCriteria detachedCriteria) {
			detachedCriteria.add(Expression.not(condition.toComplexCondition()));			
		}

		@Override
		public void addConditionToCriteria(Criteria criteria) {
			criteria.add(Expression.not(condition.toComplexCondition()));
		}

		@Override
		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			paginationDetachedCriteria.getDetachedCriteria().add(Expression.not(condition.toComplexCondition()));
		}

		@Override
		public Criterion toComplexCondition() {
			return Expression.not(condition.toComplexCondition());
		}

		
		
	}
	
	private class EmptyCondition implements SimpleCondition{
		private String conditionName;
		private boolean isNot;
		private EmptyCondition(boolean isNot,String conditionName){
			this.isNot = isNot;
			this.conditionName = conditionName;			
		}
		@Override
		public void addConditionToDetachedCriteria(
				DetachedCriteria detachedCriteria) {
			detachedCriteria.add(isNot?Expression.isNotEmpty(conditionName):Expression.isEmpty(conditionName));			
		}

		@Override
		public void addConditionToCriteria(Criteria criteria) {
			criteria.add(isNot?Expression.isNotEmpty(conditionName):Expression.isEmpty(conditionName));			
		}

		@Override
		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			paginationDetachedCriteria.getDetachedCriteria().add(isNot?Expression.isNotEmpty(conditionName):Expression.isEmpty(conditionName));			
		}

		@Override
		public Criterion toComplexCondition() {
			if (isNot) {
				return Expression.isNotEmpty(conditionName);
			}else {
				return Expression.isEmpty(conditionName);			
			}			
		}				
	}
	
	private class NullCondition implements SimpleCondition{
		private String conditionName;
		private boolean isNot;
		private NullCondition(boolean isNot,String conditionName){
			this.isNot = isNot;
			this.conditionName = conditionName;			
		}
		
		@Override
		public void addConditionToDetachedCriteria(
				DetachedCriteria detachedCriteria) {
			detachedCriteria.add(isNot?Expression.isNotNull(conditionName):Expression.isNull(conditionName));
			
		}

		@Override
		public void addConditionToCriteria(Criteria criteria) {
			criteria.add(isNot?Expression.isNotNull(conditionName):Expression.isNull(conditionName));
		}

		@Override
		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			paginationDetachedCriteria.getDetachedCriteria().add(isNot?Expression.isNotNull(conditionName):Expression.isNull(conditionName));
		}

		@Override
		public Criterion toComplexCondition() {
			if (isNot) {
				return Expression.isNotNull(conditionName);
			}else {
				return Expression.isNull(conditionName);
			}			
		}	
	}
	
	
	class OrderCondition implements RelationCondition{
		private String conditionName;
		private boolean isAsc;
		private OrderCondition(Boolean isAsc,String conditionName){
			this.isAsc =isAsc;
			this.conditionName = conditionName;
		}
		public void addConditionToDetachedCriteria(
				DetachedCriteria detachedCriteria) {
			detachedCriteria.addOrder(isAsc?Order.asc(conditionName):Order.desc(conditionName));
			
		}

		public void addConditionToCriteria(Criteria criteria) {
			criteria.addOrder(isAsc?Order.asc(conditionName):Order.desc(conditionName));
		}

		public void addConditionToPaginationDetachedCriteria(
			PaginationDetachedCriteria paginationDetachedCriteria) {
			paginationDetachedCriteria.getDetachedCriteria().addOrder(isAsc?Order.asc(conditionName):Order.desc(conditionName));
			
		}
		
	}
	
	public interface Page extends ConditionOfSearch{
		/**
		 * 是否有查询过后的分页数据
		 * @return	有数据时返回 true ， 无数据时返回false
		 */
		public boolean  isFull();
		
		/**
		 * 返回该组分页数据的总页数
		 * @return	int类型的总页数
		 */
		public int getTotalPage();
		/**
		 * 返回该组分页数据的当前页数  
		 * @return	int类型的当前页数  
		 */
		public int getPageNumber();
		/**
		 * 返回该组分页数据的每页记录条数
		 * @return	int类型的每页记录条数
		 */
		public int getPageSize();
		/**
		 * 返回该组分页数据的总记录条数
		 * @return	int类型的总记录条数
		 */
		public int getTotalSize();
		/**
		 * 返回该组分页数据的当前页数据
		 * @return	List类型的当前页数据
		 */
		public List getDataList();
	}
	
	private class OriginalPageCondition extends PageCondition{
		public OriginalPageCondition(){
			super();
		}
		public OriginalPageCondition(int pageNumber,int pageSize){
			super(pageNumber,pageSize);
		}

	}
	
	abstract class PageCondition implements Page,ConditionOfSearch{
		
		private int totalPage;   //总页数
		private int pageNumber = 1;  //当前页数  默认值为1
		private int pageSize = 10;    //每页记录条数	 默认值为10 
		private int totalSize;   //总记录条数
		private List dataList;   //当前页数据
		private boolean full = false;	//page页中是否有数据
		
		
		public PageCondition(){}
		
		public PageCondition(int pageNumber,int pageSize){
			this.pageNumber = pageNumber;
			this.pageSize = pageSize;
		}
		
		public void addConditionToCriteria(Criteria criteria) {
			criteria.setFirstResult((pageSize)*(pageNumber-1));
			criteria.setMaxResults(pageSize);
		}
		
		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			paginationDetachedCriteria.setFirstResult((pageSize)*(pageNumber-1));
			paginationDetachedCriteria.setMaxResults(pageSize);		
		}
			
		public boolean isFull(){
			return full;
		}
		
		public int getTotalPage() {
			return totalPage;
		}

		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}

		public int getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getTotalSize() {
			return totalSize;
		}

		public void setTotalSize(int totalSize) {
			this.totalSize = totalSize;
		}

		public List getDataList() {
			return dataList;
		}

		public void setDataList(List dataList) {
			this.dataList = dataList;
			if(dataList !=null ){
				full = true;
			}
		}		
	}
	
	private class OrCondition extends ComplexCondition {

		public void addConditionToCriteria(Criteria criteria) {
			try {
				if(getCriterionList().size()<2){
					throw new SizeException();
				}
				if (getCriterionList().size() > 2) {
					Criterion criterion = Expression.or(getCriterionList().get(0),
							getCriterionList().get(1));
					if (getCriterionList().size() > 3) {
						for (int i = 3; i < getCriterionList().size(); i++) {
							criterion = Expression.or(getCriterionList().get(i),
									criterion);
						}
						criteria.add(Expression.or(criterion, getCriterionList()
								.get(2)));
					} else {
						criteria.add(Expression.or(criterion, getCriterionList()
								.get(2)));
					}

				} else {
					criteria.add(Expression.or(getCriterionList().get(0),
							getCriterionList().get(1)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			try {
				if(getCriterionList().size()<2){
					throw new SizeException();
				}
				if (getCriterionList().size() > 2) {
					Criterion criterion = Expression.or(getCriterionList().get(0),
							getCriterionList().get(1));
					if (getCriterionList().size() > 3) {
						for (int i = 3; i < getCriterionList().size(); i++) {
							criterion = Expression.or(getCriterionList().get(i),
									criterion);
						}
						paginationDetachedCriteria.getDetachedCriteria()
								.add(
										Expression.or(criterion, getCriterionList()
												.get(2)));
					} else {
						paginationDetachedCriteria.getDetachedCriteria()
								.add(
										Expression.or(criterion, getCriterionList()
												.get(2)));
					}

				} else {
					paginationDetachedCriteria.getDetachedCriteria().add(
							Expression.or(getCriterionList().get(0),
									getCriterionList().get(1)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			try {
				if(getCriterionList().size()<2){
					throw new SizeException();
				}
				if (getCriterionList().size() > 2) {
					Criterion criterion = Expression.or(getCriterionList().get(0),
							getCriterionList().get(1));
					if (getCriterionList().size() > 3) {
						for (int i = 3; i < getCriterionList().size(); i++) {
							criterion = Expression.or(getCriterionList().get(i),
									criterion);
						}
						detachedCriteria.add(Expression.or(criterion,
								getCriterionList().get(2)));
					} else {
						detachedCriteria.add(Expression.or(criterion,
								getCriterionList().get(2)));
					}
				} else {
					detachedCriteria.add(Expression.or(getCriterionList().get(0),
							getCriterionList().get(1)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public Criterion toComplexCondition() {
			try {
				if(getCriterionList().size()<2){
					throw new SizeException();
				}
				if (getCriterionList().size() > 2) {
					Criterion criterion = Expression.or(getCriterionList().get(0),
							getCriterionList().get(1));
					if (getCriterionList().size() > 3) {
						for (int i = 3; i < getCriterionList().size(); i++) {
							criterion = Expression.or(getCriterionList().get(i),
									criterion);
						}
						return Expression.or(criterion, getCriterionList().get(2));
					} else {
						return Expression.or(criterion, getCriterionList().get(2));
					}
				} else {
					return Expression.or(getCriterionList().get(0),
							getCriterionList().get(1));
				}
			} catch (Exception e) {

				e.printStackTrace();
				return null;
			}
		}
	}
	
	private abstract class ComplexCondition implements SimpleCondition {
		
		private List<Criterion> criterionList=new ArrayList<Criterion>();
		
			
		public List<Criterion> getCriterionList(){

			return criterionList;
		}
		
		public ComplexCondition add(SimpleCondition simpleCondition){
			criterionList.add(simpleCondition.toComplexCondition());
			return this;
		}
	}
	
	private class LikeCondition implements SimpleCondition {

		private String conditionName;
		private Object conditionValue;

		public LikeCondition(String conditionName, Object conditionValue) {
			this.conditionName = conditionName;
			this.conditionValue = conditionValue;
		}

		public void addConditionToCriteria(Criteria criteria) {
			criteria.add(Expression.like(conditionName,conditionValue));
		}

		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {

			paginationDetachedCriteria.getDetachedCriteria().add(
					Expression.like(conditionName,conditionValue));
		}	
		public Criterion toComplexCondition() {
			return Restrictions.like(conditionName, conditionValue);
		}

		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			detachedCriteria.add(
					Expression.like(conditionName,conditionValue));
		}
	}
	
	private class JoinCondition implements RelationCondition {
		private String conditionName;
		private List<RelationCondition> conditionList = new ArrayList<RelationCondition>();
		
		public JoinCondition(String conditionName,List<RelationCondition> conditionList){
			this.conditionName=conditionName;
			this.conditionList=conditionList;
		}
		public JoinCondition(String conditionName,RelationCondition...relationConditions){
			this.conditionName=conditionName;
			for (RelationCondition relationCondition : relationConditions) {
				conditionList.add(relationCondition);
			}		
		}
		public void addConditionToCriteria(Criteria criteria) {
			Criteria criteria4conditionName = criteria.createCriteria(conditionName);
			for (RelationCondition relationCondition : conditionList) {
				relationCondition.addConditionToCriteria(criteria4conditionName);
			}
		}

		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			DetachedCriteria criteria4conditionName = paginationDetachedCriteria.getDetachedCriteria().createCriteria(conditionName);
			for (RelationCondition relationCondition : conditionList) {
				relationCondition.addConditionToDetachedCriteria(criteria4conditionName);			
			}

		}
		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			DetachedCriteria criteria4conditionName =detachedCriteria.createCriteria(conditionName);
			for (RelationCondition relationCondition : conditionList) {
				relationCondition.addConditionToDetachedCriteria(criteria4conditionName);			
			}		
		}
	}
	
	private class LtCondition implements SimpleCondition {
		private String conditionName;
		private Object conditionValue;

		public LtCondition(String conditionName, Object conditionValue) {
			this.conditionName = conditionName;
			this.conditionValue = conditionValue;
	
		}
	public void addConditionToCriteria(Criteria criteria) {
			criteria.add(Expression.lt(conditionName, conditionValue));
		}
		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {

			paginationDetachedCriteria.getDetachedCriteria().add(
					Expression.lt(conditionName, conditionValue));			
		}
		public Criterion toComplexCondition() {
			
			return Restrictions.lt(conditionName, conditionValue);
		}
		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			detachedCriteria.add(
					Expression.lt(conditionName, conditionValue));		
		}
	}
	
	private class GtCondition implements SimpleCondition {
		private String conditionName;
		private Object conditionValue;

		public GtCondition(String conditionName, Object conditionValue) {
			this.conditionName = conditionName;
			this.conditionValue = conditionValue;
	
		}
		public void addConditionToCriteria(Criteria criteria) {
			criteria.add(Expression.gt(conditionName, conditionValue));
		}
		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {

			paginationDetachedCriteria.getDetachedCriteria().add(
					Expression.gt(conditionName, conditionValue));			
		}
		public Criterion toComplexCondition() {
			
			return Restrictions.gt(conditionName, conditionValue);
		}
		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			detachedCriteria.add(
					Expression.gt(conditionName, conditionValue));		
		}
	}
	
	private class EqualCondition implements SimpleCondition {
		private String conditionName;
		private Object conditionValue;

		public EqualCondition(String conditionName, Object conditionValue) {
			this.conditionName = conditionName;
			this.conditionValue = conditionValue;
	
		}

		public void addConditionToCriteria(Criteria criteria) {
			criteria.add(Expression.eq(conditionName, conditionValue));
		}

		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {

			paginationDetachedCriteria.getDetachedCriteria().add(
					Expression.eq(conditionName, conditionValue));
			
			
		}
		public Criterion toComplexCondition() {
			
			return Restrictions.eq(conditionName, conditionValue);
		}


		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			detachedCriteria.add(
					Expression.eq(conditionName, conditionValue));
			
		}
	}
	
	private class BetweenAndGeLeCondition implements SimpleCondition {

		private String conditionName;
		private Object lowValue;
		private Object highValue;

		public BetweenAndGeLeCondition(String conditionName, Object lowValue) {
			this.conditionName = conditionName;
			this.lowValue = lowValue;
		}

		public BetweenAndGeLeCondition(String conditionName, Object lowValue,
				Object highValue) {
			this.conditionName = conditionName;
			this.lowValue = lowValue;
			this.highValue = highValue;
		}

		public void addConditionToCriteria(Criteria criteria) {
			if (lowValue != null && highValue != null) {
				criteria
						.add(Expression.between(conditionName, lowValue, highValue));
			} else if (lowValue != null && highValue == null) {
				criteria.add(Expression.ge(conditionName, lowValue));
			} else {
				criteria.add(Expression.le(conditionName, highValue));
			}

		}

		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			if (lowValue != null && highValue != null) {
				paginationDetachedCriteria.getDetachedCriteria().add(
						Expression.between(conditionName, lowValue, highValue));
			} else if (lowValue != null && highValue == null) {
				paginationDetachedCriteria.getDetachedCriteria().add(
						Expression.ge(conditionName, lowValue));
			} else {
				paginationDetachedCriteria.getDetachedCriteria().add(
						Expression.le(conditionName, highValue));
			}

		}
		public Criterion toComplexCondition() {
			if (lowValue != null && highValue != null) {
				return Expression.between(conditionName, lowValue, highValue);
			} else if (lowValue != null && highValue == null) {
				return Expression.ge(conditionName, lowValue);
			} else {			
				return Expression.le(conditionName, highValue);
			}		
		}



		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			if (lowValue != null && highValue != null) {
				detachedCriteria.add(
						Expression.between(conditionName, lowValue, highValue));
			} else if (lowValue != null && highValue == null) {
				detachedCriteria.add(
						Expression.ge(conditionName, lowValue));
			} else {
				detachedCriteria.add(
						Expression.le(conditionName, highValue));
			}
		}
	}
	
	private class AliasCondition implements RelationCondition {
		private String conditionName;
		private String aliasName;
		public AliasCondition(String conditionName,String aliasName){
			this.aliasName=aliasName;
			this.conditionName=conditionName;
		}
		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			detachedCriteria.createAlias(conditionName, aliasName);
		}

		public void addConditionToCriteria(Criteria criteria) {
			criteria.createAlias(conditionName, aliasName);
		}

		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			paginationDetachedCriteria.getDetachedCriteria().createAlias(conditionName, aliasName);
		}

	}
	
	public class AggregateCondition implements RelationCondition {
		ProjectionList   proList   =   Projections.projectionList();
		public AggregateCondition sum(String conditionName){
			proList.add(Projections.sum(conditionName));    	
			return this;
		};
		public AggregateCondition group(String conditionName){
			proList.add(Projections.groupProperty(conditionName));
			return this;
		}
		public AggregateCondition avg(String conditionName){
			proList.add(Projections.avg(conditionName));
			return this;		
		}
		public AggregateCondition max(String conditionName){
			proList.add(Projections.max(conditionName));
			return this;
		}

		public AggregateCondition min(String conditionName){
			proList.add(Projections.min(conditionName));
			return this;
		}
		public AggregateCondition count(String conditionName){
			proList.add(Projections.count(conditionName));
			return this;
		}
		public AggregateCondition countDistinct(String conditionName){
			proList.add(Projections.countDistinct(conditionName));
			return this;
		}
		public AggregateCondition property(String conditionName){
			proList.add(Projections.property(conditionName));
			return this;
		}
		public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria) {
			detachedCriteria.setProjection(proList);
		}

		public void addConditionToCriteria(Criteria criteria) {
			criteria.setProjection(proList);
		}

		public void addConditionToPaginationDetachedCriteria(
				PaginationDetachedCriteria paginationDetachedCriteria) {
			paginationDetachedCriteria.getDetachedCriteria().setProjection(proList);
		}

	}
}
