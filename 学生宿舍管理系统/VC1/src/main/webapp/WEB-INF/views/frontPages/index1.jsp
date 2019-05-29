<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
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
		  background-color: black;
		  min-width: 100px;
		  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		  padding: 10px 10px;
		}
		.dropdown:hover .dropdown-content {
		  display: block;
		}
		h4{
			color: white;
		}
		p{
			color: white;
		}
     </style>
</head> 
<body>
	<div style="height: 100%;width: 100%;border: 0px solid black;position: fixed;margin-left: 0px;">
		<div id="plook" style="height: auto;width: 100%;border: 1px solid red;z-index: 9999;position:relative;background-color: #99ff33; ">
			<div id="header">
				<h1 style="text-align: center;">学生宿舍管理系统</h1>
				<div id="lab1">
					<p>
					<font face="微软雅黑" size="3" color="black">客户服务热线：</font>&nbsp;
					<font face="微软雅黑" size="3" color="black">400-855-9626</font>
					</p>
				</div>
			</div>
			<div style="position: relative; bottom: 55px;">
				<div class="dropdown">
					 <h4><a href="#" onclick="javascript:history.back(-1);" style="color: white;">后&nbsp;退</a></h4>
				</div>	
				<div class="dropdown">
					<h4><a href="${wh}/Logout" style="color: white;">退出</a></h4>
				</div>
				<div class="dropdown">
					<h4>留言板</h4>
				  <div class="dropdown-content">
				    <p><a href="${wh}/ShowallMess" target="as" style="color: white;" >留言板</a></p>
				    <p><a href="${wh}/AddMess" target="as" style="color: white;" >添加留言板</a></p>
				  </div>
				</div>		
				<div class="dropdown">
					<h4><a href="${wh}/qk" style="color: white;">宿舍检查情况</a></h4>
				</div>	
				<div class="dropdown">
					<h4>备忘录</h4>
				  <div class="dropdown-content">
				    <p><a href="${wh}/ShowallMemorandum" target="as" style="color: white;" >备忘录</a></p>
				    <p><a href="${wh}/Addmemo" target="as" style="color: white;" >添加备忘录</a></p>
				  </div>
				</div>
				<div class="dropdown">
					<h4>其他操作</h4>
				  <div class="dropdown-content">
				    <p><a href="${wh}/yj" target="as" style="color: white;" >写邮件</a></p>
				    <p><a href="${wh}/showresource" target="as" style="color: white;">资源连接</a></p>
				  </div>
				</div>	
				<div class="dropdown">
					<h4>报修任务</h4>
				  <div class="dropdown-content">
				    <p><a href="${wh}/Addbaoxiu" target="as" style="color: white;" >添加报修订单</a></p>
				    <p><a href="${wh}/Endbaoxiu" target="as" style="color: white;">结束报修</a></p>
				  </div>
				</div>
				<div class="dropdown">
					<h4>个人信息</h4>
				  <div class="dropdown-content">
				    <p><a href="${wh}/xg" target="as" style="color: white;">修改个人信息</a></p>
				  </div>
				</div>
		</div>		
		</div>
		<div style="width: 100%;height: 90%;border: 1px solid blue;z-index: -1;position:absolute;">
			<iframe name="as" scrolling="auto" width="100%" height="100%" style="z-index: -5;position: absolute;"></iframe>
		</div>
	</div>
</body>
</html>