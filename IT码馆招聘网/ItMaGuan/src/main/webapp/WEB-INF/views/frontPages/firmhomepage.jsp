<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>公司企业注册界面</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/homepage.css" />
	</head>

	<body>
		<div id="qydljm">
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
			<br />
			<div id="gll">
				<a href="${pageContext.request.contextPath }/com_logout">退出</a>
				<a href="#">帮助</a>
				<a href="#">消息</a>
			</div>
		    
		    <div id="mmm">
		    <div id="mmm1">
		    
		    		<li><h2>公司基本信息</h2>
		    			<ul>
		    			  <li><a href="${pageContext.request.contextPath }/Show_companyinformation">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看公司信息</a></li>	
		    			  <li><a href="${pageContext.request.contextPath }/Change_companyinformation">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改公司信息</a></li>		
		    			</ul>
		    		</li>
		    </div>
		    <div id="mmm2">
		    		<li><h2>发布招聘信息</h2>
		    			<ul>
		    				 <li><a href="${pageContext.request.contextPath }/AddRecruitmentInformation">&nbsp;&nbsp;填写招聘信息</a></li>	
		    				 <li><a href="${pageContext.request.contextPath }/Allcompanyrecruitment">&nbsp;&nbsp;查看本公司招聘信息</a></li>	
		    			</ul>
		    		</li>
		    </div>
		    <div id="mmm3">
		    		<li><h2>查看所有招聘信息</h2>
		    			<ul>
		    				 <li><a href="${pageContext.request.contextPath }/ShowAllrecruitment">&nbsp;&nbsp;具体招聘信息</a></li>	
		    				 <li><a href="${pageContext.request.contextPath }/ShowOthercompanyInformation">&nbsp;&nbsp;浏览招聘公司</a></li>	
		    			</ul>
		    		</li>
		    </div>
		    <div id="mmm4">
		    		<li><h2>求职人信息</h2>
		    			<ul>
		    				 <li><a href="${pageContext.request.contextPath }/Show">&nbsp;&nbsp;查看所有申请人</a></li>
		    			</ul>
		    		</li>
		     </div>
		 </div>
			      
	
		    
		
		    <!--底部标记-->
			<div id="footer">
				Copyright © 2006-2012 IT马倌 | 营业执照 | 苏ICP证B2-20070191
			</div>
		</div>
	</body>

</html>