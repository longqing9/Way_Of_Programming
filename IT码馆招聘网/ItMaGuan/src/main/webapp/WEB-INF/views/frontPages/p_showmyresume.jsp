<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>个人简历</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/resume.css" />
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
		<div id="main">
			<div class="tit" align="center">
				<h2>求职意向</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo1" align="center">
				<tr>
					<th>求职状态：</th>
					<td>
						${sob.worknow }
					</td>
					<th>期望工作地点：</th>
					<td>
						${sob.workaddress }
					</td>
				</tr>
				<tr>
					<th>期望从事行业：</th>
					<td>
						${sob.specialty }
					</td>
					<th>期望从事职业：</th>
					<td>
						${sob.job }
					</td>
				</tr>
				<tr>
					<th>税前期望月薪：</th>
					<td>
						${sob.emolument }
					</td>
					<th>期望工作性质：</th>
					<td>
						${sob.jobnature }
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
						${sob.cname }
					</td>
				</tr>
				<tr>
					<th>所属行业：</th>
					<td>${sob.manage }
					</td>
				</tr>
				<tr>
					<th>职位名称：</th>
					<td>
						${sob.specialtyago }
					</td>
				</tr>
				<tr>
					<th>职位类别：</th>
					<td>
					${sob.zwClass }
						
					</td>
				</tr>
				<tr>
					<th>在职时间：</th>
					<td>
						${sob.worktime }
					</td>
				</tr>
				<tr>
					<th>税前月薪：</th>
					<td>
						${sob.salary }
				</tr>
				<tr>
					<th>工作描述：</th>
					<td>
						<textarea rows="20" cols="100"  wrap="physical" >
							${sob.jobmiaoshu }
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
						${sob.proName }
					</td>
				</tr>
				<tr>
					<th>项目时间：</th>
					<td>
						${sob.proTime }
					</td>
				</tr>
				<tr>
					<th>项目描述：</th>
					<td>
						<textarea rows="20" cols="100" wrap="physical">
						${sob.proDescripe }
						</textarea>
					</td>
				</tr>
				<tr>
					<th>个人职责：</th>
					<td>
						<%-- <textarea rows="20" cols="100"  wrap="physical">
							${sob.proDuty }
						</textarea> --%>
						<div class="protext">${sob.proDuty }</div>
					</td>
				</tr>
				<tr>
					<th>所属公司：</th>
					<td>
						${sob.proCompany }
					</td>
				</tr>
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
					<th>学校名称：</th>
					<td>
						${sob.schName }
					</td>
				</tr>
				<tr>
					<th>就读时间：</th>
					<td>
						${sob.schTime }
						
					</td>
				</tr>
				<tr>
					<th>所学专业：</th>
					<td>
						${sob.schProfe }
					</td>
				</tr>
				<tr>
					<th>是否统招：</th>
					<td>
						${sob.istzhao }
					</td>
				</tr>
				<tr>
					<th>学历/学位：</th>
					<td>
						${sob.degree }
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
						${sob.pxTime }
					</td>
				</tr>
				<tr>
					<th>培训机构：</th>
					<td>
						${sob.pxJigou }
					</td>
				</tr>
				<tr>
					<th>培训课程：</th>
					<td>
						${sob.pxClass }
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
						${sob.yyYuzhong }
					</td>
				</tr>
				<tr>
					<th>听说能力：</th>
					<td>
					${sob.yyTs }
					</td>
				</tr>
				<tr>
					<th>读写能力：</th>
					<td>
						${sob.yyDx }
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
						${sob.zsName }
					</td>
				</tr>
				<tr>
					<th>获得时间：</th>
					<td>
						${sob.zsTime }
					</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
			<div class="tit" align="center">
				<h2>自我评价</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo" align="center">
				<tr>
					<td>评价内容：
						<div class="protext">${sob.selfassess }</div>
					</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<div id="f1">Copyright 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
	</body>

</html>