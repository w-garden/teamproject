<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<%-- 상단 공통부분 끝 --%>
  <link rel="stylesheet" href="../css/apply_style_03.css">  
  <script src="../js/apply.js" defer></script>
  <script src="../js/jquery.js"></script>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/> <!--달력css-->
  <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>

  <title>Step 3</title>
</head>

<body>

  <div id="estimate_step03">
    <section aria-label="예산 선택" class="estimate_yourcost">
      <div class="title">
        <h2>상세 내용을 알려주세요.</h2><h3>3/4</h3>
      </div>
          <p class="subtitle">단 한번 입력으로 조건에 맞는 전문가들과 간편하게 상담 하세요.</p><br />
      <div class="estimate_box">
        <h3>의뢰인 정보 입력</h3>
        <input type="text" id="name" name="name" placeholder="이름을 입력해주세요.">
        <input type="text" id="phone" name="phone" placeholder="휴대폰 번호를 입력해 주세요.">
        <button type="button" id="certify_phone">인증하기</button>

        <div class="para">
        <h3>스타일을 알려주세요.(1500자 내외)</h3>
        <p class="textCount">0자</p><p class="textTotal">/1500자</p>
      </div>
        <input type="textarea" id="paragraph" name="paragraph" maxlength="1500" placeholder="원하는 스타일에 대해 자유롭게 써주세요.">
        <form action="" method="post" enctype="multipart/form-data" name="">
          <input type="file" name="FileName">
      </div>
      </form>
      </section>
     
  <!-- id : 고유한 식별 목적
             class : 재사용을 목적
             name : 컨트롤 요소값(value)을 서버로 전송하기위함-->

  <div class="nextpage">
    <button class="button" id="go-back" onclick="location.href='applicationSheet2.jsp'">이전</button>
    <button class="button" id="go-next" onclick="location.href='applicationSheet4.jsp'">다음</button>
  </div>
  </div>
</body>
<%-- 하단 공통부분 --%>
<jsp:include page="../common/footer.jsp" />