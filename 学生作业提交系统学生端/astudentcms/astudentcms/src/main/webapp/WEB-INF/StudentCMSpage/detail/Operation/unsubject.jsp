<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
<title>科目信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/index_1.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/common.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath }/style/images/title_arrow.gif" /> 科目信息
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<%-- <form action="${pageContext.request.contextPath}/findUnsubjectTeacherbysubname.action" method="post">
			<input type="text" name="subname" title="请输入科目名称">
			<input type="submit" value="搜索">
		</form> --%>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>序列号</td>
					<td>科目名称</td>
					<td>任课教师</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData" align="center" >
				<c:forEach items="${list }" var="list" varStatus="index">
					<tr class="TableDetail1">
						<td>${index.count }</td>
						<td>${list.subname }</td>
						<td>${list.tname }</td>
						<td>
							<a href="${pageContext.request.contextPath}/unoperation.action?subid=${list.subid }&&url=${pageContext.request.contextPath}/unoperation.action?subid=${list.subid }"  class="FunctionButton">进入查看</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="TableTail" align="center">
		<div class="paginate">
			<c:if test="${page.countpage!=1 }">
				<div class="FunctionButton"><a href="${pageContext.request.contextPath}/unsubject.action?pc=1">&nbsp;首页&nbsp;</a></div>
			</c:if>
			<c:if test="${page.currentpage>1 }">
				<div class="FunctionButton"><a href="${pageContext.request.contextPath}/unsubject.action?pc=${page.currentpage-1}">&nbsp;上一页&nbsp;</a></div>
			</c:if>
			<c:choose>
				<c:when test="${page.countpage<=3 }">
					<c:set var="begin" value="1" />
					<c:set var="end" value="${page.countpage }" />
				</c:when>
				<c:otherwise>
					<c:set var="begin" value="${page.currentpage-1 }" />
					<c:set var="end" value="${page.currentpage+1 }" />
					<c:if test="${begin<1 }">
						<c:set var="begin" value="1" />
						<c:set var="end" value="3" />
					</c:if>
					<c:if test="${end>page.countpage }">
						<c:set var="begin" value="${page.countpage-2 }" />
						<c:set var="end" value="${page.countpage }" />
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${begin }" end="${end }">
				<c:choose>
					<c:when test="${i eq page.currentpage }">
						<div class="FunctionButton">${i }</div>
					</c:when>
					<c:otherwise>
						<div class="FunctionButton"><a href="${pageContext.request.contextPath}/unsubject.action?pc=${i}">&nbsp;[${i }]&nbsp;</a></div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${page.currentpage < page.countpage }">
				<div class="FunctionButton"><a href="${pageContext.request.contextPath}/unsubject.action?pc=${page.currentpage+1}">&nbsp;下一页&nbsp;</a></div>
			</c:if>
			<c:if test="${page.countpage!=1 }">
				<div class="FunctionButton"><a href="${pageContext.request.contextPath}/unsubject.action?pc=${page.countpage}">&nbsp;末页&nbsp;</a></div>
			</c:if>
			第${page.currentpage }/${page.countpage }页
			<div class="clear"></div>
		</div>	
    </div> 
	</div>
</body>
</html>
    