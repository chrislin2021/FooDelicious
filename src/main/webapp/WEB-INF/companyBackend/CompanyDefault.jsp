<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE html>
<html lang="zh-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>好煮意後台管理系統</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/companyMain.css">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/fontawesome/css/all.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/fontawesome/css/fontawesome.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Zen+Maru+Gothic:wght@500&display=swap"
	rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="col-fixed topBrand ">
	<a style="color: white; text-decoration: none" href="/companyMain"><span class="brandName align-middle">好煮意</span>admin</a>
		<!-- <b class="align-middle brand"><a
			style="color: white; text-decoration: none" href="/companyMain">廠商後台管理系統</b> -->
	</div>

	<div class="row">
		<div class="navbar col-md-12 rightBrand justify-content-end">
			<ul class="nav nav-pills ">
				<i class="far fa-bell fa-lg"></i>
				<a class="nav-link text-white" href="#"></a>
			</ul>
			<ul class="nav nav-pills ">
				<i class="far fa-user-circle fa-lg"></i>
				<a class="nav-link text-white" href="#"></a>
			</ul>

		</div>
	</div>

	<div class="col-fixed leftBar">
		<!-- 左上登入帳號資訊小圖 -->
		<div class="photoArea">
			<!-- 左上登入帳號照片 -->
			<!--<img src="${pageContext.request.contextPath}/img/wellcook.jpg"
				class="photo">  -->
			<!-- <span class="brandName align-middle">好煮意</span> -->
		</div>

		<ul class="list-group list-group-flush functionBar">



			
			<!--商品管理  -->
			<li id="ProductList" class="list-group-item funName">
				<button class="btn btnBor" type="button" data-bs-toggle="collapse"
					data-bs-target="#collapseExample" aria-expanded="false"
					aria-controls="collapseExample">
					<i class="text-secondary fas fa-archive"></i> <span>商品管理</span>
					<div class="collapse ulArea" id="collapseExample">
						<ul id="" class="accordion-collapse collapse show">
							<li id="addProduct" class="colLi funName"><a
								class="colLi" href="" style="text-decoration: none"><i
									class="fa fa-circle-o"></i>新增商品</a></li>
							<li id="editProduct" class="colLi"><a class="colLi" href=""
								style="text-decoration: none"><i class="fa fa-circle-o"></i>修改商品</a></li>
						

						</ul>
					</div>
				</button>
			</li>


			
			<!--訂單管理  -->
			<li id="OrderList" class="list-group-item">
				<button class="btn btnBor" type="button" data-bs-toggle="collapse"
					data-bs-target="#collapseExample" aria-expanded="false"
					aria-controls="collapseExample">
					<i class="text-secondary fas fa-shopping-cart"></i> <span>訂單管理</span>
					<div class="collapse ulArea" id="collapseExample">
						<ul id="collapseOne" class="accordion-collapse collapse show">
							<li id="addProduct" class="colLi funName"><a
								class="colLi" href="" style="text-decoration: none"><i
									class="fa fa-circle-o"></i>查詢訂單</a></li>
							<li id="editProduct" class="colLi"><a class="colLi" href=""
								style="text-decoration: none"><i class="fa fa-circle-o"></i>修改訂單</a></li>
						

						</ul>
					</div>
				</button>
			</li>


			<!-- 分析報表 -->
			<li class="list-group-item">
				<button class="btn btnBor" type="button" data-bs-toggle="collapse"
					data-bs-target="#collapseExample" aria-expanded="false"
					aria-controls="collapseExample">
					<i class="text-secondary fas fa-chart-bar"></i> <span>分析報表</span>
					<div class="collapse ulArea" id="collapseExample">
						<ul id="collapseOne" class="accordion-collapse collapse show">
							<li id="AgeDistribution" class="colLi funName"><a
								class="colLi" href="" style="text-decoration: none"><i
									class="fa fa-circle-o"></i>年齡層分析</a></li>
							<li id="1" class="colLi"><a class="colLi" href=""
								style="text-decoration: none"><i class="fa fa-circle-o"></i>暢銷商品</a></li>
							<li id="ArticleTop10" class="colLi funName"><a class="colLi"
								href="" style="text-decoration: none"><i
									class="fa fa-circle-o"></i>銷售額</a></li>

						</ul>
					</div>
				</button>
			</li>
			
			<!-- inbox -->
			<li id="BanList" class="list-group-item funName"><a href="#"
				style="color:grey;text-decoration:none" > <i class="fas fa-inbox"></i> <span>訊息</span>
			</a></li>


			<!-- 問題回報 -->
			<li id="BanList" class="list-group-item funName"><a href="#"
				style="text-decoration: none" id="button"> <i
					class="text-secondary fas fa-ban"></i> <span>問題回報</span>
			</a></li>

			<!-- 登出 -->
			<li id="" class="list-group-item logoutIcon"><a
				href="/" style="color:white"> <i
					class="fas fa-sign-out-alt fa-lg"></i>
			</a></li>


		</ul>
	</div>

	<!-- 問題回報地跳出視窗 -->
	<div class="bg-modal">
		<div class="modal-contents">

			<div class="close">+</div>


			<form action="">
				<input type="text" placeholder="Name"> <input type="email"
					placeholder="E-Mail"> <a href="#" class="button">Submit</a>
			</form>

		</div>
	</div>








	<!-- 右邊的區塊 -->
	<div class="row">
		<div class="col-md-12 rightArea">
			<tiles:insertAttribute name="content" />
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
		
	<script> //問題回報跳出視窗		
		document.getElementById('button').addEventListener("click", function() {
			document.querySelector('.bg-modal').style.display = "flex";
		});

		document.querySelector('.close').addEventListener("click", function() {
			document.querySelector('.bg-modal').style.display = "none";
		});
	</script>
</body>
</html>
