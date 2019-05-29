<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>个人信息修改</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/index_1.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/common.css" />
</head>
<body >
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 学生个人信息修改
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<div id="MainArea" style="padding-left: 25%">
	<form action="${pageContext.request.contextPath }/toupdateinformation.action" method="post" enctype="multipart/form-data">
		<div class="upone">
		    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
		        
		        <thead>
		            <tr align="center" valign="middle" id="TableTitle">
						<td>列值</td>
						<td>信息</td>
					</tr>
				</thead>	
				<!--显示数据列表 -->
		        <tbody id="TableData">
		        
		        	<tr class="TableDetail1">
						<td align="center">学号</td>
						<td align="center"><input type="text" name="sno" value="${user.sno }" readonly="readonly">
						 </td>
					</tr>
					<tr class="TableDetail1">
						<td align="center">姓名：</td>
						<td align="center" > <input type="text" name="sname" id="" value="${user.sname }" /></td>
					</tr>
					<tr class="TableDetail1">
						<td align="center">照片</td>
						<td align="center">
							<c:if test="${user.spic!=null }">
		       					<img src="/pic/${user.spic }" id="show" width="100px" height="120px"/> 
		       					<br>
		      				</c:if>
		      				<input id="file" type="file" value="${user.spic }"  name="pictureFile" onchange="c()"/>
						</td>
					</tr>
					
					
					<tr class="TableDetail1">
						<td align="center">性别：</td>
						<td align="center"> 
				            <input type="radio" name="ssex" value="男" <c:if test="${user.ssex=='男' }">checked="checked"</c:if>/> 男
				            <input type="radio" name="ssex" value="女" <c:if test="${user.ssex=='女' }">checked="checked"</c:if>/> 女
	        			</td>
					</tr>
					<tr class="TableDetail1">
						<td align="center">学院</td>
						<td align="center"><input type="text" name="college" value="${user.college }" readonly="readonly"></td>
					</tr>
					<tr class="TableDetail1">
						<td align="center">专业</td>
						<td align="center"><input type="text" name="profession" value=" ${user.profession }" readonly="readonly"></td>
					</tr>
					<tr class="TableDetail1">
						<td align="center">班级</td>
						<td align="center"> <input type="text" name="classname" value="${user.classname }" readonly="readonly"></td>
					</tr>
					<tr class="TableDetail1">
						<td align="center">联系方式</td>
						<td align="center"> <input type="tel" name="stel" id="" value="${user.stel }" /></td>
					</tr>
		        </tbody>
		    </table>
		   <!-- 其他功能超链接 -->
			<div id="TableTail">
				<input type="submit" value="修改" />&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置" />
		    </div>
		</div>
		 
    </form>
</div>
</body>
<script type="text/javascript">
function c () {
	  var r= new FileReader();
	  f=document.getElementById('file').files[0];
	   
	  r.readAsDataURL(f);
	  r.onload=function (e) {
	    document.getElementById('show').src=this.result;
	  };
	}

</script>
</html>
