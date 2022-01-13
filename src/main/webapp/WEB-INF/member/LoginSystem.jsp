<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="google-signin-client_id"
	content="676062096-mh4b0oa5ekomddrromhcdjkgl1it3mkv.apps.googleusercontent.com">
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<body>
	<div align="center">
		<font color='red'>&nbsp;${insertSuccess}</font>
	</div>

	<section class="vh-100" style="background-color: #508bfc;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card shadow-2-strong" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">

							<h3 class="mb-5">會員登入</h3>
							<form action="checklogin.controller" method="post">
								<div class="form-outline mb-4">
									<input type="text" 
										class="form-control form-control-lg" name="memberMail" 
										placeholder="memberMail" /> <label
										class="form-label" for="memberMail"></label><span
										id="loginSpan">${errors.memberMail}</span>
								</div>

								<div class="form-outline mb-4">
									<input type="password" id="typePasswordX-2"
										class="form-control form-control-lg" name="pwd" 
										placeholder="pwd" /> <label
										class="form-label" for="typePasswordX-2"></label><span
										id="loginSpan">${errors.pwd}</span>
								</div>

								<!-- Checkbox -->
								<div class="form-check d-flex justify-content-start mb-4">
									<input class="form-check-input" type="checkbox" value=""
										id="form1Example3" /> <label class="form-check-label"
										for="form1Example3">記住密碼</label>
								</div>
								<a href="RegisterPage" class="link-info">立即註冊</a><br>
								<button class="btn btn-primary btn-lg btn-block" type="submit">送出</button>

								<hr class="my-4">

								<!--             <button class="btn btn-lg btn-block btn-primary" style="background-color: #dd4b39;" type="submit"><i class="fab fa-google me-2"></i> Sign in with google</button> -->


							</form>
							<%-- 							<span id="loginSpan">${errors.msg}</span> --%>

							<div class="g-signin2 social_signin" onclick="ClickLogin()"
								data-onsuccess="onSignIn"></div>

							<form method="post" action="${contextRoot}/googleLogin">
								<input type="hidden" id="memberName" name="memberName">
								<input type="hidden" id="memberMail" name="memberMail">
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>

<script>
	var clicked = false;
	function ClickLogin() {
		clicked = true;
	}

	function onSignIn(googleUser) {
		if (clicked) {
			let profile = googleUser.getBasicProfile();
			document.getElementById("memberName").value = profile.getName();
			document.getElementById("memberMail").value = profile.getEmail();
			document.forms[2].submit();
		}
	}
</script>