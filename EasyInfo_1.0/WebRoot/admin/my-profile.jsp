<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'my-profile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<%=path %>/css/bootstrap.css" rel="stylesheet">
	<link href="<%=path %>/css/site.css" rel="stylesheet">
    <link href="<%=path %>/css/bootstrap-responsive.css" rel="stylesheet">
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="head.jsp" ></jsp:include>

  		<div class="container-fluid">
			<div class="row-fluid">
   				 <jsp:include page="left.jsp"/>
    				<div class="span9">
					<div class="row-fluid">
						<div class="page-header">
							<h1>My profile <small>Update info</small></h1>
						</div>
						<form class="form-horizontal">
							<fieldset>
								<div class="control-group">
									<label class="control-label" for="name">Name</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="name" value="Admin" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="email">E-mail</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="email" value="travis@provider.com" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="pnohe">Phone</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="phone" value="xxx-xxx-xxxx" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="city">City</label>
									<div class="controls">
										<input type="text" class="input-xlarge" id="city" value="My City" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="role">Role</label>
									<div class="controls">
										<select id="role">
											<option value="admin" selected>Admin</option>
											<option value="mod">Moderator</option>
											<option value="user">User</option>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="active">Active?</label>
									<div class="controls">
										<input type="checkbox" id="active" value="1" checked />
									</div>
								</div>
								<div class="form-actions">
									<input type="submit" class="btn btn-success btn-large" value="Save Changes" />
									<a class="btn" href="<%=path %>/admin/users.jsp">Cancel</a>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>

			<hr>

			 <jsp:include page="foot.jsp"></jsp:include>

		</div>

		<script src="<%=path %>/js/jquery.js"></script>
		<script src="<%=path %>/js/bootstrap.min.js"></script>
    
  </body>
</html>
