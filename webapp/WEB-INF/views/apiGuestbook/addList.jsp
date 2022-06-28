<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">

<!-- jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

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
				<h2>방명록</h2>
				<ul>
					<li>일반방명록</li>
					<li>ajax방명록</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
				
				<div id="content-head" class="clearfix">
					<h3>ajax방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">ajax방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<form action="" method="">
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th><label class="form-text" for="input-uname">이름</label></td>
									<td><input id="input-uname" type="text" name="name"></td>
									<th><label class="form-text" for="input-pass">패스워드</label></td>
									<td><input id="input-pass"type="password" name="pass"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button type="submit">등록</button></td>
								</tr>
							</tbody>
							
						</table>
						<!-- //guestWrite -->
						<input type="hidden" name="action" value="add">
						
					</form>	
					
					
					
					
					
					
					</div>
				<!-- //guestbook -->
			
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

<script type='text/javascript'>
$(document).ready(function(){
	console.log('jquery request');
})


$.ajax({
	url : "${pageContext.request.contextPath }/api/guestbook/list",
	type : "post",
	// contentType : "application/json",
	// data : {name: '심영'},
	dataType : "json",
	success : function(guestBookList){
		console.log(guestBookList);
		
		for(var i=0; i<guestBookList.length; i++){
			render(guestBookList[i]);
		}
		
	},
	error : function(XHR, status, error) {
		console.log(status + ' : ' + error);
	} });
	
function render(guestBookVo){
	console.log('render()');
	var str = '';
	//$('#listArea').append(name + '<br>');
	
	str += '<table class = 'guestRead'>;
	str += '	<colgroup>';
	str += '		<col style='width : 10%;'>';
	str += '		<col style='width : 40%;'>';
	str += '		<col style='width : 40%;'>';
	str += '		<col style='width : 10%;'>';
	str += '	</colgroup>';
	str += '	<tr>';
	str += '		<td>1234</td>';
	str += '		<td>이정재</td>';
	str += '		<td>2020-03-03</td>';
	str += '		<td><a href = ''></a></td>';
	str += '	</tr>';
	str += '	<tr>';
	str += '		<td colspan = '4' class = 'text-left'>방명록 글</td>';
	str += '	</tr>';
	str += '</table>;
	
	$('#listArea').append(str);
}

	
</script>


</html>