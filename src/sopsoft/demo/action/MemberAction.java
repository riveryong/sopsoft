package sopsoft.demo.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.typeconverter.Convert;

import net.sopsoft.framework.shutil.ConditionManager;
import net.sopsoft.framework.shutil.IPublicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static Logger loger = LoggerFactory.getLogger(MemberAction.class);
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
	public Map<String, String> check(@RequestParam  String username,HttpServletRequest request,HttpServletResponse response) {
		loger.info("Member/check,开始检查会员编号是否重复");
		loger.debug("username:"+username);
		System.out.println(this.getClass().getClassLoader().getResource("").getPath());
		Long count = (Long) publicService.normalPublicSearch(User.class,false,cm.eq("username", username),cm.aggregate().count("username")).get(0);
		Map<String, String> modelMap = new HashMap<String, String>();
		if (count == 0) {
			modelMap.put("count", Convert.toString(count));
			modelMap.put("msg", "MemberNo OK!");
			return modelMap;
		}else {
			modelMap.put("count", Convert.toString(count));
			modelMap.put("msg", "MemberNo repeat!");
			return modelMap;
		}
	}
	
	@RequestMapping("/p101a")
    @ResponseBody
	public ModelAndView foward(){
	    return new ModelAndView("M1/P101A");
	}
}
