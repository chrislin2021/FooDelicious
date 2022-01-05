<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<style>
	.productbody {
		text-align: center;
	}
	.tablebody,th {
		margin: auto;
		vertical-align: middle;
  		text-align: center;
  		border: 1px solid black ;
	}
</style>
<div class="row" id="rowSelect">
	<div class="col-12 col-md-2">
		<div class="list-group">
			<a href="/LoginSystem" class="list-group-item list-group-item-action">會員登入</a>
			<a href="/Product" class="list-group-item list-group-item-action">前往商城</a>
			<a href="#" class="list-group-item list-group-item-action">前往分享區</a>
			<a href="/postArticle" class="list-group-item list-group-item-action">發表新文章</a>
		</div>
	</div>
</div>
	<div class="productbody">
		<header>
			<h1>商品列表</h1>
		</header>
		<br>
		<table class="tablebody">
			<tr style="background-color: #FF8040">
				<th>商品編號
				<th>商品圖片
				<th>商品公司
				<th>商品名稱
				<th>商品價格
				<th>編輯 
			</tr>
			<c:forEach items="${pros}" var="pro">
				<tr>
					<td>${pro.productId}
					<td>${pro.productPics}
					<td>${pro.productCompany}
					<td>${pro.productName}
					<td>${pro.productPrice}
					<td>
						<a href="edit/${pro.productId}">edit</a>
						<a href="del?id=${pro.productId}">delete</a></td>
						
				</tr>		
			</c:forEach>
			  
		</table>
		<br>
	</div>
	<script type="text/javascript">
		function check(productId) {
			if (confirm("確定刪除?")) {
				window.location.href = "DeletePro?productId=" + productId;
			} else {
			}
		}
	</script>
</body>
</html>