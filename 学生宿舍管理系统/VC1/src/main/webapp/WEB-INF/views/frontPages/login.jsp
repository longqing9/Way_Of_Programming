<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>ç»å½</title>
<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/normalize.css">
<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/login.css">
<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/sign-up-login.css">
<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/inputEffect.css" />
<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/tooltips.css" />
<link rel="stylesheet" href="${ctxStatic}/frontLayout/css/spop.min.css" />

<script src="${ctxStatic}/frontLayout/js/jquery.min.js"></script>
<script src="${ctxStatic}/frontLayout/js/snow.js"></script>
<script src="${ctxStatic}/frontLayout/js/jquery.pure.tooltips.js"></script>
<script src="${ctxStatic}/frontLayout/js/spop.min.js"></script>
<script>	
	(function() {
		// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
		if (!String.prototype.trim) {
			(function() {
				// Make sure we trim BOM and NBSP
				var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
				String.prototype.trim = function() {
					return this.replace(rtrim, '');
				};
			})();
		}

		[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
			// in case the input is already filled..
			if( inputEl.value.trim() !== '' ) {
				classie.add( inputEl.parentNode, 'input--filled' );
			}

			// events:
			inputEl.addEventListener( 'focus', onInputFocus );
			inputEl.addEventListener( 'blur', onInputBlur );
		} );

		function onInputFocus( ev ) {
			classie.add( ev.target.parentNode, 'input--filled' );
		}

		function onInputBlur( ev ) {
			if( ev.target.value.trim() === '' ) {
				classie.remove( ev.target.parentNode, 'input--filled' );
			}
		}
	})();
	
	$(function() {	
		$('#login #login-password').focus(function() {
			$('.login-owl').addClass('password');
		}).blur(function() {
			$('.login-owl').removeClass('password');
		});
		$('#login #register-password').focus(function() {
			$('.register-owl').addClass('password');
		}).blur(function() {
			$('.register-owl').removeClass('password');
		});
		$('#login #register-repassword').focus(function() {
			$('.register-owl').addClass('password');
		}).blur(function() {
			$('.register-owl').removeClass('password');
		});
		$('#login #forget-password').focus(function() {
			$('.forget-owl').addClass('password');
		}).blur(function() {
			$('.forget-owl').removeClass('password');
		});
	});
	
	function goto_register(){
		$("#register-username").val("");
		$("#register-password").val("");
		$("#register-repassword").val("");
		$("#register-code").val("");
		$("#tab-2").prop("checked",true);
	}
	
	function goto_login(){
		$("#login-username").val("");
		$("#login-password").val("");
		$("#tab-1").prop("checked",true);
	}
	
	function goto_forget(){
		$("#forget-username").val("");
		$("#forget-password").val("");
		$("#forget-code").val("");
		$("#tab-3").prop("checked",true);
	}
	
	function login(){//ç»å½
		var username = $("#login-username").val(),
			password = $("#login-password").val(),
			validatecode = null,
			flag = false;
		//å¤æ­ç¨æ·åå¯ç æ¯å¦ä¸ºç©º
		if(username == ""){
			$.pt({
        		target: $("#login-username"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"用户名不能为空"
        	});
			flag = true;
		}
		if(password == ""){
			$.pt({
        		target: $("#login-password"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"密码不能为空"
        	});
			flag = true;
		}
		//ç¨æ·ååªè½æ¯15ä½ä»¥ä¸çå­æ¯ææ°å­
		var regExp = new RegExp("^[a-zA-Z0-9_]{1,15}$");
		if(!regExp.test(username)){
			$.pt({
        		target: $("#login-username"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"ç¨æ·åå¿é¡»ä¸º15ä½ä»¥ä¸çå­æ¯ææ°å­"
        	});
			flag = true;
		}
		
		if(flag){
			return false;
		}else{//ç»å½
			//è°ç¨åå°ç»å½éªè¯çæ¹æ³
			alert('ç»å½æå');
			return false;
		}
	}
	
	//æ³¨å
	function register(){
		var username = $("#register-username").val(),
			password = $("#register-password").val(),
			repassword = $("#register-repassword").val(),
			code = $("#register-code").val(),
			flag = false,
			validatecode = null;
		//å¤æ­ç¨æ·åå¯ç æ¯å¦ä¸ºç©º
		if(username == ""){
			$.pt({
        		target: $("#register-username"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"ç¨æ·åä¸è½ä¸ºç©º"
        	});
			flag = true;
		}
		if(password == ""){
			$.pt({
        		target: $("#register-password"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"å¯ç ä¸è½ä¸ºç©º"
        	});
			flag = true;
		}else{
			if(password != repassword){
				$.pt({
	        		target: $("#register-repassword"),
	        		position: 'r',
	        		align: 't',
	        		width: 'auto',
	        		height: 'auto',
	        		content:"ä¸¤æ¬¡è¾å¥çå¯ç ä¸ä¸è´"
	        	});
				flag = true;
			}
		}
		//ç¨æ·ååªè½æ¯15ä½ä»¥ä¸çå­æ¯ææ°å­
		var regExp = new RegExp("^[a-zA-Z0-9_]{1,15}$");
		if(!regExp.test(username)){
			$.pt({
        		target: $("#register-username"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"ç¨æ·åå¿é¡»ä¸º15ä½ä»¥ä¸çå­æ¯ææ°å­"
        	});
			flag = true;
		}
		//æ£æ¥ç¨æ·åæ¯å¦å·²ç»å­å¨
		//è°åå°ä»£ç æ£æ¥ç¨æ·åæ¯å¦å·²ç»è¢«æ³¨å
		
		//æ£æ¥æ³¨åç æ¯å¦æ­£ç¡®
		//è°åå°æ¹æ³æ£æ¥æ³¨åç ï¼è¿éåæ­»ä¸º11111111
		if(code != '11111111'){
			$.pt({
		        target: $("#register-code"),
		        position: 'r',
		        align: 't',
		        width: 'auto',
		        height: 'auto',
		        content:"æ³¨åç ä¸æ­£ç¡®"
		       });
			flag = true;
		}
		
		
		if(flag){
			return false;
		}else{//æ³¨å
			spop({			
				template: '<h4 class="spop-title">æ³¨åæå</h4>å³å°äº3ç§åè¿åç»å½',
				position: 'top-center',
				style: 'success',
				autoclose: 3000,
				onOpen : function(){
					var second = 2;
					var showPop = setInterval(function(){
						if(second == 0){
							clearInterval(showPop);
						}
						$('.spop-body').html('<h4 class="spop-title">æ³¨åæå</h4>å³å°äº'+second+'ç§åè¿åç»å½');
						second--;
					},1000);
				},
				onClose : function(){
					goto_login();
				}
			});
			return false;
		}
	}
	
	//éç½®å¯ç 
	function forget(){
		var username = $("#forget-username").val(),
			password = $("#forget-password").val(),
			code = $("#forget-code").val(),
			flag = false,
			validatecode = null;
		//å¤æ­ç¨æ·åå¯ç æ¯å¦ä¸ºç©º
		if(username == ""){
			$.pt({
        		target: $("#forget-username"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"ç¨æ·åä¸è½ä¸ºç©º"
        	});
			flag = true;
		}
		if(password == ""){
			$.pt({
        		target: $("#forget-password"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"å¯ç ä¸è½ä¸ºç©º"
        	});
			flag = true;
		}
		//ç¨æ·ååªè½æ¯15ä½ä»¥ä¸çå­æ¯ææ°å­
		var regExp = new RegExp("^[a-zA-Z0-9_]{1,15}$");
		if(!regExp.test(username)){
			$.pt({
        		target: $("#forget-username"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"ç¨æ·åå¿é¡»ä¸º15ä½ä»¥ä¸çå­æ¯ææ°å­"
        	});
			flag = true;
		}
		//æ£æ¥ç¨æ·åæ¯å¦å­å¨
		//è°åå°æ¹æ³
		
		//æ£æ¥æ³¨åç æ¯å¦æ­£ç¡®
		if(code != '11111111'){
			$.pt({
		        target: $("#forget-code"),
		        position: 'r',
		        align: 't',
		        width: 'auto',
		        height: 'auto',
		        content:"æ³¨åç ä¸æ­£ç¡®"
		       });
			flag = true;
		}
		
		
		
		if(flag){
			return false;
		}else{//éç½®å¯ç 
			spop({			
				template: '<h4 class="spop-title">éç½®å¯ç æå</h4>å³å°äº3ç§åè¿åç»å½',
				position: 'top-center',
				style: 'success',
				autoclose: 3000,
				onOpen : function(){
					var second = 2;
					var showPop = setInterval(function(){
						if(second == 0){
							clearInterval(showPop);
						}
						$('.spop-body').html('<h4 class="spop-title">éç½®å¯ç æå</h4>å³å°äº'+second+'ç§åè¿åç»å½');
						second--;
						},1000);
				},
				onClose : function(){
					goto_login();
				}
			});
			return false;
		}
	}
	
	
	
	
	
	
	
</script>
<style type="text/css">
html{width: 100%; height: 100%;}

body{

	background-repeat: no-repeat;

	background-position: center center #2D0F0F;

	background-color: #00BDDC;

	background-image: url(${ctxStatic}/frontLayout/images/snow.jpg);

	background-size: 100% 100%;

}

.snow-container { position: fixed; top: 0; left: 0; width: 100%; height: 100%; pointer-events: none; z-index: 100001; }

</style>
</head>
<body>
	<!-- éªè±èæ¯ -->
	<div class="snow-container"></div>
	<!-- ç»å½æ§ä»¶ -->
	<div id="login">
		<input id="tab-1" type="radio" name="tab" class="sign-in hidden" checked />
		<input id="tab-2" type="radio" name="tab" class="sign-up hidden" />
		<input id="tab-3" type="radio" name="tab" class="sign-out hidden" />
		<div class="wrapper">
			<!-- ç»å½é¡µé¢ -->
			<div class="login sign-in-htm">
				<form class="container offset1 loginform">
					<!-- ç«å¤´é¹°æ§ä»¶ -->
					<div id="owl-login" class="login-owl">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad input-container">
						<section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="login-username" 
									autocomplete="off" placeholder="è¯·è¾å¥ç¨æ·å" tabindex="1" maxlength="15" />
								<label class="input__label input__label--hideo" for="login-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="login-password" placeholder="è¯·è¾å¥å¯ç " tabindex="2" maxlength="15"/>
								<label class="input__label input__label--hideo" for="login-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
						</section>
					</div>
					<div class="form-actions">
						<a tabindex="4" class="btn pull-left btn-link text-muted" onClick="goto_forget()">å¿è®°å¯ç ?</a>
						<a tabindex="5" class="btn btn-link text-muted" onClick="goto_register()">æ³¨å</a>
						<input class="btn btn-primary" type="button" tabindex="3" onClick="login()" value="ç»å½" 
							style="color:white;"/>
					</div>
				</form>
			</div>
			<!-- å¿è®°å¯ç é¡µé¢ -->
			<div class="login sign-out-htm">
				<form action="#" method="post" class="container offset1 loginform">
					<!-- ç«å¤´é¹°æ§ä»¶ -->
					<div id="owl-login" class="forget-owl">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad input-container">
						<section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="forget-username" autocomplete="off" placeholder="è¯·è¾å¥ç¨æ·å"/>
								<label class="input__label input__label--hideo" for="forget-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="forget-code" autocomplete="off" placeholder="è¯·è¾å¥æ³¨åç "/>
								<label class="input__label input__label--hideo" for="forget-code">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="forget-password" placeholder="è¯·éç½®å¯ç " />
								<label class="input__label input__label--hideo" for="forget-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
						</section>
					</div>
					<div class="form-actions">
						<a class="btn pull-left btn-link text-muted" onClick="goto_login()">è¿åç»å½</a>
						<input class="btn btn-primary" type="button" onClick="forget()" value="éç½®å¯ç " 
							style="color:white;"/>
					</div>
				</form>
			</div>
			<!-- æ³¨åé¡µé¢ -->
			<div class="login sign-up-htm">
				<form action="#" method="post" class="container offset1 loginform">
					<!-- ç«å¤´é¹°æ§ä»¶ -->
					<div id="owl-login" class="register-owl">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad input-container">
						<section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="register-username" 
									autocomplete="off" placeholder="è¯·è¾å¥ç¨æ·å" maxlength="15"/>
								<label class="input__label input__label--hideo" for="register-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="register-password" placeholder="è¯·è¾å¥å¯ç " maxlength="15"/>
								<label class="input__label input__label--hideo" for="register-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="register-repassword" placeholder="è¯·ç¡®è®¤å¯ç " maxlength="15"/>
								<label class="input__label input__label--hideo" for="register-repassword">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="register-code" autocomplete="off" placeholder="è¯·è¾å¥æ³¨åç "/>
								<label class="input__label input__label--hideo" for="register-code">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
						</section>
					</div>
					<div class="form-actions">
						<a class="btn pull-left btn-link text-muted" onClick="goto_login()">è¿åç»å½</a>
						<input class="btn btn-primary" type="button" onClick="register()" value="æ³¨å" 
							style="color:white;"/>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>