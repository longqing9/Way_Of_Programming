<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看所有申请人</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
		<script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.8.3.min.js"></script>
		<link rel="stylesheet" href="${ctxStatic}/bootstrap/2.3.1/css_cerulean/bootstrap.min.css" />
		<script type="text/javascript">
		function page(n,s){
		 	$("#pageNo").val(n);
			$("#pageSize").val(s); 
			$("#searchForm").submit();
        	return false;
        }
		</script>
	</head>
	<body>
		<div id="cksqr">
		
		<div id="header">
				<!--头部导航栏-->
				<p>&nbsp;&nbsp;
					<font face="微软雅黑" size="6">|</font>&nbsp;&nbsp;
					<font face="微软雅黑" size="6">企业版</font>
				</p>
				<ul>
					<li>
						<p>
							<font face="微软雅黑" size="3">客户服务热线：</font>&nbsp;
							<font face="微软雅黑" size="3">400-855-9626</font>
						</p>
					</li>
				</ul>
			</div>
			
			<hr color="#BBBBBB" style="height: 5px;" width="100%">
			<br />
			
			<div id="gll">
				<a href="${pageContext.request.contextPath }/com_logout">退出</a>
				<a href="#">帮助</a>
				<a href="#" onclick="javascript:history.back(-1)">返回上一页</a>
				<a href="${pageContext.request.contextPath }/Show_companyinformation">公司基本信息</a>
			</div>
			<c:forEach items="${shpwList }" var="shpwList">
			<div id="eg2" style="height: auto;"> 
				<h2>${shpwList.tbStudent.name }</h2>
				<table class="TB">
					<tr>
						<th>&nbsp;&nbsp;申请职位：&nbsp;&nbsp;</th>
						<td>
							${shpwList.tbSobz.job }
						</td>
						<th>&nbsp;&nbsp;毕业院校：&nbsp;&nbsp;</th>
						<td>
						${shpwList.tbSobz.schName }
						</td>
				</tr>
					<tr>
							<th>&nbsp;&nbsp;性别：&nbsp;&nbsp;</th>
						<td>
							${shpwList.tbStudent.sex }
						</td>
						<th>&nbsp;&nbsp;期望工作地点：&nbsp;&nbsp;</th>
						<td>
							${shpwList.tbSobz.workaddress }
						</td>
					</tr>
					<tr>
						<th>&nbsp;&nbsp;电话：&nbsp;&nbsp;</th>
						<td>
							${shpwList.tbStudent.tell }
						</td>
						<th>&nbsp;&nbsp;邮箱Email：&nbsp;&nbsp;</th>
						<td>
							${shpwList.tbStudent.email }
						</td>
					</tr>
				</table>
			</div>
			<a href="${pageContext.request.contextPath }/ComShowstuinformation?studid=${shpwList.tbStudent.id }&&sobzid=${shpwList.tbSobz.id }" class="box1More shadow">查看详情</a>
		</c:forEach>
			<%-- <c:forEach items="${shpwList }" var="shpwList">
				${shpwList.tbSobz.studentid }<br>
				${shpwList.tbSobz.companyid }<br>
				${shpwList.tbStudent.studentid }<br>
				${shpwList.tbStudent.name }<br>
			</c:forEach> --%>
			
			<form id="searchForm" action="${pageContext.request.contextPath }/ShowOthercompanyInformation" method="POST">
			<input id="pageNo" name="pageNo" type="hidden" value="${job.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${job.pageSize}"/>
			</form>	
			<div class="pagination">${findPage}</div>
			
			
			
			<div id="footer">
				Copyright © 2006-2012 IT马倌 | 营业执照 | 苏ICP证B2-20070191
			</div>
	</div>
	</body>
</html>
