package sopsoft.demo.service;

import sopsoft.demo.entity.User;

public interface IUserService {
	public int lookUser();  
    public int deleteUser(int id);  
    public void saveUser(User user);  
}
