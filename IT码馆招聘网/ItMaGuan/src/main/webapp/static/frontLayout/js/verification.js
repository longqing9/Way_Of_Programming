function ComInformation(){
	 var xx0 = document.getElementById("xx0").value.toUpperCase(); 
	 var xx1 = document.getElementById("xx1").value.toUpperCase(); 
	 var xx2 = document.getElementById("xx2").value.toUpperCase();
	 var xx3 = document.getElementById("xx3").value.toUpperCase(); 
	 var xx4 = document.getElementById("xx4").value.toUpperCase(); 
	 var xx5 = document.getElementById("xx5").value.toUpperCase(); 
	 var xx6 = document.getElementById("xx6").value.toUpperCase(); 
	 var xx7 = document.getElementById("xx7").value.toUpperCase(); 
	 if(xx0.length<=0){
 		alert("公司名称不能为空!!!");
 		return false;
 	 }
	 if(xx1.length<=0){
		 alert("所属行业不能为空!!!");
	 		return false;
	 }
	 if(xx2.length<=0){
		 alert("公司性质不能为空!!!");
	 		return false;
	 }
	 if(xx3.length<=0){
		 alert("公司规模不能为空!!!");
	 		return false;
	 }
	 if(xx4.length<=0){
		 alert("咨询电话不能为空!!!");
	 		return false;
	 }
	 if(xx5.length<=0){
		 alert("公司邮箱不能为空!!!");
	 		return false;
	 }
	 if(xx6.length<=0){
		 alert("公司地址不能为空!!!");
	 		return false;
	 }
	 if(xx7.length<=0){
		 alert("公司介绍不能为空!!!");
	 		return false;
	 }
	 return true;
}
function Cjob(){
	 var xx0 = document.getElementById("xx0").value.toUpperCase(); 
	 var xx1 = document.getElementById("xx1").value.toUpperCase(); 
	 var xx2 = document.getElementById("xx2").value.toUpperCase();
	 var xx3 = document.getElementById("xx3").value.toUpperCase(); 
	 var xx4 = document.getElementById("description1").value.toUpperCase(); 
	 if(xx0.length<=0){
		alert("岗位名称不能为空!!!");
		return false;
	 }
	 if(xx1.length<=0){
		 alert("专业要求不能为空!!!");
	 		return false;
	 }
	 if(xx2.length<=0){
		 alert("诚招薪水不能为空!!!");
	 		return false;
	 }
	 if(xx3.length<=0){
		 alert("工作地点不能为空!!!");
	 		return false;
	 }
	 if(xx4.length<=0){
		 alert("岗位要求不能为空!!!");
	 		return false;
	 }
	 return true;
}
function StuInformation(){
	 var xx0 = document.getElementById("xx0").value.toUpperCase(); 
	 var xx1 = document.getElementById("xx1").value.toUpperCase(); 
	 var xx2 = document.getElementById("xx2").value.toUpperCase();
	 var xx3 = document.getElementById("xx3").value.toUpperCase(); 
	 var xx4 = document.getElementById("xx4").value.toUpperCase(); 
	 var xx5 = document.getElementById("xx5").value.toUpperCase(); 
	 var xx6 = document.getElementById("xx6").value.toUpperCase(); 
	 var xx7 = document.getElementById("xx7").value.toUpperCase(); 
	 if(xx0.length<=0){
		alert("姓名不能为空!!!");
		return false;
	 }
	 if(xx1.length<=0){
		 alert("年龄不能为空!!!");
	 		return false;
	 }
	 if(xx2.length<=0){
		 alert("出生日期不能为空!!!");
	 		return false;
	 }
	 if(xx3.length<=0){
		 alert("参加工作时间不能为空!!!");
	 		return false;
	 }
	 if(xx4.length<=0){
		 alert("户籍不能为空!!!");
	 		return false;
	 }
	 if(xx5.length<=0){
		 alert("现居地不能为空!!!");
	 		return false;
	 }
	 if(xx6.length<=0){
		 alert("联系方式不能为空!!!");
	 		return false;
	 }
	 if(xx7.length<=0){
		 alert("电子邮箱不能为空!!!");
	 		return false;
	 }
	 return true;
}


function savedata() {
	var result="1";
	 var xx0 = document.getElementById("xx0").value; 
	 var xx1 = document.getElementById("xx1").value; 
	 var xx2 = document.getElementById("xx2").value;
	 var xx4 = document.getElementById("xx4").value; 
	 var xx5 = document.getElementById("xx5").value; 
	 var xx6 = document.getElementById("xx6").value; 
	 if(xx0.length<=0){
		alert("期望工作地点不能为空!!!");
		result= "0";
	 }
	 if(xx1.length<=0){
		 alert("期望行业不能为空!!!");
		 result="0";
	 }
	 if(xx2.length<=0){
		 alert("期望职业不能为空!!!");
		 result= "0";
	 }
	 if(xx4.length<=0){
		 alert("就读学校不能为空!!!");
		 result= "0";
	 }
	 if(xx5.length<=0){
		 alert("就读时间不能为空!!!");
		 result="0";
	 }
	 if(xx6.length<=0){
		 alert("所学专业不能为空!!!");
		 result="0";
	 }
	if(confirm("提交数据")){
		if(result=="1")
			document.getElementById("myform").submit();
	}
	
}





function Sturesume(){
	 var xx0 = document.getElementById("xx0").value.toUpperCase(); 
	 var xx1 = document.getElementById("xx1").value.toUpperCase(); 
	 var xx2 = document.getElementById("xx2").value.toUpperCase();
	 var xx4 = document.getElementById("xx4").value.toUpperCase(); 
	 var xx5 = document.getElementById("xx5").value.toUpperCase(); 
	 var xx6 = document.getElementById("xx6").value.toUpperCase(); 
	 var xx7 = document.getElementById("description1").value.toUpperCase(); 
	 var s;
	 if(xx0.length<=0){
		alert("期望工作地点不能为空!!!");
		return false;
	 }
	 if(xx1.length<=0){
		 alert("期望行业不能为空!!!");
	 		return false;
	 }
	 if(xx2!=password){
		 alert("期望职业不能为空!!!");
	 		return false;
	 }
	 if(xx4.length<=0){
		 alert("就读学校不能为空!!!");
	 		return false;
	 }
	 if(xx5.length<=0){
		 alert("就读时间不能为空!!!");
	 		return false;
	 }
	 if(xx6.length<=0){
		 alert("所学专业不能为空!!!");
	 		return false;
	 }
	 if(xx7.length<=0){
		 alert("自我评价不能为空!!!");
	 		return false;
	 }
	 return 100;
}


