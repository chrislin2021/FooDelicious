<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

			<link rel="stylesheet" href="css/cart.css">

			<!-- <div class="container-shoppingCart">
				<div class="flow-chart">
					<div class="circle-outter">
						<div class="circle active">1</div>
						<div class="circle-inner">購物車</div>
					</div>
					<div class="line"></div>
					<div class="circle-outter shift-line">
						<div class="circle">2</div>
						<div class="circle-inner">填寫資料</div>
					</div>
					<div class="line"></div>
					<div class="circle-outter">
						<div class="circle">3</div>
						<div class="circle-inner">訂單確認</div>
					</div>
				</div>
			</div> -->

			<table class="table">
				<thead>
					<tr>
						<th scope="col">　購物車</th>
						<th scope="col">填寫資料</th>
						<th scope="col">訂單確認</th>
					</tr>
				</thead>
			</table>

			<div class="progress">
				<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar"
					aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 33%">33%</div>
			</div>

			<br>

			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"><input type="checkbox"></th>
						<th scope="col">商品</th>
						<th scope="col">單價</th>
						<th scope="col">數量</th>
						<th scope="col">小計</th>
						<th scope="col">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="carts" items="${carts}">
						<tr>
							<th scope="row"><input type="checkbox"></th>
							<td>${carts.product.productName}</td>
							<td>${carts.product.productPrice}</td>
							<td><input type="number" value="${carts.quantity}" min=1 max=${carts.product.productStock }>
							</td>
							<td>${carts.product.productPrice*carts.quantity}</td>
							<td><a onclick="return confirm('確定刪除嗎?')" href="/shoppingCart/${carts.cartId}"
									class="link-dark">刪除</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td>
							<input type="text" class="form-control" placeholder="請輸入賣場折扣碼"
								aria-label="Example text with button addon" aria-describedby="button-addon1">
						</td>
					</tr>
					<tr>
						<td>滿$1000，貨到付款，免運費！！</td>
					</tr>
				</tfoot>
			</table>

			<table></table>




			<script src="../../js/bootstrap.bundle.min.js"></script>