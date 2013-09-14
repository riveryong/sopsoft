package net.sopsoft.utils.tag;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class PageDateFormat extends BodyTagSupport {
	private String pattern; // 格式化显示日期的格式 格式化方法同SimpleDateFormat的格式化方法
	private Date date; // 要格式化的日期


	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		if (pattern != null && date != null) {

			DateFormat format = new SimpleDateFormat(pattern);
			String dateString = format.format(date);
			try {
				out.print(dateString);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return EVAL_PAGE;
	}

}
