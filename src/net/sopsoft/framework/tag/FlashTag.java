package net.sopsoft.framework.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class FlashTag extends BodyTagSupport {

	private String id;						//id
	private String width = "100%"; 			//宽
	private String height = "100%"; 		//高
	private String src;						//swf文件路径
	private String flashVars;				//flash变量
	private String quality = "high";		//画质	

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		String str = getTagString(id, width, height, src, flashVars, quality);
		try {
			out.print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	
	public static String getTagString(String id,String width,String height,String src,String flashVars,String quality) {
		StringBuffer su = new StringBuffer();
		//object开始标签
		su.append("<object width='"+ width +"' height='"+ height +"' id='"+ id +"'") 
	       .append(" classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000'") 
	       .append(" codebase='http://fpdownload.macromedia.com" +
	       		"/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' > ")
	       .append("<param name='movie' value='"+ src +"' />")
	       .append("<param name='FlashVars' value=\""+ flashVars +"\" >")
	       .append("<param name='quality' value='"+ quality +"' />");
		
		//embed标签
		su.append("<embed src='"+ src +"' flashVars=\""+ flashVars +"\" ")
			.append("width='"+ width +"' height='"+ height +"' name='"+ id +"' ")
			.append("quality='"+ quality +"' type='application/x-shockwave-flash' ")
			.append("pluginspage='http://www.macromedia.com/go/getflashplayer' />");
		
		//object结束标签
		su.append("</object>");
		
		return su.toString();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getWidth() {
		return width;
	}


	public void setWidth(String width) {
		this.width = width;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getSrc() {
		return src;
	}


	public void setSrc(String src) {
		this.src = src;
	}


	public String getFlashVars() {
		return flashVars;
	}


	public void setFlashVars(String flashVars) {
		this.flashVars = flashVars;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	
}
