package sopsoft.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sopsoft.demo.dao.IUserDao;
import sopsoft.demo.entity.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired  
    private IUserDao userdao;  
  
    public int lookUser() {  
        return userdao.lookUser();  
    }  
    /** 
     * 删除表数据 
     * @return 
     */  
    public int deleteUser(int id){  
        return userdao.deleteUser(id);  
    }  
    /** 
     * 添加数据 
     * @param user 
     */  
    public void saveUser(User user){  
        userdao.saveUser(user);  
    }
}
