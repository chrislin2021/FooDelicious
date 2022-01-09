<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<body>

	<h1 class="tableName" style="margin: 8px">
		商品列表<span class="smallFont">Product List</span>
	</h1>

	<table class="table table-hover" style='text-align: center'>
		<thead class="table table-dark table-striped">
			<tr>
				<th class="col col2 ">編號</th>
				<th class="col col1 ">類別</th>
				<th class="col col3 ">公司</th>
				<th class="col col5 ">上架狀態</th>
				<th class="col col5 ">商品名稱</th>
				<th class="col col6 ">商品概述</th>
				<th class="col col7">價格</th>
				<th class="col col6 ">庫存</th>
				<th class="col col8">新增日期</th>


				<th class="col col8">更新</th>
				<th class="col col9">刪除</th>
			</tr>
		</thead>
		<tbody>
			<form>
				<tr>
					<td class='align-middle'><input
						class="upInput readonly text-middle upInputSm" type="text"
						value="" readonly id="productId" style="width:50px"></td>
						
					<td class='align-middle'><input class="upInput" type="text"
						value="" readonly id="productCat" style="width:50px"></td>

					<td class='align-middle'><input class="upInput" type="text"
						value="" id="productCompany" style="width:80px"></td>
						
					<td class="align-middle">
					<select id="productStatus"
						class="form-select upInput text-middle upInputMd">
							<option value="" id="productStatus" selected></option>
							<option value="1">上架</option>
							<option value="0">下架</option>

					</select></td>
					<td class='align-middle'><input class="upInput" type="text"
						value="" id="productName" style="width:80px"></td>
						
					<td class='align-middle'><input class="upInput" type="text"
						value="" id="productContent" style="width:140px"></td>
						
					<td class='align-middle'><input class="upInput" type="text"
						value="" id="productPrice" style="width:50px"></td>
						
					<td class='align-middle'><input class="upInput" type="text"
						value="" id="productStock" style="width:50px"></td>
						
					<td class='align-middle'><input class="upInput" type="text"
						value="" id="productDate"></td>
						
				
					<td class="align-middle"><input id="updateBtn"
						class="btn btn-outline-primary" type="button" value="更新">
					</td>
					<td class=""><input id="delBtn" class="btn btn-outline-danger"
						type="button" value="取消" onclick="cancel()"></td>
				</tr>
			</form>

		</tbody>

	</table>

	<span id="total"> </span>



	<%-- 	<c:set var="userID" value="${userID}"/> --%>
	<%-- 	${userID} --%>


	<script>
		//=============刪除確認=============

		$("#comProducts").on("click", "#delBtnCom", function() {
			let deleteProductId = $(this).attr("data-id")

			if (confirm("確定要刪除嗎")) {
				$.ajax({
					url : "/companyProducts/delete/" + deleteProductId,
					type : "DELETE",
					success : function() {
						alert("刪除成功");
						window.location.href = "/companyProduct2";
					}
				});
			}
		})
	</script>

	<script>
		//=============更新商品資料=============

		//更新前先查詢出資料
		$("#comProducts")
				.on(
						"click",
						"#updateBtn",
						function() {
							let data = $(this).attr("data-id")
							$
									.ajax({
										url : "http://localhost:8080/companyProducts/update/"
												+ data,
										type : "GET",
										success : function(product) {
											//將json字串化
											let productString = JSON
													.stringify(product);
											//將資料存到localStorage，給另一個頁面使用
											localStorage.setItem("productData",
													memberString);
											//跳轉頁面
											window.location.href = "http://localhost:8080/companyProduct2/update";
										}
									})

						});
	</script>

	<script>
		//=============抓取另一頁傳來的資料=============
		// jsp 資料傳jsp 忠和哥好強ㄚㄚㄚ
		let productString = localStorage.getItem("productData")
		//將字串json化
		let product = JSON.parse(productString);
		//填入資料
		$("#productId").val(product.productId);
		$("#productCat").val(product.productCategories_name);
		$("#productStatus").text(product.productStatus);
		$("#productStatus").val(product.productStatus);
		$("#productName").val(product.productName);
		$("#productCompany").val(product.productCompany);
		$("#productContent").val(product.productContent);
		$("#productPrice").val(product.productPrice);
		$("#productStock").val(product.productStock);
		$("#productSalesFigures").val(product.productSalesFigures);
		
		let newDate = new Date(product.productInsertDate);
		let register = newDate.toLocaleString();
		$("#productDate").val(register);
	</script>




	<script>
		//顯示所有資料
		const productUrl = "http://localhost:8080/companyProducts";
		let productData;

		$.ajax({
			url : productUrl,
			type : "GET",
			success : function(products) {
				//將值傳到全域
				productData = products;

				//=================分頁功能================
				//最大頁數
				var maxPage;
				//目前顯示頁數
				let nowPage = 0;
				//每頁最大筆數
				let maxItems = products.length;
				//設定起始編號
				let startItem = 0;
				//設定結束編號
				let endItem = maxItems;

				//讀回資料時就先顯示
				showData(startItem, endItem);

			}
		});

		//顯示資料
		function showData(startItem, endItem) {

			let txt = "<tr>";
			for (let i = startItem; i < endItem; i++) {

				txt += "<td class='align-middle'>" + (i + 1) + "</td>"

				let cate = productData[i].productCategories;
				let type = ""
				if (cate == 0) {
					type = "廚具";
				} else {
					type = "食材";
				}

				txt += "<td class='align-middle'>" + type + "</td>"

				txt += "<td class='align-middle'>"
						+ productData[i].productCompany + "</td>"

				let st = productData[i].productStatus;
				let status = ""
				if (st == 1) {
					status = "上架中";
				} else {
					status = "下架中";
				}
				txt += "<td class='align-middle'>" + status + "</td>"
				txt += "<td class='align-middle'>" + productData[i].productName
						+ "</td>"
				txt += "<td class='align-middle'>"
						+ productData[i].productContent + "</td>"
				txt += "<td class='align-middle'>"
						+ productData[i].productPrice + "</td>"
				txt += "<td class='align-middle'>"
						+ productData[i].productStock + "</td>"
				txt += "<td class='align-middle'>"
						+ productData[i].productSalesFigures + "</td>"

				let newDate = new Date(productData[i].productInsertDate);
				let register = newDate.toLocaleString();
				txt += "<td class='align-middle'>" + register + "</td>"

				txt += '<td class="align-middle">'
						+ '<form method="" >'
						+ '<input type="hidden" type="text" name="memupd" value=?>'
						+ '<input id="updateBtnCom" class="btn btn-secondary btn-sm" type="button" value="更新" data-id='+productData[i].productId+'>'
						+ '</form>' + '</td>'
				txt += '<td class="mdata">'
						+ '<form method="" action="">'
						+ '<input type="hidden" type="text" name="empdel" value=?>'
						+ '<input id="delBtnCom" class="btn btn-danger btn-sm" type="button" value="刪除" data-id='+productData[i].productId+'>'
						+ '</form>' + '</td></tr>'

			}

			$("#comProducts").html(txt);
			let total = '<h1>共' + endItem + '個商品</h1>';
			

		}
	</script>
</body>
