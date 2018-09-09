<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'roles.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=path%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=path%>/css/site.css" rel="stylesheet">
<link href="<%=path%>/css/bootstrap-responsive.css" rel="stylesheet">

</head>

<body>
	<jsp:include page="head.jsp" />
    <div class="container-fluid">
			<div class="row-fluid">
				 <jsp:include page="left.jsp"/>
	<div class="span9">
		<div class="row-fluid">
			<div class="page-header">
				<h1>
					Roles <small>Manage roles</small>
				</h1>
			</div>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>Role</th>
						<th>Description</th>
						<th>Slug</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr class="list-roles">
						<td>1</td>
						<td>Admin</td>
						<td>Aliquam erat volutpat. Vivamus molestie tempor
							pellentesque. Praesent lobortis, neque.</td>
						<td>admin</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-mini dropdown-toggle" data-toggle="dropdown"
									href="#">Actions <span class="caret"></span></a>
								<ul class="dropdown-menu pull-right">
									<li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
									<li><a href="#"><i class="icon-trash"></i> Delete</a></li>
								</ul>
							</div>
						</td>
					</tr>
					<tr class="list-roles">
						<td>2</td>
						<td>Moderator</td>
						<td>Phasellus scelerisque, quam ac bibendum pulvinar, erat
							ligula pulvinar risus, in ultricies...</td>
						<td>mod</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-mini dropdown-toggle" data-toggle="dropdown"
									href="#">Actions <span class="caret"></span></a>
								<ul class="dropdown-menu pull-right">
									<li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
									<li><a href="#"><i class="icon-trash"></i> Delete</a></li>
								</ul>
							</div>
						</td>
					</tr>
					<tr class="list-roles">
						<td>3</td>
						<td>User</td>
						<td>Donec cursus, velit eu fermentum ullamcorper, libero est.</td>
						<td>user</td>
						<td>
							<div class="btn-group">
								<a class="btn btn-mini dropdown-toggle" data-toggle="dropdown"
									href="#">Actions <span class="caret"></span></a>
								<ul class="dropdown-menu pull-right">
									<li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
									<li><a href="#"><i class="icon-trash"></i> Delete</a></li>
								</ul>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<a href="<%=path %>/admin/new-role.jsp" class="btn btn-success">New Role</a>
		</div>
	</div>
	</div>
	<hr>

	<jsp:include page="foot.jsp" />
	</div>
	<script src="<%=path%>/js/jquery.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>

	<script>
		$(document).ready(function() {
			$('.dropdown-menu li a').hover(function() {
				$(this).children('i').addClass('icon-white');
			}, function() {
				$(this).children('i').removeClass('icon-white');
			});
		});
	</script>
</body>
</html>
