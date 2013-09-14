package sopsoft.demo.dao;

import sopsoft.demo.entity.User;

public interface IUserDao {  
    /** 
     * 查看条数 
     * @return 
     */  
    public int lookUser();  
      
    /** 
     * 删除表数据 
     * @return 
     */  
    public int deleteUser(int id);  
      
    /** 
     * 添加数据 
     * @param user 
     */  
    public void saveUser(User user);  
}  
