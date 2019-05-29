<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>求职人员注册</title>	
		<style type="text/css">
			body {
					font-family: "微软雅黑";
					font-size: 18px;
					background: url(${ctxStatic}/frontLayout/images/zc1234.png);
					background-size: cover;
				}
		</style>
		<link rel="stylesheet" type="text/css" href="${ctxStatic}/frontLayout/css/register.css" />
		<script type="text/javascript" src="${ctxStatic}/frontLayout/js/register.js"></script>
		<script type="text/javascript" src="${ctxStatic}/frontLayout/js/verifycode.js" ></script>
	</head>

	<body>
		<!--头部导航栏-->
		<div id="header">
			<img src="${ctxStatic}/frontLayout/images/logo.png" />
			<p>&nbsp;&nbsp;
				<font face="微软雅黑" size="6">|</font>&nbsp;&nbsp;
				<font face="微软雅黑" size="6">个人版</font>
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
		<br><br>
		<p id="i"  align="center"><font size="6" >用户注册</font></p>
		<!--用户注册-->
		<div id="d1">
			<form action="${pageContext.request.contextPath }/SaveStudregister" method="post" onsubmit="return StudRegister()">
				<!-- 当触发提交事件时调用validateForm()方法  -->
				<table border="26" align="right" width="50%">
					<tr>
						<td align="right"></td>
						<td><p style="color: red;">${stip }</p></td>
					</tr>
					<tr>
						<td align="right">
							<!--<sup></sup>定义上标文本-->
							<sup><font color="red">*</font></sup>用户ID：
						</td>
						<td>
							<input type="text" name="studentid" id="username" class="input_class"  />
							<span id="username_span">用户ID由6-15个字符组成</span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<sup><font color="red">*</font></sup>密码：
						</td>
						<td><input type="password" name="password" id="password" class="input_class"  />
							<span id="password_span">请输入8-12位密码</span>
						</td>
					</tr>

					<tr>
						<td align="right">
							<sup><font color="red">*</font></sup>确认密码：
						</td>
						<td>
							<input type="password" id="rePassword" class="input_class"  />
							<span id="rePassword_span">两次密码不一致</span>
						</td>
					</tr>

					<tr>
						<td align="right">
							<sup><font color="red">*</font></sup>Email：
						</td>
						<td>
							<input type="text" name="email" id="Email" class="input_class"  />
							<span id="Email_span">格式示例：xxxxxxxx@163.com</span>
						</td>
					</tr>

					<tr>
						<td align="right">
							<sup><font color="red">*</font></sup>真实姓名：
						</td>
						<td>
							<input type="text" name="name" id="realName" class="input_class"  />
							<span id="realName_span">由2-5个中文组成</span>
						</td>
					</tr>	
					
					<tr>
						<td align="right">
							<sup><font color="red">*</font></sup>学历：
						</td>
						<td>
							<select name="knowledge" id="graduate" >
								<option value="">--请选择--</option>
								<option value="高中">高中</option>
								<option value="专科">专科</option>
								<option value="本科">本科</option>
								<option value="研究生">研究生</option>
							</select>
							<span id="graduate_span">请选择学历</span>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="submit" class="aaa" value="注册" style="color: #000000">
							<input type="reset" name="reset" class="aaa" value="重置" />
						</td>	
					</tr>
				</table>
			</form>
		</div>
		<div id="f1">Copyright  2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
	</body>
</html>