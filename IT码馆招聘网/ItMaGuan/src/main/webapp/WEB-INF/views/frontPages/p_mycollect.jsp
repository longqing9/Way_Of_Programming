<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
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
		function dc(id){
			alert(id);
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath }/Deletecollect",
				data:{id:id},
				dataType:"text",
				success:function(data){
					alert(data);
				}
			});			
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
		<c:forEach items="${findPageT.list }" var="TbCjob">
			< <div id="eg1" style="height: auto"> 
				<h2>${TbCjob.job }</h2>
				<div id="tit1">
					<div id="fr">
						<a id="btnC3 box1T3" href="${pageContext.request.contextPath }/ShowStudcompanyinformation?companyid=${TbCjob.companyid}">${TbCjob.comname }</a><br />
					</div>
					<div id="fr1">
						<a href="javascript:void(0);" ><input type="button" value="取消收藏" onclick="dc('${TbCjob.id}')"> </a>
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
		<form id="searchForm" action="${pageContext.request.contextPath }/ShowOthercompanyInformation" method="POST">
			<input id="pageNo" name="pageNo" type="hidden" value="${findPageT.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${findPageT.pageSize}"/>
		</form>	
		<div class="pagination">${findPageT}</div>


			<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
		</div>
</div>
	</body>

</html>