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
    font-size: 14px;
    font-family: 'Titillium Web', sans-serif;
    background-color:rgb(0,0,0);
    color:#FFFFFF;
}


h1{
    font-size:16px;
    font-weight: bolder;
}


/* ########################################### */
/*           Forums.html                       */
/* ########################################### */
.container{
    margin: 20px;
    padding: 20px;
}

.subforum{
    margin-top:20px;
}

.subforum-title{
    background-color:#FFFFFF;
    padding: 5px;
    border-radius: 5px;
    margin:4px;
}

.subforum-row{
    display: grid;
    grid-template-columns: 7% 60% 13% 20%;
}

.subforum-column{
    padding: 10px;
    margin:4px;
    border-radius: 5px;
    background-color:#FFFFFF;
}

.subforum-description *{
    margin-block: 0;
}

.center{
    display: flex;
    justify-content: center;
    align-items: center;
}

.subforum-icon i{
    font-size: 45px;
}

.subforum-devider{
    display: none;   
}


/* For the smartphones */
@media screen and (max-width: 460px) {
    .container{
        margin: 10px;
        padding: 10px;
    }

    .subforum-row{
        display: grid;
        grid-template-columns: 25% 75%;
        grid-template-rows: 65% 35%;
    }

    .subforum-devider{
        display: block;
        border: 0;
        height: 1px;
        background-image: linear-gradient(to right, rgba(190, 190, 190, 0), rgba(255, 255, 255, 0.75), rgba(190, 190, 190, 0));
    }

}

/* ########################################### */
/*            posts.html                       */
/* ########################################### */

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
    flex: 80%;
}

.body{
    display: flex;
    background-color: #D9EAD3;
    padding: 10px;
    margin-top: 5px;
    border-radius: 4px;
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
	<h2>問答紀錄</h2>
	<br />

        <!--Another Comment With replies-->
        <c:forEach var="message" items="${abc}">
        <div class="comments-container">
            <div class="body">
<!--                 <div class="authors"> -->
<!--                     <div class="username"><a href="">AnotherUser</a></div> -->
<!--                     <div>Role</div> -->
<!--                     <img src="https://cdn.pixabay.com/photo/2015/11/06/13/27/ninja-1027877_960_720.jpg" alt=""> -->
<!--                 </div> -->
                <div class="content">
                    
                        ${message.getCstm_name()}
                        <br />
                        ${message.getProblem_Type()}
                        <br />
                        ${message.getProblem_Text()}
                        <br />
                        ${message.getProblem_postTime()}
                    
                    <div class="comment">
                        <button onclick="showReply()">編輯留言</button>
                    	<button onclick="showComment()">刪除留言</button>
                        <button onclick="location.href = 'http://localhost:8080/customerService/ReplyPage';">客服回覆</button>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
        <!--Reply Area-->
<!--         <div class="comment-area hide" id="reply-area"> -->
<!--             <textarea name="reply" id="" placeholder="reply here ... "></textarea> -->
<!--             <input type="submit" value="submit"> -->
<!--         </div> -->
    </div>

</body>
</html>