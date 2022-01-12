function check_all(obj, cName) {
	var checkboxs = document.getElementsByName(cName);
	for (var i = 0; i < checkboxs.length; i++) {
		checkboxs[i].checked = obj.checked;
	}
}

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
					str += '<th scope="row"><input type="checkbox" name="c"></th>';
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
			if (priceTotal < 1000) {
				$("#freight").empty();
				str += ' 運費：<span>100 元</span>';
				$("#freight").append(str);
				priceTotal += 100;
				$("#pay").attr("value", "NT$: " + priceTotal + " 元");
			} else {
				$("#freight").empty();
				str += '運費：<del style="color: red;"> 100 元</del>&nbsp;&nbsp;<span>0 元</span>';
				$("#freight").append(str);
				$("#pay").attr("value", "NT$: " + priceTotal + " 元");
			}
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
				var temp = "";
				if (productPolymers != null) {
					for (let productPolymer of productPolymers) {
						temp += '<tr>';
						temp += '<td>' + productPolymer.productPics + '</td>';
						temp += '<td>' + productPolymer.productName + '</td>';
						temp += '<td>' + productPolymer.productPrice + '</td>';
						temp += '<td><input type="number" ></td>';
						temp += '<td><button type="button" class="btn btn-success" onclick="addToCart()">加入購物車</button></td>';
					}
				}
				alert(temp);
			}
		})
	}
}