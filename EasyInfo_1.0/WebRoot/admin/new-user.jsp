<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
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

<title>My JSP 'new-user.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=path%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=path%>/css/site.css" rel="stylesheet">
<link href="<%=path%>/css/bootstrap-responsive.css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/js/users.js"></script>

</head>

<body onload="addSelectInfo()">
	<jsp:include page="head.jsp" />

	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="left.jsp" />

			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							New User <small>用户注册</small>
						</h1>
					</div>
					<form class="form-horizontal" id="registerForm" name="registerForm"
						action="${pageContext.request.contextPath }/UserAction_save"
						method=post>
						<fieldset>
							<div class="control-group">
								<label class="control-label" for="tea_id">职工ID</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="tea_id"
										name="tea_id" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="teacher.tea_name">姓名</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="teacher.tea_name" name="teacher.tea_name" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="teacher.tea_gender.dict_id">性别</label>
								<div class="controls">
									<div id="genderDiv"></div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="teacher.tea_dep.dict_id">所在院系</label>
								<div class="controls">
									<div id="deptDiv"></div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="teacher.tea_role.dict_item_name">角色</label>
								<div class="controls">
									<select id="teacher.tea_role.dict_item_name"" name="teacher.tea_role.dict_item_name">
								<option value="管理员">管理员</option>
								<option value="普通用户" selected>普通用户</option>
							</select>
								</div>
							</div>
							<!-- 自动赋值初始密码和状态 -->
							<input type="hidden" name="user_password" value="000000" />
							 <input type="hidden" name="state" value="使用" />
							<!-- 	<div class="control-group">
					  	<label class="control-label" for="active">Active?</label> 
						<div class="controls">
							<input type="checkbox" id="active" value="1" />
						</div> 
					</div>   -->
							<div class="form-actions">
								<input type="submit" class="btn btn-success btn-large"
									value="保存" /> <a class="btn" href="${pageContext.request.contextPath }/UserAction_list">取消</a>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="foot.jsp" />
	</div>
	<script src="<%=path%>/js/jquery.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
</body>
</html>
