<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title>修改个人信息</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/reviseInformation.css" />
		<script src="${ctxStatic}/frontLayout/js/jquery-1.7.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${ctxStatic}/frontLayout/js/verification.js"></script>
	</head>

	<body>
		<div id="main">
			<!-- 一条记录 开始 -->
			<form action="${pageContext.request.contextPath }/SaveStuinformation" method="post"  onsubmit="return StuInformation()">
			<table class="myInfo" align="center">
				<tr>
					<th>姓名：</th>
					<td>
						<input id="xx0" type="text" name="name" value="${stud.name }" />
					</td>
				</tr>
				<tr>
					<th>性别：</th>
					<td> 
						<input type="radio" name="Sex"  value="男"  <c:if test="${stud.sex=='男' }">checked="checked"</c:if> />男
						<input type="radio" name="Sex" value="女"  <c:if test="${stud.sex=='女' }">checked="checked"</c:if> />女
					</td>

				</tr>
				<tr>
					<th>年龄：</th>
					<td>
						<input id="xx1" type="text" name="age" value="${stud.age }" />
					</td>
				</tr>
				<tr>
					<th>出生日期：</th>
					<td>
						<input id="xx2" type="text" name="birthday" value='<fmt:formatDate value="${stud.birthday }" pattern="yyyy-MM-dd HH:mm:ss" />' onclick="this.type='date'"  />
					</td>
				</tr>
				<tr>
					<th>参加工作时间：</th>
					<td>
						<input id="xx3" type="text" name="worktime" value='<fmt:formatDate value="${stud.worktime }" pattern="yyyy-MM-dd HH:mm:ss" />' onclick="this.type='date'" />
					</td>
				</tr>
				<tr>
					<th>户籍：</th>
					<td>
						<input id="xx4" type="text" name="huji" value="${stud.huji }" />
					</td>
				</tr>
				<tr>
					<th>现居地：</th>
					<td>
						<input id="xx5" type="text" name="nowadress" value="${stud.nowadress }" />
					</td>
				</tr>
				<tr>
					<th>学历：</th>
					<td>
						<select name="knowledge" id="select">
							<option value="高中" <c:if test="${stud.knowledge=='高中' }">selected="selected"</c:if>>高中</option>
							<option value="专科" <c:if test="${stud.knowledge=='专科' }">selected="selected"</c:if>>专科</option>
							<option value="本科" <c:if test="${stud.knowledge=='本科' }">selected="selected"</c:if>>本科</option>
							<option value="研究生" <c:if test="${stud.knowledge=='研究生' }">selected="selected"</c:if>>研究生</option>
							<option value="博士" <c:if test="${stud.knowledge=='博士' }">selected="selected"</c:if>>博士</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>联系方式：</th>
					<td>
						<input id="xx6" type="text" name="tell" value="${stud.tell }" />
					</td>
				</tr>
				<tr>
					<th>电子邮箱：</th>
					<td>
						<input id="xx7" type="text" name="email" value="${stud.email }" />
						<!-- 
						<select name="select2" id="select2">
							<option selected="selected">@163.com</option>
							<option>@qq.com</option>
						</select> -->
					</td>
				</tr>
			</table>
			<div id="d2" align="center">
			<input type="submit" value="保存并更新" class="indexLoginTBinput4" style="color: deeppink;font-size: 18px;" />
			<input type="reset" value="取消" style="color: deeppink;font-size: 18px;" >
			</div>
			
		</form>
		</div>
		<div id="f1">Copyright 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
	</body>

</html>