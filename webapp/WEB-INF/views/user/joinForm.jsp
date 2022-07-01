<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">


<!-- jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>

</head>

<body>
	<div id="wrap">
		<!-- header -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //header -->

		<!-- nav -->
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
		<!-- //nav -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li>회원정보</li>
					<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/user/joinForm">회원가입</a></li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>회원가입</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">회원가입</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="user">
					<div id="joinForm">
						<form id = "join-form" action="join" method="get">

							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label>
								<input type="text" id="input-uid" name="id" value="" placeholder="아이디를 입력하세요">
								<button type="button" id="">중복체크</button>
							</div>

							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label>
								<input type="password" id="input-password" name="password" value="" placeholder="비밀번호를 입력하세요">
							</div>

							<!-- 이름 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label>
								<input type="text" id="input-name" name="name" value="" placeholder="이름을 입력하세요">
							</div>

							<!-- 성별 -->
							<div class="form-group">
								<span class="form-text">성별</span>
								
								<label for="rdo-male">남</label>
								<input type="radio" id="rdo-male" name="gender" value="male">
								
								<label for="rdo-female">여</label>
								<input type="radio" id="rdo-female" name="gender" value="female">

							</div>

							<!-- 약관동의 -->
							<div class="form-group">
								<span class="form-text">약관동의</span>
								<input type="checkbox" id="chk-agree" value="" name="">
								<label for="chk-agree">서비스 약관에 동의합니다.</label>
							</div>

							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">회원가입</button>
							</div>

						</form>
					</div>
					<!-- //joinForm -->
				</div>
				<!-- //user -->
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<!-- footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->
	

<!-- MODAL -->
<div id = "duplicateModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">비밀번호 입력</h4>
      </div>
      
      <div class="modal-body">
      	<label for = "password">비밀번호</label>
      	<input type = "password" name = "password"></input>
      	<input type = "hidden" name = "no"></input>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id = "btnModalDelete" type="button" class="btn btn-primary">Delete</button>
        
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


</body>

<script type = 'text/javascript'>

$("#join-form").on("submit", function(){
	console.log("회원가입 버튼");
	
	var id = $("input-uid").val();
	var password = $("input-password").val();
	var name = $("input-name").val();
	var policy = $("#chk-agree").is(":checked");
	
	
	if(id == "" || id == null){
		alert("아이디 입력");
		return false;
	}
	
	if(password == "" || password == null){
		alert("패스워드 입력");
		return false;
	}
	
	if(name == "" || name == null){
		alert("이름 입력");
		return false;
	}
	
	if(policy == false){
		alert("약관 동의 필요");
		return false;
	}
})

/*
$("#btn-submit").on("click", function(){
	console.log("회원가입 버튼");
	
	event.preventDefault();	// html 락다운
	
	var id = $("#input-uid").val();
	
	if(id == null){
		alert("아이디 없음")
		return false;
	}
})
*/

</script>



</html>