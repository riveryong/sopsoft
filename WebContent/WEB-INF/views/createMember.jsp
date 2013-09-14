<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head> 
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<%@ include file="inc/import.jsp"%>
</head>
<body style="min-width:980px">
  <!-- Header----Start-- -->
  <%@ include file="common/header.jsp"%>
  <!-- Header----End-- -->

  <!-- main content 
  ================================================== -->
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
			<form  class="sInputForm form-horizontal" action="member/register" >
				<legend class="lableShadow">页面名称</legend>
				<div class="row-fluid">
					<div class="span12">
	
						<div class="control-group">
							<label class="control-label" for="txtMemberNo">会员卡号</label>
							<div class="controls">
								<input type="text" id="txtMemberNo" name="username" placeholder="会员卡号">
							</div>
						</div>
	
						<div class="control-group">
							<label class="control-label" for="txtMemberPwd">密码</label>
							<div class="controls">
								<input type="password" id="txtMemberPwd" name="password" placeholder="密码">
							</div>
						</div>
	
	
						<button type="submit" class="btn" id="regBtn">注册</button>
						<button type="submit" class="btn">取消</button>
	
					</div>
				</div>
			</form>
	
		</div>		
	
	  </div> <!-- END class="row" -->
  </div><!-- END class="container" -->
  
  <!-- Footer----Start-- -->
  <%@ include file="common/footer.jsp"%>
  <!-- Footer----End-- -->
  
	<script type="text/javascript">
		$(function(){
			
			$('#txtMemberNo').blur(function(){
				$('#msg').remove();
				var options = {
						url: "member/check",
						data: {'username':$('#txtMemberNo').val()},
						dataType:'text',
						cache: false,
						error:function (XMLHttpRequest, textStatus, errorThrown) {
									alert('ajax error!');
									alert(textStatus);
									alert(errorThrown);
								},
						success: function(objStr){
										var obj = eval("("+objStr+")");
					   					if(obj.count == 0){
					   						$('#txtMemberNo').after("<span id='msg' class='help-inline'>"+obj.msg+"</span>");
					   					}else{
					   						$('#txtMemberNo').after("<span id='msg' class='help-inline error'>"+obj.msg+"</span>");
					   						$('div:has(#txtMemberNo)').addClass("error");
					   					}
								   }
					};
				$.ajax(options);				
			});
			
			
			$("#txtMemberNo").focus(function(){
				$('div:has(#txtMemberNo)').removeClass("error");
				$('#msg').remove();
			});

		});
	</script>
</body>
</html>
