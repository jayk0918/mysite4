<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css  -->
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
					<li><a href="">댓글게시판</a></li>
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
							<li class="last">일반게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="board">
					<div id="list">
						<form action="${pageContext.request.contextPath}/board/search2" method="get">
							<div class="form-group text-right">
								<select name = 'content'>
									<option value = "">선택</option>
									<option id = "searchTitle">제목</option>
									<option id = "searchName">글쓴이</option>
								</select>
								<c:if test = >
									<input type="text" name = "keyword">
								</c:if>
								<c:if test = >
									<input type="text" name = "keyword">
								</c:if>
									<button type="submit" id=btnSearch>검색</button>
								
							</div>
						</form>
						<table>
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${bList}" var="BoardVo">
									<tr>
										<td>${BoardVo.no}</td>
										<td class="text-left"><a href="${pageContext.request.contextPath}/board/read?no=${BoardVo.no}">${BoardVo.title}</a></td>
										<td>${BoardVo.name}</td>
										<td>${BoardVo.hit}</td>
										<td>${BoardVo.date}</td>
										<c:choose>
											<c:when test="${BoardVo.userNo == authUser.no}">
												<td><a href="${pageContext.request.contextPath}/delete/no=${BoardVo.no}">[삭제]</a></td>
											</c:when>
										</c:choose>
									</tr>
								</c:forEach>		
								
							</tbody>
						</table>
			
						<div id="paging">
							<ul>
								<li><a href="">◀</a></li>
								<li><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li class="active"><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">9</a></li>
								<li><a href="">10</a></li>
								<li><a href="">▶</a></li>
							</ul>
							
							
							<div class="clear"></div>
						</div>
						<c:choose>
							<c:when test = "${authUser.no != null}">
								<a id="btn_write" href="${pageContext.request.contextPath}/board/writeForm?no=${authUser.no}">글쓰기</a>
							</c:when>
						</c:choose>
					</div>
					<!-- //list -->
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
