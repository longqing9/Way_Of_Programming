<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>公司登陆</title>
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
	  <div id="gsdl">
		<div id="header">
			
			<p>&nbsp;&nbsp;<font face="微软雅黑" size="6">|</font>&nbsp;&nbsp;<font face="微软雅黑" size="6">企业版</font></p>
			<ul><li><p><font face="微软雅黑" size="3">客户服务热线：</font>&nbsp;<font face="微软雅黑" size="3">400-855-9626</font></p></li></ul>
		</div>
		<br />
		<hr color="#BBBBBB" style="height: 5px;" width="100%">
		<br /><br /><br />
		<div id="left1">
			<img src="${ctxStatic}/frontLayout/images/ct.png"  />
		</div>
		
		
		<div id="right">
			
			<p id="ts" style="color: red">${tips }</p>
			<form action="${pageContext.request.contextPath}/comlogin" method="POST" onsubmit="return validate()">
			<table>
				<tr>
					<th>帐户</th>
					<td  >
						<input type="text" name="username" id="username" value=""   />
					</td>
				</tr>
				<tr>
					<th>密码</th>
					<td ><input type="password" id="password" name="password" value=""  /></td>
				</tr>
				<tr>
					<th>验证码</th>
					<td>
 						<input type="text" id="input" /> 
 						<input type="button" id="code" onclick="createCode()" style="width:79px;height: 25px;" title='点击更换验证码' />
 					</td>
				
				</tr>
				<tr>
					<th>&nbsp;</th>
					<!-- <td><input name="input" type="checkbox" value="" />记住密码
					<a href="#">忘记密码</a></td> -->
				</tr>
				<tr>
					<th>&nbsp;</th>
					<td >
						<input type="submit" value="登录" style="color:#000000 " class="gsdltp">
					</td>
				</tr>
				<tr>
					<th>&nbsp;</th>
					<td>
						<p><font size="3">没有账号?</font><a href="${pageContext.request.contextPath}/Company_register.action">立即注册</a></p>
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
