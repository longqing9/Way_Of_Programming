<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息显示</title>
		<style type="text/css">
			.main{
				background-color: #F3F9FD;
			}
			.container{
				margin-top: 5%;
				
				width: 100%;
				height: 100%;
			}
			
			.rowclearfix{
				
				width: 100%;
			} 
			.pic{
				border: 1px solid black;
				width: 120px;
				height: 120px;
				margin-left: 40%;
			}
			.teatno{
				padding-top: 5px;
				margin-left: 38%;
			}
			.tlbl{
				padding-top: 5px;
				margin-left: 38%;
			}
		</style>
	</head>
	<body class="main">
		<div class="container">
        	<div class="rowclearfix">
          		<div class="pic">
                    <img src="/pic/${Student.spic }" width="120px" height="120px" />
               </div>
              
            </div>
            <div class="rowclearfix">
          		<div class="teatno">
                    <span>学号：</span> &nbsp;&nbsp;&nbsp;<span>${Student.sno }</span>
               </div>
            </div>
            <div class="rowclearfix">
          		<div class="tlbl">
                    <span>姓名：</span> &nbsp;&nbsp;&nbsp;<span>${Student.sname }</span>
                </div>
                <div class="tlbl">
                    <span>性别：</span> &nbsp;&nbsp;&nbsp;<span>${Student.ssex }</span>
                </div>
            </div>
            <div class="rowclearfix">
          		<div class="tlbl">
                    <span>学院：</span> &nbsp;&nbsp;&nbsp;<span>${Student.college }</span>
                </div>
                <div class="tlbl">
                    <span>班级：</span> &nbsp;&nbsp;&nbsp;<span>${Student.classname }</span>
                </div>
            </div>
            <div class="rowclearfix">
                <div class="tlbl">
                    <span>专业：</span> &nbsp;&nbsp;&nbsp;<span>${Student.profession }</span>
                </div>
            </div>
            <div class="rowclearfix">
                <div class="tlbl">
                    <span style="width: 40%; padding-left: 0px;">联系方式：</span> <span>${Student.stel }</span>
                </div>
            </div>
        </div>
	</body>
</html>
