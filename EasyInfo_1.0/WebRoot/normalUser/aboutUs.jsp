<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>project</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/fonts/ionicons.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet" href="assets/css/styles.min.css">
<style>
/* 下拉按钮样式 */
.dropbtn {
    background-color:#3FA5F7;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

/* 容器 <div> - 需要定位下拉内容 */
.dropdown {
    position: relative;
    display: inline-block;
}

/* 下拉内容 (默认隐藏) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

/* 下拉菜单的链接 */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* 鼠标移上去后修改下拉菜单链接颜色 */
.dropdown-content a:hover {background-color: }

/* 在鼠标移上去后显示下拉菜单 */
.dropdown:hover .dropdown-content {
    display: block;
}

/* 当下拉内容显示后修改下拉按钮的背景颜色 */
.dropdown:hover .dropbtn {
    background-color: #3FA5F7;
}
</style>
</head>

<body>
	<nav
		class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
	<div class="container">
		<a class="navbar-brand logo" href="index.jsp"
			data-bs-hover-animate="pulse"><img src="assets/img/icon.jpg"
			width="44" height="44">欢迎${user.tea_id}使用本系统</a>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarNav">
			<span class="sr-only">Toggle navigation</span><span
				class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="index.jsp" data-bs-hover-animate="pulse">首页</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="infomation.jsp" data-bs-hover-animate="pulse">查看个人信息</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="showResult.jsp" data-bs-hover-animate="pulse">定制模板导出</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="methods.jsp" data-bs-hover-animate="pulse">模板管理</a></li>

			</ul>
			<c:choose>
				<c:when test="${sessionScope.user eq null}">
					<a class="btn btn-primary" role="button"
						href="<%=path%>/normalUser/login.jsp"
						data-bs-hover-animate="pulse"
						style="background-color:rgb(254,170,109);"> 登录</a>
				</c:when>
				<c:otherwise>
					<div class="dropdown">
						<a class="btn btn-primary" role="button"
							data-bs-hover-animate="pulse"
							style="background-color:rgb(35,218,222);"> 账户</a>
						<div class="dropdown-content">
							<a href="<%=path%>/normalUser/pwdChange.jsp">修改密码</a> <a href="<%=path%>/normalUser/loginout.jsp">注销</a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	</nav>
	<div class="team-clean">
		<div class="container">
			<div class="intro" style="padding-top: 80px;">
				<h2 class="text-center">我们的团队</h2>
			</div>
			<div class="row people">
				<div class="col-md-6 col-lg-4 item">
					<img class="rounded-circle" src="assets/img/1.jpg">
					<h3 class="name">任旭</h3>
					<p class="title">Musician</p>
					<p class="description">Aenean tortor est, vulputate quis leo
						in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida.
						Aliquam varius finibus est, et interdum justo suscipit id. Etiam
						dictum feugiat tellus, a semper massa.</p>
					<div class="social">
						<a href="#"><i class="fa fa-facebook-official"></i></a> <a
							href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-instagram"></i></a>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 item">
					<img class="rounded-circle" src="assets/img/2.jpg">
					<h3 class="name">詹淇</h3>
					<p class="title">Artist</p>
					<p class="description">Aenean tortor est, vulputate quis leo
						in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida.
						Aliquam varius finibus est, et interdum justo suscipit id. Etiam
						dictum feugiat tellus, a semper massa.</p>
					<div class="social">
						<a href="#"><i class="fa fa-facebook-official"></i></a> <a
							href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-instagram"></i></a>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 item">
					<img class="rounded-circle" src="assets/img/3.jpg">
					<h3 class="name">陶宇豪</h3>
					<p class="title">Stylist</p>
					<p class="description">Aenean tortor est, vulputate quis leo
						in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida.
						Aliquam varius finibus est, et interdum justo suscipit id. Etiam
						dictum feugiat tellus, a semper massa.</p>
					<div class="social">
						<a href="#"><i class="fa fa-facebook-official"></i></a> <a
							href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-instagram"></i></a>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 item">
					<img class="rounded-circle" src="assets/img/1.jpg">
					<h3 class="name">王敬雯</h3>
					<p class="title">Musician</p>
					<p class="description">Aenean tortor est, vulputate quis leo
						in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida.
						Aliquam varius finibus est, et interdum justo suscipit id. Etiam
						dictum feugiat tellus, a semper massa.</p>
					<div class="social">
						<a href="#"><i class="fa fa-facebook-official"></i></a> <a
							href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-instagram"></i></a>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 item">
					<img class="rounded-circle" src="assets/img/2.jpg">
					<h3 class="name">狄克</h3>
					<p class="title">Artist</p>
					<p class="description">Aenean tortor est, vulputate quis leo
						in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida.
						Aliquam varius finibus est, et interdum justo suscipit id. Etiam
						dictum feugiat tellus, a semper massa.</p>
					<div class="social">
						<a href="#"><i class="fa fa-facebook-official"></i></a> <a
							href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-instagram"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="team-boxed"></div>
	<footer class="page-footer">
	<div class="container">
		<div class="links">
			<a href="aboutUs.jsp">关于我们</a> <a href="emailToUs.jsp">联系我们</a>
		</div>
		<div class="social-icons">
			<a href="#"><i class="icon ion-social-facebook"></i></a> <a href="#"><i
				class="icon ion-social-instagram-outline"></i></a> <a href="#"><i
				class="icon ion-social-twitter"></i></a>
		</div>
	</div>
	</footer>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>
</body>

</html>