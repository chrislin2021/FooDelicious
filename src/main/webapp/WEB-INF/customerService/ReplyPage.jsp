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
<title>客服回覆</title>
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
	margin: 0;
	padding: 0;
}

#container {
	width: 500px;
	height: 500px;
}

#sendMessage {
	width: 500px;
	height: 50px;
	line-height: 50px;
	margin-bottom: 30px;
}

#content {
	width: 500px;
	height: 400px;
	border: 1px solid #808080;
	overflow: scroll;
}

#messColumn {
	width: 300px;
}
</style>

</head>
<body>

	<h2>客服回覆</h2>
	<br/>
	<form:form class="form-horizontal" method="POST"
		modelAttribute="customerService" autocomplete="on">
		<!--  customerService是物件的型別-->
		<div class="form-group">
			<label class="control-label" for="type">問題類別</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="problem_Type" name="problemType"
					value="" disabled>
			</div>

			<label class="control-label" for="problem_Text">欲回覆之留言</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="problem_Text" name="problemText"
					value="" disabled>
			</div>
		</div>
		<form:form>
			<div class="form-group">
				<label class="control-label" for="replyText">回覆內容</label>
				<div class="col-sm-8">
					<textarea id="reply_Text" name="replyText"
						placeholder="請站在客戶角度思考並理性回應" rows="8" required>
    				</textarea>
				</div>
			</div>
		</form:form>

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
			//$("#name").val("王小明");
			//$("#email").val("mingming11@gmail.com");
			$("#reply_Text").val("謝謝您的留言，很抱歉造成困擾，我們立即幫您處理!");
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