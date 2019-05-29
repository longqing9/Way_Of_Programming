<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览招聘信息</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
		<%-- <link href="https://fonts.googleapis.com/css?family=Raleway:200,400" rel="stylesheet">
      <link rel="stylesheet" href="${ctxStatic}/frontLayout/css/style.css"> --%>
</head> 
<body>
	<div style="height: 100%;width: 100%;border: 1px solid black;position: fixed;margin-left: 0px;">
		<div id="plook" style="height: 98px;width: 100%;border: 1px solid red;z-index: 9999;position:relative; ">
				
			<div id="header">
				<div id="lab1">
					<br/><br />
					<p>
					<font face="微软雅黑" size="3" color="#FFFFF0">客户服务热线：</font>&nbsp;
					<font face="微软雅黑" size="3" color="white">400-855-9626</font>
					</p>
				</div>
						
			
			</div>
			<br />
			<div id="label" style="z-index: 9999;position: relative;">
			<nav>
		     <h4><a href="${pageContext.request.contextPath }/Yklogout">退出</a></h4>
			</nav>
			<nav style="float: left;">
		     <h4><a href="#" onclick="javascript:history.back(-1);">后&nbsp;退</a></h4>
			</nav>
			<nav>
			     <h4><a href="${pageContext.request.contextPath }/Yklogout">去登录</a></h4>
			</nav>	
			<nav>
			    <h4><a href="${pageContext.request.contextPath }/ShowYkrecruit" target="as">浏览招聘</a></h4> 
			</nav>
		</div>		
		</div>
		<div style="width: 100%;height: 90%;border: 1px solid blue;z-index: -1;position:absolute;">
			<iframe name="as" scrolling="auto" width="100%" height="100%" style="z-index: -5;position: absolute;"></iframe>
		</div>
	</div>
</body>
</html>