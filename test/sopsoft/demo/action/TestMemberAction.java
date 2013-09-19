package sopsoft.demo.action;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import sopsoft.test.base.JUnitActionBase;

public class TestMemberAction extends JUnitActionBase {

	@Test
	public void testCheck() throws  Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		request.setRequestURI("/member/check");
		request.addParameter("username", "123123123");
		request.setMethod("POST");
		
		final ModelAndView mav = this.excuteAction(request, response);
		// Assert logic  
        Assert.assertEquals("/member/check", mav.getViewName());
        String msg = (String)request.getAttribute("msg");
		System.out.println(msg);
		
	}

}
