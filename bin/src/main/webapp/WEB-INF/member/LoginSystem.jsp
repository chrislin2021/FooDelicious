<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container" id="mainDiv">
	<h1>Login</h1>
	<form action="checklogin.controller" method="post">
		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="floatingInput"
				name="userAccount" placeholder="Account"> <label
				for="floatingInput">Account</label> <span id="loginSpan">${errors.account}</span>
		</div>
		<div class="form-floating" id="passwordDiv">
			<input type="password" class="form-control" id="floatingPassword"
				name="userPwd" placeholder="Password"> <label
				for="floatingPassword">Password</label> <span id="loginSpan">${errors.pwd}</span>
		</div>

		<button type="submit" class="btn btn-outline-primary">Login</button>
		<button type="button" class="btn btn-outline-primary"
			onclick="location.href='goregister'">Register</button>
	</form>
	<span id="loginSpan">${errors.msg}</span>
</div>