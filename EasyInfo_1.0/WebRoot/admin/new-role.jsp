<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new-role.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<%=path %>/css/bootstrap.css" rel="stylesheet">
	<link href="<%=path %>/css/site.css" rel="stylesheet">
    <link href="<%=path %>/css/bootstrap-responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>
  
  <body>
 	 <jsp:include page="head.jsp"></jsp:include>
 	 <div class="container-fluid">
			<div class="row-fluid">
 				 <jsp:include page="left.jsp"></jsp:include>
     	<div class="span9">
		  <div class="row-fluid">
			<div class="page-header">
				<h1>New Role <small>Add a new role</small></h1>
			</div>
			<form class="form-horizontal">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="role">Role Name</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="role" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="description">Description</label>
						<div class="controls">
							<textarea class="input-xlarge" id="description" rows="3"></textarea>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="slug">Slug</label>
						<div class="controls">
							<input type="text" class="input-xlarge" id="slug" />
						</div>
					</div>
					<div class="form-actions">
						<input type="submit" class="btn btn-success btn-large" value="Save Role" /> <a class="btn" href="<%=path %>/admin/roles.jsp">Cancel</a>
					</div>					
				</fieldset>
			</form>
		  </div>
        </div>
      </div>
      <hr/>
      <jsp:include page="foot.jsp"></jsp:include>
      
      </div>
      	<script src="<%=path %>/js/jquery.js"></script>
		<script src="<%=path %>/js/bootstrap.min.js"></script>
  </body>
</html>
