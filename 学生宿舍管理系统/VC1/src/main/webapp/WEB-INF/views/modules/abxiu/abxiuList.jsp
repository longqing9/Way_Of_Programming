<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>报修订单管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/abxiu/abxiu/">报修订单列表</a></li>
		<shiro:hasPermission name="abxiu:abxiu:edit"><li><a href="${ctx}/abxiu/abxiu/form">报修订单添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="abxiu" action="${ctx}/abxiu/abxiu/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>applyid：</label>
				<form:input path="applyid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>acceptid：</label>
				<form:input path="acceptid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>numb：</label>
				<form:input path="numb" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="abxiu:abxiu:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="abxiu">
			<tr>
				<td><a href="${ctx}/abxiu/abxiu/form?id=${abxiu.id}">
					<fmt:formatDate value="${abxiu.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${abxiu.remarks}
				</td>
				<shiro:hasPermission name="abxiu:abxiu:edit"><td>
    				<a href="${ctx}/abxiu/abxiu/form?id=${abxiu.id}">修改</a>
					<a href="${ctx}/abxiu/abxiu/delete?id=${abxiu.id}" onclick="return confirmx('确认要删除该报修订单吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>