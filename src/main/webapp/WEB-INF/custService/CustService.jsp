<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="zh-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>客戶反應中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../../css/backend.css">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../../fontawesome/css/all.css">
<link
	href="https://fonts.googleapis.com/css2?family=Zen+Maru+Gothic:wght@500&display=swap"
	rel="stylesheet">
<script src="../../js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="col-fixed topBrand ">
		<b class="align-middle brand">客戶反應中心</b>
	</div>

	<div class="row">
		<div class="navbar col-md-12 rightBrand justify-content-end">
			<ul class="nav nav-pills ">
				<li class="nav-item"><a class="nav-link text-white" href="#">首頁</a>
				</li>
			</ul>
		</div>
	</div>

	<div class="row justify-content-md-center">
		<div class="col-sm-6">
			<div class="card">
				<h5 class="card-header">請敘述您的問題</h5>
				<div class="card-body">
					<form:form class="form" method="POST" modelAttribute="statusUpdate">
						<form:errors path="text" />
						<div class="input-group">
							<form:textarea class="form-control" path="text"></form:textarea>
						</div>
						<input type="submit" name="submit" value="新增狀態">
					</form:form>

				</div>
			</div>
		</div>
	</div>

	<div class="col-fixed leftBar">
		<!-- 左上登入帳號資訊小圖 -->
		<div class="photoArea">
			<!-- 左上登入帳號照片 -->
			<img src="${pageContext.request.contextPath}/img/wellcook.jpg"
				class="photo"> <span class="brandName align-middle">好煮意</span>
		</div>
</div>
	<!-- 這裡是右邊的區塊 -->
	<div class="row">
		<div class="col-md-12 rightArea">
			<tiles:insertAttribute name="content" />
		</div>
	</div>

	<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>

