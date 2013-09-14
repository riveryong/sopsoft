package net.sopsoft.utils.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import net.sopsoft.utils.shutil.ConditionManager.Page;

public class PaginationTag extends BodyTagSupport {

	/**
     * 
     */
    private static final long serialVersionUID = 8459558862345715898L;
    private int totalPage; // 总页数
	private int pageNumber; // 当前页数
	private int pageSize; // 每页记录条数
	private int totalSize; // 总记录条数
	private String searchMethod; //查询对应的ACTION方法名称
	
	public String getSearchMethod() {
		return searchMethod;
	}

	public void setSearchMethod(String searchMethod) {
		this.searchMethod = searchMethod;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		Page page =(Page)pageContext.getAttribute("page",PageContext.REQUEST_SCOPE);
		totalPage = page.getTotalPage();
		totalSize = page.getTotalSize();
		pageNumber = page.getPageNumber();
		pageSize = page.getPageSize();	
		StringBuffer su = new StringBuffer();
		su	.append("	<script  language=\"javascript\" type=\"text/javascript\">")	
			.append("$(function(){"+				
				"var $totalPage = parseInt($(\"#totalPage\").text()); "+ 
				"var $totalSize = parseInt($(\"#totalSize\").text());"+	 
				"var $pageSize = parseInt($(\"#pageSize\").val());"+		
				"var $pageNumber = parseInt($(\"#pageNumber\").val());"+		
				"var $searchMethod = $(\"#searchMethod\").text();");			
		su	.append("$(\"#searchMethod\").hide();")
			.append("if($pageNumber==1){"+
					"	$(\"#prevPage\").replaceWith(\"<label style=\\\"margin:0 10px;font-size:10px;line-height:100%;\\\">上一页</label>\");"+					
					"}"+
					"if($pageNumber==$totalPage){"+
					"	$(\"#nextPage\").replaceWith(\"<label style=\\\"margin:0 10px;font-size:10px;line-height:100%;\\\">下一页</label>\");"+					
					"}");								
		su	.append("$(\"#submitGO\").click(function(){"+
					"	var $goPage = parseInt($(\"#goPage\").val());"+
					"$(\"input[name='op']\").val($searchMethod);"+											
					"if($goPage>=1 && $goPage<=$totalPage){"+
					"	$(\"#pageNumber\").val($goPage);"+
					"	document.forms[0].submit();"+
					"}else{"+
					"	alert(\"没有您输入的页数，请重新输入！\");"+
					"}"+				
					"});");
		su	.append("$(\"#firstPage\").click(function(event){"+
						"$(\"input[name='op']\").val($searchMethod);"+
						"$(\"#pageNumber\").val(1);"+
						"document.forms[0].submit();"+
						"event.stopImmediatePropagation();"+
					"});");
		su	.append("$(\"#prevPage\").click(function(event){"+
						"$(\"input[name='op']\").val($searchMethod);"+
						"$(\"#pageNumber\").val($pageNumber-1);"+
						"document.forms[0].submit();"+
						"event.stopImmediatePropagation();"+
					"});");
		su	.append("$(\"#nextPage\").click(function(event){"+
						"$(\"input[name='op']\").val($searchMethod);"+
						"$(\"#pageNumber\").val($pageNumber+1);"+
						"document.forms[0].submit();"+
						"event.stopImmediatePropagation()"+
					"});");
		su	.append("$(\"#lastPage\").click(function(event){"+
						"$(\"input[name='op']\").val($searchMethod);"+
						"$(\"#pageNumber\").val($totalPage);"+
						"document.forms[0].submit();"+
						"event.stopImmediatePropagation()"+
					"});");
				
				
		su.	append("	});")
			.append("</script>")
			
				.append("<div style=\"margin:auto;width:95%;height:40px;text-align:center;color:darkblue;\">")
				.append(
						"共<span id=\"totalSize\">"
								+ totalSize
								+ "</span>条记录    每页<input type=\"text\" id=\"pageSize\" name=\"pageSize\" value=\""
								+ pageSize + "\" style=\"width:30px;\"/>条    ").append(
						"当前第"	+ pageNumber+ "页/共<span id=\"totalPage\">"
								+ totalPage + "</span>页    ").append(
						"<label id=\"firstPage\" href=\"#\" style=\"cursor:pointer;color:darkblue;margin:0 10px;font-size:16px;\">第一页</label>").append(
						"<label id=\"prevPage\" href=\"#\" style=\"cursor:pointer;color:darkblue;margin:0 10px;font-size:16px;\">上一页</label>").append(
						"<label id=\"nextPage\" href=\"#\" style=\"cursor:pointer;color:darkblue;margin:0 10px;font-size:16px;\">下一页</label>").append(
						"<label id=\"lastPage\" href=\"#\" style=\"cursor:pointer;color:darkblue;margin:0 10px;font-size:16px;\">最后一页</label>");
		int goPage = (pageNumber + 1) > totalPage ? totalPage
				: (pageNumber + 1);
		su
				.append(
						"转到<input type=\"text\" id=\"goPage\" name=\"goPage\" value=\""
								+ goPage + "\" style=\"width:60px;\"/>页")
				.append(
						"<button id=\"submitGO\" name=\"submitGO\"  width=\"20\" style=\"cursor:pointer;\">GO</button>")
				.append("</div>").append("<span id=\"searchMethod\" style=\"display:none;\">"+searchMethod+"</span>")
				.append("<input type=\"hidden\" id=\"pageNumber\" name=\"pageNumber\" value=\""+ pageNumber +"\" />");
		try {
			out.print(su.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
