<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />

<meta charset="UTF-8">
<title>FooDelicious</title>
<style type="text/css">
.img-fluid {
	width: 100%;
	height: 250px;
}
div.path {
	background-color: rgb(209, 203, 203);
}
#rowSelect {
	margin-top: 30px;
}
#mainDiv {
	margin-top: 30px;
	border: 1px black solid;
	padding: 20px;
	border-radius: 10px;
}
#passwordDiv {
	margin-bottom: 10px;
}
#loginSpan {
	color: red;
}
#registerMain {
	margin-top: 30px;
	border: 1px gray solid;
	padding: 20px;
	border-radius: 10px;
}
</style>

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="${contextRoot}/">好煮意</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">首頁</a></li>

					<li class="nav-item">
						<div class="dropdown">
							<button class="nav-link dropdown-toggle" type="button"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false">
								會員相關<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="${contextRoot}/LoginSystem">會員登入</a></li>
								<li><a class="dropdown-item" href="${contextRoot}/RegisterPage">會員註冊</a></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
										
							</ul>
						</div>
					</li>


					<li class="nav-item"><a class="nav-link dropdown-toggle"
						href="/Product">前往商城</a></li>
					<li class="nav-item"><a class="nav-link" href="/goShareArea">前往分享區</a></li>
					<li class="nav-item"><a class="nav-link" href="/postArticle">發表新文章</a></li>

				</ul>

			</div>
		</div>
	</nav>
	<div>
		<img src="${contextRoot}\img\top.jpg" class="img-fluid">
	</div>

<!--設定div class container代表標題以下是由tiles管理排版  --> 
<div class="container">
    <tiles:insertAttribute name="content" />
 </div>

	<script src="/js/jquery-3.6.0.min.js"></script>
	<script src="/js/bootstrap.bundle.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>


	<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js"></script> -->

</body>
</html>