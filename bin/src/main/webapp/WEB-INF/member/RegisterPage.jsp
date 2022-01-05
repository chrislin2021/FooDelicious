<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>

	<div class="container" id="registerMain">
		<h3>會員註冊</h3>
		<form:form method="POST" action="${pageContext.request.contextPath}/RegisterPage"  class="form-signin" >
		<div class="input-group mb-3">
			<span class="input-group-text">會員帳號：</span> <input type="text"
				class="form-control" aria-label="Sizing example input"	
				aria-describedby="inputGroup-sizing-default" id="memberMail"
				name ="memberMail">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text">會員密碼：</span> <input type="password"
				class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="pwd" name="pwd">
		</div>
		<div class="input-group mb-3">
				<form:errors path="text" />
				<span class="input-group-text">會員姓名：</span>
				<input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default" id="memberName"
					name="memberName">
		</div>

		<div class="form-check form-check-inline">
			<span class="input-group-text">會員性別：</span> <input
				class="form-check-input" type="radio" name="memberGender"
				id="member_gender_m" value="male"> <label
				class="form-check-label" for="inlineRadio1">男</label>
		</div>
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="memberGender"
				id="member_gender_f" value="female"> <label
				class="form-check-label" for="inlineRadio2">女</label>
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">出生日期：</span> <input type="date"
				class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberBirth"
				name="memberBirth">
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員電話：</span> <input type="tel"
				class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberPhone"
				name="memberPhone">
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員地址：</span> <input type="text"
				class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberAddress"
				name="memberAddress">
		</div>

<!-- 			<div> -->
<!-- 				<label for="photoId">會員照片</label> <input type="file" -->
<!-- 					name="memberImage" id="photoId"><br><br> -->
<!-- 			</div> -->
			
		<button type="submit" class="btn btn-outline-primary" value="register">註冊</button>
		<input type="reset" class="btn btn-outline-primary" value="重設">
	</form:form> 
	</div>
   
</body>