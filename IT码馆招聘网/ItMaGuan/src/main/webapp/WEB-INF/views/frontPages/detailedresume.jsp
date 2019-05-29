<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看招聘详细信息</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
	</head>
	<body id="look">
	<div id="jx1">
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
				<a href="#" onclick="javascript:history.back(-1);">返回上一页</a>
				<a href="${pageContext.request.contextPath }/Allcompanyrecruitment">查看招聘信息</a>
				<a href="${pageContext.request.contextPath }/AddRecruitmentInformation">发布招聘</a>
				<a href="${pageContext.request.contextPath }/Com_firmHomepage.action">首页</a>
			</div>
			<!--招聘信息填写-->
			 <div id="fbzp" style="width: 60%;margin-left: 16%;">
			 	<table>
			 		<!--第一行-->
			 		<tr>
			 			<th>岗位名称：</th>
			 			<td>
			 				${cjob.job }
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;所属部门：</th>
			 			<td>
			 				${cjob.department }
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;学历：</th>
			 			<td>
			 				${cjob.educational }
			 			</td>
			 		</tr>
			 		<!--第二行-->
			 		<tr>
			 			<th>年龄要求：</th>
			 			<td>
			 				${cjob.age }
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;专业要求：</th>
			 			<td>
			 				${cjob.specialty }
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;海外经历：</th>
			 			<td>
			 				${cjob.undergo }
			 			</td>
			 		</tr>
			 		<!--第三行-->
			 		<tr>
			 			<th>是否全日：</th>
			 			<td>
			 				${cjob.fulltime }
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;诚招薪水：</th>
			 			<td>
			 				${cjob.emolument }
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;工作经验：</th>
			 			<td>
			 				${cjob.experience }
			 			</td>
			 		</tr>
			 		<tr>
			 			<th>招聘人数：</th>
			 			<td>${cjob.number }人</td>
			 			<th>&nbsp;&nbsp;工作地点：</th>
			 			<td>${cjob.place }</td>
			 			<th>&nbsp;&nbsp;外语要求：</th>
			 			<td>${cjob.language }</td>
			 		</tr>
			 	
			 	</table>
			 	     <h3>岗位要求：</h3>
			 			<p>${cjob.other }</p>
			 			<br  /><br  />
			 	   <h3>公司福利：</h3>
			 	   	<div class="gsjs">${cjob.comprofile }</div>
			 			<%-- <textarea rows="10" cols="80" readonly="readonly" style="background-color: bisque" >${cjob.comprofile }</textarea> --%>
			 </div>
		<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
</div>
	
	</body>
</html>
