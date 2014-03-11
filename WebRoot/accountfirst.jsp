<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head><title>账户管理</title></head>
  <body>
  <s:action name="getAccount" executeResult="true">
      <s:param name="usernumber" value="#session['infoCustomer'].usernumber"></s:param> 
  </s:action>
 
  </body>
</html>
