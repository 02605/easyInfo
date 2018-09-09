<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<%=path %>/css/bootstrap.css" rel="stylesheet">
	<link href="<%=path %>/css/site.css" rel="stylesheet">
    <link href="<%=path %>/css/bootstrap-responsive.css" rel="stylesheet">
     <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<!--[if lte IE 8]><script src="js/excanvas.min.js"></script><![endif]-->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<style type="text/css">
    html, body {
        height: 100%;
    }
    </style>
  </head>
  
<body>
  <jsp:include page="head.jsp" ></jsp:include>

   
    <div class="container-fluid">
			<div class="row-fluid">
				 <jsp:include page="left.jsp"/>
        <div class="span9">
		  <div class="row-fluid">
			<div class="page-header">
				<h1>网站统计 <small></small></h1>
			</div>
			<div id="placeholder" style="width:80%;height:300px;"></div>
			<br />
			<div id="visits" style="width:80%;height:300px;"></div>
		  </div>
        </div>
	</div>
      <hr>

      <jsp:include page="foot.jsp"></jsp:include>

    </div>

    <script src="<%=path %>/js/jquery.js"></script>
	<script src="<%=path %>/js/jquery.flot.js"></script>
	<script src="<%=path %>/js/jquery.flot.resize.js"></script>	
	<script src="<%=path %>/js/bootstrap.min.js"></script>
	<script>
	$(function () {
		var data = [
		{
			label: 'Page Views',
			data: [[0, 19000], [1, 15500], [2, 11100], [3, 15500]]
		}];
		var dataVisits = [
		{
			label: 'Visits',
			data: [[0, 1980], [1, 1198], [2, 830], [3, 1550]]
		}];
		var options = {
			legend: {
				show: true,
				margin: 10,
				backgroundOpacity: 0.5
			},
			points: {
				show: true,
				radius: 3
			},
			lines: {
				show: true
			},
			grid: {
				borderWidth:1,
				hoverable: true
			},
			xaxis: {
				axisLabel: 'Month',
				ticks: [[0, 'Jan'], [1, 'Feb'], [2, 'Mar'], [3, 'Apr'], [4, 'May'], [5, 'Jun'], [6, 'Jul'], [7, 'Aug'], [8, 'Sep'], [9, 'Oct'], [10, 'Nov'], [11, 'Dec']],
				tickDecimals: 0
			},
			yaxis: {
				tickSize:1000,
				tickDecimals: 0
			}
		};
		var optionsVisits = {
			legend: {
				show: true,
				margin: 10,
				backgroundOpacity: 0.5
			},
			bars: {
				show: true,
				barWidth: 0.5,
				align: 'center'
			},
			grid: {
				borderWidth:1,
				hoverable: true
			},
			xaxis: {
				axisLabel: 'Month',
				ticks: [[0, 'Jan'], [1, 'Feb'], [2, 'Mar'], [3, 'Apr'], [4, 'May'], [5, 'Jun'], [6, 'Jul'], [7, 'Aug'], [8, 'Sep'], [9, 'Oct'], [10, 'Nov'], [11, 'Dec']],
				tickDecimals: 0
			},
			yaxis: {
				tickSize:1000,
				tickDecimals: 0
			}
		};
		function showTooltip(x, y, contents) {
			$('<div id="tooltip">' + contents + '</div>').css( {
				position: 'absolute',
				display: 'none',
				top: y + 5,
				left: x + 5,
				border: '1px solid #D6E9C6',
				padding: '2px',
				'background-color': '#DFF0D8',
				opacity: 0.80
			}).appendTo("body").fadeIn(200);
		}
		var previousPoint = null;
		$("#placeholder, #visits").bind("plothover", function (event, pos, item) {
			if (item) {
				if (previousPoint != item.dataIndex) {
					previousPoint = item.dataIndex;

					$("#tooltip").remove();
					showTooltip(item.pageX, item.pageY, item.series.label + ": " + item.datapoint[1]);
				}
			}
			else {
				$("#tooltip").remove();
				previousPoint = null;            
			}
		});
		$.plot( $("#placeholder") , data, options );
		$.plot( $("#visits") , dataVisits, optionsVisits );
	});
	</script>
  </body>
</html>
