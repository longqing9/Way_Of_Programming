<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>成绩查询</title>
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
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 成绩列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
<%-- 	<form action="${pageContext.request.contextPath}/SelectShowScore.action" method="post">
		<input type="hidden" name="method" value="search">
		<input type="text" name="tm" title="请输入题目">
		<input type="submit" value="搜索">
	</form> --%>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>序列号</td>
				<td>科目</td>
				<td>任务标题</td>
				<td>得分</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
		<c:forEach items="${list }" var="list" varStatus="index">
			<tr class="TableDetail1">
					<td align="center">${index.count }&nbsp;</td>
					<td align="center"> ${list.subname }&nbsp;</td>
					<td align="center">${list.optop }</td>
					<td align="center">${list.rescore }</td>
				</tr>
		</c:forEach>
			
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<!-- 可能会使用到分页 -->
	<div id="TableTail" align="center">
		<div class="paginate">
			<c:if test="${page.countpage!=1 }">
				<div class="FunctionButton"><a href="${pageContext.request.contextPath}/showscore.action?pc=1">&nbsp;首页&nbsp;</a></div>
			</c:if>
			<c:if test="${page.currentpage>1 }">
				<div class="FunctionButton"><a href="${pageContext.request.contextPath}/showscore.action?pc=${page.currentpage-1}">&nbsp;上一页&nbsp;</a></div>
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
						<div class="FunctionButton"><a href="${pageContext.request.contextPath}/showscore.action?pc=${i}">&nbsp;[${i }]&nbsp;</a></div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${page.currentpage < page.countpage }">
				<div class="FunctionButton"><a href="${pageContext.request.contextPath}/showscore.action?pc=${page.currentpage+1}">&nbsp;下一页&nbsp;</a></div>
			</c:if>
			<c:if test="${page.countpage!=1 }">
				<div class="FunctionButton"><a href="${pageContext.request.contextPath}/showscore.action?pc=${page.countpage}">&nbsp;末页&nbsp;</a></div>
			</c:if>
			第${page.currentpage }/${page.countpage }页
			<div class="clear"></div>
			
		</div>	
    </div> 
</div>
</body>
</html>
