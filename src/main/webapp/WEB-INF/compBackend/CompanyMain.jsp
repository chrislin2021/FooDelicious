<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>


<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,100&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />

</head>


<div class="top-container">
	<!-- 用來當margin的 -->
	<h2 class="app-page-title" style="display: hidden"></h2>

	<div class="app-card shadow p-3 mb-5 bg-body rounded">
		<div class="">
			<div class="app-card-body p-3 p-lg-4">
				<h3 class="mb-3">Welcome, ${userName}!</h3>
				<div class="row gx-5 gy-3">
					<div class="col-12 col-lg-9">

						<div>最好給我賣東西喔</div>
					</div>
					<!--//col-->

				</div>
				<!--//row-->

			</div>
		</div>
	</div>
</div>
<!--//app-card-body-->




<div class="app-wrapper">

	<div class="app-content shadow p-3 mb-5 bg-body rounded" style="width:50%;background-color:#E9F5C2">
		<div class="container-xl">
			<h2 class="app-page-title" style="font-family: 'Source Sans Pro', sans-serif">設定</h2>
			<hr class="mb-4">
			<div class="row g-4 settings-section">
				<div class="col-12 col-md-4">
					<h3 class="section-title">General</h3>
					<div class="section-intro">
						基本資訊 <a href="help.html">Learn more</a>
					</div>
				</div>
				<div class="col-12 col-md-8">
					<div class="app-card app-card-settings shadow p-3 mb-5 bg-body rounded">

						<div class="app-card-body">
							<form class="settings-form">
								<div class="mb-3">
									<label for="setting-input-1" class="form-label"><strong>公司名稱</strong></label> 
									<input type="text" class="form-control" id="setting-input-1 companyName" value="${userName}">
								</div>
								<div class="mb-3">
									<label for="setting-input-2" class="form-label"><strong>電子信箱</strong></label> 
									<input type="text" class="form-control"
										id="companyEmail" value="${memberMail}" required>
								</div>
								<div class="mb-3">
									<label for="setting-input-3" class="form-label"><strong>電話</strong></label> 
									<input type="text" class="form-control" id="companyPhone" value="${memberPhone}">
								</div>
								<div class="mb-3">
									<label for="setting-input-3" class="form-label"><strong>密碼</strong></label> 
									<input type="password" class="form-control" id="companyPassword" value="${pwd}" style="margin-bottom:-33px"/>
									<i class="bi bi-eye-slash" id="togglePassword"></i>

								</div>
								<div class="mb-3">
									<input type="hidden" class="form-control" id="companyId" value="${userID}">
								</div>
								<button type="submit" class="btn btn-primary" style="margin-left:85%;margin-top:5px" id="companyDetailUpdate">儲存</button>
							</form>
						</div>
						<!--//app-card-body-->

					</div>
					<!--//app-card-->
				</div>
			</div>
			<!--//row-->
		</div>
	</div>

</div>


<script>
	// toggle password visibility
	 const togglePassword = document.querySelector("#togglePassword");
     const password = document.querySelector("#companyPassword");

     togglePassword.addEventListener("click", function () {
            
            const type = password.getAttribute("type") === "password" ? "text" : "password";
            password.setAttribute("type", type);
            this.classList.toggle("bi-eye");
        });
	
	
	
	$("#companyDetailUpdate").on("click",function(){
		let companyId = $("#companyId").val();
		let pwd = $("#companyPassword").val();
		alert(pwd);
// 		let updateCompanyDetail = {
// 			"memberId":$("#companyId").val();
// 			"memberName" : $("#companyName").val(),
// 			"memberMail": $("#companyEmail").val(),
// 			"memberPhone" : $("#companyPhone").val(),
// 			"pwd" : $("#companyPassword").val(),
// 		}
		
// 		let detailString = JSON.stringify(updateCompanyDetail);
		
// 		$.ajax({
// 			url:"/companyDetailUpdate",
// 			type:"PUT",
// 			contentType:'application/json; charset=UTF-8',
//             data: detailString,
//             success : function(msg){
//             	alert(msg);
//             	window.location.href="/companyMain2";
//             }
// 			error : function(msg){
// 				alert("Detail update fail!");
// 				window.location.href="/companyMain2";
// 			}
// 		})
		
	})

	

</script>