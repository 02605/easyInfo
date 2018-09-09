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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Projects - Brand</title>
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
							<a href="<%=path%>/normalUser/pwdChange.jsp">修改密码</a> <a href="<%=path%>/normalUser/loginout.jsp">注销</a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="heading">
			<h2>通知</h2>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div id="sidebar">
					<h3>
						<!--#begineditable name="栏目名称" viewid="191367" tagname="栏目名称" action="" layout="" contype="" stylesysid="" template="" tplstyle="" clone="" istemp=""-->
						新闻
						<!--#endeditable-->
					</h3>
					<ul>
						<!--#begineditable name="网站导航2" viewid="191368" tagname="网站导航2" action="" layout="" contype="" stylesysid="" template="" tplstyle="" clone="" istemp=""-->
						<li><a href="#" title="通知">通知</a></li>
						<!--#endeditable-->
					</ul>
				</div>
			</div>
			<!-- 此处开始为"右侧显示结果页面" -->
			<div class="col-md-9 col-lg-9" align="center">

				<script language="javascript"
					src="/system/resource/js/news/statpagedown.js"></script>
				<ul class="inner">
					<li id="line_u9_0"><span> 2018 年 08 月 22 日</span> <a
						href="../info/1121/3337.htm" target="_blank"
						title="北华航天工业学院建校40周年校友邀请函" style="color:#f70f0f;">北华航天工业学院建校
							40 周年校友邀请函</a></li>

					<li id="line_u9_1"><span> 2018 年 08 月 22 日</span> <a
						href="../info/1121/3338.htm" target="_blank"
						title="我校举行2017级学生军训动员大会">我校举行 2017 级学生军训动员大会</a></li>

					<li id="line_u9_2"><span> 2018 年 08 月 21 日</span> <a
						href="../info/1121/3335.htm" target="_blank"
						title="我校外教柯克·艾伦·沃尔曼荣获2017年度“廊坊市创新合作优​秀中外专家”称号">我校外教柯克 · 艾伦 ·
							沃尔曼荣获 2017 年度 “廊坊市创新合作优​秀中外专家” 称号</a></li>

					<li id="line_u9_3"><span> 2018 年 08 月 19 日</span> <a
						href="../info/1121/3322.htm" target="_blank"
						title="学校领导班子召开巡视整改专题民主生活会">学校领导班子召开巡视整改专题民主生活会</a></li>

					<li id="line_u9_4"><span> 2018 年 08 月 16 日</span> <a
						href="../info/1121/3312.htm" target="_blank"
						title="韩文仲校长在教育部 “地方高校转型发展专题研讨班” （第八期）作专题报告">韩文仲校长在教育部
							“地方高校转型发展专题研讨班” （第八期）作专题报告</a></li>

					<li id="line_u9_5"><span> 2018 年 08 月 16 日</span> <a
						href="../info/1121/3311.htm" target="_blank"
						title="学校召开2018年学生军训工作部署会">学校召开 2018 年学生军训工作部署会</a></li>

					<li id="line_u9_6"><span> 2018 年 08 月 14 日</span> <a
						href="../info/1121/3285.htm" target="_blank"
						title="继续教育学院成功承办荣盛发展2018年雏鹰训练营">继续教育学院成功承办荣盛发展 2018 年雏鹰训练营</a></li>

					<li id="line_u9_7"><span> 2018 年 08 月 14 日</span> <a
						href="../info/1121/3284.htm" target="_blank"
						title="关于发布建校40周年纪念标识、吉祥物的公告  ">关于发布建校 40 周年纪念标识、吉祥物的公告 </a></li>

					<li id="line_u9_8"><span>2018 年 08 月 12 日</span> <a
						href="../info/1121/3271.htm" target="_blank"
						title="我校学生获2018中国国际飞行器设计挑战赛全国一等奖">我校学生获 2018
							中国国际飞行器设计挑战赛全国一等奖</a></li>

					<li id="line_u9_9"><span> 2018 年 08 月 10 日</span> <a
						href="../info/1121/3272.htm" target="_blank"
						title="乌克兰茹科夫斯基国立航空航天大学 校长率团访问我校">乌克兰茹科夫斯基国立航空航天大学 校长率团访问我校</a></li>

					<li id="line_u9_10"><span> 2018 年 08 月 10 日</span> <a
						href="../info/1121/3273.htm" target="_blank"
						title="美国乔治梅森大学曲建和教授 来我校进行学术交流">美国乔治梅森大学曲建和教授 来我校进行学术交流</a></li>

					<li id="line_u9_11"><span> 2018 年 08 月 10 日</span> <a
						href="../info/1121/3264.htm" target="_blank"
						title="我校获批新增两个硕士学位授权点">我校获批新增两个硕士学位授权点</a></li>

					<li id="line_u9_12"><span> 2018 年 08 月 08 日</span> <a
						href="../info/1121/3256.htm" target="_blank"
						title="我校2018年招生录取工作圆满结束">我校 2018 年招生录取工作圆满结束</a></li>

					<li id="line_u9_13"><span> 2018 年 08 月 05 日</span> <a
						href="../info/1121/3254.htm" target="_blank"
						title="郝玉龙传达部署全省组织工作会议精神">郝玉龙传达部署全省组织工作会议精神</a></li>

					<li id="line_u9_14"><span> 2018 年 07 月 29 日</span> <a
						href="../info/1121/3243.htm" target="_blank"
						title="我校学生在全国大学生机械创新设计大赛中获全国一等奖">我校学生在全国大学生机械创新设计大赛中获全国一等奖</a></li>

				</ul>
				<div align="center">
					<input type="hidden" name="actiontype" value=""><input
						type="hidden" name="_scode_" value="1534998549185"><input
						type="hidden" name="urltype" value="tree.TreeTempUrl"><input
						type="hidden" name="wbtreeid" value="1121"><input
						type="hidden" name="outFlag" value="false">
					<style type="text/css">
