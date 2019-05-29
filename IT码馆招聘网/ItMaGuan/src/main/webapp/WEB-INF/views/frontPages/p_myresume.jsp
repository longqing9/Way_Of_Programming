<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的简历</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/resume.css" />
		<script type="text/javascript" src="${ctxStatic}/ckeditor/ckeditor.js" ></script>
		<script src="${ctxStatic}/frontLayout/js/jquery-1.7.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${ctxStatic}/frontLayout/js/verification.js"></script>
		<script type="text/javascript">
		    window.onload = function()
		    {
		        CKEDITOR.replace( 'description');
		        CKEDITOR.replace( 'description1');
		    }/* ;
		    function savedata() {
				if(Sturesume()){
					
					if(confirm("提交数据")){
						document.getElementById("myform").submit();
					}
				}
			} */
		</script> 
	</head>

	<body>
	
	
		<div class="tit" align="center">
			<h1>我的简历</h1>
		</div>

		<div id="main">
			<div class="tit" align="center">
				<h2>个人信息</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo1" align="center">
				<tr>
					<th>姓名：</th>
					<td>${stud.name }</td>
					<th>性别</th>
					<td>${stud.sex }</td>
				</tr>
				<tr>
					<th>年龄：</th>
					<td>${stud.age }</td>
					<th>出生日期：</th>
					<td><fmt:formatDate value="${stud.birthday }" pattern="yyyy年MM月dd日" /></td>
				</tr>
				<tr>
					<th>参加工作时间：</th>
					<td><fmt:formatDate value="${stud.worktime }" pattern="yyyy年MM月dd日"  /></td>
					<th>现居地：</th>
					<td>${stud.nowadress }</td>
				</tr>
				<tr>
					<th>学历：</th>
					<td>${stud.knowledge }</td>
					<th>联系方式:</th>
					<td>${stud.tell }</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<form action="${pageContext.request.contextPath }/saveStudresume" method="post" id="myform">
		<div id="main">
			<div class="tit" align="center">
				<h2>求职意向</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo1" align="center">
				<tr>
					<th>求职状态：</th>
					<td>
						<select name="worknow" id="select">
							<option  value="我目前处于离职状态，可立即上岗" >我目前处于离职状态，可立即上岗</option>
							 <option <c:if test="${sob.worknow=='我目前处于离职状态，可立即上岗' }">selected="selected"</c:if> value="我目前处于离职状态，可立即上岗" >我目前处于离职状态，可立即上岗</option>
							<option <c:if test="${sob.worknow == '我目前在职，正考虑换个新环境(如有合适的工作机会，到岗时间一个月左右' }">selected="selected"</c:if> value="我目前在职，正考虑换个新环境(如有合适的工作机会，到岗时间一个月左右" >我目前在职，正考虑换个新环境(如有合适的工作机会，到岗时间一个月左右)</option>
							<option <c:if test="${sob.worknow == '我对现有工作还算满意，如有更好的工作机会，我也可以考虑(到岗时间另议)' }">selected="selected"</c:if> value="我对现有工作还算满意，如有更好的工作机会，我也可以考虑(到岗时间另议)" >我对现有工作还算满意，如有更好的工作机会，我也可以考虑(到岗时间另议)</option>
							<option <c:if test="${sob.worknow == '目前暂无跳槽打算' }">selected="selected"</c:if> value="目前暂无跳槽打算">目前暂无跳槽打算</option>
							<option <c:if test="${sob.worknow == '应届毕业生' }">selected="selected"</c:if> value="应届毕业生" >应届毕业生</option> 
						</select>
					</td>
					<th>期望工作地点：</th>
					<td>
					<input id="xx0" type="text" name="workaddress" value="${sob.workaddress }" />
					</td>
				</tr>
				<tr>
					<th>期望从事行业：</th>
					<td>
					<input id="xx1" type="text" name="specialty" value="${sob.specialty }"  />
					</td>
					<th>期望从事职业：</th>
					<td>
						<input id="xx2" type="text" name="job" value="${sob.job }" >
					</td>
				</tr>
				<tr>
					<th>税前期望月薪：</th>
					<td> <input type="text" name="emolument" value="${sob.emolument }" />
					</td>
					<th>期望工作性质：</th>
					<td>
						<input type="radio" name="checkbox" <c:if test="${sob.jobnature=='全职' }">checked="checked"</c:if> value="全职" >全职
						<input type="radio" name="checkbox" <c:if test="${sob.jobnature=='兼职' }">checked="checked"</c:if> value="兼职">兼职
						<input type="radio" name="checkbox" <c:if test="${sob.jobnature=='实习' }">checked="checked"</c:if> value="实习">实习
					</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
			<div class="tit" align="center">
				<h2>工作经验</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo" align="center">
				<tr>
					<th>公司名称：</th>
					<td>
						<input type="text" name="cname" value="${sob.cname }" />
					</td>
				</tr>
				<tr>
					<th>所属行业：</th>
					<td>
					<input type="text" name="manage" value="${sob.manage }">
					</td>
				</tr>
				<tr>
					<th>职位名称：</th>
					<td>
						<input type="text" name="specialtyago" value="${sob.specialtyago }" />
					</td>
				</tr>
				<tr>
					<th>职位类别：</th>
					<td>
					<input type="text" name="zwClass" value="${sob.zwClass }">
					</td>
				</tr>
				<tr>
					<th>在职时间：</th>
					<td>
						<input type="text" name="worktime" id="time1" value="${sob.worktime }" />(YYYY/MM/DD)
					</td>
				</tr>
				<tr>
					<th>税前月薪：</th>
					<td>
						<input type="text" name="salary"  value="${sob.salary }" />
					</td>
				</tr>
				<tr>
					<th>工作描述：</th>
					<td>
						<textarea rows="20" cols="100"  name="jobmiaoshu"  wrap="physical" >${sob.jobmiaoshu }
						</textarea>
					</td>
					<tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
			<div class="tit" align="center">
				<h2>项目经验</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo" align="center">
				<tr>
					<th>项目名称：</th>
					<td>
						<input type="text" name="proName" value="${sob.proName }" />
					</td>
				</tr>
				<tr>
					<th>项目时间：</th>
					<td>
						<input type="text" name="proTime" id="time1" value="${sob.proTime }" />
					</td>
				</tr>
				<tr>
					<th>项目描述：</th>
					<td>
						<textarea rows="20" cols="100" name="proDescripe"  placeholder="更完善的项目信息有助于快速找到你" wrap="physical">
							${sob.proDescripe }
						</textarea>
					</td>
				</tr>
				<tr>
					<th>个人职责：</th>
					<td>
						<textarea name="proDuty" id="description" placeholder="更完善的工作信息有助于提升你的竞争力" wrap="physical">
							${sob.proDuty }
						</textarea> 
					</td>
				</tr>
				<tr>
					<th>所属公司：</th>
					<td>
						<input type="text" name="proCompany" value="${sob.proCompany }" />
					</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
			<div class="tit" align="center">
				<h2>教育经历</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo" align="center">
				<tr>
					<th>学校名称：</th>
					<td>
						<input id="xx4" type="text" name="schName"  value="${sob.schName }" />
					</td>
				</tr>
				<tr>
					<th>就读时间：</th>
					<td>
						<input id="xx5" type="text" name="schTime" id="time1" value="${sob.schTime }" />
						
					</td>
				</tr>
				<tr>
					<th>所学专业：</th>
					<td>
						<input id="xx6" type="text" name="schProfe" value="${sob.schProfe }" />
					</td>
				</tr>
				<tr>
					<th>是否统招：</th>
					<td>
						<input type="radio" name="istzhao" value="是" <c:if test="${sob.istzhao=='是' }">checked="checked"</c:if>  />是
						<input type="radio" name="istzhao" value="否" <c:if test="${sob.istzhao=='否' }">checked="checked"</c:if> />否
					</td>
				</tr>
				<tr>
					<th>学历/学位：</th>
					<td> 
						<select name="degree" id="select">
							<option <c:if test="${sob.degree=='高中' }">selected="selected"</c:if>>高中</option>
							<option <c:if test="${sob.degree=='大专' }">selected="selected"</c:if>>大专</option>
							<option <c:if test="${sob.degree=='本科' }">selected="selected"</c:if>>本科</option>
							<option <c:if test="${sob.degree=='研究生' }">selected="selected"</c:if>>研究生</option>
							<option <c:if test="${sob.degree=='博士' }">selected="selected"</c:if>>博士</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
			<div class="tit" align="center">
				<h2>培训经历</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo" align="center">
				<tr>
					<th>培训时间：</th>
					<td>
						<input type="text" name="pxTime" id="time1" value="${sob.pxTime }" />
					</td>
				</tr>
				<tr>
					<th>培训机构：</th>
					<td>
						<input type="text" name="pxJigou" value="${sob.pxJigou }" />
					</td>
				</tr>
				<tr>
					<th>培训课程：</th>
					<td>
						<input type="text" name="pxClass" value="${sob.pxClass }" />
					</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
			<div class="tit" align="center">
				<h2>语言能力</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo" align="center">
				<tr>
					<th>语种：</th>
					<td>
						<input type="text" name="yyYuzhong"  value="${sob.yyYuzhong }" />
					</td>
				</tr>
				<tr>
					<th>听说能力：</th>
					<td> 
						<input type="radio" name="yyTs" <c:if test="${sob.yyTs=='一般' }">checked="checked"</c:if> value="一般" />一般
						<input type="radio" name="yyTs" <c:if test="${sob.yyTs=='良好' }">checked="checked"/></c:if> value="良好" /> 良好
						<input type="radio" name="yyTs" <c:if test="${sob.yyTs=='熟练' }">checked="checked"/></c:if> value="熟练" />熟练
						<input type="radio" name="yyTs" <c:if test="${sob.yyTs=='精通' }">checked="checked"/></c:if>  value="精通" />精通
					</td>
				</tr>
				<tr>
					<th>读写能力：</th>
					<td>
						<input type="radio" name="yyDx" <c:if test="${sob.yyDx=='一般' }">checked="checked"/></c:if>  value="一般"/>一般
						<input type="radio" name="yyDx"  <c:if test="${sob.yyDx=='良好' }">checked="checked"/></c:if> value="良好" />良好
						<input type="radio" name="yyDx" <c:if test="${sob.yyDx=='熟练' }">checked="checked"/></c:if> value="熟练" />熟练
						<input type="radio" name="yyDx" <c:if test="${sob.yyDx=='精通' }">checked="checked"/></c:if> value="精通" />精通
					</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
			<div class="tit" align="center">
				<h2>证书</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo" align="center">
				<tr>
					<th>证书名称：</th>
					<td>
						<input type="text" name="zsName" value="${sob.zsName }" />
					</td>
				</tr>
				<tr>
					<th>获得时间：</th>
					<td>
						<input type="date" name="zsTime" id="time1" value="${sob.zsTime }" />
					</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
			<div class="myInfo" align="center">
				<h2>自我评价</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo" align="center">
				<tr>
					<th style="width: 33px;">评价内容：</th>
					<td>
						<textarea wrap="physical" name="selfassess" id="description1" rows="30" cols="150" >
						${sob.selfassess }
						</textarea>
						
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
							<hr class="line" />
							<a href="#" class="a1" onclick="return savedata()">完成</a>
							<a href="#" onclick="javascript:history.back(-1);" class="a2">以后再说</a>
					</td>
				</tr>
			</table>
		</div>
		</form>
		<!-- 一条记录 结束 -->

		<div id="f1">Copyright 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
	</body>

</html>