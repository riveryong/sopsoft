<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head> 
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link href="uifw/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="uifw/sopsoft/css/style.css" rel="stylesheet">
</head>
<body>
  <div class="container-fluid well" style="padding-bottom:0px;margin-bottom:5px;">
  	<div class="row-fluid">
		<div class="span2">
			<h3>LOGO</h3>
			<h3 class="lableShadow">MyProject</h3>
		</div>
		<div class="span10">
	      <ul class="nav nav-tabs" style="padding-bottom:0px;margin-bottom:5px;">
			<li class="active"><a href="#tab1" data-toggle="tab">模块1</a></li>
			<li><a href="#tab2" data-toggle="tab">模块2</a></li>
		  </ul>
		  <div class="tab-content">
			<div class="tab-pane active" id="tab1">
			<ul class="thumbnails">
				<li class="span1" style="align:center;">
				  <a href="#">
					<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAA7ElEQVR4nO3SQRKDIBAFUe9/FA/HFZJtkgoqGHmk/IteiVNND0sp5XFnFi2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoDkdYF3XN7bOyJmXBHiVqAntXWTEzCEBejc5YublAWpCtW/f/vvceuvMKV5A7fn2xOmZOVWAlm3+cuZUAY5ctOUF7M0cHmDrIrUztS1ubfnITBbg30kALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaC5fYAnBSEljeLG6C0AAAAASUVORK5CYII=" style="width: 48px; height: 48px;" data-src="holder.js/48x48" alt="48x48"><br/>
					功能功能1
				  </a>
				</li>
				<li class="span1">
				  <a href="#">
					<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAA7ElEQVR4nO3SQRKDIBAFUe9/FA/HFZJtkgoqGHmk/IteiVNND0sp5XFnFi2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoDkdYF3XN7bOyJmXBHiVqAntXWTEzCEBejc5YublAWpCtW/f/vvceuvMKV5A7fn2xOmZOVWAlm3+cuZUAY5ctOUF7M0cHmDrIrUztS1ubfnITBbg30kALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaC5fYAnBSEljeLG6C0AAAAASUVORK5CYII=" style="width: 48px; height: 48px;" data-src="holder.js/48x48" alt="48x48"><br/>
					功能功能2
				  </a>
				</li>
				<li class="span1">
				  <a href="#">
					<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAA7ElEQVR4nO3SQRKDIBAFUe9/FA/HFZJtkgoqGHmk/IteiVNND0sp5XFnFi2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoDkdYF3XN7bOyJmXBHiVqAntXWTEzCEBejc5YublAWpCtW/f/vvceuvMKV5A7fn2xOmZOVWAlm3+cuZUAY5ctOUF7M0cHmDrIrUztS1ubfnITBbg30kALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaBJAC2gSQAtoEkALaC5fYAnBSEljeLG6C0AAAAASUVORK5CYII=" style="width: 48px; height: 48px;" data-src="holder.js/48x48" alt="48x48"><br/>
					功能功能3
				  </a>
				</li>
			</ul>
			</div>
			<div class="tab-pane" id="tab2">
			<p>Howdy, I'm in Section 2.</p>
		   </div>
		  </div>
	    </div>	
  	</div>
  </div>

  <div class="container">
	  <div class="row">
	  
		<div class="span2">
			<ul class="nav nav-list left_side_bar">
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
			
			<form class="sInputForm form-horizontal" action="memberRegister.do">
				<legend class="lableShadow">页面名称</legend>
				<div class="row-fluid">
					<div class="span12">
						<div class="control-group">
							<label class="control-label" for="txtMemberNo">註冊失敗！</label>
						</div>
					</div>
				</div>
				 
	        </form>
	
		</div>		
	
	  </div> <!-- END class="row" -->
  </div><!-- END class="container" -->
  
  <!-- Footer
    ================================================== -->
  <footer class="footer">
    <div class="container">
      <p><a href="http://sopsoft.net/" target="_blank">SopSoft设计出品</a></p>
      <p>本网站最终解释权归属<a href="http://www.sopsoft.net/">商普软件工作室(SopSoft)</a>。</p>
      <ul class="footer-links">
        <li><a href="http://www.sopsoft.net/about.html" target="_blank">关于</a></li>
        <li class="muted">·</li>
        <li><a href="https://www.sopsoft.net/issues?state=open" target="_blank">问题反馈</a></li>
        <li class="muted">·</li>
        <li><a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008888号</a></li>
      </ul>
    </div>
  </footer>
  
  <script type="text/javascript" src="uifw/jq/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="uifw/bootstrap/js/bootstrap.js"></script>	
  <script type="text/javascript" src="uifw/sopsoft/js/fw.js" ></script>

</body>
</html>
