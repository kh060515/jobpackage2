<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>

<div class="container">
		<div class="row">
		
		<form action="/member/cashget">
			입찰금액: <input readonly name="nowMoney" value="${cget.nowMoney}">
			구매자: <input readonly name="sellId" value="${cget.sellId}">
			
			<input type="submit" value="수령하기">
		</form>
		
		</div>
	</div>
<script type="text/javascript">
		$(document).ready(function(){
			
		});
	</script>
</body>
</html>