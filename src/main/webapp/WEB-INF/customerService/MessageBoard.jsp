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
<title>問答紀錄</title>
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
}

/* Style inputs */
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

/* Style the container/contact section */
.container {
  border-radius: 5px;
  background-color: transparent;
  padding: 10px;
}

/* Create two columns that float next to eachother */
.column {
  float: left;
  width: 50%;
  margin-top: 6px;
  padding: 20px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.column, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}

/* ########################################### */
/*                 Global                      */
/* ########################################### */
html{

    font-family: 'Titillium Web', sans-serif;
    background-color:rgb(0,0,0);
    color:#FFFFFF;
}

h1{
    font-size:40px;
	font-weight: bolder;
	float:right;
}

/* posts table's head  */
.table-head{
    display: flex;
}

.table-head div{
    padding: 5px;
    margin: 2px;
    background-color: #B4A7D6;
    font-weight: bold;
}

.table-head .status{
    flex: 5%;
}

.table-head .subjects{
    flex: 70%;
}

.table-head .replies{
    flex: 10%;
}

.table-head .last-reply{
    flex: 15%;
}

/* posts table's body  */

.table-row{
    display: flex;
}

.table-row .status, .table-row .subjects, .table-row .replies, .table-row .last-reply{
    padding: 5px;
    margin: 2px;
    background-color: #FFD966;
}

.table-row .status{
    flex: 5%;
    font-size: 30px;
    text-align: center;
}

.table-row .subjects{
    flex: 70%;
}

.table-row .replies{
    flex: 10%;
}

.table-row .last-reply{
    flex: 15%;
}

/* Pagination for post*/

.pagination{
    padding: 20px;
    font-size: 15px;
}

.pagination a{
    color: #fff;
    margin-inline: 5px;
    padding: 5px 10px;
    border: solid 0.5px #fff;
}

.pagination a:hover{
    opacity: 0.5;
}

.note{
    background-color:#FFD966;
    padding: 20px;
    display: block;
}

.note span{
    font-size: 20px;
    margin-block: 5px;
}

.head{
    display: flex;
    background-color: #FFD966;
    padding: 5px;
    font-weight: bold;
    font-size: 15px;
}

.authors{
    flex: 20%;
}

.content{
    flex: 50%;
    font-size:24px;
    margin:15px;
}


.body{
    display: flex;
    background-color: #FFFFFF;
    box-shadow:2px 2px #979A9A;
    padding: 10px;
    margin-top: 5px;
    border-radius: 6px;
    border:1px solid #7B7D7D;
}

.body .authors .username{
    font-size: 20px;
}

.body .authors img{
    max-width: 50px;
    max-height: 80px;
}

.body .content .comment button{
    border:none;
    border-radius: 4px;
    margin: 5px;
    padding:12px 20px;
    font-color: #FFFFFF;
    font-weight: bold;
    cursor: pointer;
    float: right;
    background-color: #4CAF50;
}

.body .content .comment button:hover{
    background-color:#45a049;
}

.body .content {
	position:float-right;
}
/* comment section */
.comment-area{
    margin-bottom:50px;
}

.comment-area textarea{
    width: 100%;
    min-height: 100px;
    padding: 10px;
    margin-block: 10px;
}

.comments-container {
	width:75%;
	position:relative;
}

.comment-area input{
    float: right;
    padding: 10px;
    border-radius: 10px;
    cursor: pointer;
}

.comment-area input:hover {
    border: solid 1px #000000;}


</style>

</head>
<body>
	<h1>問答紀錄</h1>
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
                        <label id="customerProblemText${message.getId()}">問題內容：${message.getProblem_Text()}</label>
                        <input type=hidden id="labelId${message.getId()}" value="${message.getProblem_Text()}"></input>
                        <br />
                        留言時間：${message.getProblem_postTime()}
                    
                    <div class="comment">
                        <button onclick="showCommentEditor()">編輯留言</button>
                    	<button onclick="showComment()">刪除留言</button>                     
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>

</body>
</html>