.headStyle1y2ym5d68a,.headStyle1y2ym5d68a td,.headStyle1y2ym5d68a div {
	font-size: 12px;
	font-family: 宋体;
	color: #000000;
	margin-left: auto;
	margin-right: auto;
	line-height: 14px;
}

.defaultButtonStyle {
	font-size: 12px;
	font-family: 宋体;
	height: 20px;
	color: #000000;
	BORDER: #AFD5F5 1px solid;
	margin: 0px;
	padding: 0px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#BDDBF7);
	CURSOR: pointer;
	line-height: 14px;
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff),
		to(#BDDBF7));
	background: -moz-linear-gradient(top, #ffffff, #BDDBF7);
	background: -ms-linear-gradient(top, #ffffff 0%, #bddbf7 100%);
}

.defaultinputStyle {
	font-size: 12px;
	font-family: 宋体;
	height: 20px;
	border: 1px solid #AFD5F5;
	line-height: 14px;
}

.colHeader {
	font-size: 12px;
	font-family: 宋体;
	line-height: 14px;
}

.headStyle1y2ym5d68a a,.pageList .this-page {
	font-size: 12px;
	font-family: 宋体;
	display: inline-block;
	height: 14px;
	padding: 2px 4px;
	border: solid 1px #AFD5F5;
	background: #fff;
	text-decoration: none;
	MARGIN-RIGHT: 1px;
	line-height: 14px;
}

.headStyle1y2ym5d68a a:visited {
	font-size: 12px;
	font-family: 宋体;
	color: #000000;
	text-decoration: none;
	line-height: 14px;
}

.headStyle1y2ym5d68a .PrevDisabled {
	font-size: 12px;
	font-family: 宋体;
	display: inline-block;
	height: 14px;
	margin-right: 3px;
	padding: 2px 4px;
	background: #fff;
	color: #ccc;
	border: solid 1px #AFD5F5;
	line-height: 14px;
}

.headStyle1y2ym5d68a .SelectList {
	font-size: 12px;
	font-family: 宋体;
	line-height: 14px;
}

.headStyle1y2ym5d68a .Prev {
	font-size: 12px;
	font-family: 宋体;
	margin-right: 3px;
	padding: 2px 4px;
	line-height: 14px;
}

.headStyle1y2ym5d68a .break {
	font-size: 12px;
	font-family: 宋体;
	border: none;
	text-decoration: none;
	line-height: 14px;
}

.headStyle1y2ym5d68a .NextDisabled {
	font-size: 12px;
	font-family: 宋体;
	display: inline-block;
	height: 14px;
	margin-left: 2px;
	padding: 2px 4px;
	background: #fff;
	color: #ccc;
	border: solid 1px #AFD5F5;
	line-height: 14px;
}

.headStyle1y2ym5d68a .Next {
	font-size: 12px;
	font-family: 宋体;
	margin-left: 2px;
	padding: 2px 4px;
	line-height: 14px;
}

.headStyle1y2ym5d68a .this-page {
	font-size: 12px;
	font-family: 宋体;
	display: inline-block;
	height: 14px;
	padding: 2px 4px;
	border: solid 1px #AFD5F5;
	background: #E1F0FD;
	font-weight: bold;
	color: black;
	MARGIN-RIGHT: 1px;
	line-height: 14px;
}

.headStyle1y2ym5d68a a:hover {
	font-size: 12px;
	font-family: 宋体;
	color: black;
	background: #EFF7FE;
	border-color: #AFD5F5;
	text-decoration: none;
	line-height: 14px;
}

.headStyle1y2ym5d68a a:link {
	font-size: 12px;
	font-family: 宋体;
	color: #000000;
	text-decoration: none;
	line-height: 14px;
}

.headStyle1y2ym5d68a a:active {
	font-size: 12px;
	font-family: 宋体;
	color: black;
	text-decoration: none;
	background: #EFF7FE;
	line-height: 14px;
}
</style>
					<script language="javascript" src="/system/resource/js/gotopage.js"></script>
					<script type="text/javascript">
						function a191370_gopage_fun() {
							_simple_list_gotopage_fun(97, 'a191370GOPAGE', 2)
						}
					</script>
					<table cellspacing="0" cellpadding="0" border="0">
						<tbody>
							<tr>
								<td colspan="0">
									<table cellspacing="0" class="headStyle1y2ym5d68a" width="100%"
										cellpadding="1">
										<tbody>
											<tr valign="middle">
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<!--#endeditable-->
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
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>
</body>

</html>