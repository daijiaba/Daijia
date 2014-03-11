<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head><title>用户充值</title></head>
  <body>
  <s:action name="search" executeResult="true">
      <s:param name="unumber" value="#session['infoCustomer'].usernumber"></s:param> 
  </s:action>
  </body>
</html>
