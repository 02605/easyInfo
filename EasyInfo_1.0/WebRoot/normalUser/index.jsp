<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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


<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home - Brand</title>
<link rel="stylesheet" href="normalUser/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
<link rel="stylesheet" href="normalUser/assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="normalUser/assets/fonts/ionicons.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet" href="normalUser/assets/css/styles.min.css">
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
	<main class="page lanidng-page"> <section
		class="portfolio-block block-intro"> <br />
	<div class="container">
		<div class="avatar"
			style="background-image:url(&quot;normalUser/assets/img/avatars/avatar.jpg&quot;);"></div>
		<div class="about-me">
			<p>
				<b>教师信息辅助管理系统</b>
			</p>
			<a class="btn btn-outline-primary pulse animated infinite"
				role="button" href="normalUser/functions.jsp">让我们开始吧</a>
		</div>
	</div>
	</section> <section class="portfolio-block photography">
	<div class="container">
		<!--<div class="row no-gutters">
						<div class="col-md-6 col-lg-4 item zoom-on-hover"><a href="#"><img class="img-fluid image" src="normalUser/assets/img/nature/image4.jpg"></a></div>
                    <div class="col-md-6 col-lg-4 item zoom-on-hover"><a href="#"><img class="img-fluid image" src="normalUser/assets/img/nature/image4.jpg"></a></div>
                    <div class="col-md-6 col-lg-4 item zoom-on-hover"><a href="#"><img class="img-fluid image" src="normalUser/assets/img/nature/image4.jpg"></a></div>
					</div>
					<div class="col-md-6 col-lg-4 item zoom-on-hover">
						<a href="#"><img class="img-fluid image" src="normalUser/assets/img/nature/image4.jpg"></a>
					</div>
					<div class="col-md-6 col-lg-4 item zoom-on-hover">
						<a href="#"><img class="img-fluid image" src="normalUser/assets/img/nature/image4.jpg"></a>
					</div>-->
		<div class="row">
			<div class="col-md-6" align="center">
				<p>关于本系统正式启用的通知。2018-9-15</p>
				<p>关于相关老师填写个人信息的通知。2018-08-30</p>
			</div>
			<div class="col-md-6" align="center">
				<p>关于本系统正式启用的通知。2018-9-15</p>
				<p>关于本系统正式启用的通知。2018-9-15</p>
			</div>
		</div>
	</div>
	</div>
	</section> <section class="portfolio-block call-to-action border-bottom">
	<div class="container">
		<div class="d-flex justify-content-center align-items-center content">
			<button class="btn btn-outline-primary btn-lg" type="button"
				data-bs-hover-animate="pulse"
				onclick="window.location.href='normalUser/news.jsp'">查看更多</button>
		</div>
	</div>
	</section> <section class="portfolio-block skills">
	<div class="container">
		<div class="heading">
			<h2>我们的功能</h2>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="card special-skill-item border-0">
					<div class="card-header bg-transparent border-0">
						<i class="icon ion-ios-star-outline"></i>
					</div>
					<div class="card-body">
						<h3 class="card-title">快速获取信息</h3>
						<p class="card-text">协助教师快速获取自己在教务系统中的信息，以优雅的方式呈现，便于查看并进行下一步动作。</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card special-skill-item border-0">
					<div class="card-header bg-transparent border-0">
						<i class="icon ion-ios-lightbulb-outline"></i>
					</div>
					<div class="card-body">
						<h3 class="card-title">填写Excel文件</h3>
						<p class="card-text">我们提供自动填写 Excel
							文件的功能。您可选择公共模板抑或是上传您的私人模板，系统将会根据您在教务系统中的数据自动对齐进行填写，省时省力，并保证准确性。</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card special-skill-item border-0">
					<div class="card-header bg-transparent border-0">
						<i class="icon ion-ios-gear-outline"></i>
					</div>
					<div class="card-body">
						<h3 class="card-title">协助信息校验</h3>
						<p class="card-text">倘若您在个人信息页发现自身数据存在问题，此系统也可帮助您快速定位并修改。</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section> </main>
	<footer class="page-footer">
	<div class="container">
		<div class="links">
			<a href="normalUser/aboutUs.jsp">关于我们</a> <a href="normalUser/emailToUs.jsp">联系我们</a>
		</div>
		<div class="social-icons">
			<a href="#"><i class="icon ion-social-facebook"></i></a> <a href="#"><i
				class="icon ion-social-instagram-outline"></i></a> <a href="#"><i
				class="icon ion-social-twitter"></i></a>
		</div>
	</div>
	</footer>
	<nav
		class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
	<div class="container">
		<a class="navbar-brand logo" href="normalUser/index.jsp"
			data-bs-hover-animate="pulse"><img src="normalUser/assets/img/icon.jpg"
			width="44" height="44">		
			<%-- <c:choose><c:when test="${sessionScope.userLogin eq null}">欢迎使用本系统！</c:when><c:otherwise>欢迎您，${userLogin.tea_id }</:otherwise></c:choose> --%> 
			欢迎${user.tea_id}使用本系统</a>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarNav">
			<span class="sr-only">Toggle navigation</span><span
				class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item" role="presentation"><a
					class="nav-link active" href="normalUser/index.jsp"
					data-bs-hover-animate="pulse">首页</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link"
					href="normalUser/functions.jsp" data-bs-hover-animate="pulse">功能</a></li>
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
	<script src="normalUser/assets/js/jquery.min.js"></script>
	<script src="normalUser/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="normalUser/assets/js/script.min.js"></script>
</body>

</html>
