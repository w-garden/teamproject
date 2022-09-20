<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>파트너스 로그인</title>
<link rel="stylesheet" href="/Partners/css/main_style.css">
<link rel="stylesheet" href="/Partners/css/join_style.css">

<script src="/Partners/js/jquery.js"></script>
<script src="/Partners/js/javascript.js"></script>
<style>


</style>


</head>
<body>


	<article id="join_wrap">
		

		<div id= signin_cont>
			<div id="signin_title">
					<div><a href="/DoZip/index.jsp">
						<img src="images/partners_logo.png" alt="메인로고"></a></div>
			</div>
			<form action="partners_login_ok.do" method="post" id="로그인 폼" onsubmit="return check()">
				<div><input type="text" name="login_pId" id="signin_id" placeholder="아이디"></div>
				<div><input type="password" name="login_pPw" id="signin_pw" placeholder="비밀번호"></div>
				<div><input type="submit" value="로그인" id="login"></div>
				<div id=bottom_button1>
					<div id=id_save>
					<div><input type="checkbox" id=id_save_checkbox></div>		
					<div><button type="button" id=id_save_button>아이디 저장</button></div>
					</div>
					<div> <input type="button" id="signup_button" value="회원가입" onclick="location='partners_signup.do'"></div>
				</div>
			</form>
			<div id=bottom_button2>
				<div> 아이디 또는 비밀번호를 잃어버리셨다면 ?</div>
				<div><input type="button" id="" value="문의하기" onclick="location='partners_findinfo.do'"></div>
			</div>
		
		
		</div>
	
	
		<script>
		
			/* 유효성 검증 */
			function check(){
				if($.trim($('#signin_id').val())==''){
					alert('아이디를 입력하세요');
					$('#id').focus();
					return false;
				}
				if($.trim($('#signin_pw').val())==''){
					alert('비밀번호를 입력하세요');
					$('#pw').focus();
					return false;
				}
			}
		
		/*아이디 체크 버튼 연동 */
			$(function(){
				$('#id_save_button').click(function(){
					if($('#id_save_checkbox').prop('checked')){
						$('#id_save_checkbox').prop('checked','');
					}
					else{
						$('#id_save_checkbox').prop('checked','checked');
					}
					
				});
				
			});
		
		
		</script>
	
		
<jsp:include page="include/footer.jsp" />


		