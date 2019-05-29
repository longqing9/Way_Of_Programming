// JavaScript Document


/**
 * 当在页码输入框中按了回车后，就会提交分页表单
 */
function submitPaginationFormByInput( event, pageNum ){
	if( event.keyCode == 13 ){
		gotoPage(pageNum);
		return false;
	}
}



function gotoPage( pageNum ){
	if( typeof(pageCount) == "undefined" ){
		alert("请指定总页码数（定义变量pageCount）！");
		return;
	}	
	
	// 找出输入页面的文本框
	var pageNumInput = document.getElementById("PageSelector_PageNumInput");

	var paginationForm = document.getElementById("paginationForm");
	if( paginationForm == null ){
		paginationForm = document.forms[0];
	}
	if( paginationForm == null ){
		alert("找不到分页用的表单！");
		return;
	}
	
	// 解决小数点的问题（去掉小数点后的数字）
	pageNum = parseInt(pageNum);

	// 如果不是数字，就提示错误
	if( pageNum == "" || isNaN(pageNum) ){
		alert("请填写正确的页码数字！范围是 1-" + pageCount);
		if( pageNumInput != null ){
			pageNumInput.focus();
			pageNumInput.select();
		}
		return;
	}
		
	// 如果数字超出页码范围，就提示错误
	if( pageNum < 1 || pageNum > pageCount ){
		alert("请填写正确的页码！范围是 1-" + pageCount);
		if( pageNumInput != null ){
			pageNumInput.focus();
			pageNumInput.select();
		}
		return;
	}
	
	// 如果找不到名为"pageNum"的字段，就增加一个，用于传递页码参数。
	if(	paginationForm.pageNum == null ){
		var pageNumInput = document.createElement("<input type='hidden' name='pageNum' value='1'/>");
		paginationForm.appendChild(pageNumInput);
	}
	
	// 处理pageSize
	var pageSize =  $("#PaginationBar_PageSizeSelector").val();	
	
	// 如果找不到名为"pageSize"的字段，就增加一个。
	if(	paginationForm.pageSize == null ){
		var pageSizeField= document.createElement("<input type='hidden' name='pageSize' value='" + pageSize + "'/>");
		paginationForm.appendChild(pageSizeField);
		//alert("new ");
	}else{
		$(paginationForm.pageSize).val( pageSize );
		//alert("old ");
	}
	
	//alert(pageSize);
	//alert( $(paginationForm.pageSize).val() );
	
	// 修改页码值后提交表单
	paginationForm.pageNum.value = pageNum;
	paginationForm.submit();
}


/**
 * 删除前的确认提示
 */
function delConfirm(){
	return window.confirm("您确定要删除一条记录码？");	
}

/*
 * 答案提交前校验，不能为空或者为使用空格
 */
/*function Isnull(){
	alert($("#LAY_demo_editor").val());
	if($("#LAY_demo_editor").val()=="" ||$.trim($("#LAY_demo_editor").val()).length<0){
		alert("答案不能为空！！!");
		return false;
	}
	else{
		true;
	}	
}*/

/**
 * （使用模式对活框）显示图片
 */ 
function showImage( url, width, height ){
	var sFeatures = "resizable: yes; ";
	if( width != null ){
		sFeatures += "dialogWidth:" + width + "px; ";
	}
	if( height != null ){
		sFeatures += "dialogHeight:" + height + "px; ";
	}
	window.showModalDialog(url, null, sFeatures);
}

