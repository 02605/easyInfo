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

</head>

<body>
	<div class="span3">
		<div class="well sidebar-nav">
			<ul class="nav nav-list">
				<li class="nav-header"><i class="icon-wrench"></i> 管理</li>
				<li onclick="addCss(this.id)" id="yh"><a href="<%=path %>/UserAction_list">用户</a></li>
				<li onclick="addCss(this.id)" id="js"><a href="<%=path %>/admin/roles.jsp">角色</a></li>
				<li class="nav-header"><i class="icon-info-sign"></i> 查询</li>
				<li onclick="addCss(this.id)" id="zhxx"><a href="<%=path %>/TeacherAction_list">综合信息</a></li>

				<li class="nav-header"><i class="icon-signal"></i> 统计</li>
				<li onclick="addCss(this.id)" id="ty"><a href="<%=path %>/admin/info-stat.jsp">通用</a></li>
				<li onclick="addCss(this.id)" id="tjyh"><a href="<%=path %>/admin/user-stats.jsp">用户</a></li>
				<li onclick="addCss(this.id)" id="fwz"><a href="<%=path %>/admin/visitor-stats.jsp">访问者</a></li>
				<li class="nav-header"><i class="icon-user"></i> 资料</li>
				<li onclick="addCss(this.id)" id="wdzl"><a href="<%=path %>/admin/my-profile.jsp">我的资料</a></li>
				<li onclick="addCss(this.id)" id="sz"><a href="#">设置</a></li>
				<li onclick="addCss(this.id)" id="tc"><a href="#">退出</a></li>
			</ul>
		</div>
	</div>
</body>
<script src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript">
function addCss(id) {
	/* 移除上一个选中的css */
	$("li").removeClass("active");
	/* 增添一个新的选中 */
	$("#"+id).addClass("active");
	
}

</script>
</html>
