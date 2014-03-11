<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="css/index-css.css" rel="stylesheet" type="text/css">
<style type="text/css">
body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;}
#fram{height:100%;width:1150px;margin:-15px auto}
#l-map{height:100%;width:920px;border:2px solid #bcbcbc;margin:0 auto}
#r-result{position: absolute;z-index:99;}
#result-list{height:100%;width:220px;float:right;}
</style>

<script type="text/javascript" src="js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=F11b633766ca28f5a2ab3f9177e59ea5"></script>
<title>关键字输入提示词条</title>
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
							<em>代驾网</em>
						</a>

						<form class="navbar-form pull-right">
							<!--<input class="span2" type="text" placeholder="賬戶">
							<input class="span2" type="password" placeholder="密碼">-->
							<a type="submit" class="btn btn-success" href="login_final.html">
								登录
							</a>
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
											代驾司机
										</a>
									</li>
								</ul>
							</div>
						</form>
						<!-- nav-collapse collapse -->
						<div class="nav-collapse collapse">
							<ul class="nav">
								<li class="active">
									<a href="#">
										<i class="icon-home"></i>首页
									</a>
								</li>
								<li>
									<a href="#">
										代驾顾客
									</a>
								</li>
								<li>
									<a href="#">
										代驾司机
									</a>
								</li>
								<!-- 下拉菜单 -->
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										关于我们<b class="caret"></b>
									</a>
									<ul class="dropdown-menu">
										<li class="nav-header">
											腾讯QQ：
										</li>
										<li class="disabled">
											<a href="#">
												<abbr title="腾讯QQ">xxxxxxxxx</abbr>
											</a>
										</li>
										<li class="divider"></li>
										<li class="nav-header">
											企业邮箱：
										</li>
										<li class="disabled">
											<a href="#">
												<abbr title="网易邮箱">xxx@xxx.xxx</abbr>
											</a>
										</li>
										<li class="divider"></li>
										<li class="nav-header">
											新浪微博：
										</li>
										<li>
											<a href="#">
												@代驾XXX
											</a>
										</li>
									</ul>
								</li>
								<!-- 下拉菜单 -->
							</ul>
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
		
		
<div id="fram">		
<div id="l-map" style="position:absolute;"></div>
<div id="r-result">
<form action="order_pay" method="post" id="form2" name="form2">
	<input type="text" id="city" size="10"  style="width:50px;margin:100px 0 0 30px;font-size:15px;position:absolute;"/>
	<input type="text" id="suggestId" name="startPlace" size="30"  style="width:150px;margin:100px 0 0 100px;font-size:15px;position:absolute;" onchange="clearTarget('start');"/>
	<input type="text" value="↔" onclick="exchange();" style="cursor:pointer;width:17px;margin:100px 0 0 270px;font-size:15px;position:absolute;"/>
	<input type="text" id="suggestId1" name="endPlace" size="30"  style="width:150px;margin:100px 0 0 307px;font-size:15px;position:absolute;" onchange="clearTarget('end');" />
	<input type="text" value="找代驾" onclick="callAjax();" style="cursor:pointer;width:45px;margin:100px 0 0 478px;font-size:15px;position:absolute;"/>
	<input type="text" value="车型" id="autotype" name="autotype" style="cursor:pointer;width:150px;margin:150px 0 0 30px;font-size:15px;position:absolute;"/>
	<input type="text" id="start" name="start"/>
	<input type="text" id="end" name="end"/>
	<input type="button" onclick="handle();"/>
	
	<input type="hidden" id="selength" name="selength"/>
	<input type="hidden" id="guMoney" name="guMoney"/>
	<input type="hidden" id="qiMoney" name="qiMoney"/>
</form>



</div>
<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:250px;height:auto;">
</div>
<div id="result-list">
	
</div>
</div>
</body>
</html>
<script type="text/javascript">

function G(id) {
    return document.getElementById(id);
}

function clearTarget(id) {
	//alert(G(id).value);
	G(id).value = "";
	//alert(G(id).value);
}

function callAjax(){
	var start = G("start").value;
	var end = G("end").value;
	//$.post("searchDriver",{start:start,end:end},function(data,retn){
	//	alert(data);
	//},"json");
	
	$.ajax({
    type: "POST",
    url: "searchDriver",
    data: {start:start,end:end},
    dataType:"text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
    success: function(json){  
    var obj = $.parseJSON(json);  //使用这个方法解析json
    var data = obj;  //result是和action中定义的result变量的get方法对应的
    alert(json);
    var username = data.username.split('|');
    var length = data.length.split('|');
    var drivingage = data.drivingage.split('|');
    var servicetimes = data.servicetimes.split('|');
    var usertel = data.usertel.split('|');
    alert(username[0]);
    for(i=0;i<2;i++){
    	G("result-list").innerHTML += "<br><strong>" + username[i] + "</strong>" + "<br>距离您" +
    length[i] + "千米<br>驾龄：" + drivingage[i] + "年<br>已服务:" + servicetimes[i] + "次<br>" + 
    "联系电话：" + usertel[i] + "<br>";
    }
    
    G("result-list").innerHTML += "<br><strong>预计距离 " + data.selength + "千米</strong>";
    G("result-list").innerHTML += "<br><strong>预计需 RMB " + data.guMoney + "</strong>";
    G("result-list").innerHTML += "<br><strong>需预支付 RMB " + data.qiMoney + "</strong><br>";
    
    G("result-list").innerHTML += "<br><input type='button' onclick='pay();' value='付款'/>";
    	
    G("selength").value = data.selength;
    G("guMoney").value = data.guMoney;
    G("qiMoney").value = data.qiMoney;
    }
    });
}

