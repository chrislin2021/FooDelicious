<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<body>
<div align='center'>
<h3>註冊會員</h3>
		    <c:set var='updateurl' value='${pageContext.request.contextPath}/members/${id}' />
		<form:form class="form" method="POST" modelAttribute="member">
		
		<div class="input-group mb-3">
			<span class="input-group-text">會員帳號：</span> <form:input type="text" 
				class="form-control" aria-label="Sizing example input"	
				aria-describedby="inputGroup-sizing-default" id="memberMail"
				path ="memberMail" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員密碼：</span> <input type="password"
				class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="pwd" name="pwd">
		</div>
		
		<div class="input-group mb-3">
				<span class="input-group-text">會員姓名：</span>
				<form:input type="text" class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default" id="memberName" path="memberName" />
		</div>
		
		<div class="form-check form-check-inline">
			<span class="input-group-text">會員性別：</span> 
			<form:radiobutton class="form-check-input"  path="memberGender" id="member_gender_m" value="male" /> 
			<label class="form-check-label" for="inlineRadio1">男</label>
		</div>
		
		<div class="form-check form-check-inline">
			<form:radiobutton class="form-check-input" path="memberGender" id="member_gender_f" value="female" /> 
			<label class="form-check-label" for="inlineRadio2">女</label>
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">出生日期：</span> 
			<form:input type="date" class="form-control" aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-default" id="memberBirth" path="memberBirth" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員電話：</span> 
			<form:input type="tel" class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberPhone" path="memberPhone" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員地址：</span> 
			<form:input type="text"	class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberAddress" path="memberAddress" />
		</div>
		
		<form:input type="hidden"	class="form-control" aria-label="Sizing example input" 
				aria-describedby="inputGroup-sizing-default"  path="memberDiscountId" />
				
		<form:input type="hidden"	class="form-control" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default"  path="memberCoin" />

<!-- 		<div> --> 
<!-- 				<label for="photoId">會員照片</label> <input type="file" --> 
<!--					name="memberImage" id="photoId"><br><br> --> 
<!-- 			</div> --> 
			
		<button type="submit" class="btn btn-outline-primary" value="register">註冊</button>
	</form:form> 
	</div>
   
</body>