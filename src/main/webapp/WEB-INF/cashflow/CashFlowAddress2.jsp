<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="/js/jquery-3.6.0.min.js"></script>
<script src="https://demeter.5fpro.com/tw/zipcode-selector.js"></script>
<script src="../../js/cashflow.js"></script>
<script src="../../js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>


<body>
	<div align="center">
		<h2>您的寄貨資訊</h2>
		<table class="table">
			<thead>
				<div class="input-group mb-3">
					<span class="input-group-text">會員編號：</span>
					
				<div class="input-group mb-3">
					<span class="input-group-text">會員帳號：</span>

				<div class="input-group mb-3">
					<span class="input-group-text">會員姓名：</span>

				<div class="input-group mb-3">
					<span class="input-group-text">會員地址：</span>

				<div class="input-group mb-3">
					<span class="input-group-text">出貨地址：</span>
			
			<tbody id="addrList">
			<c:forEach var="data" items="${data}">
				<tr  align="center">
					<td>${data.memberId}</td>
					<td>${data.memberName}</td>
					<td>${data.memberMail}</td>
					<td>${data.memberAddress}</td>
					<td>${data.title[i].commonAddress}</td>
				</tr>
			</c:forEach>
			</tbody>
			
		</table>

		<button type="submit" class="btn btn-outline-primary" id='sendData'>確認更改</button>

		<a href="<c:url value='/listAllMembers'/> ">回前頁</a>
	</div>

</body>

</html>