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
<link href="<%=path%>/css/bootstrap-responsive.css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<SCRIPT language=javascript>
	function changePage(pageNum){
			//1 将页码的值放入对应表单隐藏域中
				$("#currentPageInput").val(pageNum);
			//2 提交表单
				$("#pageForm").submit();
	};
	
	function changePageSize(pageSize){
			//1 将页码的值放入对应表单隐藏域中
			$("#pageSizeInput").val(pageSize);
		//2 提交表单
			$("#pageForm").submit();
	};
</SCRIPT>
</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="left.jsp" />

			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							用户管理 <small>所有用户</small>
						</h1>
						<FORM id="pageForm" name="userForm"
							action="${pageContext.request.contextPath }/UserAction_list"
							method=post>
							<!-- 隐藏域.当前页码 -->
							<input type="hidden" name="currentPage" id="currentPageInput"
								value="<s:property value="#pageBean.currentPage" />" />
							<!-- 隐藏域.每页显示条数 -->
							<input type="hidden" name="pageSize" id="pageSizeInput"
								value="<s:property value="#pageBean.pageSize" />" />
							<TABLE cellSpacing=0 cellPadding=2 border=0>
								<TBODY>
									<TR>
										<TD>账户ID：</TD>
										<TD><INPUT class=textbox style="WIDTH: 80px" maxLength=50
											name="tea_id" ></TD>

										<TD><INPUT class=button id=sButton2 type=submit
											value=" 搜索 " name=sButton2></TD>
									</TR>
								</TBODY>
							</TABLE>
						</FORM>
					</div>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>ID</th>
								<th>密码</th>
					  		  	<th>角色</th>  
								<th>Status</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#pageBean.list" var="user">
								<tr class="list-users">

									<TD><s:property value="#user.tea_id" /></TD>
									<TD><s:property value="#user.user_password" /></TD>
								 	<TD><s:property value="#user.tea_role.dict_item_name" /></TD>  
									<td><span class="label label-success"><s:property value="#user.user_state.dict_item_name" /></span></td>
									<td>
										<div class="btn-group">
											<a class="btn btn-mini dropdown-toggle"
												data-toggle="dropdown" href="#">操作 <span
												class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="${pageContext.request.contextPath }/UserAction_toUpdate?tea_id=<s:property value="#user.tea_id" />"><i class="icon-pencil"></i> 修改账户</a></li>
												<li><a href="${pageContext.request.contextPath }/UserAction_resetpwd?tea_id=<s:property value="#user.tea_id" />"><i class="icon-pencil"></i> 重置密码</a></li>
												<li><a href="${pageContext.request.contextPath }/UserAction_blockUser?tea_id=<s:property value="#user.tea_id" />"><i class="icon-pencil"></i> 冻结账户</a></li>
												<li><a href="${pageContext.request.contextPath }/UserAction_delete?tea_id=<s:property value="#user.tea_id" />"><i class="icon-pencil"></i> 删除账户</a></li>
										<!--  		<li class="nav-header">权限</li>
												<li><a href="#"><i class="icon-lock"></i> Make <strong>管理员</strong></a>
												</li>
												<li><a href="#"><i class="icon-lock"></i> Make <strong>普通用户</strong></a>
												</li> 
										-->
											</ul>
										</div>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="pagination">
						<font size="4"> 共[<B><s:property
									value="#pageBean.totalCount" /> </B>]条记录,[<B><s:property
									value="#pageBean.totalPage" /></B>]页 ,每页显示 <select name="pageSize"
							onchange="changePageSize($('#pageSizeSelect option:selected').val())"
							id="pageSizeSelect" style="width:50px">
							<option value="3"
									<s:property value="#pageBean.pageSize==3?'selected':''" />>3</option>
								<option value="10"
									<s:property value="#pageBean.pageSize==10?'selected':''" />>10</option>
						</select> 条 ，当前第[<b><s:property value="#pageBean.currentPage" /></b>]页
							<ul>
								<li><a href="javaScript:void(0)"
									onclick="changePage(<s:property value='#pageBean.currentPage-1' />)">前一页</a></li>
								<li><a href="javaScript:void(0)"
									onclick="changePage(<s:property value='#pageBean.currentPage+1' />)">后一页</a></li>
							</ul> 到 <input style="WIDTH: 80px" type="text" size="3" id="page"
							name="page" value="<s:property value="#pageBean.currentPage"/>" />
							页 <input type="button" value="Go"
							onclick="changePage($('#page').val())" /> 
							
						
						
						</font>
					</div>
					<a href="<%=path%>/admin/new-user.jsp" class="btn btn-success">新建用户</a>
				</div>
			</div>
		</div>
		<hr />
		<jsp:include page="foot.jsp" />
	</div>
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
			});
		</script>
</body>
</html>
