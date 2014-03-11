<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" href="css/index-css.css" />

  </head>
  
  <body>
    <!-- navbar-wrapper -->
		<div class="navbar-wrapper">
			<!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
			<!-- container -->
			<div class="container">
				<!-- 导航条 -->
				<div class="navbar <!--navbar-fixed-top-->">
					<!-- navbar-inner -->
					<div class="navbar-inner">
						<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="brand" href="#">
							<em>代驾网</em>&nbsp;&nbsp;|&nbsp;<span>找回密码</span>
						</a>

						<!-- nav-collapse collapse -->
						<div class="nav-collapse collapse">

							<form class="navbar-form pull-right">
								<div class="btn-group">
									<button class="btn dropdown-toggle" data-toggle="dropdown" href="#">
										注册账户
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li>
											<a href="#">
												客户
											</a>
										</li>
										<li>
											<a href="#">
												客户
											</a>
										</li>
										<li>
											<a href="#">
												客户
											</a>
										</li>
									</ul>
								</div>
							</form>

						</div>
						<!-- nav-collapse collapse -->
					</div>
					<!-- navbar-inner -->
				</div>
				<!-- 导航条 -->
			</div>
			<!-- container -->
		</div>
		<!-- navbar-wrapper -->

		<!-- login container -->
		<div class="container marketing">

			<!-- 上部提醒 -->
			<div class="alert  alert-block">
				<button type="button" class="close" data-dismiss="alert">
					&times;
				</button>
				<strong>温馨提醒：欢迎登录代驾网，感谢你对代驾网的支持。 </strong>
			</div><!-- 上部提醒 -->

			<!-- 登陆框 标签页 容器 -->
			<div>
				<!-- 标签页 选项  -->
				<ul id="myTab" class="nav nav-tabs">
					<li class="active">
						<a href="#ligin-customer" data-toggle="tab">
							通过注册邮箱找回
						</a>
					</li>
					<li>
						<a href="#ligin-driver" data-toggle="tab">
							通过密保找回
						</a>
					</li>
				</ul><!-- 标签页 选项  -->
				<!-- 标签页 内容 -->
				<div id="myTabContent" class="tab-content">
					<!-- 顾客登录 内容 -->
					<div class="tab-pane fade in active" id="ligin-customer">
						<div class="well">
							<form method="post" class="form-signin" action="find">
							    <input type="hidden" name="usernumber" value="<s:property value="#session['infoCustomer'].usernumber"/>">
								<h2 class="form-signin-heading">通过注册邮箱找回</h2>
								用户名/邮箱<input type="text" name="infoCustomer.email" class="input-block-level" placeholder="用户名/邮箱" />
								<button class="btn btn-success" type="submit">
									下一步
								</button>
							</form>
						</div>
					</div><!-- 顾客登录 内容 -->
					<!-- 司机登录 内容 -->
					<div class="tab-pane fade" id="ligin-driver">
						<div class="well">
							<form class="form-signin" action="findEmail">
							    <input type="hidden" name="usernumber" value="<s:property value="#session['infoCustomer'].usernumber"/>">
								<h2 class="form-signin-heading">通过密保找回</h2>
								用户名/邮箱<input type="text" name="infoCustomer.email" class="input-block-level" placeholder="用户名/邮箱" />
								<button class="btn btn-success" type="submit">
									下一步
								</button>
							</form>
						</div>
					</div><!-- 司机登录 内容 -->
					
					
				</div><!-- 标签页 内容 -->
			</div><!-- 登陆框 标签页 容器 -->

			<!-- FOOTER wrap -->
			<div id="footer-wrap">
				<hr />
				<!-- FOOTER -->
				<footer>
					<p class="pull-right">
						<a href="#">
							回到頂部
						</a>
					</p>
					<p>
						&copy; 2013 代駕畢業設計. &middot;
					</p>
				</footer><!-- FOOTER -->
			</div><!-- FOOTER wrap -->

		</div><!-- login container -->

		<script src="js/jquery-1.10.2.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
  </body>
</html>
