<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.lcpan.bean.CartBean"
	pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Cart</title>
			<style>
				.cartbody {
					text-align: center;
				}

				.carttable {
					width: 90%;
					margin: auto;
				}
			</style>
		</head>

		<body background="https://cestmarie.com/wp-content/uploads/2019/01/Screenshot-3.png">
			<div class="cartbody">
				<header>
					<h1>使用者放入購物車的商品</h1>
				</header>

				<br>
				<table class="carttable">
					<tr style="background-color: #a8fefa">
						<th>商品編號
						<th>商品圖片
						<th>商品名稱
						<th>商品單價
						<th>商品數量
						<th>商品總計
						<th>操作
							<c:set var="sum" value="0" />
							<c:set var="member_id" value="0" />
							<c:forEach items="${carts}" var="cart">
					<tr>
						<td>${cart.product_id}
						<td><img src="http://memenow.cc/wp-content/uploads/2020/11/20201116_5fb20697b441b.jpg"
								width="50" height="50">
						<td>
							<form method="post" action="SelectProduct">
								<a href="SelectProduct?product_id=${cart.product_id}">${cart.product_name}</a>
							</form>
						<td>${cart.product_price}
						<td>
							<form method="post" action="UpdateCart">
								<input type="number" name="cart_product_quantity" value="${cart.cart_product_quantity}"
									min="1" step="1" max="10" onchange="this.form.submit()"> <input type="hidden"
									name="cart_id" value="${cart.cart_id}" />
								<c:set var="sum" value="${sum + cart.cart_product_price_total}" />
								<input type="hidden" name="member_id" value="${cart.member_id}" />
							</form>
						<td>${cart.cart_product_price_total}
						<td>
							<form method="post" action="DeleteCart">
								<input type="button" value="刪除"
									onclick="check('${cart.cart_id}','${cart.member_id}')" /> <input type="hidden"
									name="cart_id" value="${cart.cart_id}" /><input type="hidden" name="member_id"
									value="${cart.member_id}" />
							</form>
							<c:set var="member_id" value="${member_id = cart.member_id }" />
							</c:forEach>
					</tr>
				</table>
				<h2>
					總計：
					<c:out value="${sum}" />
				</h2>
				<br>
				<form method="post" action="CheckCart">
					<input type="submit" value="去買單" /> <input type="hidden" name="member_id" value="${member_id}" />
				</form>

				<br>
				<footer>
					<h1>使用者放入購物車的商品</h1>
				</footer>


			</div>

			<script type="text/javascript">
				function check(cart_id, member_id) {
					if (confirm("是否刪除?")) {
						window.location.href = "DeleteCart?cart_id=" + cart_id
							+ "&member_id=" + member_id;
					} else {

					}
				}
			</script>
		</body>

		</html>