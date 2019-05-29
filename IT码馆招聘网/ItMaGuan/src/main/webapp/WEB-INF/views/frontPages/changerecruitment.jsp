<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改招聘信息</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
		<script type="text/javascript" src="${ctxStatic}/ckeditor/ckeditor.js" ></script>
		<script src="${ctxStatic}/frontLayout/js/jquery-1.7.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${ctxStatic}/frontLayout/js/verification.js"></script>
		<script type="text/javascript">
		    window.onload = function()
		    {
		        CKEDITOR.replace( 'description1');
		    };
		</script> 
	</head>
	<body>
	<div id="xg">
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
				<a href="${pageContext.request.contextPath }/Allcompanyrecruitment">查看招聘信息</a>
				<a href="${pageContext.request.contextPath }/AddRecruitmentInformation">发布招聘</a>
				<a href="${pageContext.request.contextPath }/Com_firmHomepage.action">首页</a>
			</div>
			
			<!--招聘信息填写-->
			 <div id="fbzp" style="width: 60%;margin-left: 20%;padding-left: 1%;height:auto;">
			 <form action="${pageContext.request.contextPath }/SaveRecruitmentInformation" method="post" onsubmit="return Cjob()">
			 	<table style="overflow-x:auto;">
			 		<!--第一行-->
			 		<input type="hidden" name="id" value="${cjob.id }">
			 		<tr>
			 			<th>岗位名称：</th>
			 			<td>
			 			<input id="xx0" type="text" name="job" value="${cjob.job }" />
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;所属部门：</th>
			 			<td>
			 				<select name = "department" id="select">
							     <option value = "行政部门" <c:if test="${cjob.department=='行政部门' }">selected = "selected"</c:if> >行&nbsp;政&nbsp;部&nbsp;门</option>&nbsp;
								 <option value = "企划部" <c:if test="${cjob.department=='企划部' }">selected = "selected"</c:if> >企&nbsp;划&nbsp;部</option>&nbsp;
								 <option value = "销售部" <c:if test="${cjob.department=='销售部' }">selected = "selected"</c:if> >销&nbsp;售&nbsp;部</option>&nbsp;
								 <option value = "市场部" <c:if test="${cjob.department=='市场部' }">selected = "selected"</c:if> >市&nbsp;场&nbsp;部</option>&nbsp;
								 <option value = "研发部" <c:if test="${cjob.department=='研发部' }">selected = "selected"</c:if> >研&nbsp;发&nbsp;部</option>&nbsp;
							  </select>
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;学历：</th>
			 			<td>
			 				<select name = "educational" id="select">
			 					 <option value = "大专以上"  <c:if test="${cjob.educational=='大专以上' }"> selected="selected" </c:if>  >大&nbsp;&nbsp;专&nbsp;&nbsp;以&nbsp;&nbsp;上</option>&nbsp;
							     <option value = "本科"  <c:if test="${cjob.educational=='本科' }"> selected="selected" </c:if> >本&nbsp;&nbsp;科</option>&nbsp;
								 <option value = "研究生" <c:if test="${cjob.educational=='研究生' }"> selected="selected" </c:if> >研&nbsp;&nbsp;究&nbsp;&nbsp;生</option>&nbsp;
								 <option value = "博士" <c:if test="${cjob.educational=='博士' }"> selected="selected" </c:if> >博&nbsp;&nbsp;士</option>&nbsp;
							  </select>
			 			</td>
			 		</tr>
			 		<!--第二行-->
			 		<tr>
			 			<th>年龄要求：</th>
			 			<td>
			 				<select name = "age" id="select">
							     <option value = "18-22"  <c:if test="${cjob.age=='18-22' }">selected = "selected"</c:if> >18&nbsp;&nbsp;-&nbsp;&nbsp;22</option>&nbsp;
								 <option value = "22-28" <c:if test="${cjob.age=='22-28' }">selected = "selected"</c:if> >22&nbsp;&nbsp;-&nbsp;&nbsp;28</option>&nbsp;
								 <option value = "28-35" <c:if test="${cjob.age=='28-35' }">selected = "selected"</c:if> >28&nbsp;&nbsp;-&nbsp;&nbsp;35</option>&nbsp;
								 <option value = "35-40" <c:if test="${cjob.age=='35-40' }">selected = "selected"</c:if> >35&nbsp;&nbsp;-&nbsp;&nbsp;40</option>&nbsp;
								 <option value = "40-45" <c:if test="${cjob.age=='40-45' }">selected = "selected"</c:if> >40&nbsp;&nbsp;-&nbsp;&nbsp;45</option>&nbsp;
								 <option value = "不&nbsp;&nbsp;限" <c:if test="${cjob.age=='不&nbsp;&nbsp;限' }">selected = "selected"</c:if> >不&nbsp;&nbsp;限</option>&nbsp;
							  </select>
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;专业要求：</th>
			 			<td>
			 				<input id="xx1" type="text" name="specialty" value="${cjob.specialty }" id="select">
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;海外经历：</th>
			 			<td>
			 				<select name = "undergo" id="select">
			 					 <option value = "有" <c:if test="${cjob.undergo=='有' }">selected = "selected"</c:if> >&nbsp;&nbsp;有&nbsp;&nbsp;</option>&nbsp;
							     <option value = "无" <c:if test="${cjob.undergo=='无' }">selected = "selected"</c:if> >&nbsp;&nbsp;无&nbsp;&nbsp;</option>&nbsp;
								 <option value = "不做要求" <c:if test="${cjob.undergo=='不做要求' }">selected = "selected"</c:if> >不&nbsp;做&nbsp;要&nbsp;求</option>&nbsp;
							  </select>
			 			</td>
			 		</tr>
			 		<!--第三行-->
			 		<tr>
			 			<th>是否全日制：</th>
			 			<td>
			 				<select name = "fulltime" id="select">
							     <option value = "是"  <c:if test="${cjob.fulltime=='是' }">selected = "selected"</c:if> >&nbsp;&nbsp;是&nbsp;&nbsp;</option>&nbsp;
								 <option value = "否" <c:if test="${cjob.fulltime=='否' }">selected = "selected"</c:if>>&nbsp;&nbsp;否&nbsp;&nbsp;</option>&nbsp;
							  </select>
			 			</td>
			 			<th>&nbsp;&nbsp;&nbsp;&nbsp;工作经验：</th>
			 			<td>
			 				<select name = "experience" id="select">
			 					<option value = "1年" <c:if test="${cjob.experience=='1年' }">selected = "selected"</c:if> >1&nbsp;&nbsp;年</option>&nbsp;
			 					<option value = "2年" <c:if test="${cjob.experience=='2年' }">selected = "selected"</c:if> >2&nbsp;&nbsp;年</option>&nbsp;
							    <option value = "3年"  <c:if test="${cjob.experience=='3年' }">selected = "selected"</c:if> >3&nbsp;&nbsp;年</option>&nbsp;
								<option value = "5年" <c:if test="${cjob.experience=='5年' }">selected = "selected"</c:if> >5&nbsp;&nbsp;年</option>&nbsp;
								<option value = "10年" <c:if test="${cjob.experience=='10年' }">selected = "selected"</c:if> > 10&nbsp;&nbsp;年</option>&nbsp;
								<option value = "不限"  <c:if test="${cjob.experience=='不限' }">selected = "selected"</c:if> >不&nbsp;&nbsp;限&nbsp;</option>&nbsp;
							  </select>
			 			</td>
			 			<th>&nbsp;&nbsp;诚招薪水：</th>
			 			<td><input id="xx2" name="emolument" value="${cjob.emolument }" type="text" /></td>
			 		</tr>
			 		<tr>
			 			<th>招聘人数：</th>
			 			<td><input id="fbzp1" name="number" min="1"  type="number"  value="${cjob.number }" /></td>
			 			<th>&nbsp;&nbsp;工作地点：</th>
			 			<td><input id="xxx3" name="place" value="${cjob.place }"  type="text" /></td>
			 			<th>&nbsp;&nbsp;外语要求：</th>
			 			<td><input id="fbzp2" name="language" value="${cjob.language }" type="text" /></td>
			 		</tr>
			
			 	</table>
			 	     <h3>岗位要求：</h3>
			 			<textarea id="description1" name = "other"  wrap = "physical">${cjob.other }</textarea>
			 	   <h3>公司福利：</h3>
			 			<textarea name = "comprofile" cols = "90" rows = "10" wrap = "physical">${cjob.comprofile }</textarea>
			 		<table >
			 			<tr>&nbsp;&nbsp;&nbsp;</tr>
			 			<tr>
			 			<td >
			 			<input type="submit" value="发布招聘" class="gsdltp" style="color: #000000;"/>
					</td></tr></table> 
				</form>
			 </div>
		<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
	</div>
	</body>
</html>
