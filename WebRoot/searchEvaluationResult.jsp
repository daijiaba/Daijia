<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>查看评价</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
		<link rel="stylesheet" href="css/index-css.css" />
		<link rel="stylesheet" href="css/style.css" type="text/css" />
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
							<em>代驾网</em>&nbsp;&nbsp;|&nbsp;<span>查看评价</span>
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
				<strong>温馨提醒：欢迎登录代驾网，感谢你对代驾网的支持。</strong>
			</div><!-- 上部提醒 -->
			<div class="tab-pane fade in active" id="ligin-customer">
			<div class="well">
			<div style="float:left">
			<form method="post" action="searchEva.action">
				  订单编号:<input type="text" name="ordernumber" />
				  评价状态:<input type="text" name="status" />
				  <button class="btn btn-success" type="submit">搜索</button>
			</form>
			</div></div>
			<div id="page">
	          <div class="wrapper">				
					<table id="report" class="stylized full" >
						<thead>
							<tr>
								<th class="ta-right">订单编号</th>
								<th class="ta-right">评价状态</th>
								<th class="ta-right">服务评分</th>
								<th class="ta-right">服务评语</th>
							</tr>
						</thead>
						<tbody>
						    <s:set name="allevas" value="#request.allevas"></s:set> 
						     <s:iterator value="#allevas" id="alleva">
							<tr>
								<td class="ta-right"><s:property value="#alleva.ordernumber"/></td>
								<s:if test="#alleva.status==0">
								      <td class="ta-right">未评价
								           <a href="<s:url action="getSEva">
                                           <s:param name="ordernumber" value="ordernumber" /></s:url>">请评价</a>
								      </td>
								</s:if>
								<s:if test="#alleva.status==1">
								      <td class="ta-right">已评价
								           <a href="<s:url action="getSEva1">
                                           <s:param name="ordernumber" value="ordernumber" /></s:url>">修改评价</a>
								      </td>
								</s:if>
								<td class="ta-right"><s:property value="#alleva.score"/></td>
								<td class="ta-right"><s:property value="#alleva.information"/></td>
							</tr>
							</s:iterator>
						</tbody>
					</table>

		</div>
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
