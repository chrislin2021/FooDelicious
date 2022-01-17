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
		<ul id="selectPage" class="nav nav-tabs">
			<li class="nav-item"><a id="all" class="nav-link active"
				aria-current="page" href="#">更新會員資料</a></li>
			<li class="nav-item"><a id="address" class="nav-link" href="#">更新會員寄貨地址</a>
			</li>
		</ul>
		
		<div class="input-group mb-3">
			<span class="input-group-text">會員帳號：</span>
			<form:input type="text" readonly="true" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberMail"
				path="memberMail" />
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
			<span class="input-group-text">會員地址：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberAddress"
				path="memberAddress" />
			<form:errors path="memberAddress" cssClass="error" />
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text">寄貨地址：</span>
			<form:input type="text" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default" id="memberAddress"
				path="memberAddress" />
			<form:errors path="memberAddress" cssClass="error" />
		</div>

		<button type="submit" class="btn btn-outline-primary" id='sendData'>確認更改</button>

	</form:form>
	<a href="<c:url value='/listAllMembers'/> ">回前頁</a>
</div>


