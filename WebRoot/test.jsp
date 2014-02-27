<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
</head>
<%String servletPath=request.getServletPath(); %>
  <body>
  <script type="text/javascript">
		if("${tips}"=="false"){
			alert("积分不足");
		}
  </script>
  <form method="post" action="saveInfoCustomer">
  	<input type="text" name="infoCustomer.usertel"/>
  	<input type="text" name="infoCustomer.passwd"/>
  	<input type="text" name="path" value="<%=servletPath%>"/>
  	<input type="submit"/>
  </form>
  </body>
</html>
