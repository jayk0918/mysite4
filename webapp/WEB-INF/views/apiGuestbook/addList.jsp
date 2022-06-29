<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
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
				<h2>방명록</h2>
				<ul>
					<li><a href="${pageContext.request.contextPath}/guestbook/addList">일반방명록</a></li>
					<li><a href="${pageContext.request.contextPath}/api/guestbook/addList">ajax방명록</a></li>
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
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">이름</label></th>
								<td><input id="input-uname" type="text" name="name"></td>
								<th><label class="form-text" for="input-pass">패스워드</label></th>
								<td><input id="input-pass"type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4" class="text-center"><button id = 'btnSubmit' type="submit">등록</button></td>
							</tr>
						</tbody>
					</table>
					
					<div id = 'listArea'>
					</div>
						
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




<!-- MODAL -->
<div id = "delModal" class="modal fade">
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

<script type='text/javascript'>
$(document).ready(function(){
	fetchList();
})

$('#btnSubmit').on('click', function(){
	var name = $('[name = "name"]').val();
	var password = $('[name = "password"]').val();
	var content = $('[name = "content"]').val();
	var guestVo = {
			name: name,
			password: password,
			content: content
	}
	
	$.ajax({
		//url : "${pageContext.request.contextPath }/api/guestbook/add?name="+name+"&password="+password+"&content="+content,
		url : "${pageContext.request.contextPath }/api/guestbook/add",
		type : "post",
		data : guestVo,
		// contentType : "application/json",
		dataType : "json",
		success : function(gVo){
			render(gVo,'up');
			$('[name = "name"]').val('');
			$('[name = "password"]').val('');
			$('[name = "content"]').val('');
		},
		error : function(XHR, status, error) {
			console.log(status + ' : ' + error);
		} });
});

/*
$('#btnTest').on('click', function(){
	console.log('testbutton')
	
	$('#delModal').modal('show');
});
*/

$("#listArea").on("click", ".btnDelete", function(){
	var $this = $(this);
	var no = $this.data("no");
	// modal창 내부 no값
	$("[name = 'no']").val(no);
	$("#delModal [name = 'password']").val(""); //#delModal의 하위 클래스로 특정(안할 시 전역의 password에 val값 적용)
	$("#delModal").modal("show");
});

$("#btnModalDelete").on("click", function(){
	console.log('modal click');
	
	var password = $('#delModal [name="password"]').val();
	var no = $('#delModal [name="no"]').val();
	
	var guestBookVo = {
		password: password,
		no: no
	};
	
	
	$.ajax({
		url : "${pageContext.request.contextPath}/api/guestbook/remove",
		type : "post",
		// contentType : "application/json",
		data : guestBookVo,
		dataType : "json",
		success : function(result){
			if(result == "success"){
				$("#t"+no).remove();
				$("#delModal").modal("hide");
			}else{
				alert("반동이다! 전위대! 전위대!");
			}
			
		},
		error : function(XHR, status, error) {
			console.log(status + ' : ' + error);
		}
	});
})



function fetchList(){
	$.ajax({
		url : "${pageContext.request.contextPath }/api/guestbook/list",
		type : "post",
		// contentType : "application/json",
		// data : {name: '심영'},
		dataType : "json",
		success : function(guestBookList){
			console.log(guestBookList);
			
			for(var i=0; i<guestBookList.length; i++){
				render(guestBookList[i], 'down');
			}
		},
		error : function(XHR, status, error) {
			console.log(status + ' : ' + error);
		}
	});
}

function render(guestBookVo, opt){
	console.log('render()');
	var str = '';
	
	str += '<table id="t'+guestBookVo.no+'" class="guestRead">';
	str += '    <colgroup>' ;
	str += '        <col style="width: 10%;">' ;
	str += '        <col style="width: 40%;">' ;
	str += '        <col style="width: 40%;">' ;
	str += '        <col style="width: 10%;">' ;
	str += '    </colgroup>' ;
	str += '    <tr>' ;
	str += '        <td>'+guestBookVo.no+'</td>' ;
	str += '        <td>'+guestBookVo.name+'</td>' ;
	str += '        <td>'+guestBookVo.date+'</td>' ;
	str += '        <td><button class = "btnDelete" type = "button" data-no = '+guestBookVo.no+'>삭제</button></td>' ;
	str += '    </tr>' ;
	str += '    <tr>' ;
	str += '        <td colspan=4 class="text-left">'+guestBookVo.content+'</td>' ;
	str += '    </tr>' ;
	str += '</table>' ;
	
	if(opt == 'down'){
		$('#listArea').append(str);
	}else if(opt == 'up'){
		$('#listArea').prepend(str);
	}else{
		console.log('opt error');
	}
	
}


</script>

</html>