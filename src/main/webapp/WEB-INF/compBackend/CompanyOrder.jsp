<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<body>
	<h1 class="tableName">
		訂單列表<span class="smallFont">Order List</span>
	</h1>

	<section class="content">
		<div class="col-xs-12">
			<table id="" class='table table-striped table-hover '>
				<thead>
					<tr>
					   
						<th class="col table-warning smalW">訂單編號</th>
						<th class="col table-warning midW">會員帳號</th>
						<th class="col table-warning midW">收件人姓名</th>
						<th class="col table-warning midW">收件人電話</th>
						<th class="col table-warning large">收件人地址</th>
						<th class="col table-warning smalW">訂單狀態</th>
						<th class="col table-warning smalW">訂單金額</th>
						<th class="col table-warning midW">新增日期</th>
						<th class="col table-warning smalW">更新</th>
					</tr>
				</thead>
				<tbody id="orders"></tbody>
			</table>
			<nav aria-label="Page navigation example ">
				<ul id="page" class="pagination justify-content-center"></ul>
			</nav>
			<input type="text" hidden id="companyId" value='${userID}'>
			
		</div>
	</section>



	<script>

				//=============顯示所有商品資料=============
		window.onload = function() {
					
			$.ajax({
				url: "/companyProducts",
				type: "GET",
				success: function(allCompanyProducts){
					
				}
			});
					
			let companyId = $("#companyId").val();

			
 			$.ajax({
 				url : "/companyOrders",
 				type : "GET",
 				success : function(allOrderDetails) {
 					let len = allOrderDetails.length;
 				
 					alert(len);
 					
//   					for(let i = 0 ; i < len ; i ++){
  						
//   						let orderDetailJson = JSON.parse(allOrderDetails[i].productDetail);
  						
//   						let jsonLen = Object.keys(orderDetailJson).length;
  						
//   						for(let j = 0 ; j < jsonLen ; j ++){
  							
//   							let productId = orderDetail[j].id;
								
								
//   						}
  						
  						
//   					}

   					alert(allOrderDetails[1].productDetail);
   					
   					let orderDetailJson = JSON.parse(allOrderDetails[1].productDetail);
   					
   					alert(orderDetailJson);
   					
   					alert(Object.keys(orderDetailJson).length)
   					
   					alert("productId: " +orderDetailJson[0].id);
   					
   					
  					
//   					alert(allOrderDetails[1].productDetail[1]["id"]);
					
//  					for (let i = 0 ; i < len ; i++){
 						
//  						//alert(Object.keys(allOrderDetails[i]));
//  					}
 					
 					
 					
 					
 					
 					
//  					if (len >= 10) {
//  						pages(10, productData);
// 					} else {
//  						pages(len, productData);
// 					}
 				}
 			});
 		};
		
		

	</script>

</body>