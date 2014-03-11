<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>交易记录</title>
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
							<em>代驾网</em>&nbsp;&nbsp;|&nbsp;<span>交易记录</span>
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
			
			<form method="post" style="width:900px;height:100px" class="form-signin" action="hqlCD">
								
								<h4 style="float:left">交易时间</h4>
								<select name="paytime" class="input-block-level" style="width:100px;float:left" >
								       <option >
								       <option value="7">最近一周
								       <option value="30">最近一月
								       <option value="90">最近三月
								</select>
								<h4 style="float:left;margin:0 0 0 400px">交易状态</h4>
								<select name="orderstatus" class="input-block-level" style="width:100px;margin:0 0 0 400px" >
								        <option >
								       <option value="0">预约
								       <option value="1">已付款
								       <option value="2">已审核
								       <option value="3">取消
								       <option value="4">完成    
								</select><br>
								<h4 style="float:left">订单编号</h4>
								<input name="ordernumber" class="input-block-level" style="width:150px;float:left" />	
								<h4 style="float:left;margin:0 0 0 350px">资金流向</h4>
								<select name="status" class="input-block-level" style="width:100px;margin:0 0 0 350px" >
								        <option >
								       <option value="1">收入
								       <option value="0">支出
								</select>
								<button class="btn btn-success" type="submit" style="margin:-70px 600px 0 0">
									搜索
								</button>
			</form>
			</div>
			<div id="page">
	          <div class="wrapper"><h4>交易记录</h4>				
					<table id="report" class="stylized full" >
						<thead>
							<tr>
								<th class="ta-right">时间</th>
								<th class="ta-right">名称</th>
								<th class="ta-right">交易号</th>
								<th class="ta-right">资金流向</th>
								<th class="ta-right">金额</th>
								<th class="ta-right">状态</th>
								<th class="ta-right">操作</th>
							</tr>
						</thead>
						<tbody>
						    <s:set name="ifos" value="#request.ifos"></s:set> 
						     <s:iterator value="#ifos" id="ifo">
							<tr>
								<td class="ta-right"><s:property value="#ifo.paytime"/></td>
								<s:if test="#ifo.ordernumber==null">
								     <td class="ta-right">充值</td>
								</s:if>
								<s:if test="#ifo.ordernumber!=null">
								     <td class="ta-right">代驾</td>
								</s:if>
								<td class="ta-right"><s:property value="#ifo.tradeid"/></td>
								<s:if test="#ifo.status==1">
								     <td class="ta-right">收入</td>
								</s:if>
								<s:if test="#ifo.status==0">
								     <td class="ta-right">支出</td>
								</s:if>
								<td class="ta-right"><s:property value="#ifo.payamount"/></td>
								<s:if test="#ifo.infoOrder.status==1">
								     <td class="ta-right">已付款</td>
								      <td class="ta-right">等待审核</td>
								</s:if>
								<s:if test="#ifo.infoOrder.status==2">
								     <td class="ta-right">已审核</td>
								     <td class="ta-right"><a href="">确认完成</a></td>
								</s:if>
								<s:if test="#ifo.infoOrder.status==3">
								     <td class="ta-right">已完成</td>
								     <td class="ta-right"><a href="<s:url action="getSEva">
                                           <s:param name="ordernumber" value="ordernumber" /></s:url>">请评价</a>
								     </td>
								</s:if>
								<s:if test="#ifo.infoOrder.status==4">
								     <td class="ta-right">已取消</td>
								     <td class="ta-right"><a href="<s:url action="getSEva">
                                           <s:param name="ordernumber" value="ordernumber" /></s:url>">请评价</a>
								     </td>
								</s:if>
								<s:if test="#ifo.infoOrder==null">
								     <td class="ta-right">成功</td>
								    <td class="ta-right"><a href="<s:url action="getSEva">
                                           <s:param name="ordernumber" value="ordernumber" /></s:url>">继续充值</a>
								     </td>
								</s:if>
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
