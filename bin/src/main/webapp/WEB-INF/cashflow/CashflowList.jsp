<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<title>訂單資訊</title>

<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>訂單資訊</h2>
		<h2>付款完成!!</h2>
		<table>
			<thead>
			<tbody id="cartList">
				<c:forEach var="carts" items="${carts}" begin="1" end="1">
					<span style="margin: 250px">
						<th>會員編號 :
					<td>${carts.member.memberId}
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;
				</c:forEach>
				<c:forEach var="carts" items="${carts}" begin="1" end="1">
					<th>訂單編號 :
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<th>總金額 :
					</span>
				</c:forEach>
			</tbody>
			<tbody id="cartList">
				<c:forEach var="carts" items="${carts}">
					<tr>


					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		<table class="table table-striped">
			<thead>
				<tr style="background-color: #a8fefa">			
					<th>商品名稱					
					
					
					<th>商品數量					
					
					<th>商品價格					
					
					<th>購買總價				
				
				</tr>
			</thead>
			<c:forEach var="carts" items="${carts}">
				<tr style="background-color: lightblue" align="center">
					<td>${carts.product.productName}</td>
					
					<td>${carts.quantity}</td>
					<td>${carts.product.productPrice}</td>
					<td>${carts.product.productPrice*carts.quantity}</td>
				</tr>
			</c:forEach>
			</tbody>


			<table>
				<thead>
				
				
				<tbody id="cartList">
					<c:forEach var="carts" items="${carts}" begin="1" end="1">
						<tr>
							<th>姓名&nbsp;<input id="ReceiverName" name="ReceiverName"
								type="text" size="4" maxlength="120"
								value="${carts.member.memberName}">
							
							
							<th>&nbsp;&nbsp;手機&nbsp;<input id="ReceiverMobile"
								name="ReceiverMobile" type="text" size="9" maxlength="12"
								value="${carts.member.memberPhone}">
							
							
							<th>&nbsp;&nbsp;信箱&nbsp;<input id="ReceiverTel"
								name="ReceiverMail" type="text" size="30" maxlength="30"
								value="${carts.member.memberMail}">
						
						
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table>
				<thead>
				
				
				<tbody id="cartList">
					<c:forEach var="carts" items="${carts}" begin="1" end="1">
						<tr>
							<th>寄送地址&nbsp; <input id="ReceiverAddr" name="ReceiverAddr"
								type="text" size="30" maxlength="150"
								value="${carts.member.memberAddress}">
						
						
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<input type="button" value="確定"
				onclick="javascript:location.href='http://localhost:8080'" />

			</div>

			<script src="/js/jquery-3.6.0.min.js"></script>
			<script src="https://demeter.5fpro.com/tw/zipcode-selector.js"></script>
			<script src="../../js/cashflow.js"></script>


</body>



