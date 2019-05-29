<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改公司信息</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
		<script src="${ctxStatic}/frontLayout/js/jquery-1.7.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${ctxStatic}/frontLayout/js/verification.js"></script>
	</head>
	<body>
		<div id="xggsxx">
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
				<a href="${pageContext.request.contextPath }/Show_companyinformation">查看信息</a>
				<a href="${pageContext.request.contextPath }/Com_firmHomepage.action">首页</a>
			</div>
			<!--修改信息-->
			<div id="xxck1">
				<h2>修改公司信息:</h2>
				<form action="${pageContext.request.contextPath }/Save_companyinformation" method="post"  onsubmit="return ComInformation()" >
				<table>
					<tr>
						<th>公司名称：</th>
						<td>
							<input id="xx0" name="name" value="${company.name }" type="text" />
						</td>
					</tr>
					<tr>
						<th>所属行业：&nbsp;&nbsp;</th>
						<td>
						<input id="xx1" name="manage" value="${company.manage }" type="text" />
						</td>
					</tr>
					<tr>
							<th>公司性质：</th>
						<td>
							<input id="xx2" name="property" value="${company.property }" type="text"  />
						</td>
					</tr>
					<tr>
						<th>公司规模：</th>
						<td>
							<input id="xx3" name="scale" value="${company.scale }" type="text"  />
						</td>
					</tr>
					<tr>
						<th>咨询电话：</th>
						<td>
							<input id="xx4" name="tel" value="${company.tel }" type="text"  />
						</td>
					</tr>
					<tr>
						<th>公司Email：</th>
						<td>
							<input id="xx5" name="email" type="text" value="${company.email }" />
						</td>
					</tr>
					<tr>
						<th>公司地址：</th>
						<td>
							<input id="xx6" name="address" value="${company.address }" type="text" />
						</td>
					</tr>
					<tr>
						<th>企业介绍：</th>
						<td>
							<textarea id="xx7" name = "resume" cols = "80" rows = "12"  wrap = "physical">${company.resume }</textarea>
						</td>
					</tr>
					<tr>&nbsp;</tr>
				<tr>
					<th>&nbsp;</th>
					<td >
						<input type="submit" class="gsdltp" style="color: #000000;" value="提交修改"/>
					</td>
				</tr>
				</table>
		</form>
			</div>
			
			<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>

	</body>
</html>