function pay(){
	document.form2.submit();
}

function exchange(){
	var tmp = G("suggestId").value;
	G("suggestId").value = G("suggestId1").value;
	G("suggestId1").value = tmp;
	tmp = G("start").value;
	G("start").value = G("end").value;
	G("end").value = tmp;
}

var map = new BMap.Map("l-map");
var cityName;
var myCity = new BMap.LocalCity();
myCity.get(myFun);
function myFun(result){
    cityName = result.name;
    //map.setCenter(cityName);
    //alert(cityName);
    //var point = new BMap.Point(116.400244,39.92556);
	map.centerAndZoom(cityName,14);                   // 初始化地图,设置城市和地图级别。
	map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
	map.addControl(new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT }));    //左上角，默认地图控件
	map.setCurrentCity(cityName);   //由于有3D图，需要设置城市哦
	//map.centerAndZoom("汕头",20);                   // 初始化地图,设置城市和地图级别。
	//map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
	//map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]}));     //2D图，卫星图
	G("city").value = cityName;
}

var gc = new BMap.Geocoder();
// 将地址解析结果显示在地图上，并调整地图视野  
//gc.getPoint("北京大会堂", function(point){    
// if (point) {
//   alert("dsfsdf");    
//   map.centerAndZoom(point, 16);    
//   map.addOverlay(new BMap.Marker(point));    
// }    
//}, "北京市");    
function handle(){
	function myFun(result){
    	//var cityName = result.name;
    	//map.setCenter(cityName);
    	alert(cityName);
    	var local = new BMap.LocalSearch(cityName, {
  		renderOptions: {
    	map: map,
    	panel : "result-list",
    	autoViewport: true,
    	selectFirstResult: false
  		}
		});
		local.search(G("suggestId").value);
	}
	var myCity = new BMap.LocalCity();
	if(G("start").value==""){
		myCity.get(myFun);
	}
}

/* 右键  */
var contextMenu = new BMap.ContextMenu();
var txtMenuItem = [
  {
   text:'设为起点',
   callback:function(pt){
    map.clearOverlays();
    createMarker(pt,"start",1);
   }
  },
  {
   text:'设为终点',
   callback:function(pt){
    map.clearOverlays();
	createMarker(pt,"end",1);     
   }
  }
 ];
 for(var i=0; i < txtMenuItem.length; i++){
  contextMenu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
  if(i==1 || i==3) {
   contextMenu.addSeparator();
  }
 }
 map.addContextMenu(contextMenu);
 /* 右键  */

var myValue;
var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
    {"input" : "suggestId"
    ,"location" : map
});

ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	onhighlightListener("start",e);
});

ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	onconfirmListener("start",e);
});

var at = new BMap.Autocomplete(    //建立一个自动完成的对象--目的地
    {"input" : "suggestId1"
    ,"location" : map
});

at.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	onhighlightListener("end",e);
});

at.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	onconfirmListener("end",e);
});

//鼠标放在下拉列表上的事件
function onhighlightListener(id,e){
	var str = "";
    var _value = e.fromitem.value;
    var value = "";
    if (e.fromitem.index > -1) {
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }    
    str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value; 
    value = "";
    if (e.toitem.index > -1) {
        _value = e.toitem.value;
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }    
    str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
    G("searchResultPanel").innerHTML = str;
}

//鼠标点击下拉列表后的事件
function onconfirmListener(id,e){
	var _value = e.item.value;
    myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;  
    setPlace(id);
}

function setPlace(id){
    map.clearOverlays();    //清除地图上所有覆盖物
    function myFun(){
        var pt = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        alert(pt);
        map.centerAndZoom(pt, 17);
        createMarker(pt,id,0);
    }
    //alert(cityName);
    var point = new BMap.Point(116.400244,39.92556);
    var local = new BMap.LocalSearch(cityName, { //智能搜索
      onSearchComplete: myFun,
      renderOptions: {
    	map: map
  		}
    });
    local.search(myValue);  
}

//reAdd:地址是否需要重新确定
function createMarker(pt,id,reAdd){
	var myIcon = new BMap.Icon("http://api0.map.bdimg.com/images/marker_red_sprite.png", new BMap.Size(60,120));
	var marker = new BMap.Marker(pt,{icon:myIcon});  // 创建标注
	map.addOverlay(marker);              // 将标注添加到地图中
	marker.enableDragging();    //可拖拽
	gc.getLocation(pt, function(rs){
   		var addComp = rs.addressComponents;
 		var address = addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
   		G(id).value = pt.lng + "," + pt.lat;
   		alert(G(id).value);
   		alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
   		if(reAdd == 1){
   			if(id == "start") G("suggestId").value = address;
       		else if(id == "end") G("suggestId1").value = address;
   		}
   	});  
   	//alert(G(id).value);          	
	//Listener
	marker.addEventListener("dragend", function(e){
   		var pt = e.point;
   		gc.getLocation(pt, function(rs){
       	var addComp = rs.addressComponents;
       	alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
       	var address = addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
       	G(id).value = pt.lng + "," + pt.lat;
       	if(id == "start") G("suggestId").value = address;
       	else if(id == "end") G("suggestId1").value = address;
       	alert(G(id).value);
       	});            
		//alert("当前位置：" + e.point.lng + ", " + e.point.lat);    
	});
}

</script>
