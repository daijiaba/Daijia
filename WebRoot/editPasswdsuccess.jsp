<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>修改密码</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
		<link rel="stylesheet" href="css/index-css.css" />
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		<link rel="stylesheet" href="css/searchformstyle.css" type="text/css" />
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
							<em>代驾网</em>&nbsp;&nbsp;|&nbsp;<span>修改密码</span>
						</a>
						<span><a class="brand" href="accountfirst.jsp">&nbsp;&nbsp;&nbsp;&nbsp;账户设置</a></span>

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
				<strong>温馨提醒：欢迎登录代驾网，感谢你对代驾网的支持。</strong>
			</div><!-- 上部提醒 -->
			<div class="tab-pane fade in active" id="ligin-customer">
			<h4>修改密码成功</h4>
			</div>
			<div id="page">
	</div>
				
			</div><!-- 登陆框 -->
			
			
			
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


		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
