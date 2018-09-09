<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    <link href="<%=path %>/css/loginStyles.css" rel="stylesheet" type="text/css"  />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  </head>
  
  <body bgcolor="33CCCC">
	<article class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>EasyInfo后台管理系统<span><font color="red" ><s:property value="exception.message" /> </font></span></h1>
		</header>
		<div class="panel-lite">
		  <div class="thumbur">
		    <div class="icon-lock"></div>
		  </div>
		  <h4>用户登录</h4>
		  <form action="${pageContext.request.contextPath}/AdminAction_login"  method=post id="f1">
		  <div class="form-group">
		    <input required="required" class="form-control" name="tea_id"/>
		    <label class="form-label">用户名    </label>
		  </div>
		  <div class="form-group">
		    <input type="password" required="required" class="form-control" name="admin_password"/>
		    <label class="form-label">密　码</label>
		  </div><a href="#">忘记密码 ?  </a>
		  <a href="javascript:document:f1.submit();"><button class="floating-btn" type="button"><i class="icon-arrow"></i></button></a>
		  </form>
		</div>
		
	</article>
	
</body>
</html>
