<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>浏览招聘信息</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
		<script src="${ctxStatic}/jquery/jquery-1.9.1.js" ></script>
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
		    .comment_inner{
		    width: 600px;
		    word-break: break-all;
		    display: -webkit-box; 
		    -webkit-box-orient: vertical; 
		    -webkit-line-clamp: 3;
		    white-space:nowrap; overflow:hidden; text-overflow:ellipsis; 
		    }   
		</style>
	</head>
	<body>
		<div id="look">
			
			<div id="main">
				
				 <div class="right">
        <div class="rSearch shadow">
         <form id="searchForm" action="${pageContext.request.contextPath }/ShowYkrecruit" method="POST">
				<input id="pageNo" name="pageNo" type="hidden" value="${findPage.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${findPage.pageSize}"/>
	      		  职位<input name="job" type="text"  class="rSearchInput" />
	            <br />
	           	 企业  <input name="comname" type="text"  class="rSearchInput" />
	            <br />
	           	 地区  <input name="place" type="text"  class="rSearchInput" />
	            <br />
	            <br />
	            <input type="submit" value="搜索" class="inputBtn searchBtn">
          </form>
        </div>
    </div>
    	<c:forEach items="${cjob.list }" var="TbCjob">
			<div id="eg0" style="height: auto;"> 
			<input type="hidden" class="cic" value="${TbCjob.id}">
			<input type="hidden" class="com" value="${TbCjob.companyid}">
				<h2>${TbCjob.job }</h2>
				<div id="tit1">
					<div id="fr">
						<a id="btnC3 box1T3" href="${pageContext.request.contextPath }/ShowStudcompanyinformation?companyid=${TbCjob.companyid}" >${TbCjob.comname }</a><br /><br>
					</div>
				</div>
				<table class="TB1">
					<tr>
						<th>发布日期：</th>
						<td>${TbCjob.ptime }</td>
					</tr>
					<tr>
						<th>工作地点：</th>
						<td>${TbCjob.place }</td>
					</tr>
					<tr>
						<th>职位职能：</th>
						<td>
						<div style="height: 50px;overflow:hidden ">
						<p class="comment_inner">${TbCjob.other }</p>
						</div> 
						<h3 style="color: black;margin: 0;">......</h3>
						</td>
					</tr>
				</table>
			</div>
			<a href="${pageContext.request.contextPath }/Showstudrecruit?id=${TbCjob.id}" class="box1More shadow">查看详情</a>
		</c:forEach>
			<div class="pagination">${cjob}</div>


			<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
		</div>
</div>
</body>
</html>
