<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container" id="registerMain">
	<h3>會員註冊</h3>
	<div class="input-group mb-3">
		<span class="input-group-text">會員帳號：</span> <input type="text"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="userAccount"
			name="userAccount" >
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text">會員密碼：</span> <input type="text"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="userPwd"
			name="userPwd">
	</div>
	<div class="input-group mb-3">
		<span class="input-group-text">會員姓名：</span> <input type="text"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="userName"
			name="userName">
	</div>
<span class="input-group-text">會員性別：</span>
	<div class="form-check form-check-inline">
		
		<input class="form-check-input" type="radio" name="inlineRadioOptions"
			id="inlineRadio1" value="option1"> <label
			class="form-check-label" for="inlineRadio1">男</label>
	</div>
	<div class="form-check form-check-inline">
		<input class="form-check-input" type="radio" name="inlineRadioOptions"
			id="inlineRadio2" value="option2"> <label
			class="form-check-label" for="inlineRadio2">女</label>
	</div>


	<div class="input-group mb-3">
		<span class="input-group-text">會員性別：</span> <input type="radio"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="member_gender"
			name="member_gender">
	</div>

	<div class="input-group mb-3">
		<span class="input-group-text">出生日期：</span> <input type="date"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="member_birth"
			name="member_birth">
	</div>


	<div class="input-group mb-3">
		<span class="input-group-text">Email</span> <input type="email"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="userEmail"
			name="userEmail">
	</div>

	<div class="input-group mb-3">
		<span class="input-group-text">手機</span> <input type="text"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="userPhone"
			name="userPhone">
	</div>

	<div class="input-group mb-3">
		<span class="input-group-text">生日</span> <input type="text"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="userBirth"
			name="userBirth">
	</div>

	<div class="input-group mb-3">
		<span class="input-group-text">地址</span> <input type="text"
			class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="userAddress"
			name="userAddress">
	</div>

	<div>
		<label for="photoId">會員照片</label> <input type="file"
			name="memberImage" id="photoId">
	</div>

	<button onclick="registBTN()" class="btn btn-outline-primary">註冊</button>

</div>

<script>
	function registBTN() {
		var postData = {
			account : $("#userAccount").val(),
			pwd : $("#userPwd").val(),
			member_name : $("#userName").val(),
			member_birth : $("#userBirth").val(),
			member_phone : $("#userPhone").val(),
			member_address : $("#userAddress").val(),
			member_mail : $("#userEmail").val()
		};
		$.ajax({
			url : "/register.controller",
			data : JSON.stringify(postData),
			type : "POST",
			contentType : "application/json;charset=utf-8",
		});
	}
</script>