<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人简历</title>
		<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/resume.css" />
		<script src="${ctxStatic}/jquery/jquery-1.9.1.js" ></script>
		<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		function upth(){
			var other =document.getElementById("other").value;
			var id =document.getElementById("id").value;
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath }/Saveresumeother",
				data:{id:id,other:other},
				dataType:"text",
				success:function(data){
					alert(data);
				}
			});
		}

	</script>
	</head>

	<body>
		<div id="header">
			<p>&nbsp;&nbsp;
				<font face="微软雅黑" size="6">|</font>&nbsp;&nbsp;
				<font face="微软雅黑" size="6">我的简历</font>
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
		<hr color="#BBBBBB" style="height: 5px;" width="100%">
		<div id="gll">
			<div id="gll">
				<a href="${pageContext.request.contextPath }/com_logout">退出</a>
				<a href="#" onclick="javascript:history.back(-1)">返回上一页</a>
				<a href="${pageContext.request.contextPath }/Com_firmHomepage.action">首页</a>
			</div>
		</div>
		<div class="tit" align="center">
			<h1>我的简历</h1>
		</div>

		<div id="main">
			<div class="tit" align="center">
				<h2>个人信息</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo1">
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
					<td>
					<fmt:formatDate value="${stud.birthday }" pattern="yyyy年MM月dd日"/>
					</td>
				</tr>
				<tr>
					<th>参加工作时间：</th>
					<td><fmt:formatDate value="${stud.worktime }" pattern="yyyy年MM月dd日"/></td>
					<th>现居地：</th>
					<td>${stud.nowadress }</td>
				</tr>
				<tr>
					<th>学历：</th>
					<td>${stud.knowledge }</td>
					<th>户籍所在地:</th>
					<td>${stud.huji }</td>
				</tr>
				<tr>
					<th>联系方式:</th>
					<td>${stud.tell }</td>
					<th>邮箱：</th>
					<td>${stud.email }</td>
				</tr>
			</table>
		</div>
		<!-- 一条记录 结束 -->
		<!-- 一条记录 开始 -->
		<div id="main">
		<input type="hidden" id="id" value="${sobz.id }" />
			<div class="tit" align="center">
				<h2>求职意向</h2>
				<div class="titText"></div>
			</div>
			<table class="myInfo1" align="center">
				<tr>
					<th>求职状态：</th>
					<td>
						${sobz.worknow }
					</td>
					<th>期望工作地点：</th>
					<td>
						${sobz.workaddress }
					</td>
				</tr>
				<tr>
					<th>期望从事行业：</th>
					<td>
						${sobz.specialty }
					</td>
					<th>期望从事职业：</th>
					<td>
						${sobz.job }
					</td>
				</tr>
				<tr>
					<th>期望月薪：</th>
					<td>
						${sobz.emolument }
					</td>
					<th>期望工作性质：</th>
					<td>
						${sobz.jobnature }
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
						${sobz.cname }
					</td>
				</tr>
				<tr>
					<th>所属行业：</th>
					<td>
						${sobz.manage }
					</td>
				</tr>
				<tr>
					<th>职位名称：</th>
					<td>
						${sobz.specialtyago }
					</td>
				</tr>
				<tr>
					<th>职位类别：</th>
					<td>
						${sobz.zwClass }
					</td>
				</tr>
				<tr>
					<th>在职时间：</th>
					<td>
						${sobz.worktime }
					</td>
				</tr>
				<tr>
					<th>税前月薪：</th>
					<td>
						${sobz.salary }
				</tr>
				<tr>
					<th>工作描述：</th>
					<td>
					<div style="width: "></div>
						 <textarea rows="20" cols="100"  wrap="physical" >
							${sobz.jobmiaoshu }
							
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
						${sobz.proName }
					</td>
				</tr>
				<tr>
					<th>项目时间：</th>
					<td>
						${sobz.proTime }
					</td>
				</tr>
				<tr>
					<th>项目描述：</th>
					<td>
						<textarea rows="20" cols="100" wrap="physical">
							${sobz.proDescripe }
						</textarea>
					</td>
				</tr>
				<tr>
					<th>个人职责：</th>
					<td>
						<div class="protext">${sobz.proDuty }</div>
					</td>
				</tr>
				<tr>
					<th>所属公司：</th>
					<td>
						${sobz.proCompany }
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
						${sobz.schName }
					</td>
				</tr>
				<tr>
					<th>就读时间：</th>
					<td>
						${sobz.schTime }
						
					</td>
				</tr>
				<tr>
					<th>所学专业：</th>
					<td>
						${sobz.schProfe }
					</td>
				</tr>
				<tr>
					<th>是否统招：</th>
					<td>
						${sobz.istzhao }
					</td>
				</tr>
				<tr>
					<th>学历/学位：</th>
					<td>
						${sobz.degree }
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
						${sobz.pxTime }
					</td>
				</tr>
				<tr>
					<th>培训机构：</th>
					<td>
						${sobz.pxJigou }
					</td>
				</tr>
				<tr>
					<th>培训课程：</th>
					<td>
						${sobz.pxClass }
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
						${sobz.yyYuzhong }
					</td>
				</tr>
				<tr>
					<th>听说能力：</th>
					<td>
					${sobz.yyTs }
						
					</td>
				</tr>
				<tr>
					<th>读写能力：</th>
					<td>
						${sobz.yyDx }
						
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
						${sobz.zsName }
					</td>
				</tr>
				<tr>
					<th>获得时间：</th>
					<td>
						${sobz.zsTime }
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
			<table class="myInfo" >
				<tr>
					<th>评价内容：</th>
					<td>
					<div>${sobz.selfassess }</div>
					
					
					</td>
				</tr>
					<tr>
						<th>简历状态：</th>
						<td>
							<select name="other" class="other" id="other">   
						        <option value="已查阅">已查阅</option>   
						        <option value="不符合">不符合</option>   
						        <option value="已查阅">待沟通</option>    
						    </select>
						    <a href="#">
						    <input type="button" value="提交保存" onclick="upth()" /></a>
						</td>
					</tr>
					
			</table>
		</div>
		<!-- 一条记录 结束 -->
		

		<div id="f1">Copyright 2012 itmag.com All rights reserved. | 苏ICP备12067872号 </div>
	</body>
	

</html>