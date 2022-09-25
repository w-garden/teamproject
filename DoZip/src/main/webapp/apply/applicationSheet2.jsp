<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<%-- 상단 공통부분 끝 --%>
 <link rel="stylesheet" href="./css/apply_style_02.css">  
  <script src="./js/apply.js" defer></script>
  <script src="./js/jquery.js"></script>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/> <!--달력css-->
  <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>

 <script>
 function check(){
	var est_bud = document.getElementById("estimate_cost");
	var est_start = document.getElementById("est_start");
	var est_end = document.getElementById("est_end");
	
	if(est_bud.value == "") {
		alert('예산을 입력해주세요!');
		estimate_cost.focus();
		return false;
	}
	else if(est_start.value == "") {
		alert('시작일을 알려주세요!');
		est_start.focus();
		return false;
	}
	else if(est_end.value == "") {
		alert('종료일을 알려주세요!');
		est_end.focus();
		return false;
	}
 }
 </script>
 
  <title>Step 2</title>
</head>

<body>
 <form method="post" onsubmit="return check();" action="estimate_apply2_ok.do">

  <div id="estimate_step02">
    <section aria-label="예산 선택" class="estimate_yourcost">
      <div class="title">
        <h2>예산과 일정을 알려주세요.</h2><h3>2/4</h3>
        </div>
        <div>
        <p>단 한번 입력으로 조건에 맞는 전문가들과 간편하게 상담 하세요.</p><br />
      </div>
      </section>
      <div class="estimate_box">
        <h3>예산</h3>
        <div class="your_cost">
          <input type="text" id="estimate_cost" name="est_bud" maxlength="7" placeholder="0" onkeyup="inputNumberFormat(this);" />
        <h3>만원</h3>
        </div>
        <br/><br/><br/><br/><hr/>
        </div>
        <div class="estimate_date">
          <h3>희망 시공일정</h3><br/><br/>
          오늘 날짜 : <span id="today"></span>
        <form>
          <br/>
          <label for="est_start">시작일</label>
          <input type="text" name="est_start" id="est_start">
          ~
          <label for="est_end">종료일</label>
          <input type="text" name="est_end" id="est_end">
        </form>
        </div>

  <!-- id : 고유한 식별 목적
             class : 재사용을 목적
             name : 컨트롤 요소값(value)을 서버로 전송하기위함-->

             <div class="nextpage">
              <button class="button" id="go-back" onclick="location.href='estimate_apply.do'">이전</button>
              <button class="button" type="submit" id="go-next">다음</button>
            </div>
  </div>
 </form>
</body>
 <%-- 하단 공통부분 --%>
<jsp:include page="../common/footer.jsp" />