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
<SCRIPT language=javascript>
	function initPassword() {
		//将密码重置为初始密码
		var initpassword = "000000";
        document.getElementById("user_password").value=initpassword;
	};
</SCRIPT>


</head>

<body onload="addUserSelectInfo(<s:property value="#user.user_state.dict_id" />,
<s:property value="#user.tea_role.dict_id" />)">
	<jsp:include page="head.jsp" />

	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="left.jsp" />

			<div class="span9">
				<div class="row-fluid">
					<div class="page-header">
						<h1>
							用户管理 <small>修改用户</small>
						</h1>
					</div>
					<form class="form-horizontal" id="userForm" name="userForm"
						action="${pageContext.request.contextPath }/UserAction_update"
						method=post>
						<fieldset>
							<div class="control-group">
								<label class="control-label" for="tea_id">职工ID</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="tea_id" name="tea_id"
										value="<s:property value="#user.tea_id" />" 
										readonly="readonly" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="user_password">密码</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="user_password" name="user_password"
										value="<s:property value="#user.user_password" />"
										readonly="readonly"/> <input type="button"
										class="btn  btn-large" value="重置密码" onclick="initPassword();"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="state">状态</label>
								<div class="controls">
								<div id="stateDiv"></div>
								<!--  <select id="state" name="state">
										<option
											value="<s:property value="#user.user_state.dict_item_name" />" selected>
											<s:property value="#user.user_state.dict_item_name" />
										</option>
									</select> -->	
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="teacher.tea_role.dict_item_name">角色</label>
								<div class="controls">
								<div id="roleDiv"></div>
								<!--	<select id="teacher.tea_role.dict_item_name" name="teacher.tea_role.dict_item_name">
										<option
											value="<s:property value="#user.tea_role.dict_item_name" />" selected>
											<s:property value="#user.tea_role.dict_item_name" />
										</option>
									</select> -->	
								</div>
							</div>

							<div class="form-actions">
								<input type="submit" class="btn btn-success btn-large"
									value="保存" /> <a class="btn"
									href="${pageContext.request.contextPath }/UserAction_list">Cancel</a>
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
