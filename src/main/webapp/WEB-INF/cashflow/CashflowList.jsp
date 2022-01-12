<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%request.setCharacterEncoding("UTF-8");%>

	<title>訂單資訊</title>

	<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>訂單資訊</h2>
		<h2>付款完成!!</h2>
		<table>
		<span style="margin: 250px">
		<th>訂單編號 :
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
		<th>總金額 :
		
		</span>
		</table>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">會員編號
					<th scope="col">商品編號
					<th scope="col">商品名稱
					<th scope="col">商品數量
					<th scope="col">商品價格
					<th scope="col">購買總價
				</tr>
			</thead>
			<tbody id="cartList">
				<c:forEach var="carts" items="${carts}">
					<tr>
						
						<td>${carts.memberId}</td>
						<td>${carts.product.productId}</td>
						<td>${carts.product.productName}</td>
						<td>${carts.quantity}</td>
						<td>${carts.product.productPrice}</td>
						<td>${carts.product.productPrice*carts.quantity}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<table>
			<tr>
				<th>姓名&nbsp;<input id="ReceiverName" name="ReceiverName"
					type="text" size="6" maxlength="120"><span
					class="description">(中文全名)&nbsp;&nbsp;</span>
				<th>手機&nbsp;<input id="ReceiverMobile" name="ReceiverMobile"
					type="text" size="9" maxlength="12">
				<th>信箱&nbsp;<input id="ReceiverTel" name="ReceiverMail"
					type="text" size="30" maxlength="30"><span
					class="description">&nbsp;</span>
		</table>
		<table>
			<tr>
				<th>寄送地址&nbsp; <input class="js-demeter-tw-zipcode-selector"
					data-city="#city" data-dist="#dist" placeholder="郵遞區號" size="6" />
					<select id="city" placeholder="請選擇縣市" name="city"></select> <select
					id="dist" placeholder="請選擇鄉鎮區" name="dist"></select> <input
					id="ReceiverAddr" name="ReceiverAddr" type="text" size="30"
					maxlength="150">
			</tr>
		</table>

		
		<input type="button" value="確定"
			onclick="javascript:location.href='http://localhost:8080'" />

	</div>

	 <script src="/js/jquery-3.6.0.min.js"></script>
	 <script src="https://demeter.5fpro.com/tw/zipcode-selector.js"></script>
	<script src="../../js/cashflow.js"></script>

	</body>



