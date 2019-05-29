<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>备忘录</title>
		<script type="text/javascript" src="${ctxStatic}/ckeditor/ckeditor.js" ></script>
		<script type="text/javascript" src="${ctxStatic}/frontLayout/js/check.js" ></script>
		<script type="text/javascript">
		    window.onload = function()
		    {
		        CKEDITOR.replace('description',{ height: '400px', width: '100%' });
		    };
		</script> 
		<style type="text/css">
			body { height: 100%; padding: 0; margin: 0; }
			.content { height: 100%; padding: 100px 0 0; box-sizing: border-box ; }
			.top { height: 30px; margin: -100px 0 0; background: #BBE8F2; }
			.bottom { height: 100%; background: #D9C666; }
			#description{
				height:600px;
			}
		</style>
	</head>
	<body>
		<div class="content">
		<form action="${pageContext.request.contextPath }/SaveMemorandum" method="post" onsubmit="return validate()">
			<div class="top" style="text-align: center;">
				备忘录主题：<textarea rows="1" cols="50" name="title" id="title" >${bwl.title }</textarea>
				<input type="submit" value="保&nbsp;存">
			</div>
			<div class="bottom">
				<textarea id="description" name = "content"  wrap = "physical" cols="30" rows="30" >${bwl.content }</textarea>
			</div>
		</form>
		</div>
	</body>
</html>