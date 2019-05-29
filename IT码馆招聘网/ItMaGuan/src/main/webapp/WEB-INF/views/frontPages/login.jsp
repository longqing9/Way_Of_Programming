<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
		<script type="text/javascript" src="${ctxStatic}/frontLayout/js/verifycode.js" ></script>
		<style type="text/css">
		#code{
            font-family:Arial,宋体;
            font-style:italic;
            color:green;
            border:0;
            padding:5px 10px;
            letter-spacing:3px;
            font-weight:bolder;
            }
		</style>
	</head>

	<body onload='createCode()'>
	   <div id="background">
		<div id="header">
			<ul>
				<li>
					<a href="Company_login.action" style="color: white;">企业登录</a>
				</li>
			
			</ul>
		</div>
		<hr color="#BBBBBB" style="height: 5px;" width="100%">
		<div id="left1">
		<c:forEach items="${cjob }" var="job" begin="0" end="9">
			<li><span>${job.ptime }</span>
				<a href="${pageContext.request.contextPath }/Showstudrecruit?id=${job.id}">${job.comname }</a>
			</li>
		</c:forEach>
		
		</div>

		<div id="right">
		<p id="ts" style="color: red">${tips }</p>
		<form action="${pageContext.request.contextPath }/Stulogin" method="post" onsubmit="return validate()">
			<table>
				<tr>
					<th>帐户</th>
					<td>
						<input type="text" name="username" id="username" value=""  />
					</td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input type="password" name="password" id="password" value=""  /></td>
				</tr>
				<tr>
					<th>验证码</th>
 						<td>
 						<input type="text" id="input" /> 
 						<input type="button" id="code" onclick="createCode()" style="width:60px;height: 25px;" title='点击更换验证码' />
 						</td>
 				</tr>
				<tr>
					<th>&nbsp;</th>
					<!-- <td><input name="input" type="checkbox" value="" /> 记住密码
						<a href="#">忘记密码</a>
					</td> -->
				</tr>
				<tr>
					<th>&nbsp;</th>
					<td>
					<!--  
						<a href="p_index.html" class="indexLoginTBinput3">登 录</a>-->
						<input type="submit" class="indexLoginTBinput3" value="登录" />
						<a href="${pageContext.request.contextPath }/Gostudregister" class="indexLoginTBinput4">注 册</a>
					</td>
				</tr>
				
				<tr>
					<th>&nbsp;</th>
					<td>
						<a href="${pageContext.request.contextPath }/Yklogin" style="color: black;">游客进入</a>
					</td>
				</tr>
			</table>
		</form>
		</div>
		<div id="footer">
			Copyright © 2006-2012 IT马倌 | 营业执照 | 苏ICP证B2-20070191
		</div>
    </div>
	</body>

</html>