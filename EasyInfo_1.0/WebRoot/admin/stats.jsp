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

<title>教师数据分类统计</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="<%=path%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=path%>/css/site.css" rel="stylesheet">
<link href="<%=path%>/css/bootstrap-responsive.css" rel="stylesheet">
<link href="<%=path%>/css/bootstrap-datepicker3.css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/stat.js"></script>

</head>

<body>

	<jsp:include page="head.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="left.jsp" />

			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>分类统计</h1>

						<FORM id="pageForm" name="statForm"
							<%-- action="${pageContext.request.contextPath }/StatAction" --%>
							method=post>
							<TABLE cellSpacing=0 cellPadding=2 border=0>
								<TBODY>
									<tr>
										统计类别：
										<select name="condition" id="conditionId" style="width:150px"
											onchange="addSelectInfo($('#conditionId option:selected').val())">
											<option value="0">请选择统计类别</option>
											<option value="a">教师个人信息</option>
											<option value="b">论文</option>
											<option value="c">专利</option>
											<option value="d">奖励</option>
											<option value="e">教材著作</option>
											<option value="f">教学评估</option>
											<option value="g">纵向科研</option>
											<option value="h">横向科研</option>
											<option value="i">指导学生</option>
											<option value="j">挂职实践</option>
											<option value="k">培训学习</option>
											<option value="l">年终考核</option>
											<option value="m">当辅导员情况</option>
										</select>
									</tr>
									<br>
									<script type="text/javascript"
										src="<%=path%>/js/bootstrap-datepicker.min.js"></script>
									<script type="text/javascript"
										src="<%=path%>/js/bootstrap-datepicker.zh-CN.js"></script>
									<tr>
										请选择时间段：
										<input type="text" id="beginTime" name="beginTime">至
										<input type="text" id="endTime" name="endTime">
										<script>
											function DatePicker(beginSelector,
													endSelector) {
												// 仅选择日期
												$(beginSelector)
														.datepicker(
																{
																	language : "zh-CN",
																	autoclose : true,
																	startView : 0,
																	format : "yyyy-mm-dd",
																	clearBtn : true,
																	todayBtn : false,
																	endDate : new Date()
																})
														.on(
																'changeDate',
																function(ev) {
																	if (ev.date) {
																		$(
																				endSelector)
																				.datepicker(
																						'setStartDate',
																						new Date(
																								ev.date
																										.valueOf()));
																	} else {
																		$(
																				endSelector)
																				.datepicker(
																						'setStartDate',
																						null);
																	}
																});

												$(endSelector)
														.datepicker(
																{
																	language : "zh-CN",
																	autoclose : true,
																	startView : 0,
																	format : "yyyy-mm-dd",
																	clearBtn : true,
																	todayBtn : false,
																	endDate : new Date()
																})
														.on(
																'changeDate',
																function(ev) {
																	if (ev.date) {
																		$(
																				beginSelector)
																				.datepicker(
																						'setEndDate',
																						new Date(
																								ev.date
																										.valueOf()));
																	} else {
																		$(
																				beginSelector)
																				.datepicker(
																						'setEndDate',
																						new Date());
																	}
																});
											}
											DatePicker("#beginTime",
													"#endTime");
										</script>
									</tr>
									</div>
									<tr>

										<div id="selectDiv"></div>
										<TD><INPUT class=button id=Button type=submit
											value=" 进行统计 " name=Button></TD>
									</tr>
								</TBODY>
							</TABLE>
						</FORM>
					</div>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
						</thead>
						<tbody>
							<th>该时间段符合统计条件的记录数量为:</th>
							<th><a href="#">查看记录详细信息</a></th>
						</tbody>
					</table>



				</div>
			</div>
			<hr />
			<jsp:include page="foot.jsp" />
		</div>

		<script>
			$(document).ready(function() {
				$('.dropdown-menu li a').hover(function() {
					$(this).children('i').addClass('icon-white');
				}, function() {
					$(this).children('i').removeClass('icon-white');
				});

				if ($(window).width() > 760) {
					$('tr.list-users td div ul').addClass('pull-right');
				}
			});
		</script>
</body>
</html>
