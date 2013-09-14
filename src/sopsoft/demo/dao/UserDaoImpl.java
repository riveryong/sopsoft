package sopsoft.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import sopsoft.demo.conmmon.BaseDao;
import sopsoft.demo.entity.User;
  
@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {

	/** 
     * 查询个数 
     */  
    public int lookUser(){  
        //Query query = getCurrentSession().createSQLQuery("SELECT COUNT(*) FROM t_user");  
        Query query = getCurrentSession().createQuery("FROM User");  
        List<?> l = query.list();  
        return l.size();  
    }  
      
    /** 
     * 删除表数据 
     * @return 
     */  
    public int deleteUser(int id){  
        Query query = getCurrentSession().createSQLQuery("DELETE  FROM t_user where id = "+id);  
        return query.executeUpdate();  
    }  
      
    /** 
     * 添加数据 
     * @param user 
     */  
    public void saveUser(User user){  
        getCurrentSession().save(user);  
    }  

}
