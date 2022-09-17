<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./include/header.jsp" />








<style>
#loading {
	width: 100%;
	height: 100%;
	top: 0px;
	left: 0px;
	position: fixed;
	display: block;
	opacity: 0.7;
	background-color: #fff;
	z-index: 99;
	text-align: center;
}
#loading-image {
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 100;
}
</style>

</head>
<body>

	<div align="center" id="loading">
		<img id="loading_image" src="./images/loading.gif">
	</div>
	<h2>하이</h2>
</body>
<script>
	$(window).ready(function() {
		alert('하이');
		$('#loading').hide();   
		$(window).load();
	});
</script>

<jsp:include page="./include/footer.jsp" />


