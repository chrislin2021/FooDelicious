<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE html>

<html lang="zh-TW">
<head>
<meta charset="UTF-8">
<!--<title> Drop Down Sidebar Menu | CodingLab </title>-->
<link rel="stylesheet" href="../../css/Test.css">
<!-- Boxiocns CDN Link -->
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	  rel='stylesheet'>
<link
	href="https://fonts.googleapis.com/css2?family=Zen+Maru+Gothic:wght@500&display=swap"
	rel="stylesheet">

<link href="../../css/bootstrap.min.css" rel="stylesheet">



<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="sidebar close">
		<div class="logo-details"></div>
		<ul class="nav-links">
			<li><a href="#"> <i class='bx bx-user-circle'></i> <span
					class="link_name">管理員</span>
			</a>
				<ul class="sub-menu blank">
					<li><a class="link_name" href="#">管理員</a></li>
				</ul></li>
			<li>
				<div class="iocn-link">
					<a href="#"> <i class='bx bx-cart'></i> <span
						class="link_name">商品管理</span>
					</a> <i class='bx bxs-chevron-down arrow'></i>
				</div>
				<ul class="sub-menu">
					<li><a class="link_name" href="#">商品管理</a></li>
					<li><a href="#">所有商品</a></li>
					<li><a href="#">新增商品</a></li>

				</ul>
			</li>
			<li>
				<div class="iocn-link">
					<a href="#"> <i class='bx bx-book-alt'></i> <span
						class="link_name">訂單管理</span>
					</a> <i class='bx bxs-chevron-down arrow'></i>
				</div>
				<ul class="sub-menu">
					<li><a class="link_name" href="#">訂單管理</a></li>
					<li><a href="#">所有訂單</a></li>
					<li><a href="#">修改訂單</a></li>
				</ul>
			</li>
			<li>
				<div class="iocn-link">
					<a href="#"> <i class='bx bx-bar-chart-alt-2'></i> <span
						class="link_name">分析報表</span>
					</a> <i class='bx bxs-chevron-down arrow'></i>
				</div>
				<ul class="sub-menu">
					<li><a class="link_name" href="#">分析報表</a></li>
					<li><a href="#">年齡層分析</a></li>
					<li><a href="#">暢銷商品</a></li>
					<li><a href="#">銷售總額</a></li>
				</ul>
			</li>
			<li><a href="#"> <i class='bx bx-error-alt'></i> <span
					class="link_name">問題回報</span>
			</a>
				<ul class="sub-menu blank">
					<li><a class="link_name" href="#" id="problem">問題回報</a></li>
				</ul></li>

			<li><a href="#"> <i class='bx bxs-inbox'></i> <span 
					class="link_name">訊息</span>
			</a>
				<ul class="sub-menu blank">
					<li><a class="link_name" href="#">訊息</a></li>
				</ul></li>
			<li>
				<div class="profile-details">

					<div class="profile-content">

						<i class='bx bxs-log-out' onclick="logout('${account}')"></i>
					</div>
					

				</div>
			</li>
		</ul>
	</div>
	<section class="home-section">
		<div class="home-content">
			<i class='bx bx-menu'></i> <span class="text brandName" style="color:EFF966">好煮意<small style="color:black">admin</small></span>
		</div>
	</section>

	<section class="main-section">
		<tiles:insertAttribute name="content" />

	</section>

	<!-- 問題回報地跳出視窗 -->

	<div class="bg-modal">
		<div class="modal-contents">

			<div class="closing">+</div>

			<div>
				<form action=""></form>



			</div>

		</div>
	</div>



	<!-- 登出 -->
	<script>
		function logout(account) {

			if (confirm("確定要登出嗎") == true) {
				window.location.href="/logout";
			}
		}
	</script>

	<!-- 問題回報跳出視窗 -->
	<script>
				
		document.getElementById('problem').addEventListener("click", function() {
			document.querySelector('.bg-modal').style.display = "flex";
		});

		document.querySelector('.closing').addEventListener("click", function() {
			document.querySelector('.bg-modal').style.display = "none";
		});
	</script>


	<script>
  let arrow = document.querySelectorAll(".arrow");
  for (var i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e)=>{
   let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
   arrowParent.classList.toggle("showMenu");
    });
  }
  let sidebar = document.querySelector(".sidebar");
  let sidebarBtn = document.querySelector(".bx-menu");
  console.log(sidebarBtn);
  sidebarBtn.addEventListener("click", ()=>{
    sidebar.classList.toggle("close");
  });
  </script>
</body>
</html>