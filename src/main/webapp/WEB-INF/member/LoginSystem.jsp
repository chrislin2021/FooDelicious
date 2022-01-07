<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<body>
<div align="center" >
<h2><b style="color:brown"> ${message} </b></h2>
</div>

<section class="vh-100" style="background-color: #508bfc;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5">會員登入</h3>
			<form action="checklogin.controller" method="post">
            <div class="form-outline mb-4">
              <input type="text" id="memberMail" class="form-control form-control-lg" name="memberMail" placeholder="memberMail" required="required" />
              <label class="form-label" for="memberMail"></label><span id="loginSpan">${errors.memberMail}</span>
            </div>

            <div class="form-outline mb-4">
              <input type="password" id="typePasswordX-2" class="form-control form-control-lg" name="pwd" placeholder="pwd" required="required" />
              <label class="form-label" for="typePasswordX-2"></label><span id="loginSpan">${errors.pwd}</span>
            </div>

            <!-- Checkbox -->
            <div class="form-check d-flex justify-content-start mb-4">
              <input
                class="form-check-input"
                type="checkbox"
                value=""
                id="form1Example3"
              />
              <label class="form-check-label" for="form1Example3">記住密碼</label>
            </div>
			 <a href="RegisterPage" class="link-info">立即註冊</a><br>
            <button class="btn btn-primary btn-lg btn-block" type="submit">送出</button>
           
            <hr class="my-4">

            <button class="btn btn-lg btn-block btn-primary" style="background-color: #dd4b39;" type="submit"><i class="fab fa-google me-2"></i> Sign in with google</button>
            <button class="btn btn-lg btn-block btn-primary mb-2" style="background-color: #3b5998;" type="submit"><i class="fab fa-facebook-f me-2"></i>Sign in with facebook</button>
			</form>
			<span id="loginSpan">${errors.msg}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>