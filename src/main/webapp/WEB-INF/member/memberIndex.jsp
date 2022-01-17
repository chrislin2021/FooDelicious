<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<style>
.error {
	color: red;
	display: inline-block;
	font-size: 8pt;
}
</style>

<meta charset="UTF-8">
<title>登入成功</title>
</head>
<body>

	<c:if test='${userName == null}'>
		<span>您好，請登入會員</span>
	</c:if>

	<c:if test='${userName != null}'>
		<span>歡迎來到會員中心, ${userName}</span>
	</c:if>


	<div class="container-xl px-4 mt-4">
		<font color='darkgreen'>&nbsp;${insertSuccess}</font>
		<c:set var='updateurl'
			value='${pageContext.request.contextPath}/members/${memberId}' />
		<%-- 	<form method="POST" action="${updateurl}" class="form" modelAttribute="member"> --%>

				<input type='hidden' name='_method' value='POST'>
				<br>
				<!-- put一定要有底線_method
				<input type='hidden' path='memberId' />
				<br>&nbsp;



		<!-- Account page navigation-->
		<hr class="mt-0 mb-4">
		<div class="row">
			<div class="col-xl-4">
				<!-- Profile picture card-->
				<div class="card mb-4 mb-xl-0">
					<div class="card-header">大頭照</div>
					<div class="card-body text-center">
						<!-- Profile picture image-->
						<img class="img-account-profile rounded-circle mb-2"
							src="img/defaultImg.jpg" alt="">
						<!-- Profile picture help block-->
						<div class="small font-italic text-muted mb-4">JPG or PNG no
							larger than 5 MB</div>
						<!-- Profile picture upload button-->
						<button class="btn btn-primary" type="">更新照片</button>
					</div>
				</div>
			</div>
			<div class="col-xl-8">
			<form method="GET" action="${updateurl}" class="form" >
				<c:set var='updateurl'
			value='${pageContext.request.contextPath}/members/${memberId}' />
				<input type='hidden' name='_method' value='POST'>
				<input type='hidden' path='memberId' />
				
				
				<!-- Account details card-->
				<div class="card mb-4">
					<div class="card-header">個人資料</div>
					<div class="card-body">
						
							<!-- Form Group (username)-->
							<div class="mb-3">
								<label class="small mb-1" for="memberId">會員編號</label> <input
									class="form-control" id="memberId" type="text" placeholder=""
									value="${userID}" readonly="readonly">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="memberMail">會員帳號</label> <input
									class="form-control" id="memberMail" type="text" placeholder=""
									value="${memberMail}" readonly="readonly">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="pwd">會員密碼</label> <input
									class="form-control" id="pwd" type="password" placeholder=""
									value="${pwd}">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="userName">會員姓名</label> <input
									class="form-control" id="userName" type="text" placeholder=""
									value="${userName}">
							</div>

							<div class="input-group mb-3">
								<div class="mb-3">
									<label class="small mb-1" for="memberGender">會員性別</label> <input
										class="form-control" id="member_gender_m" type="radio"
										placeholder="" value="${memberGender}">
								</div>
								<div class="mb-3">
									<input class="form-control" id="member_gender_f" type="radio"
										placeholder="" value="${memberGender}">
								</div>
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="memberBirth">會員生日</label> <input
									class="form-control" id="memberBirth" type="date"
									placeholder="" value="${memberBirth}">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="memberPhone">會員電話</label> <input
									class="form-control" id="memberPhone" type="tel" placeholder=""
									value="${memberPhone}">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="memberAddress">會員地址</label> <input
									class="form-control" id="memberAddress" type="text"
									placeholder="" value="${memberAddress}">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="memberDiscountId">會員折扣</label> <input
									class="form-control" id="memberDiscountId" type="text"
									placeholder="" value="${memberDiscountId}" readonly="readonly">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="member_status">會員身份</label> <input
									class="form-control" id="member_status" type="text"
									placeholder="" value="${member_status}" readonly="readonly">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="memberCoin">會員金幣</label> <input
									class="form-control" id="memberCoin" type="text" placeholder=""
									value="${memberCoin}" readonly="readonly">
							</div>

							<div class="mb-3">
								<label class="small mb-1" for="register_date">註冊時間</label> <input
									class="form-control" id="register_date" type="text"
									placeholder="" value="${register_date}" readonly="readonly">
							</div>
					</div>
					<!-- Save changes button-->
					<button type="submit" class="btn btn-primary" id='sendData'>確認更改</button>
					</form>
					<a href="<c:url value='/'/> ">回首頁</a>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- 	<h2>這裡是會員中心</h2> -->
	<!-- 	<h3>這裡是會員中心</h3>	<br> -->

	<!-- 	 <div class="col-12 col-md-2"> -->
	<!--             <div class="list-group"> -->
	<!--                 <a href="/LoginSystem" class="list-group-item list-group-item-action">會員登入</a> -->
	<!--                 <a href="/Product" class="list-group-item list-group-item-action">前往商城</a> -->
	<!--                 <a href="#" class="list-group-item list-group-item-action">前往分享區</a> -->
	<!--                 <a href="/postArticle" class="list-group-item list-group-item-action">發表新文章</a> -->
	<!--                 <a href="/custService" class="list-group-item list-group-item-action">客服中心</a> -->
	<!--             </div> -->
	<!--         </div> -->


</body>
</html>