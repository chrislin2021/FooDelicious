<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<body>
	<h1 class="tableName titleName2">
		訂單列表<span class="smallFont">Order List</span>
	</h1>
	<div class="searchArea">
		<input class="keyWord keyWord1 searchBox" type="text"
			name="accKeyWord" placeholder="請輸入關鍵字"> <input id="searchAcc"
			class="keyWord btn btn-outline-secondary searchBox2 " type="button"
			value="查詢" />
	</div>
	<ul id="selectPage" class="nav nav-tabs">
		<li class="nav-item"><a id="all" class="nav-link active"
			aria-current="page" href="#">全部訂單</a></li>
	</ul>
	<section class="content">
		<div class="col-xs-12">
			<table id="" class='table table-striped table-hover '>
				<thead>
					<tr>
						<th class="col table-warning smalW">訂單編號</th>
						<th class="col table-warning midW">會員帳號</th>
						<th class="col table-warning smalW">收件人姓名</th>
						<th class="col table-warning smalW">收件人電話</th>
						<th class="col table-warning large">收件人地址</th>
						<th class="col table-warning large">購買商品</th>
						<th class="col table-warning large">購買數量</th>
						<th class="col table-warning smalW">訂單金額</th>
						<th class="col table-warning midW">下單日期</th>

					</tr>
				</thead>
				<tbody id="orders"></tbody>
			</table>
			<nav aria-label="Page navigation example ">
				<ul id="page" class="pagination justify-content-center"></ul>
			</nav>
			<input type="text" hidden id="companyId" value='${userID}'>
			<input type="button" value="umm" onclick="show()">
			<input type="button" value="umm" onclick="show2()">
		</div>
	</section>


	<script>
		//=============顯示所有商品資料=============

		let companyId = $("#companyId").val();
		let companyProductIdsGlobal;
		let totalProductsLength;
		let allFoundCompanyOrders = new Array();
		//測試用 記得把function show() 拔掉
		function show(){
			
			$.ajax({
				url : "/companyProducts",
				type : "GET",
				success:function(companyProducts){
					let num = companyProducts.length;
					alert(num);
 					const companyProductIdsLocal = new Array();
					for(let j = 0 ; j < num ; j++){
						companyProductIdsLocal.unshift(companyProducts[j].productId);
					}
					
					//把company product ids 值傳到全域
					companyProductIdsGlobal = companyProductIdsLocal;
					
					let totalProducts = companyProductIdsGlobal.length;
					
					//把product length 值傳到全域
					totalProductsLength = totalProducts;
				},error: function(){
					alert("get product ids fail.")
 				}
			})
			
		}
		
		
		

		
		
		function show2 (){
			
			$.ajax({
				url : "/companyOrderDetails",
				type : "GET",
				success: function(allCompanyOrderDetails){
	 				let totalOrders = allCompanyOrderDetails.length;
	 				//alert(totalOrders);
	 				//console.log(allCompanyOrderDetails[0]);
	 				
					
// 	  				for (let i = 0; i < totalOrders; i++) {
// 	 					for(let z = 0 ; z < totalProductsLength ; z++ ){
// 	 						//如果產品id是該家公司的 把該筆order detail存進?哪裡
// 	 						if(allCompanyOrderDetails[i].product_id == companyProductIdsGlobal[z]){
// 	 							allFoundCompanyOrders.unshift(allCompanyOrderDetails[i]);
// 	 						}
// 	 					}

// 	 				}
					
// 	 			},error:function(){
// 	 				alert("fail")
	 			}
			})
			
		}
	
	</script>



</body>