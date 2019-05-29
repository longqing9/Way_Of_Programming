<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>企业注册</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
		<script src="${ctxStatic}/frontLayout/js/jquery-1.7.min.js" type="text/javascript"></script>
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
		<div id="qyzc">
			<!--头部导航栏-->
			<div id=header>
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
			<br />
			<hr color="#BBBBBB" style="height: 5px;" width="100%">
			<br /><br />
		<p align="center"><font color="blue" size="14">企业注册</font></p>
			<!--登录注册界面-->
			<div id="right">
			<p style="color: red;">${tip }</p>
			<form action="${pageContext.request.contextPath }/firmregister" method="post" onsubmit="return Comregister()">
				<table>
					<tr >
						<td>单位名称：
							<input type="text" name="name" id="name" value="请输入与单位证照资料一致的单位全称/2-26个中文" onclick="this.value=''" />
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;城&nbsp;&nbsp;市&nbsp;&nbsp;：
							  <input type="text" id="city" name="address" value="">
						</td>
					</tr>
					<tr>
						<td>&nbsp;公司电话：&nbsp;
							<input type="text" id="tel" name="tel" value="请输入公司电话" onclick="this.value=''" />
						</td>
					</tr>
					<tr>
						<td>&nbsp;验&nbsp;证&nbsp;码：
						<input type="text" id="input" /> 
 						<input type="button" id="code" onclick="createCode()" style="width:60px;height: 25px;" title='点击更换验证码' />
						</td>
					</tr>
					<tr >
						<td>电子邮箱：
							<input type="email" id="email" name="email"  />
						</td>
					</tr>
					<tr >
						<td>&nbsp;用&nbsp;户&nbsp;名：
							<input type="text" id="username" name="companyid" value="请输入用户名,由3-5个字符组成" onclick="this.value=''"  />
						</td>
					</tr>
					<tr >
						<td>&nbsp;&nbsp;密&nbsp;&nbsp;码&nbsp;&nbsp;：
							<input type="password" id="password" name="password" />
						</td>
					</tr>
					<tr id="dl3">
						<td >
							<input type="checkbox"  name="dl2" /><font color="cornflowerblue" size="2">我已阅读并同意IT马馆《用户服务协议》和《隐私政策》</font>
						</td>
				</tr>
					<tr>
						<td >
							<input type="submit" value="立即注册" id="zc2" style="color: #000000" >
						</td>
				</tr>
			</table>
		</form>
			</div>
			<div id="footer">Copyright © 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
		</div>
	</body>

</html>