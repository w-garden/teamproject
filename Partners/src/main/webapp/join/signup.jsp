<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파트너스 회원가입</title>
<link rel="stylesheet" href="/Partners/css/main_style.css">
<link rel="stylesheet" href="/Partners/css/join_style.css">

<script src="/Partners/js/jquery.js"></script>
<script src="/Partners/js/javascript.js"></script>

<style>
#join_wrap .email_info {
	display: flex;
	justify-content: space-around;
	width: 306px;
}
</style>
</head>
<body>
	<article id="join_wrap">

		<div id="signup_form">

			<div id="signup_title">
				<div>
					<a href="/Partners/signin.jsp"> <img src="images/logo.png"
						alt="메인로고"></a>
				</div>
				<div class="msg" style="font-size: 26px;">파트너스 회원가입</div>
			</div>
			<form action="partners_signup_ok.do" method="post"
				onsubmit="return login_check();">
				<div class="info">
					<label for="businessName">사업자명</label> <input type="text"
						id="businessName" name="businessName" placeholder="업체명을 입력해주세요">
				</div>
				<div class="info">
					<label for="business_num">사업자번호</label> <input type="text"
						id="business_num" name="business_num" placeholder="000-00-00000">
				</div>
				<div class="info">
					<label for="pName">대표자 이름</label> <input type="text" id="pName"
						name="pName" placeholder="대표자 이름을 입력해주세요">
				</div>
				<div class="info">
					<label for="pTel">대표자 연락처</label> <input type="text" id="pTel"
						name="pTel" placeholder="핸드폰번호('-')제외">

				</div>
				<div class="info">
					<label for="pMail">대표자 이메일</label>
					<div class="email_info">
						<input type="text" id="pMail_id" name="pMail_id"
							placeholder="이메일 아이디"><span style="margin: 0px 3px;">@</span>
						<input type="text" id="pMail_domain" name="pMail_domain"
							placeholder="이메일 도메인">
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
						<input type="text" id="pId" name="pId" placeholder="2~16자 영문, 숫자">
						<input type="button" name="idchk" value="중복확인">
					</div>
				</div>
				<div class="signup_pwd">
					<label for="pPw">비밀번호</label> <input type="password" id="pPw"
						name="pPw" placeholder="10~16자 영문, 숫자, 특수문자 조합"> <input
						type="password" id="pwchk" placeholder="비밀번호 다시 입력">
				</div>
				<div id=signup_personalInfo>
					<div>
						<div>
							<input type="checkbox" id="all">
						</div>
						<div id=signup_personalInfo_label>
							<label for="all">전체동의</label>
						</div>
					</div>

					<div>
						<div>
							<input type="checkbox" id=check_1>
						</div>
						<div id=signup_personalInfo_label>
							<label for="check_1">개인(신용)정보의 수집 이용 동의 </label>
						</div>
					</div>
					<div>
						<div>
							<input type="checkbox" id="check_2">
						</div>
						<div id=signup_personalInfo_label>
							<label for="check_2">개인(신용)정보의 제3자 제공 동의</label>
						</div>
					</div>
					<div>
						<div>
							<input type="checkbox" id="check_3">
						</div>
						<div id=signup_personalInfo_label>
							<label for="check_3">서비스이용약관 동의</label>
						</div>
					</div>

				</div>
				<div class=signup_submit>
					<input type="submit" value="가입하기">
				</div>
			</form>
		</div>
		<jsp:include page="../include/footer.jsp" />
</body>
</html>