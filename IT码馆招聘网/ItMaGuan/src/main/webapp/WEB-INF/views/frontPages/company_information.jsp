<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>信息查看</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
	</head>
	<body>
		<div id="xxck">
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
				<a href="${pageContext.request.contextPath }/Change_companyinformation">修改信息</a>
				<a href="${pageContext.request.contextPath }/Com_firmHomepage.action">首页</a>
			</div>
			<!--中间信息-->
			<div id="xxck1">
				<h2>公司基本信息：</h2><br />
				<table style="table-layout: fixed;">
					<tr>
						<th>公司名称：</th>
						<td>${company.name }</td>
					</tr>
					<tr>
						<th>所属行业：&nbsp;&nbsp;</th>
						<td>${company.manage }</td>
					</tr>
					<tr>
						<th>公司性质：</th>
						<td>${company.property }</td>
					</tr>
					<tr>
						<th>公司规模：</th>
						<td>
							${company.scale }
						</td>
					</tr>
					<tr>
						<th>咨询电话：</th>
						<td>
							${company.tel }
						</td>
					</tr>
					<tr>
						<th>公司Email：</th>
						<td>
							${company.email }
						</td>
					</tr>
					<tr>
						<th>公司地址：</th>
						<td>
							${company.address }
						</td>
					</tr>
					<tr>
						<th>企业介绍：</th>
						<td>
							<div class="gsjs1">
							${company.resume }
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
		</div>
	</body>
</html>
