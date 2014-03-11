<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>账户设置</title>
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
							<em>代驾网</em>&nbsp;&nbsp;|&nbsp;<span>账户设置</span>
						</a>
						<span><a class="brand" href="accountfirst.jsp">&nbsp;&nbsp;&nbsp;&nbsp;账户管理</a></span>

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
			<div  style="width:900px;height:200px" class="form-signin" >
					<h4 style="float:left">基本信息</h4><hr>
					<h5>姓名:&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#session['infoCustomer'].username"/>
					&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a class="brand" href="">修改</a></h5>
					<h5>账户名:&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#session['infoCustomer'].usertel"/>
					&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a class="brand" href="">修改</a></h5>
					<h5>邮箱:&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#session['infoCustomer'].email"/>
					&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a class="brand" href="">修改</a></h5>
					<h5>居住地址:&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#session['infoCustomer'].address"/>
					&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a class="brand" href="">修改</a></h5>
			</div><br>
			<s:if test="#session.ifa==null">
			     <h4><a class="brand" href="">请进行账户設置</a></h4>
			</s:if>
			<s:else>
			<div  style="width:900px;height:250px" class="form-signin" >
					<h4 style="float:left">账户信息</h4><hr>
					<h5 style="display:inline;">支付密码:</h5><span style="margin:0 0 0 250px">在账户资金变动、修改账户信息时需要输入的密码</span>
					<span style="float:right"><a class="brand" href="">修改支付密码</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="brand" href="accountpasswdfind.jsp">找回支付密码</a></span><br><br>
					<s:if test="#session['ifa'].passwdfind==null||#session['ifa'].passwdfind==''">
					     <h5 style="display:inline;">安全保护问题:</h5><span style="margin:0 0 0 220px">您没有设置安全问题，请设置</span>
					     <span style="float:right"><a class="brand" href="">设置</a></span><br><br>
					     <h5 style="display:inline;">安全保护问题答案:</h5><span style="margin:0 0 0 190px">您没有设置安全问题，请设置</span>
					     <span style="float:right"><a class="brand" href="">设置</a></span><br><br>
					</s:if>
					<s:else>
					     <h5 style="display:inline;">安全保护问题:</h5><span style="margin:0 0 0 220px">安全保护问题在您找回密码时需要用到。</span>
					     <span style="float:right"><a class="brand" href="">修改</a></span><br><br>
					     <h5 style="display:inline;">安全保护问题答案:</h5><span style="margin:0 0 0 190px">请牢记您的答案</span>
					     <span style="float:right"><a class="brand" href="">修改</a></span><br><br>
					</s:else>
					<h5 style="display:inline;">设置密码时间:</h5>
					<span style="margin:0 0 0 250px"><s:property value="#session['ifa'].setpasswdtime"/></span><br><br>
			</div>
			</s:else>
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
