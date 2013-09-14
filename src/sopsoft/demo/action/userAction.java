package sopsoft.demo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sopsoft.utils.shutil.ConditionManager;
import net.sopsoft.utils.shutil.ConditionOfSearch;
import net.sopsoft.utils.shutil.IPublicService;
import net.sopsoft.utils.shutil.ConditionManager.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sopsoft.demo.entity.User;
import sopsoft.demo.service.IUserService;

@SuppressWarnings("unused")
@Controller
public class userAction {

	@Autowired
	private IUserService userService;

	@Autowired
	private IPublicService publicService;

	ConditionManager cm = new ConditionManager();

	@RequestMapping("/getUser")
	public String getUser() {
		// 返回查询的数量
		System.out.println("old:" + userService.lookUser());
		// 保存一个新的对象
		User d2u = new User();
		d2u.setUsername("adfadfasd");
		d2u.setPassword("sdfadfdfdf");
		userService.saveUser(new User());

		System.out.println("new:" + userService.lookUser());
		return "index";
	}

	@RequestMapping("/getUser2")
	public String getUser2(HttpServletRequest request) {
		
		// 返回查询的数量
		System.out.println("old:"
				+ publicService.normalPublicSearch(User.class, false,
						cm.aggregate().count("id")).get(0));
		// 保存一个新的对象
		User d2u = new User();
		d2u.setUsername("adfadfasd");
		d2u.setPassword("sdfadfdfdf");
		publicService.add(d2u);

		Page page = publicService.normalPublicSearch(User.class);
		request.setAttribute("page", page);
		
		System.out.println("new:"
				+ publicService.normalPublicSearch(User.class, false,
						cm.aggregate().count("id")).get(0));
		return "index";
	}
}
