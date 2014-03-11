<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>账户管理</title>
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
							<em>代驾网</em>&nbsp;&nbsp;|&nbsp;<span>账户管理</span>
						</a>
						<span><a class="brand" href="accountset.jsp">&nbsp;&nbsp;&nbsp;&nbsp;账户设置</a></span>

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
				<strong>账户名:<s:property value="#session['infoCustomer'].usertel"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				姓名:<s:property value="#session['infoCustomer'].username"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				上次登录时间:<s:property value="#session['ifa'].lasttime"/>
				</strong>
			</div><!-- 上部提醒 -->
			<div class="tab-pane fade in active" id="ligin-customer">
			<div  style="width:900px;height:100px" class="form-signin" >
					<h4 style="float:left">账户余额</h4><br><br>
					&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#session['ifCD'].accountbalance"/>￥
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="brand" href="prepaidfirst.jsp">充值	</a>
					&nbsp;&nbsp;&nbsp;&nbsp;						
					<a class="brand" href="">转账</a>
					<hr size="150px" width="2px" align="left" color="#00ffFF" style="margin:-80px 0 0 400px">
					<form method="post" action="accountCD.action">
					            <input type="hidden" name="usernumber" value="<s:property value="#session['infoCustomer'].usernumber"/>">
					            <h4 style="margin:-130px 0 0 410px">起止时间</h4>
								<input name="time1" class="input-block-level" style="width:150px;margin:-25px 0 0 500px" >
								<h4 style="margin:-25px 0 0 650px">至</h4>
								<input name="time2" class="input-block-level" style="width:150px;margin:-25px 0 0 670px" >
								<br>
								<h4 style="margin:10px 0 0 410px">资金流向</h4>
								<select name="status" class="input-block-level" style="width:150px;margin:-26px 0 0 500px" >	
								        <option ></option>
								       <option value="1">收入</option>
								       <option value="0">支出</option>
								</select>
								<button class="btn btn-success" type="submit" style="margin:-70px 200px 0 0">
									搜索
								</button>
					</form>
			</div>
			</div>
			<div id="page">
	          <div class="wrapper"><br>姓名:<s:property value="#session['infoCustomer'].username"/>
	          &nbsp;&nbsp;&nbsp;&nbsp;账号:<s:property value="#session['infoCustomer'].usertel"/>
	          &nbsp;&nbsp;&nbsp;&nbsp;查询时间:<%=(new java.util.Date()).toLocaleString() %>			
					<table id="report" class="stylized full" border=1>
						<thead>
							<tr>
								<th class="ta-right" rowspan="2">交易日期</th>
								<th class="ta-right" rowspan="2">摘要</th>
								<th class="ta-right" rowspan="2">交易方式</th>
								<th class="ta-right" rowspan="2">地区国家</th>
								<th class="ta-right" colspan="3">交易金额</th>
								<th class="ta-right" colspan="3">记账金额</th>
								<th class="ta-right" rowspan="2">余额</th>
							</tr>
							<tr>
								<th class="ta-right">收入</th>
								<th class="ta-right">支出</th>
								<th class="ta-right">币种</th>
								<th class="ta-right">收入</th>
								<th class="ta-right">支出</th>
								<th class="ta-right">币种</th>
							</tr>
						</thead>
						<tbody>
						    <s:set name="accountcds" value="#request.accountcds"></s:set> 
						     <s:iterator value="#accountcds" id="accd">
							<tr>
								<td class="ta-right"><s:property value="#accd.paytime"/></td>
								<td class="ta-right"><s:property value="#accd.remark"/></td>
								<s:if test="#accd.status==0">
								    <td class="ta-right">支 出</td>
								</s:if>
								<s:if test="#accd.status==1">
								    <td class="ta-right">收入</td>
								</s:if>
								<td class="ta-right">CHINA</td>
								<td class="ta-right">-</td>
								<td class="ta-right">-</td>
							    <td class="ta-right">-</td>
							    <s:if test="#accd.status==1">
								    <td class="ta-right"><s:property value="#accd.payamount"/></td>
								     <td class="ta-right">-</td>
								</s:if>
								<s:if test="#accd.status==0">
								     <td class="ta-right">-</td>
								     <td class="ta-right"><s:property value="#accd.payamount"/></td>
								</s:if>
								<td class="ta-right">人民币</td>
								<td class="ta-right"><s:property value="#accd.accountbalance"/></td>
							</tr>
							</s:iterator>
							<tr>
							<td class="ta-right" colspan="7">合计金额</td>
							<td class="ta-right" ><%=request.getAttribute("count1")%></td>
							<td class="ta-right" ><%=request.getAttribute("count0")%></td>
							<td class="ta-right" ></td>
							<td class="ta-right" ></td>
							</tr>
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
