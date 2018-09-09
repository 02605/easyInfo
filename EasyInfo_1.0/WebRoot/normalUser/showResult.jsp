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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/fonts/ionicons.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet" href="assets/css/styles.min.css">

<!-- <link rel="stylesheet" href="assets/css/reset.css"> -->
<link rel="stylesheet" href="assets/css/hoverex-all.css">
<link rel="stylesheet" href="assets/css/templates.css"> 
<script type="text/javascript" src="assets/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.hoverex.js"></script> 


<style>
/* 下拉按钮样式 */
.dropbtn {
	background-color: #3FA5F7;
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
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
}

/* 下拉菜单的链接 */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

/* 鼠标移上去后修改下拉菜单链接颜色 */
.dropdown-content a:hover {
	background-color:
}

/* 在鼠标移上去后显示下拉菜单 */
.dropdown:hover .dropdown-content {
	display: block;
}

/* 当下拉内容显示后修改下拉按钮的背景颜色 */
.dropdown:hover .dropbtn {
	background-color: #3FA5F7;
}
</style>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">

<script type="text/javascript" src="assets/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.hoverex.js"></script>
<%--  <script src="//code.jquery.com/jquery-1.9.1.js"></script> --%>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>

</head>

<body>

	<main class="page projects-page"> <section
		class="portfolio-block projects-with-sidebar"> <nav
		class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
	<div class="container">
		<a class="navbar-brand logo" href="index.jsp"><img
			src="assets/img/icon.jpg" width="44" height="44">欢迎${user.tea_id}使用本系统</a>
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
							<a href="<%=path%>/normalUser/pwdChange.jsp">修改密码</a> <a
								href="<%=path%>/normalUser/loginout.jsp">注销</a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	</nav>

	<div class="container">
		<div class="heading">
			<h2>预览</h2>
		</div>
		<div class="row">
			<div class="col-md-3">
				<!-- 此处开始为"左侧操作栏" -->

				<ul class="list-unstyled sidebar">
					<div class="row">
						<div class="col-md-6">

							<img width="80" height="80" src="assets/img/3.jpg"
								style="-webkit-border-radius:10px" />

						</div>
						<div class="col-md-6">
							<div class="row">
								<h4>陶宇豪</h4>
								<h6>2016405A</h6>
							</div>
						</div>
					</div>

					<li>
						<hr />
					</li>
					<li>

						<div class="row">
							<div id="tabs">
								<ul>
									<li><a href="#tabs-1"><font size="3" color="black">私人模板</font></a></li>
									<li><a href="#tabs-2"><font size="3" color="black">公共模板</font></a></li>
								</ul>
								<div id="tabs-1">
									<div class="row">
										<div class="col-md-12">
											<div align="center">
												<div class="box">
													<div class="he-wrap tpl6">
														<img class="img-fluid"
															src="assets/img/screenCapture/jl1.jpg" alt="">
														<div class="he-view">
															<div class="bg a0" data-animate="fadeIn">
																<h3 class="a1" data-animate="fadeInDown">功能选项</h3>
																<a href="usePrivate.action" class="btn a2" data-animate="rotateInLeft">套用</a>
																<a href="#" class="btn a2" data-animate="rotateInRight">删除</a>
															</div>
														</div>
													</div>
												</div>

												<br />基础信息模板
											</div>

											<div align="center">
												<div class="box">
													<div class="he-wrap tpl6">
														<img class="img-fluid"
															src="assets/img/screenCapture/jl2.jpg" alt="">
														<div class="he-view">
															<div class="bg a0" data-animate="fadeIn">
																<h3 class="a1" data-animate="fadeInDown">功能选项</h3>
																<a href="#" class="btn a2" data-animate="rotateInLeft">套用</a>
																<a href="#" class="btn a2" data-animate="rotateInRight">删除</a>
															</div>
														</div>
													</div>
												</div>
												<br />科研信息模板
											</div>
										</div>
									</div>
								</div>
								<div id="tabs-2">
									<div class="row">
										<div class="col-md-12">
											<div align="center">
												<div class="box">
													<div class="he-wrap tpl6">
														<img class="img-fluid"
															src="assets/img/screenCapture/jl3.jpg" alt="">
														<div class="he-view">
															<div class="bg a0" data-animate="fadeIn">
																<h3 class="a1" data-animate="fadeInDown">功能选项</h3>
																<a href="#" class="btn a2" data-animate="rotateInLeft">套用</a>
																<a href="#" class="btn a2" data-animate="rotateInRight">删除</a>
															</div>
														</div>
													</div>
												</div>
												<br />管理班级模板
											</div>
										</div>
									</div>

								</div>
								<!-- 							<div class="col-md-6">
								<button class="btn-dark">
									<font size="2">公共模板</font>
								</button>
							</div>
							<div class="col-md-6">
								<button class="btn-dark">
									<font size="2">私人模板</font>
								</button>
							</div>
						</div>
						<hr />
						<div class="row">
							<div class="col-md-12">
								<div align="center">
									<div class="box">	
											<div class="he-wrap tpl6"> 
												<img class="img-fluid" src="assets/img/screenCapture/jl1.jpg" alt="">
												<div class="he-view">
													<div class="bg a0" data-animate="fadeIn">
														<h3 class="a1" data-animate="fadeInDown">功能选项</h3>
														<a href="#" class="btn a2" data-animate="rotateInLeft">套用</a>
														<a href="#" class="btn a2" data-animate="rotateInRight">删除</a>
													</div>
												</div>
											</div>
									</div>

										<img class="img-fluid" src="assets/img/screenCapture/jl1.jpg" />

									<br />基础信息模板
								</div>
								<div align="center">
								<div class="box">	
											<div class="he-wrap tpl6"> 
												<img class="img-fluid" src="assets/img/screenCapture/jl2.jpg" alt="">
												<div class="he-view">
													<div class="bg a0" data-animate="fadeIn">
														<h3 class="a1" data-animate="fadeInDown">功能选项</h3>
														<a href="#" class="btn a2" data-animate="rotateInLeft">套用</a>
														<a href="#" class="btn a2" data-animate="rotateInRight">删除</a>
													</div>
												</div>
											</div>
									</div>
									<br />科研信息模板
								</div>
								<div align="center">
									<div class="box">	
											<div class="he-wrap tpl6"> 
												<img class="img-fluid" src="assets/img/screenCapture/jl3.jpg" alt="">
												<div class="he-view">
													<div class="bg a0" data-animate="fadeIn">
														<h3 class="a1" data-animate="fadeInDown">功能选项</h3>
														<a href="#" class="btn a2" data-animate="rotateInLeft">套用</a>
														<a href="#" class="btn a2" data-animate="rotateInRight">删除</a>
													</div>
												</div>
											</div>
									</div>
								<br />管理班级模板</div>

							</div> -->

							</div>
					</li>
					<li>
						<hr />
					</li>
					<li>

						<div class="row" > 
						
							<div class="col-md-12"  align="center">
								<form action="privateMethodUpload.action" method="post"
									enctype="multipart/form-data">
									<input type="file" name="uploadPrivateMethod">
									 <input type="submit" value="上传新模板">
									<!-- 
										
										2. 其他页面如何调用显示保存的图片? 
首先要求图片按步骤 1 中说的那样，保存在 web 应用根目录下 
Html 代码  收藏代码
<img src="<s:property value="'upload/' + uploadFileName"/>"/>   -->
								</form>
							</div>
						</div>
					</li>
				</ul>
				<!-- 此处为"左侧操作栏"的结束 -->
			</div>
			<!-- 此处开始为"右侧显示结果页面" -->
			<div class="col-md-9 col-lg-4" align="center">
				<div align="center">
					<img style="width: 800px;height: 900px;"
						src="assets/img/screenCapture/jl1.jpg" />
				</div>

			</div>
		</div>
	</div>
	</section> </main>
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
  <%--  	<script src="assets/js/jquery.min.js"></script>  --%>
	 <script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>  
</body>

</html>