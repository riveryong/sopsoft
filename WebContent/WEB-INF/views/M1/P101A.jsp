<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head> 
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<%@ include file="../inc/import.jsp"%>
</head>
<body style="min-width:980px">
  <!-- Header----Start-- -->
  <%@ include file="../common/header.jsp"%>
  <!-- Header----End-- -->
  
  <div class="container-fluid">
	  <div class="row-fluid">
	  
		<div class="span2">
			<ul class="nav nav-list left_side_bar">
			  <li class="nav-header"><a href=""> 快捷功能</a></li>
			  <li><a href="#typography"> 快捷功能1</a></li>
			  <li><a href="#code"> 快捷功能2</a></li>
			  <li><a href="#tables"> 快捷功能3</a></li>
			  <li><a href="#forms"> 快捷功能4</a></li>
			  <li><a href="#buttons"> 快捷功能5</a></li>
			  <li><a href="#images"> 快捷功能6</a></li>
			  <li><a href="#icons"> 快捷功能7</a></li>
			</ul>
		</div>
		
		<div class="span10">
			<form  class="sInputForm form-search" action="" >
				<legend class="lableShadow">会员管理</legend>
				<div class="add_margin_bottom">
			    	<div class="input-prepend inline add_margin_bottom">
		              <span class="add-on">检索条件1</span>
		              <input id="prependedInput" class="input-medium" placeholder="Username" type="text">
		            </div>
		            <div class="input-prepend inline add_margin_bottom">
		              <span class="add-on">检索条件2</span>
		              <input id="appendedInput" class="input-small" type="text">
		            </div>
		            <br>
		            <div class="input-prepend inline">
		              <span class="add-on">检索条件3</span>
		              <input id="appendedInput" type="text">
		            </div>
		            <div class="input-prepend inline">
		              <span class="add-on">检索条件4</span>
		              <input id="appendedInput" type="text">
		            </div>
		            
		            <button type="submit" class="btn">Search</button>
	            </div>
	            <table class="table table-bordered table-hover">
	              <thead>
	                <tr class="well">
	                  <th>#</th>
	                  <th>First Name</th>
	                  <th>Last Name</th>
	                  <th>Username</th>
	                </tr>
	              </thead>
	              <tbody>
	                <tr>
	                  <td rowspan="2">1</td>
	                  <td>Mark</td>
	                  <td>Otto</td>
	                  <td>@mdo</td>
	                </tr>
	                <tr>
	                  <td>Mark</td>
	                  <td>Otto</td>
	                  <td>@TwBootstrap</td>
	                </tr>
	                <tr>
	                  <td>2</td>
	                  <td>Jacob</td>
	                  <td>Thornton</td>
	                  <td>@fat</td>
	                </tr>
	                <tr>
	                  <td>3</td>
	                  <td colspan="2">Larry the Bird</td>
	                  <td>@twitter</td>
	                </tr>
	              </tbody>
	            </table>
	            
			</form>
		</div>		
	
	  </div> <!-- END class="row" -->
  </div><!-- END class="container" -->

  <!-- Footer----Start-- -->
  <%@ include file="../common/footer.jsp"%>
  <!-- Footer----End-- -->
  

</body>
</html>