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
			<div id="xxck1" style="margin-top: 0%;" >
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
							${company.resume }
						</td>
					</tr>
				</table>
			</div>
			<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
		</div>
	</body>
</html>
