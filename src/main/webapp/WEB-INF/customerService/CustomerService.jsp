<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>客服中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../../css/backend.css">
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../../fontawesome/css/all.css">
<link
	href="https://fonts.googleapis.com/css2?family=Zen+Maru+Gothic:wght@500&display=swap"
	rel="stylesheet">
<script src="../../js/jquery-3.6.0.min.js"></script>

<style>
* {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
}

input[type=text], textarea {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 0px;
	margin-bottom: 15px;
	resize: vertical;
}

label {
	padding-top: 0px;
	padding-bottom: 0px;
	display: inline-block;
	font-size: 20px;
	font-weight: bold;
}

input[type=button] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: center;
	margin: 15px;
	position: center;
}

input[type=button]:hover {
	background-color: #45a049;
}

input[type=radio] {
	width: 20px;
	height: 20px;
}

.container {
	border-radius: 15px;
	padding: 40px;
	margin-top: 20px;
	margin-bottom: 20px;
	position: center;
}

.form {
	border-radius: 15px;
	padding: 40px;
	margin-top: 20px;
	margin-bottom: 20px;
	position: center;
}

.custom-control-label {
	font-weight: normal;
	padding: 5px;
}

h2 {
	font-weight: bold;
}

<!--
Clear floats after the columns -->.form:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.col-sm-10, .col-75, input[type=form] {
		width: 100%;
		margin-top: 0;
	}
	.topDIV {
		margin-top: 16px;
	}
	.hero {
		width: 80%;
		height: 450px;
		position: relative;
		margin: 100px auto;
	}
	.btn-box {
		display: flex;
		border-bottom: 1px solid #ccc;
	}
	.btn-box button {
		background: transparent;
		border: none;
		outline: none;
		cursor: pointer;
		padding: 14px 16px;
		margin-right: 50px;
		font-size: 20px;
		font-weight: bold;
	}
}
</style>
</head>
<body>
	<br />

	<div class="topDIV">
		<ul class="nav nav-tabs">
			<li class="nav items"><a class="nav-link active"
				aria-current="page" href="#">客戶留言</a></li>
			<li class="nav-item"><a class="nav-link" href="#">問答紀錄</a></li>
		</ul>

		<table class="table table-hover">
			<tbody id="articleArea">
			</tbody>
		</table>
	</div>

	<h2>客戶反應中心</h2>
	<p>請留下您的寶貴建議，我們會將盡速與您聯繫，謝謝您!</p>

	<form:form class="form-horizontal" method="POST"
		modelAttribute="customerService" autocomplete="on">
		<!--  customerService是物件的型別-->
		<div class="form-group">
			<label class="control-label" for="name">姓名</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="name" name="name"
					placeholder="範例：王小明" required>
			</div>

			<label class="control-label" for="email">聯絡Email</label>
			<div class="col-sm-8">
				<input type="email" class="form-control" id="email" name="email"
					placeholder="範例：littleming11@gmail.com" required>
			</div>
		</div>
		<br>
		<div class="form-group">
			<label class="control-label" for="problemType">問題類別</label>

			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" id="customRadioInline1"
					name="customRadioInline1" class="custom-control-input" value="Orders"> <label
					class="custom-control-label" for="customRadioInline1">訂單問題</label>
				<input type="radio" id="customRadioInline1"
					name="customRadioInline1" class="custom-control-input" value="Return/Maintenance"> <label
					class="custom-control-label" for="customRadioInline1">退換貨/維修</label>
				<input type="radio" id="customRadioInline1"
					name="customRadioInline1" class="custom-control-input" value="Member"> <label
					class="custom-control-label" for="customRadioInline1">會員相關</label>
				<input type="radio" id="customRadioInline1"
					name="customRadioInline1" class="custom-control-input" value="Refund/Receipt"> <label
					class="custom-control-label" for="customRadioInline1" >退款/發票</label>
				<input type="radio" id="customRadioInline1"
					name="customRadioInline1" class="custom-control-input" value="Other"> <label
					class="custom-control-label" for="customRadioInline1">其他</label>
			</div>
		</div>
		<br />
		<%-- method="POST" action="/addProblem" modelAttribute="customerService"> --%>
		<form:form>
			<div class="form-group">
				<label class="control-label" for="subject">反應事項</label>
				<div class="col-sm-8">
					<textarea id="subject" name="problemText"
						placeholder="請描述您的問題(限500字內)" rows="8" required>
    </textarea>
				</div>
			</div>
		</form:form>
		<%-- 上傳檔案欄位 --%>
<!-- 		<label for="formFileMultiple" class="control-label">上傳檔案</label> -->
<!-- 		<input class="form-control" type="file" id="formFileMultiple" multiple /> -->
		<br />
		<%-- 下方三個按鈕 --%>
		<div class="pagination justify-content-md-center">
			<input type="button" color="#3CB371" value="送出" onclick="sendData();"
				style="height: 50px; width: 100px"> <input type="reset"
				color="#FAF0E6" value="清除" onclick="clearText();"
				style="height: 50px; width: 100px"> <input type="button"
				color="#FFD700" value="一鍵輸入" onclick="enter();"
				style="height: 50px; width: 100px">
		</div>
	</form:form>

	<script>

		function enter() {
			$("#name").val("王小明");
			$("#email").val("mingming11@gmail.com");

			$("#subject").val("服務真方便，期待回購!");
		}
		function clearText() {
			$("#name").val(" ");
			$("#email").val(" ");
			$("#subject").val(" ");
		}

		$(document).ready(function() {
			console.log("ready!");
		});

		function sendData() {
				var ele = document.getElementsByName('customRadioInline1');
				var checkedRadio = ''; 
				for (i = 0; i < ele.length; i++) {
					if (ele[i].checked) {
						checkedRadio = ele[i].value;	
					}
				}
			var submitData = {
				"Id" : "",
				"cstm_name" : $("#name").val(),
				"cstm_email" : $("#email").val(),
				"problem_Type" : checkedRadio,
				"problem_Text" : $("#subject").val(),

			};

			var ajaxRequest = $.ajax({
				type : "POST",
				url : "/customerService/add2",
				dataType : "json",
				data : JSON.stringify(submitData), //formdata1 + '&' + formdata2
				contentType : "application/json;charset=utf-8",
			// 				async : false,
			// 				cache : false,
			// 				contentType : false,
			// 				processData : false,
			});

			ajaxRequest.done(function(response) {
				if (response == true) {
					alert("送出成功");
					self.location= "/customerService";
				} else {
					alert("送出失敗，請重新輸入");
				}
			});

			var formdata = $("#SearchFm").serialize();
		}
	</script>

</body>
</html>

