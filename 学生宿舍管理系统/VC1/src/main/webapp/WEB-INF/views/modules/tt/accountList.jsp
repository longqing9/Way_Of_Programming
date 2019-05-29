<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>账号表管理</title>
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
		<li class="active"><a href="${ctx}/tt/account/">账号表列表</a></li>
		<shiro:hasPermission name="tt:account:edit"><li><a href="${ctx}/tt/account/form">账号表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="account" action="${ctx}/tt/account/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>账号：</label>
				<form:input path="account" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>是否为管理员：</label>
				<form:input path="guan" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>宿舍号：</label>
				<form:input path="durmnumber" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>家乡：</label>
				<form:input path="hometown" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>账号</th>
				<th>是否为管理员</th>
				<th>姓名</th>
				<th>宿舍号</th>
				<th>家乡</th>
				<th>个性签名</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="tt:account:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="account">
			<tr>
				<td><a href="${ctx}/tt/account/form?id=${account.id}">
					${account.account}
				</a></td>
				<td>
					${account.guan}
				</td>
				<td>
					${account.name}
				</td>
				<td>
					${account.durmnumber}
				</td>
				<td>
					${account.hometown}
				</td>
				<td>
					${account.signature}
				</td>
				<td>
					<fmt:formatDate value="${account.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${account.remarks}
				</td>
				<shiro:hasPermission name="tt:account:edit"><td>
    				<a href="${ctx}/tt/account/form?id=${account.id}">修改</a>
					<a href="${ctx}/tt/account/delete?id=${account.id}" onclick="return confirmx('确认要删除该账号表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>