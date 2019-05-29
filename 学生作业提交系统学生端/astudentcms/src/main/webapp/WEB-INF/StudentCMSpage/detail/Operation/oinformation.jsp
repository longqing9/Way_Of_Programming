<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>任务信息</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="format-detection" content="telephone=no">
		<meta http-equiv="cache-control" content="no-cache,no-store, must-revalidate" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />

		<script type="text/javascript" src="${pageContext.request.contextPath }/style/plugins/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/style/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/style/js/page_common.js"></script>
		
		<link href="${pageContext.request.contextPath }/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/index_1.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/css/common.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/style/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/style/css/form.css" />
	</head>
	<body style="background-color: #F3F9FD;">
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath }/style/images/title_arrow.gif" />作业详情
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
		<div>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>任务的信息</legend>
			</fieldset>
			<br />
			<form class="layui-form" action="${pageContext.request.contextPath }/insertresult.action" method="post">
				<div class="layui-form-item">
					<div class="info1">
						<div class="clainf">姓名 &nbsp;&nbsp;&nbsp;</div>
						<div id="clains">${operinfor.sname }</div>
						<div class="clainf">班级 &nbsp;&nbsp;&nbsp;</div>
						<div id="clains">${operinfor.classname }</div>
						<input type="hidden" name="opid" value="${operinfor.opid }">
						<div class="clainf">学号 &nbsp;&nbsp;&nbsp;</div>
						<input type="text" id="clains" name="rsno" value="${operinfor.sno }">
						<div class="clainf">科目 &nbsp;&nbsp;&nbsp;</div>
						<div id="clains">${operinfor.subname }</div>
						<div class="clainf">截止时间 &nbsp;&nbsp;&nbsp;</div>
						<input type="text" id="clains" value="<fmt:formatDate value='${operinfor.opstoptime }' pattern='yyyy-MM-dd'/>">
						
						<div class="clear"></div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">任务标题</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title" autocomplete="off" readonly="readonly" placeholder="${operinfor.optop }" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">任务要求</label>
					<div class="layui-input-block" style="border:1px solid black;width: 91%;height: 110px;OVERFLOW-Y: auto; OVERFLOW-X:hidden; ">
						
						${operinfor.optext }
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">学生答案</label>
					<div class="layui-input-block"><!-- ckeditor   lay-verify="content"  class="text"-->
						<textarea class="layui-textarea layui-hide" name="retext" lay-verify="retext" id="LAY_demo_editor">${operinfor.retext }</textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
					

					<jsp:useBean id="now" class="java.util.Date" scope="page"/>
					<c:set var="nowDate">  
					    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
					</c:set>
					<c:set var="stoptime">  
					    <fmt:formatDate value="${operinfor.opstoptime }" pattern="yyyy-MM-dd"/>
					</c:set>

					<c:if test="${stoptime > nowDate}">
						<c:if test="${operinfor.retext==null }">
							<input type="hidden" name="re" value="0">
							<button class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
						</c:if>
						<c:if test="${operinfor.retext!=null }">
							<c:if test="${operinfor.rescore==null }">
								<input type="hidden" name="re" value="1">
								 <button class="layui-btn" lay-submit="" lay-filter="demo1">重新提交</button>
							</c:if>
						</c:if>
					</c:if>
					
					</div>
				</div>
			</form>
		</div>

	</body>
		<script>
		layui.use(['form', 'layedit', 'laydate'], function() {
			var form = layui.form(),
				layer = layui.layer,
				layedit = layui.layedit,
				laydate = layui.laydate;

			//创建一个编辑器
			var editIndex = layedit.build('LAY_demo_editor');
			//自定义验证规则
			form.verify({
				retext: function(value) {
					if(value.length<2) {
						return '答案不能为空！！！';
					}
				},
				retext: function(value) {
					layedit.sync(editIndex);
				}
			});
			//监听提交
			form.on('submit(demo1)', function(data) {
					var s=JSON.stringify(data.field.retext);
					var as = s.replace(/(^s*)|(s*$)/g, "").length;
					if(as<50){
						layer.alert("答案不能少于50字！", {
							title: '信息提示'
						});
					return false;
					}
			});
		});
		</script>
</html>