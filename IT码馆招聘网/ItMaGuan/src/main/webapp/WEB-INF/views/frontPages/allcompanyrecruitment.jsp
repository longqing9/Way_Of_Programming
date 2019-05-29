<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title>查看招聘信息</title>
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
		<style>
		   .box{
			　　　　width:300px;
			　　　　height:25px;
			　　　　overflow:hidden;
			　　}
			.wz{
			　　　　float:left;
			　　　　height:25px;
			　　　　margin-right:25px;
			　　}
			.dot{
			　　　　float:right;
			　　　　width:25px;
			　　　　height:25px;
			　　　　margin-top:-25px;
			　　}
		</style>
	</head>
	<!--
    	作者：offline
    	时间：2019-02-28
    	描述：
    	该页面用于展示本公司发布的所有招聘信息
    -->
	<body>
		<div id="look">
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
				<a href="${pageContext.request.contextPath }/AddRecruitmentInformation">发布招聘</a>
				<a href="${pageContext.request.contextPath }/Com_firmHomepage.action">首页</a>
			</div>
			
		<c:forEach items="${job.list }" var="TbCjob">
			<div id="eg3" style="height: auto;"> 
				<h2>${TbCjob.job }</h2>
				<div id="tit1">
					<div id="fr">
						<a id="btnC3 box1T3" href="${pageContext.request.contextPath }/ShowComcompanyinformation?companyid=${TbCjob.companyid}">${TbCjob.comname }</a><br />
					</div>
					<div id="fr1">
						<a href="${pageContext.request.contextPath }/Deletecompanyrecryitment?id=${TbCjob.id}" >删除该招聘信息</a>
					</div>
					<br /><br />
					<div id="fr1">
						<a href="${pageContext.request.contextPath }/Changerecruitment?id=${TbCjob.id}" >修改该招聘信息</a>
					</div>
				</div>

				<table class="TB1">
					<tr>
						<th>发布日期：</th>
						<td> ${TbCjob.ptime }</td>
					</tr>
					<tr>
						<th>工作地点：</th>
						<td>${TbCjob.place }</td>
					</tr>
					<tr>
						<th>职位职能：</th>
						<td >
						 <div style="height: 50px;overflow:hidden ">
						<p class="comment_inner">${TbCjob.other }</p>
						</div> 
						<h3 style="color: black;margin: 0;">......</h3>
						 </td>
					</tr>
				</table>
			</div>
			<a href="${pageContext.request.contextPath }/Showdetailedresume?id=${TbCjob.id}" class="box1More shadow">查看详情</a>
		</c:forEach>	
			
		<form id="searchForm" action="${pageContext.request.contextPath }/Allcompanyrecruitment" method="POST">
			<input id="pageNo" name="pageNo" type="hidden" value="${job.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${job.pageSize}"/>
		</form>	
		<div class="pagination">${job}</div>

			<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
		</div>
	</body>

</html>
