<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'users.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="<%=path%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=path%>/css/site.css" rel="stylesheet">
<link rel="stylesheet" href="<%=path%>/css/zebra_tooltips.css"
	type="text/css">
<link href="<%=path%>/css/bootstrap-responsive.css" rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/asDatepicker.css">

<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/my.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-ui.js"></script>





<SCRIPT language=javascript>
	function changePage(pageNum){
			//1 将页码的值放入对应表单隐藏域中
				$("#currentPageInput").val(pageNum);
			//2 提交表单
				$("#queryForm").submit();
	};
	
	function changePageSize(pageSize){
			//1 将页码的值放入对应表单隐藏域中
			$("#pageSizeInput").val(pageSize);
		//2 提交表单
			$("#queryForm").submit();
	};
 	$(document).ready(function(){
		addSelectInfo($('#conditionId option:selected').val(),'${param.condition}');
		loadSelect("001","baseDiv","tea_gender","性别",'<s:property value="%{tea_gender}"/>');
		loadSelect("002","baseDiv","tea_dep","所属院系",${param.tea_dep});
		loadSelect("006","baseDiv","tea_nation","民族",${param.tea_nation});
		loadSelect("007","baseDiv","tea_political","政治面貌",${param.tea_political});
		loadSelect("003","baseDiv","tea_jobTitel","职称",${param.tea_jobTitel});
		loadSelect("005","baseDiv","tea_eduBG","学历",${param.tea_eduBG});
		loadSelect("004","baseDiv","tea_degree","学位",${param.tea_degree});
		$("#baseDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar2' name='tea_workTime' placeholder='点击选择教师入职年月区间' title='点击选择教师入职年月区间' class='tea_workTime'>"));
	});
	function addSelectInfo(selectInfo,selectedId) {
	/*alert("selectedId:   "+selectedId);
	alert("selectInfo:   "+selectInfo);*/
	$("#selectDiv").empty();
	$("#"+selectedId).attr("selected","selected");
	if(selectInfo=='a'||'a'==selectedId){
	/*  基础信息*/
		loadSelect("001","selectDiv","tea_gender","性别",${param.tea_gender});
		loadSelect("002","selectDiv","tea_dep","所属院系",${param.tea_dep});
		loadSelect("006","selectDiv","tea_nation","民族",${param.tea_nation});
		loadSelect("007","selectDiv","tea_political","政治面貌",${param.tea_political});
		loadSelect("003","selectDiv","tea_jobTitel","职称",${param.tea_jobTitel});
		loadSelect("005","selectDiv","tea_eduBG","学历",${param.tea_eduBG});
		loadSelect("004","selectDiv","tea_degree","学位",${param.tea_degree});
	}
	if(selectInfo=='b'||'b'==selectedId){
	/*  论文信息*/
		loadSelect("008","selectDiv","the_level","论文层次",${param.the_level});
		loadTextInfo("selectDiv","the_author","${param.the_author}","论文作者","请输入论文作者","the_author");
		loadTextInfo("selectDiv","the_title","${param.the_title}","论文题目","请输入论文题目","the_title");
		loadTextInfo("selectDiv","the_periodical","${param.the_periodical}","刊物名称","请输入刊物名称","the_periodical");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='论文发布时间区间' title='点击选择论文发布时间区间' class='otherTime'>"));
	}
	if(selectInfo=='c'||'c'==selectedId){
	/*  专利信息*/
		loadSelect("009","selectDiv","pat_type","专利类型",${param.pat_type});
		loadTextInfo("selectDiv","pat_registerNum","${param.pat_registerNum}","专利登记号","请输入专利登记号","pat_registerNum");
		loadTextInfo("selectDiv","pat_name","${param.pat_name}","专利名称","请输入专利名称","pat_name");
		loadTextInfo("selectDiv","pat_author","${param.pat_author}","专利作者","请输入专利作者","pat_author");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择专利获取时间区间' title='点击选择专利获取时间区间' class='otherTime'>"));
	}
	if(selectInfo=='d'||'d'==selectedId){
	/*  奖励信息*/
		loadSelect("010","selectDiv","rew_level","奖励级别",${param.rew_level});
		/* loadSelect("008","selectDiv","rew_levelDetail","获奖等级",0); */
		loadSelect("014","selectDiv","rew_family","奖励类别",${param.rew_family});
		loadSelect("015","selectDiv","rew_ascription","奖励所属",${param.rew_ascription});
		loadTextInfo("selectDiv","rew_name","${param.rew_name}","奖励名称","请输入奖励名称","rew_name");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择奖励获得时间区间' title='点击选择奖励获得时间区间' class='otherTime'>"));
	}
	if(selectInfo=='e'||'e'==selectedId){
	/*  教材著作*/
		/* loadSelect("008","selectDiv","cm_location","出版地",0); */
		loadTextInfo("selectDiv","cm_editor","${param.cm_editor}","著作编写者","请输入著作作者","cm_editor");
		loadTextInfo("selectDiv","cm_name","${param.cm_name}","著作书名","请输入书名","cm_name");
		loadTextInfo("selectDiv","cm_publisher","${param.cm_publisher}","出版社","请输入出版社名称","cm_publisher");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择著作出版时间区间' title='点击选择著作出版时间区间' class='otherTime'>"));
	}
	if(selectInfo=='f'||'f'==selectedId){
	/*  教学评估*/
		loadSelect("011","selectDiv","tea_eva_grade","评估成绩",${param.tea_eva_grade});
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择教学评估学年区间' title='点击选择教学评估学年区间' class='otherTime'>"));
		
	}
	if(selectInfo=='g'||'g'==selectedId){
	/*  纵向科研*/
		loadSelect("016","selectDiv","ver_nature","研究性质",${param.ver_nature});
		loadSelect("010","selectDiv","ver_projectLevel","立项级别",${param.ver_projectLevel});
		loadSelect("010","selectDiv","ver_identLevel","鉴定级别",${param.ver_identLevel});
		loadTextInfo("selectDiv","ver_no","${param.ver_no}","科研编号","请输入科研编号","ver_no");
		loadTextInfo("selectDiv","ver_manager","${param.ver_manager}","项目负责人","请输入项目负责人姓名","ver_manager");
		loadTextInfo("selectDiv","ver_personnel","${param.ver_personnel}","项目参加人员","请输入参加人员姓名","ver_personnel");
		loadTextInfo("selectDiv","ver_courseName","${param.ver_courseName}","项目名称","请输入课题名称","ver_courseName");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择研究立项时间' title='点击选择立项时间区间' class='otherTime'>"));
		
	}
	if(selectInfo=='h'||'h'==selectedId){
	/*  横向科研*/
		loadTextInfo("selectDiv","hor_no","${param.hor_no}","研究编号","请输入研究编号","hor_no");
		loadTextInfo("selectDiv","hor_manager","${param.hor_manager}","项目人员","请输入项目负责人姓名或参加人员姓名","hor_manager");
		loadTextInfo("selectDiv","hor_courseName","${param.hor_courseName}","课题名称","请输入课题名称","hor_courseName");
		loadTextInfo("selectDiv","hor_cilentName","${param.hor_cilentName}","客户名称","请输入客户名称","hor_cilentName");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择立项时间' title='点击选择立项时间区间' class='otherTime'>"));
	}
	if(selectInfo=='i'||'i'==selectedId){
	/*  指导学生*/
		loadSelect("015","selectDiv","ins_stu_type","队伍类型",${param.ins_stu_type});
		loadSelect("019","selectDiv","ins_stu_reward","是否获奖",${param.ins_stu_reward});
		loadSelect("010","selectDiv","ins_stu_rewardLevel","学生获奖级别",${param.ins_stu_rewardLevel});
		loadTextInfo("selectDiv","ins_stu_proName","${param.ins_stu_proName}","项目名称","请输入项目名称","ins_stu_proName");
		loadTextInfo("selectDiv","ins_stu_teancher","${param.ins_stu_teancher}","指导教师姓名","请输入指导教师姓名","ins_stu_teancher");
		loadTextInfo("selectDiv","ins_stu_stuNum","${param.ins_stu_stuNum}","学生学号","请输入学生学号","ins_stu_stuNum");
		loadTextInfo("selectDiv","ins_stu_stuName","${param.ins_stu_stuName}","学生姓名","请输入学生姓名","ins_stu_stuName");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择指导学生项目开始时间' title='点击选择指导学生项目开始时间区间' class='otherTime'>"));
	}
	if(selectInfo=='j'||'j'==selectedId){
	/*  挂职实践*/
		loadTextInfo("selectDiv","pra_company","${param.pra_company}","实践单位","请输入实践单位名称","pra_company");
		loadTextInfo("selectDiv","pra_post","${param.pra_post}","实践职务","请输入实践职务","pra_post");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择实践开始时间' title='点击选择实践开始时间区间' class='otherTime'>"));
	}
	if(selectInfo=='k'||'k'==selectedId){
	/*  培训学习*/
		loadSelect("012","selectDiv","tra_result","培训成果",${param.tra_result});
		loadTextInfo("selectDiv","tra_theme","${param.tra_theme}","学习主题","请输入培训学习主题","tra_theme");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择学习开始时间' title='点击选择学习开始时间区间' class='otherTime'>"));
	}
	if(selectInfo=='l'||'l'==selectedId){
	/*  年终考核*/
	$("#theamInfo").append($("<h1>年终考核</h1>"));
		loadSelect("013","selectDiv","ann_rev_grade","考核结果",${param.ann_rev_grade});
		$("#selectDiv").append($("<input style='width: 105px;height: 28px' type='text' id='calendar' name='otherTime' placeholder='点击选择考核年' title='当年内任意一天即可' class='otherTime'>"));
	}
	if(selectInfo=='m'||'m'==selectedId){
	/*  当辅导员情况*/
		loadTextInfo("selectDiv","ins_classes","${param.ins_classes}","辅导班级","请输入辅导班级号","ins_classes");
		$("#selectDiv").append($("<input style='width: 200px;height: 28px' type='text' id='calendar3' name='otherTime' placeholder='点击选择开始辅导时间' title='点击选择辅导班级开始时间区间' class='otherTime'>"));
	}
}

	
</SCRIPT>
</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<!-- <input type="text" value="000" title="123" class="zebra_tips1"> -->
	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="left.jsp" />

			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							Information<small>General info</small>
						</h1>

						<form
							action="${pageContext.request.contextPath }/QueryConditionAction_list"
							method="post" id="queryForm">
								<%--<input type="text" id="calendar2" name="time1" value="<s:property value="time1" />"
								style="width: 200px;height: 28px"> 
								<input type="text" id="calendar" name="time2" value="<s:property value="time2" />"
								style="width: 105px;height: 28px" > --%>
							<!-- 隐藏域.当前页码 -->
							<input type="hidden" name="currentPage" id="currentPageInput"
								value="<s:property value="#pageBean.currentPage" />" />
							<!-- 隐藏域.每页显示条数 -->
							<input type="hidden" name="pageSize" id="pageSizeInput"
								value="<s:property value="#pageBean.pageSize" />" /><br>
							<!-- 姓名：<input type="text" name="tea_name"/>
							性别：<input type="text" name="tea_gender"/> -->
			<TABLE cellSpacing=0 cellPadding=2 border=0>
				<tr>
					<select name="condition" id="conditionId" style="width:110px"
						onchange="addSelectInfo($('#conditionId option:selected').val(),'${param.tea_name}')">
						<option value="0">请选择查询类别</option>
						<!-- <option value="a" id="a">教师个人信息</option> -->
						<option value="b" id="b">论文</option>
						<option value="c" id="c">专利</option>
						<option value="d" id="d">奖励</option>
						<option value="e" id="e">教材著作</option>
						<option value="f" id="f">教学评估</option>
						<option value="g" id="g">纵向科研</option>
						<option value="h" id="h">横向科研</option>
						<option value="i" id="i">指导学生</option>
						<option value="j" id="j">挂职实践</option>
						<option value="k" id="k">培训学习</option>
						<option value="l" id="l">年终考核</option>
						<option value="m" id="m">当辅导员情况</option>
					</select>
				</tr>
				<tr>
					<Th>基础信息：</Th>
				</tr>
				<tr id="baseDiv">
				<%-- <input type="text" id="calendar2" name="time1" value="<s:property value="time1" />"
				style="width: 200px;height: 28px" placeholder="教师入职年月区间"> --%>
				</tr>

			</TABLE>
			<TABLE cellSpacing=0 cellPadding=2 border=0>
				<tr>
					<Th colspan="5" style="width: 87px; ">可选信息：</Th>
				</tr>
				<tr id="selectDiv"></tr>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=2 border=0>
				<TR>
					<TD><input style="width: 105px;height: 28px" type="text"
						value="${param.tea_id}" placeholder="教师编号" name="tea_id">
					</TD>
					<TD><input style="width: 105px;height: 28px" type="text"
						class="text" value="${param.tea_name}" placeholder="教师姓名"
						name="tea_name"></TD>
					<TD><input style="width: 60px;height: 60px" type="submit"
						value="筛选" /></TD>
					<TD><INPUT style="width: 60px;height: 60px" class=button
						type="reset" title="为方便回显提高查询效率，请您手动清除之前添加的查询项" value="重置" ></TD>
				</TR>

			</TABLE>
		</form>

		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<s:if test="#pageBean==null && condition==null">
					<tr>
						<h2>请选择查询条件点击查询</h2>
					</tr>
				</s:if>
				<s:elseif test="#pageBean!=null && condition==0">
					<tr>
						<!-- <th>基础数据</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>系别</th>
						<th>邮箱</th>
						<th>电话</th>
						<th>QQ</th>
						<th>角色</th>
						<th>Status</th>
						<th>操作</th>
					</tr>
				</s:elseif>
				
				<s:elseif test='#pageBean!=null && condition=="b"'>
					<tr>
						<th>职工编号</th>
						<th>姓名</th>
						<th>论文题目</th>
						<th>刊物名称</th>
						<th>出版时间</th>
						<th>作者</th>
						<th>论文层次</th>
						<th>操作</th>
					</tr>
				</s:elseif>
				
				<s:elseif test='#pageBean!=null && condition=="c"'>
					<tr>
						<!-- <th>专利</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>专利登记号</th>
						<th>题名</th>
						<th>作者</th>
						<th>专利类型</th>
						<th>获取时间</th>
						<th>操作</th>
					</tr>
				</s:elseif>
				
				<s:elseif test='#pageBean!=null && condition=="d"'>
					<tr>
						<!-- <th>奖励</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>奖励名称</th>
						<th>奖励级别</th>
						<th>奖励部门</th>
						<th>所属</th>
						<th>奖励时间</th>
					</tr>
				</s:elseif>
				
				<s:elseif test='#pageBean!=null && condition=="e"'>
					<tr>
						<!-- <th>教材著作</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>书名</th>
						<th>出版社</th>
						<th>版次</th>
						<th>主编</th>
						<th>副主编</th>
						<th>出版时间</th>
					</tr>
				</s:elseif>
				<s:elseif test='#pageBean!=null && condition=="f"'>
					<tr>
						<th>职工编号</th>
						<th>姓名</th>
						<th>学年</th>
						<th>成绩</th>
					</tr>
				</s:elseif>
				<s:elseif test='#pageBean!=null && condition=="g"'>
					<tr>
						<!-- <th>纵向研究</th> -->
						<!-- <th>课题编号</th> -->
						<!-- <th>姓名</th> -->
						<!-- <th>性质</th> -->
						<th>职工编号</th>
						<th>课题名称</th>
						<th>项目负责人</th>
						<th>立项级别</th>
						<th>立项时间</th>
						<th>鉴定级别</th>
						<th>查看</th>
					</tr>
				</s:elseif>
				<s:elseif test='#pageBean!=null && condition=="h"'>
					<tr>
						<!-- <th>横向科研</th> -->
						<th>职工编号</th>
						<th>课题编号</th>
						<th>项目负责人</th>
						<th>课题名称</th>
						<th>客户</th>
						<th>立项时间</th>
						<th>结题时间</th>
						<th>操作</th>
					</tr>
				</s:elseif>
				<s:elseif test='#pageBean!=null && condition=="i"'>
					<tr>
						<!-- <th>指导学生</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>项目名称</th>
						<th>第一指导教师</th>
						<th>第二指导教师</th>
						<th>学生</th>
						<th>开始时间</th>
						<th>是否获奖</th>
						<th>操作</th>
					</tr>
				</s:elseif>
				<s:elseif test='#pageBean!=null && condition=="j"'>
					<tr>
						<!-- <th>挂职实践</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>实践单位</th>
						<th>实践职位</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>操作</th>
					</tr>
				</s:elseif>
				<s:elseif test='#pageBean!=null && condition=="k"'>
					<tr>
						<!-- <th>培训学习</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>主题</th>
						<th>培训地点</th>
						<th>开始时间</th>
						<th>培训成果</th>
						<th>操作</th>
					</tr>
				</s:elseif>
				
				<s:elseif test='#pageBean!=null && condition=="l"'>
					<tr>
						<!-- <th>年终考核</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>年份</th>
						<th>考核结果</th>
						<th>操作</th>
					</tr>
				</s:elseif>
				
				<s:elseif test='#pageBean!=null && condition=="m"'>
					<tr>
						<!-- <th>辅导员情况</th> -->
						<th>职工编号</th>
						<th>姓名</th>
						<th>辅导班级</th>
						<th>起始时间</th>
						<th>结束时间</th>
						<th>操作</th>
					</tr>
				</s:elseif>
			</thead>
			<tbody>
				<!-- 测试 -->
				<%-- <s:debug></s:debug> --%>


				<s:if test="#pageBean!=null && condition==0">
					<s:iterator value="#pageBean.list" var="tea">
						<tr class="list-users">
							<TD><s:property value="#tea.tea_id" /></TD>
							<TD><s:property value="#tea.tea_name" /></TD>
							<TD><s:property value="#tea.tea_dep.dict_item_name" /></TD>
							<TD><s:property value="#tea.tea_email" /></TD>
							<TD><s:property value="#tea.tea_phone" /></TD>
							<TD><s:property value="#tea.tea_qq" /></TD>
							<TD><s:property value="#tea.tea_role.dict_item_name" /></TD>
							<td><span class="label label-success"><s:property
										value="#tea.tea_enable.dict_item_name" /></span></td>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<!-- <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
							<li><a href="#"><i class="icon-trash"></i> Delete</a></li> -->
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
										<%--<li class="nav-header">Permissions</li>
							 <li><a href="#"><i class="icon-lock"></i> Make <strong>Admin</strong></a>
							</li>
							<li><a href="#"><i class="icon-lock"></i> Make <strong>Moderator</strong></a>
							</li>
							<li><a href="#"><i class="icon-lock"></i> Make <strong>User</strong></a> 
							</li>--%>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="b"'>
					<s:iterator value="#pageBean.list" var="thesis">
						<tr class="list-users">
							<TD><s:property value="#thesis.tea_id.tea_id" /></TD>
							<TD><s:property value="#thesis.tea_id.tea_name" /></TD>
							<TD><s:property value="#thesis.the_title" /></TD>
							<TD><s:property value="#thesis.the_periodical" /></TD>
							<TD><s:property value="#thesis.the_pubTime" /></TD>
							<TD><s:property value="#thesis.the_firstAuthor" /></TD>
							<TD><s:property value="#thesis.the_level.dict_item_name" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				
				<s:if test='#pageBean!=null && condition=="c"'>
					<s:iterator value="#pageBean.list" var="patent">
						<tr class="list-users">
							<TD><s:property value="#patent.tea_id.tea_id" /></TD>
							<TD><s:property value="#patent.tea_id.tea_name" /></TD>
							<TD><s:property value="#patent.pat_registerNum" /></TD>
							<TD><s:property value="#patent.pat_name" /></TD>
							<TD><s:property value="#patent.pat_author" /></TD>
							<TD><s:property value="#patent.pat_type.dict_item_name" /></TD>
							<TD><s:property value="#patent.pat_pubTime" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				
				<s:if test='#pageBean!=null && condition=="d"'>
					<s:iterator value="#pageBean.list" var="reward">
						<tr class="list-users">
							<TD><s:property value="#reward.tea_id.tea_id" /></TD>
							<TD><s:property value="#reward.tea_id.tea_name" /></TD>
							<TD><s:property value="#reward.rew_name" /></TD>
							<TD><s:property value="#reward.rew_level.dict_item_name" /></TD>
							<TD><s:property value="#reward.rew_department" /></TD>
							<TD><s:property value="#reward.rew_ascription.dict_item_name" /></TD>
							<TD><s:property value="#reward.rew_time" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				
				<s:if test='#pageBean!=null && condition=="e"'>
					<s:iterator value="#pageBean.list" var="book">
						<tr class="list-users">
							<TD><s:property value="#book.tea_id.tea_id" /></TD>
							<TD><s:property value="#book.tea_id.tea_name" /></TD>
							<TD><s:property value="#book.cm_name" /></TD>
							<TD><s:property value="#book.cm_publisher" /></TD>
							<TD><s:property value="#book.cm_edition" /></TD>
							<TD><s:property value="#book.cm_chiefEditor" /></TD>
							<TD><s:property value="#book.cm_subeditor" /></TD>
							<TD><s:property value="#book.cm_pubTime" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="f"'>
					<s:iterator value="#pageBean.list" var="tea_evaluation">
						<tr class="list-users">
							<TD><s:property value="#tea_evaluation.tea_id.tea_id" /></TD>
							<TD><s:property value="#tea_evaluation.tea_id.tea_name" /></TD>
							<TD><s:property value="#tea_evaluation.tea_eva_year" /></TD>
							<TD><s:property value="#tea_evaluation.tea_eva_grade.dict_item_name" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="g"'>
					<s:iterator value="#pageBean.list" var="vertical">
						<tr class="list-users">
							<TD><s:property value="#vertical.tea_id.tea_id" /></TD>
							<TD><s:property value="#vertical.ver_courseName" /></TD>
							<TD><s:property value="#vertical.ver_manager" /></TD>
							<TD><s:property value="#vertical.ver_projectLevel.dict_item_name" /></TD>
							<TD><s:property value="#vertical.ver_projectTime" /></TD>
							<TD><s:property value="#vertical.ver_identLevel.dict_item_name" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="h"'>
					<s:iterator value="#pageBean.list" var="horizontal">
						<tr class="list-users">
							<TD><s:property value="#horizontal.tea_id.tea_id" /></TD>
							<TD><s:property value="#horizontal.hor_no" /></TD>
							<TD><s:property value="#horizontal.hor_manager" /></TD>
							<TD><s:property value="#horizontal.hor_courseName" /></TD>
							<TD><s:property value="#horizontal.hor_cilentName" /></TD>
							<TD><s:property value="#horizontal.hor_projectTime" /></TD>
							<TD><s:property value="#horizontal.hor_endTime" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="i"'>
					<s:iterator value="#pageBean.list" var="Instructed">
						<tr class="list-users">
							<TD><s:property value="#Instructed.tea_id.tea_id" /></TD>
							<TD><s:property value="#Instructed.tea_id.tea_name" /></TD>
							<TD><s:property value="#Instructed.ins_stu_proName" /></TD>
							<TD><s:property value="#Instructed.ins_stu_teancherOne" /></TD>
							<TD><s:property value="#Instructed.ins_stu_teacherTwo" /></TD>
							<TD><s:property value="#Instructed.ins_stu_name" /></TD>
							<TD><s:property value="#Instructed.ins_stu_startTime" /></TD>
							<TD><s:property value="#Instructed.ins_stu_reward.dict_item_name" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="j"'>
					<s:iterator value="#pageBean.list" var="practice">
						<tr class="list-users">
							<TD><s:property value="#practice.tea_id.tea_id" /></TD>
							<TD><s:property value="#practice.tea_id.tea_name" /></TD>
							<TD><s:property value="#practice.pra_company" /></TD>
							<TD><s:property value="#practice.pra_post" /></TD>
							<TD><s:property value="#practice.pra_startTime" /></TD>
							<TD><s:property value="#practice.pra_endTime" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="k"'>
					<s:iterator value="#pageBean.list" var="train">
						<tr class="list-users">
							<TD><s:property value="#train.tea_id.tea_id" /></TD>
							<TD><s:property value="#train.tea_id.tea_name" /></TD>
							<TD><s:property value="#train.tra_theme" /></TD>
							<TD><s:property value="#train.tra_address" /></TD>
							<TD><s:property value="#train.tra_startTime" /></TD>
							<TD><s:property value="#train.tra_result.dict_item_name" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="l"'>
					<s:iterator value="#pageBean.list" var="Annual">
						<tr class="list-users">
							<TD><s:property value="#Annual.tea_id.tea_id" /></TD>
							<TD><s:property value="#Annual.tea_id.tea_name" /></TD>
							<TD><s:property value="#Annual.ann_rev_year" /></TD>
							<TD><s:property value="#Annual.ann_rev_grade.dict_item_name" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:if test='#pageBean!=null && condition=="m"'>
					<s:iterator value="#pageBean.list" var="Instructor">
						<tr class="list-users">
							<TD><s:property value="#Instructor.tea_id.tea_id" /></TD>
							<TD><s:property value="#Instructor.tea_id.tea_name" /></TD>
							<TD><s:property value="#Instructor.ins_classes" /></TD>
							<TD><s:property value="#Instructor.ins_startTime" /></TD>
							<TD><s:property value="#Instructor.ins_endTime" /></TD>
							<td><div class="btn-group">
									<a class="btn btn-mini dropdown-toggle"
										data-toggle="dropdown" href="#">Actions <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath }/admin/AllInfo.jsp"><i
												class="icon-user"></i> Details</a></li>
									</ul>
								</div></td>
						</tr>
					</s:iterator>
				</s:if>

	
				<s:elseif test="#pageBean==null && condition!=null">
					<tr>
						<h1>没有结果</h1>
					</tr>
				</s:elseif>
			</tbody>
		</table>



						<div class="pagination">
							<font size="4"> 共[<B><s:property
										value="#pageBean.totalCount" /> </B>]条记录,[<B><s:property
										value="#pageBean.totalPage" /></B>]页 ,每页显示 <select
								name="pageSize"
								onchange="changePageSize($('#pageSizeSelect option:selected').val())"
								id="pageSizeSelect" style="width:50px">
									<option value="3"
										<s:property value="#pageBean.pageSize==3?'selected':''" />>3</option>
									<option value="5"
										<s:property value="#pageBean.pageSize==5?'selected':''" />>5</option>
									<option value="10"
										<s:property value="#pageBean.pageSize==10?'selected':''" />>10</option>
							</select> 条 ，当前第[<b><s:property value="#pageBean.currentPage" /></b>]页
								<ul>
									<li><a href="javaScript:void(0)"
										onclick="changePage(<s:property value='#pageBean.currentPage-1' />)">前一页</a></li>
									<!-- <li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li> -->
									<li><a href="javaScript:void(0)"
										onclick="changePage(<s:property value='#pageBean.currentPage+1' />)">后一页</a>
										</li>
								</ul> 到 <input style="WIDTH: 80px" type="text" size="3" id="page"
								name="page" value="<s:property value="#pageBean.currentPage"/>" />
								页 <input type="button" value="Go"
								onclick="changePage($('#page').val())" />

							</font>

							<div>
								<a href="" class="btn btn-success">Excel</a>
							</div>


						</div>
					</div>
					<hr />
					<jsp:include page="foot.jsp" />
				</div>
			</div>
			<h1>测试</h1>
			<s:if test="condition==null">
				<h2>hahahhahhah</h2>
			</s:if>
			<br />
			<s:elseif test="condition==0">
				<h2>教师基础信息</h2>
			</s:elseif>
			<br />
			<h1>
				haha:
				<s:property value="%{#request.pageBean.list}" />
			</h1>
			<br>
			<h1>
				haha:<input type="text"
					value="<s:property value='%{#request.pageBean.list}'/>">
			</h1>
			<br>
			<s:property />
			<br>
			<h2>
				参数(获取的是属性的值):
				<s:property value="currentPage" />
			</h2>
			<h2>
				参数(tea_workTime值):
				<s:property value="tea_workTime" />
			</h2>
			<h2>
				参数(getOtherTime值):
				<s:property value="otherTime" />
			</h2>
		</div>
		<script type="text/javascript" src="<%=path%>/js/jquery.toc.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery-asDatepicker.js"></script>
		<script type="text/javascript" src="<%=path%>/js/language.js"></script>
		<script>
			$(document).ready(function() {
				$('.dropdown-menu li a').hover(
					function() {
						$(this).children('i').addClass('icon-white');
					},
					function() {
						$(this).children('i').removeClass('icon-white');
					});

				if($(window).width() > 760) {
					$('tr.list-users td div ul').addClass('pull-right');
				}
		(function(){
			$('#toc').toc();
			})();
    	$("#calendar").asDatepicker({
            namespace: 'calendar',
            lang: 'zh',
            position: 'right'
        });
    
		$("#calendar2").asDatepicker({mode: 'range',
		lang: 'zh',
		position: 'right'
		}); 
		$("#calendar3").asDatepicker({mode: 'range',
		lang: 'zh',
		position: 'right'
		}); 
		$("#calendar3").val('<s:property value="%{otherTime}"/>');
		$("#calendar2").val('<s:property value="%{tea_workTime}"/>');
		$("#calendar").val('<s:property value="%{otherTime}"/>');
		new $.Zebra_Tooltips($('.tea_workTime'));
		new $.Zebra_Tooltips($('.otherTime'));
		new $.Zebra_Tooltips($('.button'));
		});
		</script>
		<script type="text/javascript" src="<%=path%>/js/zebra_tooltips.js"></script>
</body>
</html>
