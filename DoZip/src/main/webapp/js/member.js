/* 이메일주소 동기화 */
var changeSelect = function(value) {
	$("#mem_domain").val(value);
}

/* 회원가입 전체동의 */
function allselect(bool){
	var chks = document.getElementsByName("chk");
	for(var i = 0; i < chks.length; i++){
		chks[i].checked = bool;
	}
}
/* 아래 항목 선택여부 따라 자동으로 전체선택 적용, 해제 */
function checkSelectAll()  {
	  const checkboxes = document.querySelectorAll('input[name="chk"]');
	  const checked = document.querySelectorAll('input[name="chk"]:checked');
	  const selectAll = document.querySelector('input[name="all"]');
	  
	  if(checkboxes.length === checked.length)  {
	    selectAll.checked = true;
	  }else {
	    selectAll.checked = false;
	  }
}

/* 회원가입 창 띄우기 */
function openJoin(){
	window.open("member_join.do", "_blank", "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=500, height=750, left=0, top=0" );
}

