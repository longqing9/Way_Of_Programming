<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>班级基本信息</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 班级基本信息
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<div style="text-align: center;"><h2>${class1.classname }班级基本信息</h2></div>

<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>班级编号</td>
				<td>班级名称</td>
				<td>班级总人数</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
		
			<tr class="TableDetail1">
				<td align="center">${class1.classid }</td>
				<td align="center"> ${class1.classname }</td>
				<td align="center">${class1.classcount }</td>
				
				
			</tr>
        </tbody>
    </table>
</div>
</body>
</html>
