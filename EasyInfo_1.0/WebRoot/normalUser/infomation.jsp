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
<title>Home - Brand</title>


 <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700"> 
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/fonts/ionicons.min.css">  -->
 <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
 <link rel="stylesheet" href="assets/css/styles.min.css"> 

 <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
    $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
  });
  </script>
  <style>
  .ui-tabs-vertical { width: 55em; }
  .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
  .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
  .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}
  </style> 

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
	<main class="page lanidng-page"></main>
	<div class="projects-horizontal">
		<div class="container">
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
			<!--<div class="intro">
            <h2 class="text-center">功能简介</h2>
            <p class="text-center">Nunc luctus in metus eget fringilla. Aliquam sed justo ligula. Vestibulum nibh erat, pellentesque ut laoreet vitae. </p>
        </div>-->
			<div>
				<br /> <br />
			</div>
			<div class="row projects">
				<div class="col-sm-6 col-md-12 item">
					<div class="row">
						<div class="col-md-6 col-lg-5">
							<a href="showResult.jsp"><img class="img-fluid"
								style="-webkit-border-radius:10px" src="assets/img/desk.jpg"></a>
						</div>
						<div class="col-md-6 col-lg-5">
							<div align="center">
								<font size="6"><b>教师基础信息</b></font> <br />
								<div class="row">
									<div class="col-md-6">

										<table>
										<!-- 教师基本信息 -->
											<tr>
												<td>
													<h4>职工号：${teacherInfo[0].tea_id}</h4>	
												
												</td>
											</tr>
											<tr>
												<td>
													<h4>姓名：${teacherInfo[0].tea_name}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>性别：${teacherInfo[0].tea_gender.dict_item_name}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>出生日期：${teacherInfo[0].tea_birthday}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>身份证号：${teacherInfo[0].tea_identityId}</h4>
												</td>
											</tr>
										<tr>
												<td>
													<h4>民族：${teacherInfo[0].tea_nation.dict_item_name}</h4>
												</td>
											</tr>
										<tr>
												<td>
													<h4>政治面貌：${teacherInfo[0].tea_political.dict_item_name}</h4>
												</td>
											</tr>
										<tr>
												<td>
													<h4>参加工作时间：${teacherInfo[0].tea_workDate}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>职称：${teacherInfo[0].tea_jobTitel.dict_item_name}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>学历：${teacherInfo[0].tea_eduBG.dict_item_name}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>学位：${teacherInfo[0].tea_degree.dict_item_name}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>家庭住址：${teacherInfo[0].tea_home}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>电话：${teacherInfo[0].tea_phone}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>QQ：${teacherInfo[0].tea_qq}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>微信：${teacherInfo[0].tea_weChat}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>系别：${teacherInfo[0].tea_dep.dict_item_name}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>状态：${teacherInfo[0].tea_enable.dict_item_name}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>邮箱：${teacherInfo[0].tea_email}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>角色：${teacherInfo[0].tea_role.dict_item_name}</h4>
												</td>
											</tr>
											<tr>
												<td>
													<h4>证件照：${teacherInfo[0].tea_img}</h4>
												</td>
											</tr>
										</table>
									</div>

								</div>

							</div>

						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-sm-6 col-md-12 item">
							<h3 class="name canHideInfomation">年终考核表 v</h3>
			
								<table>
	
								 <tr>
										<td>Id：${teacherInfo[1].ann_rev_id}</td>
										
									</tr>
									<tr>
										<td>年份：${teacherInfo[1].ann_rev_year}</td>
									</tr>
									<tr>
										<td>考核结果：${teacherInfo[1].ann_rev_grade.dict_item_name}</td>
									</tr>  
								</table>
						
					</div>
		 		<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">教学质量评估表 v</h3>
						<table>
							<tr>
								<td>教学评估id：${teacherInfo[2].tea_eva_id}</td>
							</tr>
						 	<tr>
								<td>学年：${teacherInfo[2].tea_eva_year}</td>
							</tr>
							<tr>
								<td>评估成绩：${teacherInfo[2].tea_eva_grade.dict_item_name}</td>
							</tr> 

						</table>
						<!--<span class="glyphicon glyphicon-play"></span>
