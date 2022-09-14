<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<%-- 상단 공통부분 끝 --%>
    <link rel="stylesheet" href="../css/apply_style_04.css">
    <script src="../js/apply.js" defer></script>
    <script src="../js/jquery.js"></script>


<div id = "estimate_step04">
 <section aria-label="주소 선택& 근처 업체" class="youraddr">
    <div class="title">
        <h2>근처의 인테리어업체와 직접 연락할 수 있어요.</h2><h3>4/4</h3>
    </div>
    <div class = "estimate_box">
        <p id="p1">**님 근처에 **개의 인테리어 업체가 있습니다.<br/>
        클릭해서 직접 상담해 볼 수 있어요.</p>
    <div class = "companies">
     <ul style="list-style: none;">
      <li>
        <input type="checkbox" id="company" name="company">
        <label for = "company">호철엔지니어링</label>
    </li>
        <li id="li_01">
        <img src="../images/main_images/interior01.jpg">
        <p id="p2">총 공사 999건<br/>최근 상담 999건<br/><br/><br/>+보증보험<br/>+3D도면<br/>+일반도면<br/>+카드결제</p>
        </li>
     </ul>
     <ul style="list-style: none;">
        <li>
          <input type="checkbox" id="company2" name="company">
          <label for = "company2">동민아키텍쳐</label>
        </li>
        <li id="li_01">
          <img src="../images/main_images/interior02.jpg">
          <p id="p2">총 공사 999건<br/>최근 상담 999건<br/><br/><br/>+보증보험<br/>+3D도면<br/>+일반도면<br/>+카드결제</p>
          </li>
        </ul>
      </div>
        <div class="nextpage">
          <button class="button" id="go-back" onclick="location.href='applicationSheet3.jsp'">이전</button>
          <button class="button" id="go-next" onclick="location.href='applicationSheet5.jsp'">진행하기</button>
        </div>
    </div>
 </section>
</div>

 <%-- 하단 공통부분 --%>
<jsp:include page="../common/footer.jsp" />