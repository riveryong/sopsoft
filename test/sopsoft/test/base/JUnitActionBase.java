package sopsoft.test.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

public class JUnitActionBase {

	private static HandlerMapping handlerMapping;
	private static HandlerAdapter handlerAdapter;

	/**
	 * 读取spring3 MVC配置文件
	 */
	@BeforeClass
	public static void setUp() {
		if (handlerMapping == null) {
			String[] configs = { "file:resources/spring-servlet.xml" };
			XmlWebApplicationContext context = new XmlWebApplicationContext();
			context.setConfigLocations(configs);
			MockServletContext msc = new MockServletContext();
			context.setServletContext(msc);
			context.refresh();
			msc.setAttribute(
					WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
					context);
			handlerMapping = (HandlerMapping) context
					.getBean(DefaultAnnotationHandlerMapping.class);
			handlerAdapter = (HandlerAdapter) context
					.getBean(context
							.getBeanNamesForType(AnnotationMethodHandlerAdapter.class)[0]);
		}
	}
	
	/** 
     * 执行request对象请求的action 
     *  
     * @param request 
     * @param response 
     * @return 
     * @throws Exception 
     */  
    public ModelAndView excuteAction(HttpServletRequest request, HttpServletResponse response)  
 throws Exception {  
    	request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING,true);
        HandlerExecutionChain chain = handlerMapping.getHandler(request);  
        ModelAndView model = null;
        try{
        	model = handlerAdapter.handle(request, response,  
                    chain.getHandler()); 
        } catch(Exception e){
        	e.printStackTrace();
        }
         
        return model;  
    }

}
