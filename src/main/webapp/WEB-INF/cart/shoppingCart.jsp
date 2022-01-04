<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

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
				<td>${carts.quantity}</td>
				<td>${carts.product.productPrice*carts.quantity}</td>
				<td><button value="">刪除</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<script src="../../js/bootstrap.bundle.min.js"></script>

