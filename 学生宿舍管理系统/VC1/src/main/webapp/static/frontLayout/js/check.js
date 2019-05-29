function validate(){  
    var title = document.getElementById("title").value.toUpperCase(); 
    if(title.length <= 0) { //若输入的验证码长度为0  
        alert("请输入验证码！"); //则弹出请输入验证码 
        return false;
    }else {  
        return true;
    }
}