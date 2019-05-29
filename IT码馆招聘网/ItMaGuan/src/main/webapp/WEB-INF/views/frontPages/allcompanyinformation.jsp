<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>公司基本信息</title>
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
		<div id="jb">
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
				<a href="${pageContext.request.contextPath }/com_logout" >退出</a>
				<a href="#">帮助</a>
				<a href="#" onclick="javascript:history.back(-1);">返回上一页</a>
			</div>
		
		
		<div class="right">
        <div class="rSearch shadow"> 
        	<form id="searchForm" action="${pageContext.request.contextPath }/ShowOthercompanyInformation" method="POST">
 			公司名称<input name="name" type="text"  onclick="this.value=''" class="rSearchInput" />
            <br />
   			所属行业<input name="manage" type="text"  onclick="this.value=''" class="rSearchInput" />
            <br />
     		所在地区<input name="address" type="text"  onclick="this.value=''" class="rSearchInput" />
            <br />
            <input id="pageNo" name="pageNo" type="hidden" value="${job.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${job.pageSize}"/>
			
            <input class="inputBtn searchBtn" type="submit" value="提交"/>
        	</form>

        </div>
     </div>
		<!--
        	作者：offline
        	时间：2018-11-16
        	描述：第一个公司
        -->
        <c:forEach items="${company.list }" var="Tbcompany">
        	<div id="eg0" style="height: 180px"> 
				<h2>${Tbcompany.name }</h2>
				<table class="TB">
					<tr>
						<th>&nbsp;&nbsp;公司名称：&nbsp;&nbsp;</th>
						<td>
							${Tbcompany.name }
						</td>
						<th>&nbsp;&nbsp;所属行业：&nbsp;&nbsp;</th>
						<td>
						${Tbcompany.manage }
						</td>
				</tr>
					<tr>
							<th>&nbsp;&nbsp;公司性质：&nbsp;&nbsp;</th>
						<td>
							${Tbcompany.property }
						</td>
						<th>&nbsp;&nbsp;公司规模：&nbsp;&nbsp;</th>
						<td>
							${Tbcompany.scale }
						</td>
					</tr>
					<tr>
						<th>&nbsp;&nbsp;咨询电话：&nbsp;&nbsp;</th>
						<td>
							${Tbcompany.tel }
						</td>
						<th>&nbsp;&nbsp;公司Email：&nbsp;&nbsp;</th>
						<td>
							${Tbcompany.email }
						</td>
					</tr>
				</table>
				
			</div>
		
		<a href="${pageContext.request.contextPath }/Showdetailcompanyinformation?id=${Tbcompany.id}" class="box1More shadow">查看详情</a>
	</c:forEach>
	
	
		<%-- <form id="searchForm" action="${pageContext.request.contextPath }/ShowOthercompanyInformation" method="POST">
			<input id="pageNo" name="pageNo" type="hidden" value="${job.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${job.pageSize}"/>
		</form>	 --%>
		<div class="pagination">${company}</div>
		
	
			<div id="footer">
				Copyright © 2006-2012 IT马倌 | 营业执照 | 苏ICP证B2-20070191
			</div>
		</div>
	</body>
</html>
