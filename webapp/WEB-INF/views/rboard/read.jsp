<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">


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
				<h2>게시판</h2>
				<ul>
					<li><a href="${pageContext.request.contextPath}/board/list">일반게시판</a></li>
					<li><a href="${pageContext.request.contextPath}/rboard/list">댓글게시판</a></li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">댓글게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="board">
					<div id="read">
						<form action="#" method="get">
							<!-- 작성자 -->
							<div class="form-group">
								<span class="form-text">작성자</span>
								<span class="form-value">${RBoardVo.userName}</span>
							</div>
							
							<!-- 조회수 -->
							<div class="form-group">
								<span class="form-text">조회수</span>
								<span class="form-value">${RBoardVo.hit}</span>
							</div>
							
							<!-- 작성일 -->
							<div class="form-group">
								<span class="form-text">작성일</span>
								<span class="form-value">${RBoardVo.date}</span>
							</div>
							
							<!-- 제목 -->
							<div class="form-group">
								<span class="form-text">제 목</span>
								<span class="form-value">${RBoardVo.title}</span>
							</div>
						
							<!-- 내용 -->
							<div id="txt-content">
								<span class="form-value" >
									${RBoardVo.content}
								</span>
							</div>
							
							<c:choose>
								<c:when test="${RBoardVo.userNo == authUser.no}">
									<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/modifyForm?no=${RBoardVo.no}">수정</a>
								</c:when>
							</c:choose>
							<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/list">목록</a>
							
							<c:if test = "${authUser.no != null}">
								<a id="btn_modify" href="${pageContext.request.contextPath}/rboard/replyWriteForm?no=${RBoardVo.no}">댓글쓰기</a>
							</c:if>
							
						</form>
						<!-- //form -->
					</div>
					<!-- //read -->
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
