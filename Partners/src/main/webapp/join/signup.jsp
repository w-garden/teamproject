<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파트너스 회원가입</title>
<link rel="stylesheet" href="/Partners/css/join_style.css">

<script src="/Partners/js/jquery.js"></script>
<script src="/Partners/js/javascript.js"></script>

</head>
<body>
	<article id="join_wrap">

		<div id="signup_form">

			<div id="signup_title">
				<a href="/Partners/signin.jsp"> <img src="images/join/signup_logo.png" alt="메인로고"></a>
			</div>
			<form action="partners_signup_ok.do" method="post" onsubmit="return signup_check();">
				<div class="info">
					<label for="businessName">사업자명</label> 
					<input type="text" id="businessName" name="businessName" placeholder="업체명을 입력해주세요">
				</div>
				<div class="info">
					<label for="business_num">사업자번호</label> 
					<input type="text"	id="business_num" name="business_num" placeholder="000-00-00000">
				<div id="business_num_box">
					<span id="business_num_check"></span>
				</div></div>
				<div class="info">
					<label for="pName">대표자 이름</label> <input type="text" id="pName" name="pName" placeholder="대표자 이름을 입력해주세요">
				</div>
				<div class="info">
					<label for="pTel">대표자 연락처</label> <input type="text" id="pTel" name="pTel" placeholder="핸드폰번호('-')제외">
					<div id="pTel_check_box">
					<span id="pTel_check"></span>
				</div></div>
			
				<div class="info">
					<label for="pMail">대표자 이메일</label>
					<div class="email_info">
						<input type="text" id="pMail_id" name="pMail_id" placeholder="이메일 아이디"><span style="margin: 0px 3px;">@</span>
						<input type="text" id="pMail_domain" name="pMail_domain" placeholder="이메일 도메인">
					</div>
					<select id="email_adr" name="email_adr">
						<c:forEach var="e" items="${email}">
							<option value="${e}">${e}</option>
						</c:forEach>
					</select>
				</div>
				<div class="info">
					<label for="pId">아이디</label>
					<div class=signup_idchk>
						<input type="text" id="pId" name="pId" placeholder="4~16자 영문, 숫자">
						<input type="button" name="idchk" value="중복확인" onclick="id_check();">
					</div>
					<div id="idcheck_box">
						<span id="idcheck"></span>
					</div>
				</div>
				<div class="signup_pwd">
					<label for="pPw">비밀번호</label> <input type="password" id="pPw" name="pPw" placeholder="10~16자 영문, 숫자, 특수문자 조합"> 
					<input type="password" id="pwchk" placeholder="비밀번호 다시 입력">	
				<div id="password_check_box">
					<span id="password_check"></span>
				</div>
				</div>
				<div id=signup_personalInfo>
					<div>
						<div>
							<input type="checkbox" id="all"></div>
						<div id=signup_personalInfo_label>
							<label for="all">전체동의</label>
						</div></div>
					<div>
						<div>
							<input type="checkbox" id=check_1></div>
						<div id=signup_personalInfo_label>
							<label for="check_1">개인(신용)정보의 수집 이용 동의 </label>
						</div>
					</div>
					<div>
						<div>
							<input type="checkbox" id="check_2"></div>
						<div id=signup_personalInfo_label>
							<label for="check_2">개인(신용)정보의 제3자 제공 동의</label>
						</div></div>
					<div>
						<div>
							<input type="checkbox" id="check_3"></div>
						<div id=signup_personalInfo_label>
							<label for="check_3">서비스이용약관 동의</label>
						</div></div>

				</div>
				<div class=signup_submit>
					<input type="submit" value="가입하기"></div>
			</form>
		</div>
		<jsp:include page="../include/footer.jsp" />
		
		
		
		
		

					<script>
					
						  //사업자 번호 형식 체크
						$('#business_num').on('keyup',function(event) {
											$('#business_num_check').hide();
											$business_num = $.trim($(
													"#business_num").val());

											var a1 = $business_num.charAt(3);
											var a2 = $business_num.charAt(6);
											var a3 = $business_num.replace(
													/[-_]/g, '');
											
											if ($business_num == '') {
												$('#business_num').css("border", "2.5px solid gray");
												return false;
											}

											if (a1 == '-' && a2 == '-'
													&& a3 > 1010000000
													&& a3 < 9999999999) {
												$('#business_num_check').hide();

												$('#business_num').css(
														"border",
														"2.5px solid gray");

											} else {
												$newtext = '<font color="red" size="2"><b>형식이 맞지 않습니다!</b></font>';
												$('#business_num_check').text(
														'');
												$('#business_num_check').show(
														'');
												$('#business_num_check')
														.append($newtext);
												$('#business_num').css(
														"border",
														"2.5px solid red");
											}
										});
						//연락처 형식 체크
						$('#pTel').on('keyup',function(event) {
									$('#pTel_check').hide();
									var pTel = $.trim($("#pTel").val());
									const ONLY_NUMBER = /^[0-9]*$/; //숫자 정규 표현식
									if(pTel==''){
										$('#pTel').css("border","2.5px solid gray");
									}
									else if(!(ONLY_NUMBER.test(pTel)) || pTel.length!=11) {
										$newtext = '<font color="red" size="2"><b>형식이 맞지 않습니다!</b></font>';
										$('#pTel_check').text('');
										$('#pTel_check').show('');
										$('#pTel_check').append($newtext);
										$('#pTel').css("border","2.5px solid red");
									}
									else{
										$('#pTel').css("border","2.5px solid gray");
									}
								
								});
						//아이디 형식 체크
						$('#pId').on('keyup',function(event) {
											$('#idcheck').hide();
											$pId = $.trim($("#pId").val());

											if ($pId == '') { //입력된 값이 없을때
												$('#pId').css("border",
														"2.5px solid gray");
												return false;
											}
											if ($pId.length < 4) { //아이디 4자 미만
												$newtext = '<font color="red" size="2"><b>아이디는 4자 이상이어야 합니다!</b></font>';
												$('#idcheck').text('');
												$('#idcheck').show('');
												$('#idcheck').append($newtext);
												$('#pId').css("border",
														"2.5px solid red");
												return false;

											} else if (!(validate_userid($pId))) { //형식 안맞을때
												$newtext = '<font color="red" size="2"><b>영문 대소문자, 숫자, _조합만 가능합니다!</b></font>';
												$('#idcheck').text('');
												$('#idcheck').show('');
												$('#idcheck').append($newtext);
												$('#pId').css("border",
														"2.5px solid red");
												return false;
											} else { // 모두 충족시키면
												$newtext = '<font color="blue" size="2"><b>아이디 중복체크를 해주세요</b></font>';
												$('#idcheck').text('');
												$('#idcheck').show('');
												$('#idcheck').append($newtext);
												$('#pId').css("border",
														"2.5px solid gray");
											}
										});

						//아이디 중복체크
						function id_check() {
							$('#idcheck').hide();
							$pId = $.trim($("#pId").val());
							if ($pId == '') { //입력된 값이 없을때
								$('#pId').css("border",
										"2.5px solid gray");
								return false;
							}
							if ($pId.length < 4) { //아이디 4자 미만
								$newtext = '<font color="red" size="2"><b>아이디는 4자 이상이어야 합니다!</b></font>';
								$('#idcheck').text('');
								$('#idcheck').show('');
								$('#idcheck').append($newtext);
								$('#pId').css("border",
										"2.5px solid red");
								return false;

							} else if (!(validate_userid($pId))) { //형식 안맞을때
								$newtext = '<font color="red" size="2"><b>영문 대소문자, 숫자, _조합만 가능합니다!</b></font>';
								$('#idcheck').text('');
								$('#idcheck').show('');
								$('#idcheck').append($newtext);
								$('#pId').css("border",
										"2.5px solid red");
								return false;
								
							}else{
								$.ajax({
									type : "POST",
									url : 'partners_idcheck.do',
									data : {
										"pId" : $pId
									},
									datatype : "int",
									success : function(data) {
										if (data == 1) {
											$newtext = '<font color="red" size="2"><b>중복 아이디입니다!</b></font>';
											$('#idcheck').text('');
											$('#idcheck').show('');
											$('#idcheck').append($newtext);
											$('#pId').css("border",
													"2.5px solid red");
											$('#pId').focus();
											return false;
										} else {
											$newtext = '<font color="blue" size="2"><b>사용가능한 아이디입니다!</b></font>';
											$('#idcheck').text('');
											$('#idcheck').show('');
											$('#idcheck').append($newtext);
											$('#pId').focus();
										}
									},
									error : function() {
										alert('data error');
									}
						});
							}
								
								
								
								
								
							
									
						}

						//비밀번호 일치여부
						$('#pPw').on('keyup',function(event) {
											$('#password_check').hide();
											$pPw = $.trim($("#pPw").val()); //비밀번호
											$pwchk = $.trim($("#pwchk").val()); //비밀번호 다시 입력
											
										
											if ($pPw == '') { //입력된 값이 없을때
												$('#pPw').css("border", "2.5px solid gray");
												return false;
											}
											if (!(validate_pw($pPw)) ||$pPw.length>16 ){
												$newtext = '<font color="red" size="2"><b>비밀번호가 형식이 맞지 않습니다!</b></font>';
												$('#password_check').text('');
												$('#password_check').show('');
												$('#password_check').append($newtext);
												$('#pPw').css("border", "2.5px solid red");
											}else{
												$('#pPw').css("border", "2.5px solid gray");
											}
											
											if ($pwchk == '') { //입력된 값이 없을때
												$('#pwchk').css("border", "2.5px solid gray");
												return false;
											}
											if ($pPw != $pwchk) { //비밀번호가 일치하지 않으면
												$newtext = '<font color="red" size="2"><b>비밀번호가 일치하지 않습니다!</b></font>';
												$('#password_check').text('');
												$('#password_check').show('');
												$('#password_check').append($newtext);
												$('#pwchk').css("border", "2.5px solid red");
												$('#pPw').css("border", "2.5px solid red");
												return false;
											} else { // 모두 충족시키면
												if ((validate_pw($pPw)) && $pPw.length<16 ){
													$newtext = '<font color="blue" size="2"><b>일치합니다</b></font>';
													$('#password_check').text('');
													$('#password_check').show('');
													$('#password_check').append($newtext);
													$('#pwchk').css("border", "2.5px solid gray");
													$('#pPw').css("border", "2.5px solid gray");
												}
											}
										});
						$('#pwchk').on('keyup',function(event) {
											$('#password_check').hide();
											$pPw = $.trim($("#pPw").val()); //비밀번호
											$pwchk = $.trim($("#pwchk").val()); //비밀번호 다시 입력
							
											if ($pwchk == '') { //입력된 값이 없을때
												$('#pwchk').css("border", "2.5px solid gray");
												return false;
											}											
											if ($pPw != $pwchk) { //비밀번호가 일치하지 않으면
												$newtext = '<font color="red" size="2"><b>비밀번호가 일치하지 않습니다!</b></font>';
												$('#password_check').text('');
												$('#password_check').show('');
												$('#password_check').append($newtext);
												$('#pwchk').css("border", "2.5px solid red");
												$('#pPw').css("border", "2.5px solid red");

												return false;
											} else { // 모두 충족시키면
												$newtext = '<font color="blue" size="2"><b>일치합니다</b></font>';
												$('#password_check').text('');
												$('#password_check').show('');
												$('#password_check').append($newtext);
												$('#pwchk').css("border", "2.5px solid gray");
												$('#pPw').css("border", "2.5px solid gray");
											}
										});
						//정규표현식
						function validate_userid($pId) {
							var pattern = new RegExp(/^[A-z0-9_]+$/);//아이디를 영문소문자와 숫자 와 _조합으로 처리
							return pattern.test($pId);
						};
						function validate_pw($pPw) {
							var pattern = new RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,}$/);//아이디를 영문소문자와 숫자 와 _조합으로 처리
							return pattern.test($pPw);
						};
					</script>
</body>
</html>