-->
						<!--<span class="glyphicon glyphicon-eject"></span>-->
					</div>
					<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">论文表 v</h3>
						<table>
							<tr>
								<td>论文id：${teacherInfo[3].the_id}</td>
							</tr>
							<tr>
								<td>排名：${teacherInfo[3].the_rank}</td>
							</tr>
							<tr>
								<td>第一作者：${teacherInfo[3].the_firstAuthor}</td>
							</tr>
							<tr>
								<td>其他作者：${teacherInfo[3].the_otherAuthor}</td>
							</tr>
							<tr>
								<td>论文题目：${teacherInfo[3].the_title}</td>
							</tr>
							<tr>
								<td>刊物名称：${teacherInfo[3].the_periodical}</td>
							</tr>
							<tr>
								<td>出版时间：${teacherInfo[3].the_pubTime}</td>
							</tr>
							<tr>
								<td>卷号：${teacherInfo[3].the_reelNum}</td>
							</tr>
							<tr>
								<td>期号：${teacherInfo[3].the_issue}</td>
							</tr>
							<tr>
								<td>起始页码：${teacherInfo[3].the_startNum}</td>
							</tr>
							<tr>
								<td>终止页码：${teacherInfo[3].the_endNum}</td>
							</tr>
							<tr>
								<td>字数：${teacherInfo[3].the_wordNum}</td>
							</tr>
							<tr>
								<td>论文层次：${teacherInfo[3].the_level.dict_item_name}</td>
							</tr>
							<tr>
								<td>扫描件：${teacherInfo[3].the_scan}</td>
							</tr> 
						</table>
					</div>
							 <div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">纵向研究 v</h3>

								<table>
								<tr>
									<td>纵向科研id：${teacherInfo[4].ver_id}</td>
								</tr>
								<tr>
									<td>纵向科研编号：${teacherInfo[4].ver_no}</td>
								</tr>
								<tr>
									<td>排名：${teacherInfo[4].ver_rank}</td>
								</tr>
								<tr>
									<td>性质：${teacherInfo[4].ver_nature.dict_item_name}</td>
								</tr>
								<tr>
									<td>项目负责人：${teacherInfo[4].ver_manager}</td>
								</tr>
								<tr>
									<td>参加人员：${teacherInfo[4].ver_personnel}</td>
								</tr>
								<tr>
									<td>课题名称：${teacherInfo[4].ver_courseName}</td>
								</tr>
								<tr>
									<td>简单介绍：${teacherInfo[4].ver_introduction}</td>
								</tr>
								<tr>
									<td>立项时间：${teacherInfo[4].ver_projectTime}</td>
								</tr>
								<tr>
									<td>结题时间：${teacherInfo[4].ver_endTime}</td>
								</tr>
								<tr>
									<td>立项单位：${teacherInfo[4].ver_projectUnit}</td>
								</tr>
								<tr>
									<td>立项级别：${teacherInfo[4].ver_projectLevel.dict_item_name}</td>
								</tr>
								<tr>
									<td>鉴定时间：${teacherInfo[4].ver_identTime}</td>
								</tr>
								<tr>
									<td>鉴定级别：${teacherInfo[4].ver_identLevel.dict_item_name}</td>
								</tr>
								<tr>
									<td>鉴定结论：${teacherInfo[4].ver_identCon}</td>
								</tr>
								<tr>
									<td>扫描件：${teacherInfo[4].ver_scan}</td>
								</tr>

								</table>
							</div> 
 
							
							
					
					<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">专利表 v</h3>
		
								<table>
									<tr>
										<td>专利id：${teacherInfo[5].pat_id}</td>
									</tr>
									<tr>
										<td>排名：${teacherInfo[5].pat_rank}</td>
									</tr>
									<tr>
										<td>专利类型：${teacherInfo[5].pat_type.dict_item_name}</td>
									</tr>
									<tr>
										<td>作者：${teacherInfo[5].pat_author}</td>
									</tr>
									<tr>
										<td>题名：${teacherInfo[5].pat_name}</td>
									</tr>
									<tr>
										<td>国别：${teacherInfo[5].pat_country}</td>
									</tr>
									<tr>
										<td>登记号：${teacherInfo[5].pat_registerNum}</td>
									</tr>
									<tr>
										<td>发布日期：${teacherInfo[5].pat_pubTime}</td>
									</tr>
									<tr>
										<td>扫描件：${teacherInfo[5].pat_scan}</td>
									</tr>
	
								</table>
							</div>
				
					<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">横向研究表 v</h3>
								<table>
			 						<tr>
										<td>横向科研id：${teacherInfo[6].hor_id}</td>
									</tr>
									<tr>
										<td>横向科研编号：${teacherInfo[6].hor_no}</td>
									</tr>
									<tr>
										<td>排名：${teacherInfo[6].hor_rank}</td>
									</tr>
								<tr>
					 					<td>项目负责人：${teacherInfo[6].hor_manager}</td>
									</tr>
									<tr>
										<td>参加人员：${teacherInfo[6].hor_personnel}</td>
									</tr> 
									<tr>
										<td>课题名称：${teacherInfo[6].hor_courseName}</td>
									</tr>
									
									<tr>
										<td>简单介绍：${teacherInfo[6].hor_introduction}</td>
									</tr>
									<tr>
										<td>立项时间：${teacherInfo[6].hor_projectTime}</td>
									</tr>
									<tr>
										<td>结题时间：${teacherInfo[6].hor_endTime}</td>
									</tr>
									<tr>
										<td>客户名称：${teacherInfo[6].hor_cilentName}</td>
									</tr>
									<tr>
										<td>课题总经费：${teacherInfo[6].hor_subjcerCost}</td>
									</tr>
									<tr>
										<td>到位经费：${teacherInfo[6].hor_inplactCost}</td>
									</tr>
									<tr>
										<td>扫描件：${teacherInfo[6].hor_scan}</td>
									</tr>
								</table>
							</div>
					
								<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">指导学生 v</h3>
								<table>
									<tr>
										<td>索引id：${teacherInfo[7].ins_stu_id}</td>
									</tr>
 									<tr>
										<td>排名：${teacherInfo[7].ins_stu_rank}</td>
									</tr>
									<tr>
										<td>指导教师一：${teacherInfo[7].ins_stu_teancherOne}</td>
									</tr>
									<tr>
										<td>指导教师一单位：${teacherInfo[7].ins_stu_oneUnit}</td>
									</tr>
										<tr>
										<td>指导教师二：${teacherInfo[7].ins_stu_teacherTwo}</td>
									</tr>
									<tr>
										<td>指导教师二单位：${teacherInfo[7].ins_stu_twoUnit}</td>
									</tr>
									<tr>
										<td>指导教师三：${teacherInfo[7].ins_stu_teacherThree}</td>
									</tr>
									<tr>
										<td>指导教师三单位：${teacherInfo[7].ins_stu_threeUnit}</td>
									</tr>
				 				<tr>
										<td>学号：${teacherInfo[7].ins_stu_num}</td>
									</tr>
									<tr>
										<td>学生姓名：${teacherInfo[7].ins_stu_name}</td>
									</tr>
									<tr>
										<td>竞赛名称：${teacherInfo[7].ins_stu_comName}</td>
									</tr>
									<tr>
										<td>项目名称：${teacherInfo[7].ins_stu_proName}</td>
									</tr>
									<tr>
										<td>开始时间：${teacherInfo[7].ins_stu_startTime}</td>
									</tr>
									 <tr>
										<td>结束时间：${teacherInfo[7].ins_stu_endTime}</td>
									</tr>
									<tr>
										<td>集体或个人：${teacherInfo[7].ins_stu_type.dict_item_name}</td>
									</tr>
									<tr>
										<td>团队其他成员：${teacherInfo[7].ins_stu_others}</td>
									</tr>
									<tr>
										<td>主办单位：${teacherInfo[7].ins_stu_organizer}</td>
									</tr>
									<tr>
										<td>是否获奖：${teacherInfo[7].ins_stu_reward.dict_item_name}</td>
									</tr>
									<tr>
										<td>获奖时间：${teacherInfo[7].ins_stu_rewardTime}</td>
									</tr>
									<tr>
										<td>学生获奖级别：${teacherInfo[7].ins_stu_rewardLevel.dict_item_name}</td>
									</tr>
									<tr>
										<td>获奖等级或奖项名称说明：${teacherInfo[7].ins_stu_rewardDetail}</td>
									</tr>
									<tr>
										<td>扫描件：${teacherInfo[7].ins_stu_scan}</td>
									</tr>   
								</table>
							</div>

				
					<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">挂职实践表 v</h3>

								<table>
									<tr>
										<td>索引id：${teacherInfo[8].pra_id}</td>
									</tr>
									<tr>
										<td>起始时间：${teacherInfo[8].pra_startTime}</td>
									</tr>
									<tr>
										<td>结束时间：${teacherInfo[8].pra_endTime}</td>
									</tr>
									<tr>
										<td>实践职务：${teacherInfo[8].pra_post}</td>
									</tr>
									<tr>
										<td>依托项目：${teacherInfo[8].pra_project}</td>
									</tr>
									<tr>
										<td>实践内容：${teacherInfo[8].pra_content}</td>
									</tr>
									<tr>
										<td>扫描件：${teacherInfo[8].pra_scan}</td>
									</tr>
									
								</table>
							</div>
		
					<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">培训学习表 v</h3>

								<table>
									<tr>
										<td>索引id：${teacherInfo[9].tra_id}</td>
									</tr>
									<tr>
										<td>起始时间：${teacherInfo[9].tra_startTime}</td>
									</tr>
									<tr>
										<td>结束时间：${teacherInfo[9].tra_endTime}</td>
									</tr>
									<tr>
										<td>地点：${teacherInfo[9].tra_address}</td>
									</tr>
									<tr>
										<td>主题：${teacherInfo[9].tra_theme}</td>
									</tr>
									<tr>
										<td>培训内容：${teacherInfo[9].tra_content}</td>
									</tr>
									<tr>
										<td>培训成果：${teacherInfo[9].tra_result.dict_item_name}</td>
									</tr>
									<tr>
										<td>扫描件：${teacherInfo[9].tra_scan}</td>
									</tr>
								</table>
							</div>

						<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">奖励表 v</h3>

								<table>
									<tr>
										<td>索引id：${teacherInfo[10].rew_id}</td>
									</tr>
									<tr>
										<td>奖励时间：${teacherInfo[10].rew_time}</td>
									</tr>
									<tr>
										<td>奖励名称：${teacherInfo[10].rew_name}</td>
									</tr>
									<tr>
										<td>奖励部门：${teacherInfo[10].rew_department}</td>
									</tr>
									<tr>
										<td>奖励级别：${teacherInfo[10].rew_level.dict_item_name}</td>
									</tr>
									<tr>
										<td>获奖等级或奖项名称：${teacherInfo[10].rew_levelDetail}</td>
									</tr>
									<tr>
										<td>奖励类别：${teacherInfo[10].rew_family.dict_item_name}</td>
									</tr>
									<tr>
										<td>集体或个人：${teacherInfo[10].rew_ascription.dict_item_name}</td>
									</tr>
									<tr>
										<td>扫描件：${teacherInfo[10].rew_scan}</td>
									</tr>
								</table>
							</div>

					<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">辅导员情况表 v</h3>

								<table>
									<tr>
										<td>索引id：${teacherInfo[11].ins_id}</td>
									</tr>
									<tr>
										<td>起始时间：${teacherInfo[11].ins_startTime}</td>
									</tr>
								<tr>
										<td>结束时间：${teacherInfo[11].ins_endTime}</td>
									</tr>
									<tr>
										<td>班级：${teacherInfo[11].ins_classes}</td>
									</tr>
									
								</table>
							</div>

					<div class="col-sm-6 col-md-12 item">
						<h3 class="name canHideInfomation">教材著作表 v</h3>

								<table>
									<tr>
										<td>教材著作id：${teacherInfo[12].cm_id}</td>
									</tr>
									<tr>
										<td>排名：${teacherInfo[12].cm_rank}</td>
									</tr>
									<tr>
										<td>主编：${teacherInfo[12].cm_chiefEditor}</td>
									</tr>
									<tr>
										<td>副主编：${teacherInfo[12].cm_subeditor}</td>
									</tr>
									<tr>
										<td>著作名称：${teacherInfo[12].cm_name}</td>
									</tr>
									<tr>
										<td>版次：${teacherInfo[12].cm_edition}</td>
									</tr>
									<tr>
										<td>出版地：${teacherInfo[12].cm_location}</td>
									</tr>
									<tr>
										<td>出版者：${teacherInfo[12].cm_publisher}</td>
									</tr>
									<tr>
										<td>出版时间：${teacherInfo[12].cm_pubTime}</td>
									</tr>
									<tr>
										<td>页码：${teacherInfo[12].cm_pageNum}</td>
									</tr>
									<tr>
										<td>承担字数：${teacherInfo[12].cm_bearNum}</td>
									</tr>
									<tr>
										<td>扫描件：${teacherInfo[12].cm_scan}</td>
									</tr>
					
								</table>
							</div>
							</div>
<div id="tabs" align>
  <ul>
    <li><a href="#tabs-1">Nunc tincidunt</a></li>
    <li><a href="#tabs-2">Proin dolor</a></li>
    <li><a href="#tabs-3">Aenean lacinia</a></li>
  </ul>
  <div id="tabs-1">
    <h2>内容标题 1</h2>
    <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
  </div>
  <div id="tabs-2">
    <h2>内容标题 2</h2>
    <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>
  </div>
  <div id="tabs-3">
    <h2>内容标题 3</h2>
    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
  </div>
</div>
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
				</div>
			</div>
		</div>
	</div>


	</footer>

<%-- 	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>  --%>
	<script>
		$(document).ready(function() {
			$(".canHideInfomation").click(function() {
				$(this).next().toggle();
			});
		});
	</script> -
</body>

</html>