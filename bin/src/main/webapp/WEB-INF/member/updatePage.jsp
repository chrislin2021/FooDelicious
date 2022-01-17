<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<style>
.error {
	color: red;
	display: inline-block;
	font-size: 8pt;
}
</style>

<div align='center'>
	<h3>更新會員資料</h3>
	<font color='darkgreen'>&nbsp;${insertSuccess}</font>
	<c:set var='updateurl'
		value='${pageContext.request.contextPath}/members/${memberId}' />
	<form:form method="POST" action="${updateurl}" class="form"
		modelAttribute="member">

		<input type='hidden' name='_method' value='POST'>
		<br>
		<!-- put一定要有底線_method -->
		<form:input type='hidden' path='memberId' />
		<br>&nbsp;
		
		<div class="input-group mb-3">
			<span class="input-group-text">會員編號：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input" readonly="true"
				aria-describedby="inputGroup-sizing-default" path="memberId" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員帳號：</span>
			<form:input type="text" readonly="true" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberMail"
				path="memberMail" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員密碼：</span>
			<form:input type="password" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="pwd" path="pwd" />
				<form:errors path="pwd" cssClass="error" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員姓名：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberName"
				path="memberName" />
				<form:errors path="memberName" cssClass="error" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員性別：</span>
			<div class="radio" style="margin-left: 10px; margin-top: 5px">
				<div class="form-check form-check-inline"
					style="margin-left: 20px; align-items: center">
					<form:radiobutton class="form-check-input" path="memberGender"
						id="member_gender_m" value="MALE" />
					<label class="form-check-label" for="inlineRadio1">男</label>
				</div>
				<div class="form-check form-check-inline">
					<form:radiobutton class="form-check-input" path="memberGender"
						id="member_gender_f" value="FEMALE" />
					<label class="form-check-label" for="inlineRadio2">女</label>
				</div>
			</div>
			<form:errors path="memberGender" cssClass="error" />
		</div>


		<div class="input-group mb-3">
			<span class="input-group-text">出生日期：</span>
			<form:input type="date" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberBirth"
				path="memberBirth" />
				<form:errors path="memberBirth" cssClass="error" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員電話：</span>
			<form:input type="tel" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberPhone"
				path="memberPhone" />
					<form:errors path="memberPhone" cssClass="error" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">會員地址：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberAddress"
				path="memberAddress" />
			<form:errors path="memberAddress" cssClass="error" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">折扣：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input" readonly="true"
				aria-describedby="inputGroup-sizing-default" path="memberDiscountId" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">幣：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input" readonly="true"
				aria-describedby="inputGroup-sizing-default" path="memberCoin" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">身份：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input" readonly="true"
				aria-describedby="inputGroup-sizing-default" path="member_status" />
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text">註冊時間：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input" readonly="true"
				aria-describedby="inputGroup-sizing-default" path="register_date" />
		</div>


		<!-- 			<div> -->
		<!--  				<label for="photoId">會員照片</label>  -->
		<%--  				<form:input type="file" path="memberImage" id="photoId" /><br><br>  --%>
		<!-- 			</div>  -->

		<button type="submit" class="btn btn-outline-primary" id='sendData'>確認更改</button>

	</form:form>
	<a href="<c:url value='/listAllMembers'/> ">回前頁</a>
</div>


