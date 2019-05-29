<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>转储简历信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sobz/tbSobz/">转储简历信息列表</a></li>
		<li class="active"><a href="${ctx}/sobz/tbSobz/form?id=${tbSobz.id}">转储简历信息<shiro:hasPermission name="sobz:tbSobz:edit">${not empty tbSobz.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sobz:tbSobz:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tbSobz" action="${ctx}/sobz/tbSobz/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">用户注册ID：</label>
			<div class="controls">
				<form:input path="studentid" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">公司注册|ID：</label>
			<div class="controls">
				<form:input path="companyid" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">招聘的ID：</label>
			<div class="controls">
				<form:input path="jobid" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">期望行业：</label>
			<div class="controls">
				<form:input path="specialty" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">期望职业：</label>
			<div class="controls">
				<form:input path="job" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所求薪水：</label>
			<div class="controls">
				<form:input path="emolument" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">期望工地点：</label>
			<div class="controls">
				<form:input path="workaddress" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">求职状态：</label>
			<div class="controls">
				<form:input path="worknow" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工作性质：</label>
			<div class="controls">
				<form:input path="jobnature" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传附件：</label>
			<div class="controls">
				<form:input path="appendixid" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简历状态：</label>
			<div class="controls">
				<form:input path="other" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">前公司名称：</label>
			<div class="controls">
				<form:input path="cname" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属行业：</label>
			<div class="controls">
				<form:input path="manage" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">前职业名称：</label>
			<div class="controls">
				<form:input path="specialtyago" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">职位类别：</label>
			<div class="controls">
				<form:input path="zwClass" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">前月薪：</label>
			<div class="controls">
				<form:input path="salary" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工作描述：</label>
			<div class="controls">
				<form:input path="jobmiaoshu" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">在职时间：</label>
			<div class="controls">
				<form:input path="worktime" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目名称：</label>
			<div class="controls">
				<form:input path="proName" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目时间：</label>
			<div class="controls">
				<form:input path="proTime" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目描述：</label>
			<div class="controls">
				<form:input path="proDescripe" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">个人职责：</label>
			<div class="controls">
				<form:input path="proDuty" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属公司：</label>
			<div class="controls">
				<form:input path="proCompany" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">学校名称：</label>
			<div class="controls">
				<form:input path="schName" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">就读时间：</label>
			<div class="controls">
				<form:input path="schTime" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所学时间：</label>
			<div class="controls">
				<form:input path="schProfe" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否统招：</label>
			<div class="controls">
				<form:input path="istzhao" htmlEscape="false" maxlength="4" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">学位学历：</label>
			<div class="controls">
				<form:input path="degree" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">培训时间：</label>
			<div class="controls">
				<form:input path="pxTime" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">培训机构名称：</label>
			<div class="controls">
				<form:input path="pxJigou" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">培训课程：</label>
			<div class="controls">
				<form:input path="pxClass" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">语种：</label>
			<div class="controls">
				<form:input path="yyYuzhong" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">听说能力：</label>
			<div class="controls">
				<form:input path="yyTs" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">读写能力：</label>
			<div class="controls">
				<form:input path="yyDx" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">证书名称：</label>
			<div class="controls">
				<form:input path="zsName" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">获得时间：</label>
			<div class="controls">
				<form:input path="zsTime" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">自我评价：</label>
			<div class="controls">
				<form:input path="selfassess" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sobz:tbSobz:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>