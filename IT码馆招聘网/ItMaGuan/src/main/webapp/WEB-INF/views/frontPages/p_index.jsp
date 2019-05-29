<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能页</title>
	<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
      <style type="text/css">
      	.dropdown {
		  position: relative;
		  display: inline-block;
		  float: right;
		   padding: 10px;
		   width: 100px;
		   padding-bottom: 5px;
		}
		.dropdown-content {
		  display: none;
		  position: absolute;
		  background-color: #777777;
		  min-width: 90px;
		  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		  padding: 10px 10px;
		}
		.dropdown:hover .dropdown-content {
		  display: block;
		}
     </style>
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
			     <h4><a href="${pageContext.request.contextPath }/Stulogout">退出</a></h4>
				</nav>
				<nav style="float: left;">
			     <h4><a href="#" onclick="javascript:history.back(-1);">后&nbsp;退</a></h4>
				</nav>
				
				
				<div class="dropdown">
					<h4 style="color: white;">职位信息</h4>
				  <div class="dropdown-content">
				    <p><a href="${pageContext.request.contextPath }/ShowStudrecruit" target="as" >浏览招聘</a></p>
				    <p><a href="${pageContext.request.contextPath }/MyApply" target="as" >我的申请</a></p>
					<p><a href="${pageContext.request.contextPath }/Mycollection" target="as" >我的收藏</a></p>
				  </div>
				</div>	
				<div class="dropdown">
					<h4 style="color: white;">我的简历</h4>
				  <div class="dropdown-content">
				    <p><a href="${pageContext.request.contextPath }/AddSturesume" target="as">修改简历</a></p>
					<p><a href="${pageContext.request.contextPath }/Showstudresume" target="as" >查看简历</a></p>
				  </div>
				</div>
				<div class="dropdown">
					<h4 style="color: white;">个人信息</h4>
				  <div class="dropdown-content">
				    <p><a href="${pageContext.request.contextPath }/ToStuP_reviseinformation" target="as">修改个人信息</a></p>
				    <p><a href="${pageContext.request.contextPath }/ShowStuinformation" target="as" >查看个人信息</a></p>
				  </div>
				</div>
			
		</div>		
		</div>
		<div style="width: 100%;height: 90%;border: 1px solid blue;z-index: -1;position:absolute;">
			<iframe name="as" src="${pageContext.request.contextPath }/ShowStudrecruit" scrolling="auto" width="100%" height="100%" style="z-index: -5;position: absolute;"></iframe>
		</div>
	</div>
</body>
</html>