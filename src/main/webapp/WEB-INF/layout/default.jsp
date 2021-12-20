<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<link href="/css/bootstrap.min.css" rel="stylesheet" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="${contextRoot}/">Cool App</a>
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
					<li class="nav-item"><a class="nav-link"
						href="/LoginSystem">會員登入</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextRoot}/addStatus">前往商城</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextRoot}/viewStatus">前往分享區</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/postArticle">發表新文章</a></li>

				</ul>

			</div>
		</div>
	</nav>
  <div>
        <img src="img\top.jpg" class="img-fluid">
    </div>


	<div class="container-fluid">
		<tiles:insertAttribute name="content" />
	</div>


	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/jquery-3.6.0.min.js"></script>
	<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js"></script> -->

</body>
</html>