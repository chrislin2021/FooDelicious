function showItem() {
	$.ajax({
		url: "/shoppingCart/show",
		type: "GET",
		contentType: "application/json; charset=utf-8",
		success: function(carts) {
			if (carts != null) {
				$("#cartList").empty();
				var str = "";
				for (let cart of carts) {
					str += '<tr>';
					str += '<th scope="row"><img src="/img/' + cart.product.productPics + '"style="width:60px ;height:60px"></th>';
					str += '<td>' + cart.product.productName + '</td>';
					str += '<td>' + cart.product.productPrice + '</td>';
					str += '<td><button type="button" class="btn btn-secondary btn-sm" onclick="changeNum(' + cart.productId + ',' + -1 + ')" id="minus" ><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-minus"><line x1="5" y1="12" x2="19" y2="12"></line></svg></button>'
						+ ' <input class="num" [type="number"]  readonly="readonly" value=' + cart.quantity + ' />'
						+ ' <button type="button" class="btn btn-primary btn-sm" onclick="changeNum(' + cart.productId + ',' + 1 + ')" id="add" ><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus"><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg></button></td>';
					str += '<td>' + (cart.product.productPrice * cart.quantity) + '</td>';
					str += '<td><button onclick="deleteItem(' + cart.product.productId + ')"class="btn btn-dark btn-sm"</td><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg></button>';
					str += '</tr>';
				}
				discountTotal();
				$("#cartList").html(str);
			}
		}
	})
}

function addToCart(productId) {
	var quantity = $("#pdQty").val();
	var postData = { "pid": productId, "qty": quantity };
	$.ajax({
		url: "/shoppingCart/insert",
		type: "POST",
		data: JSON.stringify(postData),
		contentType: "application/json; charset=utf-8",
		success: function() {
			showItem();
		}
	})
}

function changeNum(productId, quantity) {
	$.ajax({
		url: "/shoppingCart/" + productId + "/" + quantity,
		type: "PUT",
		success: function() {
			showItem();
		}
	})
}

function deleteItem(productId) {
	$.ajax({
		url: "/shoppingCart/" + productId,
		type: "DELETE",
		success: function() {
			const Toast = Swal.mixin({
				toast: true,
				position: 'top-end',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			})
			Toast.fire({
				icon: 'success',
				title: '刪除成功！！！'
			})
			showItem();
		}
	})
}

function minusNum() {
	var coin = $("#goldCoin").val();
	coin--;
	if (coin < 0) {
		coin = 0;
	}
	$("#goldCoin").attr("value", coin);
	discountTotal();
}

function addNum() {
	var coin = $("#goldCoin").val();
	var limit = $("#hiddenCoin").val();
	coin++;
	if (coin > limit) {
		coin = limit;
	}
	$("#goldCoin").attr("value", coin);
	discountTotal();
}

$("#button-addon1").click(function() {
	discountTotal();
})

function discountTotal() {
	var discounts = $("#discount").val();
	var coin = $("#goldCoin").val();
	if (discounts != "") {
		disocunts = discounts;
	} else {
		discounts = "No Discount";
	}
	$.ajax({
		url: "/shoppingCart/discountTotal/" + discounts + "/" + coin,
		type: "GET",
		success: function(priceTotal) {
			var str = "";
			if (priceTotal < 1100) {
				$("#freight").empty();
				str += ' 運費：<span>100 元</span>';
				$("#freight").append(str);
				$("#pay").attr("value", "NT$: " + priceTotal + " 元");
			} else {
				$("#freight").empty();
				str += '運費：<del style="color: red;">100 元</del>&nbsp;&nbsp;<span>0 元</span>';
				$("#freight").append(str);
				$("#pay").attr("value", "NT$: " + priceTotal + " 元");
			}
			discountMoney(discounts, coin);
		}
	})
}

function discountMoney(discounts, coin) {
	$.ajax({
		url: "/getContent/" + discounts + "/" + coin,
		type: "GET",
		success: function(discountContent) {
			$("#discountPrice").attr("value", discountContent);
		}
	})
}

function searchProduct() {
	var name = $("#appleNoSale").val();
	if (name != null) {
		$.ajax({
			url: "/searchProduct/" + name,
			type: "GET",
			contentType: "application/json; charset=utf-8",
			success: function(productPolymers) {
				var product = "";
				if (productPolymers != null) {
					$(".productInformation").empty();
					for (let productPolymer of productPolymers) {
						product += '<tr>';
						product += '<td><img src=/img/' + productPolymer.productPics + ' style="width:30px ;height:30px"></td>';
						product += '<td>' + productPolymer.productName + '</td>';
						product += '<td>NT$:' + productPolymer.productPrice + '元</td>';
						product += '<td><input id="pdQty" type="number" value = 1 min=1 max=' + productPolymer.productStock + '></td>';
						product += '<td><button type="button" class="btn btn-danger btn-sm" onclick="addToCart(' + productPolymer.productId + ')"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-zoom-in"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line><line x1="11" y1="8" x2="11" y2="14"></line><line x1="8" y1="11" x2="14" y2="11"></line></svg></button></td>';
						product += '</tr>';
					}
				}
				$(".productInformation").html(product);
			}
		})
	}
}