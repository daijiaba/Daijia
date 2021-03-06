<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>查看订单</title>
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
							<em>代驾网</em>&nbsp;&nbsp;|&nbsp;<span>查看订单</span>
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
			<form method="post" action="searchorder.action">
				  订单编号:<input type="text" name="ordernumber" />
				  下单时间:<input type="text" name="ordertime" />
				  订单状态:<input type="text" name="status" />
				  司机电话:<input type="text" name="DUsertel" />
				  预约地点:<input type="text" name="beginlocation">
				  <button class="btn btn-success" type="submit">搜索</button>
			</form>
			</div></div>
			<div id="page">
	          <div class="wrapper">				
					<table id="report" class="stylized full" >
						<thead>
							<tr>
								<th class="ta-right">订单编号</th>
								<th class="ta-right">下单时间</th>
								<th class="ta-right">金额</th>
								<th class="ta-right">预约时间</th>
								<th class="ta-right">预约地点</th>
								<th class="ta-right">司机电话</th>
								<th class="ta-right">订单状态</th>
								<th class="ta-right">订单处理时间</th>
							</tr>
						</thead>
						<tbody>
						    <s:set name="orders" value="#request.allorder"></s:set> 
						     <s:iterator value="#orders" id="order">
							<tr>
								<td class="ta-right"><s:property value="#order.ordernumber"/></td>
								<td class="ta-right"><s:property value="#order.ordertime"/></td>
								<td class="ta-right">￥<s:property value="#order.infoOrderPay.payamount"/></td>
								<td class="ta-right"><s:property value="#order.begintime"/>
								                     --<s:property value="#order.endtime"/>
								</td>
								<td class="ta-right"><s:property value="#order.beginlocation"/>
								                     至<s:property value="#order.endlocation"/>
								</td>
								<td class="ta-right"><s:property value="#order.DUsertel"/></td>
								<s:if test="#order.status==0">
								     <td class="ta-right">已预约<br>
								          <a href="">请付款</a> 
								     </td>
								</s:if>
								<s:if test="#order.status==1">
								     <td class="ta-right">已付款<br>等待审核 </td>
								</s:if>
								<s:if test="#order.status==2">
								     <td class="ta-right">已审核<br>
								          <a href="">确认完成</a>
								     </td>
								</s:if>
								<s:if test="#order.status==3">
								     <td class="ta-right">已完成<br>
								          <a href="<s:url action="getSEva">
                                           <s:param name="ordernumber" value="ordernumber" /></s:url>">请评价</a>
								     </td>
								</s:if>
								<s:if test="#order.status==4">
								     <td class="ta-right">已取消<br>
								           <a href="<s:url action="getSEva">
                                           <s:param name="ordernumber" value="ordernumber" /></s:url>">请评价</a>
								     </td>
								</s:if>
								<td class="ta-right"><s:property value="#order.processtime"/></td>
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
