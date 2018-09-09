<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AllInof.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=path %>/js/jquery.js"></script>
	<script src="<%=path %>/js/bootstrap.min.js"></script>


  </head>
  
<body>
    <div class="container" id="box">
        <form role="form">
            <div class="form-group">
                <label for="Pub_tem_name">模板名称:</label>
                <input type="text" name="Pub_tem_name" class="form-control" placeholder="请输入模板名称" style="width: 170px">
            </div>
			<div class="form-group">
                <label for="Pub_tem_url">上传模板:</label>
                <input type="file" name="Pub_tem_url" class="form-control" style="width: 170px;hight: 50px">
            </div>
            <div class="form-group">
                <label for="Pub_tem_describe">模板描述:</label>
                <input type="text" name="Pub_tem_describe" class="form-control" placeholder="请输入模板描述" style="hight: 70px">
            </div>
            <div class="form-group">
                <input type="button" value="添加" class="btn btn-primary" v-on:click="add()">
                <input type="reset" value="重置" class="btn btn-danger">
            </div>
        </form>
        <hr>
        <table class="table table-bordered table-hover">
            <caption class="h3 text-info">公共模板管理</caption>
            <tr class="text-danger">
                <th class="text-center">序号</th>
                <th class="text-center">模板名称</th>
                <th class="text-center">模板简介</th>
				<th class="text-center">查看模板</th>
                <th class="text-center">操作</th>
            </tr>
            <!--<tr class="text-center" v-for="item in myData">
                <td>{{$index+1}}</td>
                <td>{{item.name}}</td>
                <td>{{item.age}}</td>
				<td>{{item.age}}</td>
                <td>
                    <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#layer" v-on:click="nowIndex=$index">删除</button>
                </td>
            </tr>-->
			 <tr>
                <th>A001</th>
                <th>教师详细信息模板</th>
                <th>详细的教师信息</th>
				<th><a href="">teacher.excel</a></th>
                <td>
                    <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#layer" v-on:click="nowIndex=$index">删除</button>
                </td>
            </tr>
            <tr >
                <td colspan="5" class="text-right">
                    <button class="btn btn-danger btn-sm" v-on:click="nowIndex=-2" data-toggle="modal" data-target="#layer" >删除全部</button>
                </td>
            </tr>
            <tr >
                <td colspan="5" class="text-center text-muted">
                    <p>暂无数据....</p>
                </td>
            </tr>
        </table>

        <!--模态框 弹出框-->
        <div role="dialog" class="modal fade bs-example-modal-sm" id="layer">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span>&times;</span>
                        </button>
                        <h4 class="modal-title">确认删除么?</h4>
                    </div>
                    <div class="modal-body text-right">
                        <button data-dismiss="modal" class="btn btn-primary btn-sm">取消</button>
                        <button data-dismiss="modal" class="btn btn-danger btn-sm" v-on:click="deleteMsg(nowIndex)">确认</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body></html>
