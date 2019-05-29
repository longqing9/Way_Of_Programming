var code ; //在全局定义验证码         
function createCode(){
     code = "";   
     var codeLength = 4;//验证码的长度  
     var checkCode = document.getElementById("code");   
     var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G',
     'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y',
     'Z');//随机数  
     for(var i = 0; i < codeLength; i++) {//循环操作  
        var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
        code += random[index];//根据索引取得随机数加到code上  
    }  
    checkCode.value = code;//把code值赋给验证码  
}
//校验验证码  
function validate(){  
    var inputCode = document.getElementById("input").value.toUpperCase(); 
    var username = document.getElementById("username").value.toUpperCase(); 
    var password = document.getElementById("password").value.toUpperCase(); 
    //取得输入的验证码并转化为大写        
    if(inputCode.length <= 0) { //若输入的验证码长度为0  
        alert("请输入验证码！"); //则弹出请输入验证码 
        return false;
    }else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时  
        alert("验证码输入错误!"); //则弹出验证码输入错误  
        createCode();//刷新验证码  
        document.getElementById("input").value = "";//清空文本框
        return false;
    }else {  
    	if(username.length<=0){
    		alert("请输入账号！！");
    		createCode();//刷新验证码  
            document.getElementById("input").value = "";//清空文本框
    		return false;
    	}
    	if(password.length<=0){
    		alert("请输入密码！！！");
    		createCode();//刷新验证码  
            document.getElementById("input").value = "";//清空文本框
    		return false;
    	}
        return true;
    }
}

function Comregister(){
	 var name = document.getElementById("name").value.toUpperCase(); 
	 var inputCode = document.getElementById("input").value.toUpperCase(); 
	 var city = document.getElementById("city").value.toUpperCase(); 
	 var username = document.getElementById("username").value.toUpperCase(); 
	 var password = document.getElementById("password").value.toUpperCase(); 
	 var tel = document.getElementById("tel").value.toUpperCase(); 
	 var email = document.getElementById("email").value.toUpperCase(); 
	 if(inputCode.length <= 0) { //若输入的验证码长度为0  
	        alert("请输入验证码！"); //则弹出请输入验证码 
	        return false;
	    }else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时  
	        alert("验证码输入错误!"); //则弹出验证码输入错误  
	        createCode();//刷新验证码  
	        document.getElementById("input").value = "";//清空文本框
	        return false;
	    }else {  
	    	if(name.length<=0){
	    		alert("请输入单位名称！！！");
	    		createCode();//刷新验证码  
	            document.getElementById("input").value = "";//清空文本框
	    		return false;
	    	}
	    	if(city.length<=0){
	    		alert("请输入企业所在位置！！！");
	    		createCode();//刷新验证码  
	            document.getElementById("input").value = "";//清空文本框
	    		return false;
	    	}
	    	if(tel.length<=0){
	    		alert("请输入联系方式！！！");
	    		createCode();//刷新验证码  
	            document.getElementById("input").value = "";//清空文本框
	    		return false;
	    	}
	    	if(email.length<=0){
	    		alert("请输入邮箱！！！");
	    		createCode();//刷新验证码  
	            document.getElementById("input").value = "";//清空文本框
	    		return false;
	    	}
	    	if(username.length<=0){
	    		alert("请输入账号！！");
	    		createCode();//刷新验证码  
	            document.getElementById("input").value = "";//清空文本框
	    		return false;
	    	}
	    	if(password.length<=0){
	    		alert("请输入密码！！！");
	    		createCode();//刷新验证码  
	            document.getElementById("input").value = "";//清空文本框
	    		return false;
	    	}
	        return true;
	    }
}

function StudRegister(){
	 var username = document.getElementById("username").value.toUpperCase(); 
	 var password = document.getElementById("password").value.toUpperCase(); 
	 var rePassword = document.getElementById("rePassword").value.toUpperCase();
	 var realName = document.getElementById("realName").value.toUpperCase(); 
	 var email = document.getElementById("Email").value.toUpperCase(); 
	 if(username.length<=0){
 		alert("请输入用户名！！！");
 		return false;
 	 }
	 if(password.length<=0){
	 		alert("请输入密码！！！");
	 		return false;
	 }
	 if(rePassword!=password){
	 		alert("密码不一致，请重新输入！！！");
	 		document.getElementById("rePassword").value = "";//清空文本框
	 		return false;
	 }
	 if(realName.length<=0){
	 		alert("请输入真实姓名！！！");
	 		return false;
	 }
	 if(email.length<=0){
	 		alert("请输入邮箱！！！");
	 		return false;
	 }
	 return true;
}














        
        