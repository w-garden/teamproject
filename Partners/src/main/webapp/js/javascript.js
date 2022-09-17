/***********/
/*좌측 메뉴  */
/***********/

$(document).ready(function() {
	$('#side_menu > li >a ').click(function() {
		$('#side_menu li ul').slideUp();
		if ($(this).attr('class') != 'enable') {
			$(this).next().slideToggle();
			$('#side_menu li a').removeClass('enable');
			$(this).addClass('enable');
		} else {
			$(this).removeClass('enable');
		}
	});
});

/***************************/
/*회원가입창 개인정보 동의 */
/**************************/
$(function() {
	$('#all').click(function() {
		if ($('#all').prop('checked')) {
			$('#check_1').prop('checked', 'checked');
			$('#check_2').prop('checked', 'checked');
			$('#check_3').prop('checked', 'checked');
		} else {
			$('#check_1').prop('checked', '');
			$('#check_2').prop('checked', '');
			$('#check_3').prop('checked', '');
		}

	});
});
$(function() {
	$('#check_1').click(function() {
		if ($('#all').prop('checked')) {
			$('#all').prop('checked', '');
		}

	});
});
$(function() {
	$('#check_2').click(function() {
		if ($('#all').prop('checked')) {
			$('#all').prop('checked', '');
		}

	});
});
$(function() {
	$('#check_3').click(function() {
		if ($('#all').prop('checked')) {
			$('#all').prop('checked', '');
		}
	});
});

/*************************/
/* 로그인 창 유효성 검사 */
/*************************/

function login_check() {
	if ($.trim($('#businessName').val()) == '') {
		alert('업체명을 입력하세요');
		$('#businessName').focus();
		return false;
	}
	if ($.trim($('#business_num').val()) == '') {
		alert('사업자번호를 입력하세요');
		$('#business_num').focus();
		return false;
	}
	if ($.trim($('#pName').val()) == '') {
		alert('이름을 입력하세요');
		$('#pName').focus();
		return false;
	}
	if ($.trim($('#pTel').val()) == '') {
		alert('연락처를 입력하세요');
		$('#pTel').focus();
		return false;
	}
	if ($.trim($('#pMail').val()) == '') {
		alert('이메일을 입력하세요');
		$('#pMail').focus();
		return false;
	}
	if ($.trim($('#pId').val()) == '') {
		alert('아이디를 입력하세요');
		$('#pId').focus();
		return false;
	}
	if ($.trim($('#pPw').val()) == '') {
		alert('비밀번호를 입력하세요');
		$('#pPw').focus();
		return false;
	}
}
/********************/
/*회원가입창 이메일 */
/********************/

$(function() {
	$('#email_adr').change(function() {
		$('#pMail_domain').val($('#email_adr').val());
	});
});

/**************/
/*로그인 시간 */
/**************/

var iSecond; //초단위로 환산
var timerchecker = null;
window.onload = function() {
	fncClearTime();
	initTimer();
}
function fncClearTime() {
	iSecond = 1800;
}

Lpad = function(str, len) {
	str = str + "";
	while (str.length < len) {
		str = "0" + str;
	}
	return str;
}
initTimer = function() {
	var timer = document.getElementById("timer");
	rHour = parseInt(iSecond / 3600);
	rHour = rHour % 60;
	rMinute = parseInt(iSecond / 60);
	rMinute = rMinute % 60;
	rSecond = iSecond % 60;
	if (iSecond > 0) {
		timer.innerHTML = "&nbsp;" + Lpad(rMinute, 2) + "분 " + Lpad(rSecond, 2) + "초 ";
		iSecond--;
		timerchecker = setTimeout("initTimer()", 1000); // 1초 간격으로 체크    
	} else {
		logoutUser();
	}
}




function refreshTimer() {
	var xhr = initAjax();
	xhr.open("POST", "/jsp_std/kor/util/window_reload2.jsp", false);
	xhr.send();
	fncClearTime();
}



function logoutUser() {
	clearTimeout(timerchecker);
	var xhr = initAjax();
	xhr.open("POST", "/mail/user.public.do?method=logout", false);
	xhr.send();
	location.reload();
}



function initAjax() { // 브라우저에 따른 AjaxObject 인스턴스 분기 처리    
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari        
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5        
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}
/*******************/
/***** 주소 검색 ***/
/*******************/

function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("sample6_extraAddress").value = extraAddr;

			} else {
				document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('sample6_postcode').value = data.zonecode;
			document.getElementById("sample6_address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}

/*******************/
/*** 공사유형선택 **/
/*******************/

$(function() {

	$('#sel_type').change(function() {
		if (($('#sel_type').val()) == 'house') {
			$('#sel_house').removeAttr("disabled");
			$('#sel_house').show();
			$('#sel_business').hide();
		}
		if (($('#sel_type').val()) == 'business') {
			$('#sel_business').removeAttr("disabled");
			$('#sel_business').show();
			$('#sel_house').hide();
		}
		if (($('#sel_type').val()) == 'none') {
			$('#sel_house, #sel_business').prop('disabled', 'disabled');
			$("#sel_house, #sel_business").val("none");
		}
	});
});

/*****************************/
/*고객관리 페이지  토글 버튼*/
/*****************************/


$(function() {
	$('#detailed_search').click(function() {
		$('#search_conditon').toggle(400);
	});
});
$(function() {
	$('#hide_button').click(function() {
		$('#search_conditon').hide(400);
	});
});

