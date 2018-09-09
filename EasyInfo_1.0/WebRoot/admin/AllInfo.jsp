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
	<script src="<%=path %>/js/jquery.js"></script>
	<script src="<%=path %>/js/LiftEffect.js"></script>
	<style>
		*{
			margin: 0;
			padding: 0;
		}
		body{
			height: 6000px;
		}
		.lift-nav-l{
			position: fixed;
			top: 100px;
			left: 30px;
			
		}
		.lift-nav li{
			width: 100px;
			height: 30px;
			text-align: center;
			line-height: 30px;
			color: #fff;
			padding: 10px 10px;
			margin-bottom: 10px;
			background: skyblue;
			cursor: pointer;
		}
		.lift-nav li.current{
			background: tomato;
		}

		.right-nav-r{
			position: fixed;
			top: 100px;
			right: 30px;
			
		}

		.t1,.t2,.t3,.t4,.t5,.t6,.t7,.t8,.t9,.t10,.t11,.t12,.t13{
			width: 800px;
			height: 400px;
			text-align: center;
			line-height: 400px;
			background: skyblue;
			margin: 100px auto;
			font-size: 20px;
			color: #fff;
		}
		.t1{
			margin-top: 200px;
		}
		.t2{
			background: pink;
		}
		.t3{
			background: tomato;
		}
		.t4{
			background: grey;
		}
		.t5{
			background: yellow;
		}
		.t6{
			background: seagreen;
		}
		.t7{
			background: blue;
		}
		.t8{
			background: orange;
		}
		.t9{
			background: orange;
		}
		.t10{
			background: orange;
		}
		.t11{
			background: orange;
		}
		.t12{
			background: orange;
		}
		.t13{
			background: orange;
		}
		
	</style>
  </head>
  
<body>
<h1 align="center">您的详细信息</h1>
<div class="lift-nav">
	<div class="lift-nav-l">
		<ul class="lift">
			<li>教师个人信息</li>
			<li>论文</li>
			<li>专利</li>
			<li>奖励</li>
			<li>教材著作</li>
			<li>教学评估</li>
		</ul>
	</div>
	<div class="right-nav-r">
		<ul class="right">
			<li>纵向科研</li>
			<li>横向科研</li>
			<li>指导学生</li>
			<li>挂职实践</li>
			<li>培训学习</li>
			<li>年终考核</li>
			<li>当辅导员情况</li>
		</ul>
	</div>
</div>

<div class="lift-target">
	<div class="t1">
		
	教师个人信息
	
	</div>
	<div class="t2">论文</div>
	<div class="t3">专利</div>
	<div class="t4">奖励</div>
	<div class="t5">教材著作</div>
	<div class="t6">教学评估</div>
	<div class="t7">纵向科研</div>
	<div class="t8">横向科研</div>
	<div class="t9">指导学生</div>
	<div class="t10">挂职实践</div>
	<div class="t11">培训学习</div>
	<div class="t12">年终考核</div>
	<div class="t13">当辅导员情况</div>
</div>


<script>

	$(function(){
		LiftEffect({
			"control1": ".lift-nav", 						  //侧栏电梯的容器
			"control2": ".lift",                           //需要遍历的电梯的父元素
			"target": [".t1",".t2",".t3",".t4",".t5",".t6"], //监听的内容，注意一定要从小到大输入
			"current": "current" 						  //选中的样式
		});
		LiftEffect({
			"control1": ".lift-nav", 						  //侧栏电梯的容器
			"control2": ".right",                           //需要遍历的电梯的父元素
			"target": [".t7",".t8",".t9",".t10",".t11",".t12",".t13"], //监听的内容，注意一定要从小到大输入
			"current": "current" 						  //选中的样式
		});
		
	})
</script>
</body>
</html>
