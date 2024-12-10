<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/resources/js/ajax.js"></script>

</head>
<body>
	<h2>main</h2>
	<table>
		<tr>
			<th>ID </th>
			<td><input type="text" name="id"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="pw"/></td>
		</tr>
		<tr>
			<th colspan="2"><button onclick="login()">로그인</button></th>
		</tr>
	</table>
</body>
<script>
	function login(){
		console.log('로그인 요청');
		
		var id = $('input[name="id"]').val();
		var pw = $('input[name="pw"]').val();
		var data = {id: id, pw : pw};
	
		httpAjax('POST', '/login', data);
		
	}
	
	function httpSuccess(response){
		if(response){
			alert('로그인 성공');
		}
	}
	
</script>
</html>