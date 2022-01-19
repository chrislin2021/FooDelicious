<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>

<html>

<head>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />
<link href="css/cart.css" rel="stylesheet">
<link href="css/form-validation.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="UTF-8">
<title>FooDelicious</title>
<link href="../../css/default4.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Kosugi+Maru&display=swap" rel="stylesheet">
	
</head>

<body>

<header class="navArea">
		<nav class="container-fluid navbar fixed-top navbar-expand-lg navbar-light bg-lightd-grid gap-3 align-items-center navArea" style="grid-template-columns: 1fr 2fr;">
			<a class="navbar-brand textCon itembox" href="${contextRoot}/">好煮意</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item itembox"><a class="nav-link textCon" aria-current="page" href="/" style="color: black">首頁</a></li>
					<li class="nav-item itembox"><a class="nav-link textCon" href="/Product" style="color: black">前往商城</a></li>
					<li class="nav-item itembox"><a class="nav-link textCon" href="/goShareArea" style="color: black">前往分享區</a></li>
					<li class="nav-item itembox"><a class="nav-link textCon" href="/postArticle" style="color: black">發表新文章</a></li>
					<li class="nav-item itembox"><a class="nav-link textCon" href="/#contactBox" style="color: black">客服中心</a></li>
					<li class="nav-item itembox"><a class="nav-link textCon" href="/shoppingCart" style="color: black"><svg 	xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg></a></li>
					<li class="nav-item item"><a class="nav-link textCon" href="/backend/member" style="color: black">暫時的後台連結</a></li>
					<li class="nav-item item"><a class="nav-link textCon" href="/memberOrders" style="color: black">暫時的會員中心</a></li>
				</ul>
			</div>

			<c:if test='${userName == null}'>
				<span>您好，請登入會員</span>
				<a class="text-dark" href="/LoginSystem">登入</a>
			</c:if>

			<c:if test='${userName != null}'>
				<span><img class="memberPic" src="/img/${memberPic}">&ensp;${userName}&ensp;</span>
				<a class="text-dark" href="/normallogout">登出</a>
			</c:if>

			<div class="d-flex align-items-center">
				<div class="flex-shrink-0 dropstart">
					<a href="/memberIndex"> <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16" class="rounded-circle"><path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" /></svg></a>
				</div>
			</div>
		</nav>
	</header>

	<!-- ===========================================分隔線=========================================== -->

	<div>
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-bag"><path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"></path><line x1="3" y1="6" x2="21" y2="6"></line><path d="M16 10a4 4 0 0 1-8 0"></path></svg> 好煮意｜訂單資料填寫</a>
				<form class="d-flex">
					<input class="form-control me-2" type="search" id="appleNoSale" placeholder="蘋果，沒有打折！！" aria-label="Search" value="">
					<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="searchProduct()"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg></button>
				</form>
			</div>
		</nav>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3>Smart Choice</h3>
				</div>
				<div class="modal-body">
					<table class="table">
						<tbody class="productInformation">
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<table class="table table align-middle">
		<thead>
			<tr>
				<th scope="col">購物車</th>
				<th scope="col">填寫資料</th>
				<th scope="col">訂單確認</th>
			</tr>
		</thead>
	</table>

	<div class="progress">
		<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 66%">66%</div>
	</div>
	<br>

	<div class="container">
		<div class="row g-5">
			<div class="col-md-5 col-lg-4 order-md-last">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-primary">訂單商品</span><span class="badge bg-primary rounded-pill"><c:out value="${count}"></c:out></span>
				</h4>
				<ul class="list-group mb-3">
					<c:forEach var="carts" items="${carts}">
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<h6 class="my-0" id="a">${carts.product.productName}</h6>
								<div class="productId" hidden>${carts.productId}</div>
								<div class="quantity" hidden>${carts.quantity}</div>
								<small class="text-muted">單價：${carts.product.productPrice}</small><small class="text-muted">｜</small><small class="text-muted">數量：${carts.quantity}</small></div><span class="text-muted">NT$:${carts.product.productPrice*carts.quantity}元</span>
						</li>
					</c:forEach>
					<li class="list-group-item d-flex justify-content-between bg-light">
						<div class="text-success">
							<h6 class="my-0">運費：</h6>
						</div>
						<c:if test="${priceTotal < 1000}"><span class="text-success">NT$:100元</span></c:if>
						<c:if test="${priceTotal >= 1000}"><span class="text-success">NT$:0元</span></c:if>
					</li>
					<li class="list-group-item d-flex justify-content-between bg-light">
						<div class="text-success">
							<h6 class="my-0">折扣金額：</h6>
						</div><span class="text-success">−NT$:${discountContent}元</span>
					</li>
					<li class="list-group-item d-flex justify-content-between"><span>總金額：</span><strong>NT$:${priceTotal}元</strong></li>
				</ul>
			</div>

			<div class="col-md-7 col-lg-8">
				<h4 class="mb-3">填寫地址</h4>
				<form class="needs-validation" novalidate method="post" id="shipping">
					<div class="row g-3">
						<div class="col-sm-6">
							<label for="firstName" class="form-label">收件人姓名<span class="text-muted">(必填)</span></label><input type="text" class="form-control" id="name" value="${orders.ordersName}" required>
							<div class="validate1 d-none" style="color: red">請填寫收件人姓名喔！！</div>
						</div>

						<div class="col-sm-6">
							<label for="lastName" class="form-label">收件人電話<span class="text-muted">(必填)</span></label><input type="text" class="form-control" id="phone" value="${orders.ordersPhone}" required>
							<div class="validate2 d-none" style="color: red">請填寫收件人電話喔！！</div>
						</div>
					</div>

					<div class="col-12">
						<label for="address" class="form-label">收件人地址<span class="text-muted">(必填)</span></label><input type="text" class="form-control" id="address" value="${orders.ordersAddress}" required>
						<div class="validate3 d-none" style="color: red">請填寫收件人地址喔！！</div>
					</div>

					<hr class="my-4">

					<div class="form-check">
						<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"><label class="form-check-label" for="flexRadioDefault1"> 貨到付款 </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked> <label class="form-check-label" for="flexRadioDefault2"> 金融支付 </label>
					</div>

					<hr class="my-4">

					<button class="w-100 btn btn-info btn-lg checkout" type="button">去買單！</button>
				</form>
			</div>
		</div>
	</div>

	<div class="container">
		<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
			<div class="col-md-4 d-flex align-items-center">
				<a href="/"  class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1"><svg class="bi" width="30" height="24"></svg></a> <span class="text-muted">&copy;2021 Company, Inc</span>
			</div>

			<ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
				<li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter" /></svg></a></li>
				<li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram" /></svg></a></li>
				<li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook" /></svg></a></li>
			</ul>
		</footer>
	</div>

	<script src="/js/jquery-3.6.0.min.js"></script>
	<script src="../../js/orders.js"></script>
	<script src="../../js/bootstrap.bundle.min.js"></script>
	<script src="form-validation.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</body>

</html>