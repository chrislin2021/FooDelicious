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
</style>

</head>
<body>

<body>
	<h2>問答紀錄</h2>
	<br />

        <!--Another Comment With replies-->
        <c:forEach var="message" items="${abc}">
        <div class="comments-container">
            <div class="body">

                <div class="content">
                    
                        客戶姓名：${message.getCstm_name()}
                        <br />
                        問題類型：${message.getProblem_Type()}
                        <br />
                        <label>問題內容：${message.getProblem_Text()}</label>
                        <input value="${message.getProblem_Text()}"></input>
                        <br />
                        留言時間：${message.getProblem_postTime()}
                    
                    <div class="comment">
                    	<textarea id="replyToCustomer" name="replyText" placeholder="請站在客戶角度並理性回應"
					     rows="8" required></textarea> 
                        <button onclick="">編輯留言</button>
                        <button onclick="location.href = 'http://localhost:8080/customerService/ReplyPage';">客服回覆</button>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
	
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