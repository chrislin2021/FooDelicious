<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<link rel="stylesheet" href="../../css/Product.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<div class="left">
	<div class="row" id="rowSelect">
		<div class="col-12 col-md-2">
			<div class="list-group">
				<a href="#" class="list-group-item list-group-item-warning">廚具</a>
                <a href="#" class="list-group-item list-group-item-warning">食材</a>
                    
			</div>
		</div>
	</div>
</div>
<!-- <div class="productbody"> -->
<!-- 		<header> -->
<!-- 			<h1>商品列表</h1> -->
<!-- 		</header> -->
<!-- 		<br> -->
<!-- 		<table class="tablebody"> -->
<!-- 			<tr style="background-color: #FF8040"> -->
<!-- 				<th>商品編號 -->
<!-- 				<th>商品圖片 -->
<!-- 				<th>商品公司 -->
<!-- 				<th>商品名稱 -->
<!-- 				<th>商品價格 -->
<!-- 				<th>編輯  -->
<!-- 			</tr> -->
<%-- 			<c:forEach items="${pros}" var="pro"> --%>
<!-- 				<tr> -->
<%-- 					<td>${pro.productId} --%>
<%-- 					<td>${pro.productPics} --%>
<%-- 					<td>${pro.productCompany} --%>
<%-- 					<td>${pro.productName} --%>
<%-- 					<td>${pro.productPrice} --%>
<!-- 					<td> -->
<%-- 						<a href="edit/${pro.productId}">edit</a> --%>
<%-- 						<a href="del?id=${pro.productId}">delete</a> --%>
<!-- 						<a href="">加入購物車</a></td> -->
						
<!-- 				</tr>		 -->
<%-- 			</c:forEach> --%>
<!-- 		</table> -->
<!-- 		<br> -->
<!-- </div> -->
<div class="right">
  <div class="container">
    <div class="row">
        <div class="col-lg-12 my-3">
            <div class="pull-right">
                <div class="btn-group">
                    <button class="btn btn-outline-primary" id="list">列表</button>
                    <button class="btn btn-outline-warning" id="grid">網格</button>
                </div>
            </div>
        </div>
    </div> 
    		<div id="products" class="row view-group">
    		  <c:forEach items="${pros}" var="pro">
                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card h-100">
                        <div class="img-event">
                        	<a href ="/Product/${pro.productId}">
                            <img class="group list-group-image img-fluid" src="/img/${pro.productPics}" alt="" style="width:260px ;height:260px"/>
                            </a>
                        </div>
                        <div class="caption card-body">
                        	<h3 class="item-product-company text-secondary">${pro.productCompany}</h3>                       
                            <h4 class="group card-title inner list-group-item-heading fw-bolder">${pro.productName}</h4>
                            <p class="group inner list-group-item-text">${pro.productContent}</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead text-danger fs-4 text fw-bold">$${pro.productPrice}</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-danger" href="/ProductDetail">加入購物車</a>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </div> 
              </c:forEach>
           </div>
        </div>
      </div>
     
	<script type="text/javascript">
		function check(productId) {
			if (confirm("確定刪除?")) {
				window.location.href = "DeletePro?productId=" + productId;
			} else {
			}
		}
		$(document).ready(function() {
            $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
            $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
        });
	</script>
</body>