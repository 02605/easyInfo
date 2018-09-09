<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="<%=path %>/admin/index.jsp">Admin</a>
				<div class="btn-group pull-right">
					<a class="btn" href="<%=path %>/admin/my-profile.jsp"><i class="icon-user"></i>
						Admin</a> <a class="btn dropdown-toggle" data-toggle="dropdown"
						href="#">&nbsp;<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="<%=path %>/admin/my-profile.jsp">个人资料</a></li>
						<li class="divider"></li>
						<li><a href="<%=path %>/admin/index.jsp">退出</a></li>
					</ul>
				</div>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="<%=path %>/admin/index.jsp">首页</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">用户 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<%=path %>/admin/new-user.jsp">新建用户</a></li>
								<li class="divider"></li>
								<li><a href="<%=path %>/UserAction_list">管理用户</a></li>
							</ul></li>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">角色 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<%=path %>/admin/new-role.jsp">新建角色</a></li>
								<li class="divider"></li>
								<li><a href="<%=path %>/admin/roles.jsp">管理角色</a></li>
							</ul></li>
						<li class="dropdown"><a href="<%=path %>/admin/info.jsp" class="dropdown-toggle"
							data-toggle="dropdown">信息查询<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<%=path %>/TeacherAction_list">教师综合信息</a></li>
							</ul>
							</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">公共模板 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath }/admin/publicTemplate.jsp">公共模板管理</a></li>
								<!-- <li class="divider"></li>
								<li><a href="#">删除模板</a></li> -->
							</ul>
						</li>
							<li class="dropdown"><a href="<%=path %>/admin/info-stat.jsp" class="dropdown-toggle"
							data-toggle="dropdown">综合统计<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<%=path %>/TeacherAction_list">教师信息分类统计</a></li>
							</ul>
					<!--  	<ul class="dropdown-menu">
								<li><a href="#">教师个人信息</a></li>
								<li class="divider"></li>
								<li><a href="#">教学评估</a></li>
								<li class="divider"></li>
								<li><a href="#">年终考核</a></li>
								<li class="divider"></li>
								<li><a href="#">论文</a></li>
								<li class="divider"></li>
								<li><a href="#">教材著作</a></li>
								<li class="divider"></li>
								<li><a href="#">专利</a></li>
								<li class="divider"></li>
								<li><a href="#">纵向科研</a></li>
								<li class="divider"></li>
								<li><a href="#">横向科研</a></li>
								<li class="divider"></li>
								<li><a href="#">指导学生</a></li>
								<li class="divider"></li>
								<li><a href="#">挂职实践</a></li>
								<li class="divider"></li>
								<li><a href="#">培训学习</a></li>
								<li class="divider"></li>
								<li><a href="#">奖励</a></li>
								<li class="divider"></li>
								<li><a href="#">当辅导员情况</a></li>
							</ul></li>  -->
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">通知管理<b class="caret"></b></a>
						<ul class="dropdown-menu">
								<li><a href="#">发布通知</a></li>
								<li class="divider"></li>
								<li><a href="#">管理通知</a></li>
							</ul></li>

					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>