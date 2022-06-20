<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite4/assets/css/mysite.css" rel="stylesheet"
	type="text/css">
<link href="/mysite4/assets/css/board.css" rel="stylesheet"
	type="text/css">

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
			<!-- board-aside -->
			<c:import url="/WEB-INF/views/includes/boardaside.jsp"></c:import>
			<!-- //board-aside -->

			<div id="content">

				<!-- content-head -->
				<c:import url="/WEB-INF/views/includes/boardcontenthead.jsp"></c:import>
				<!-- //content-head -->

				<div id="board">
					<div id="writeForm">
						<form action="bc" method="get">

							<!-- 제목 -->
							<div class="form-group">
								<label class="form-text" for="txt-title">제목</label> <input
									type="text" id="txt-title" name="title" value=""
									placeholder="제목을 입력해 주세요">
							</div>

							<!-- 내용 -->
							<div class="form-group">
								<textarea id="txt-content" name="content"></textarea>
							</div>
							<input type="hidden" name="userno" value="${authUser.no}"></input>
							<a id="btn_cancel" href="/mysite2/bc?action=list">취소</a>
							<button id="btn_add" type="submit">등록</button>
							<input type="hidden" name="action" value="insert"></input>
						</form>
						<!-- //form -->
					</div>
					<!-- //writeForm -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->


		</div>
		<!-- //container  -->


		<!-- footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
