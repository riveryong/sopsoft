package sopsoft.demo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sopsoft.utils.shutil.ConditionManager;
import net.sopsoft.utils.shutil.IPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sopsoft.demo.entity.User;

@Controller
@RequestMapping("/member")
public class MemberAction {

	@Autowired
	private IPublicService publicService;
	
	
	ConditionManager cm = new ConditionManager();
	
	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute User user,HttpServletRequest request) {
		System.out.println("Username:  " +user.getUsername());
		System.out.println("Password:  " +user.getPassword());
		publicService.add(user);
		return new ModelAndView("success");
	}
	
	@RequestMapping("/check")
	@ResponseBody
	public String check(@RequestParam  String username,HttpServletRequest request,HttpServletResponse response) {
		Long count = (Long) publicService.normalPublicSearch(User.class,false,cm.eq("username", username),cm.aggregate().count("username")).get(0);
		if (count == 0) {
			return "{'count':"+count+",'msg':'MemberNo OK!'}"; 
		}else {
			return "{'count':"+count+",'msg':'MemberNo repeat!'}"; 
		}
	}
	
	@RequestMapping("/p101a")
    @ResponseBody
	public ModelAndView foward(){
	    return new ModelAndView("M1/P101A");
	}
}
