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
				var num = 0;
				for (let cart of carts) {
					str += '<tr>';
					str += '<th scope="row"><input type="checkbox" name="c"></th>';
					str += '<td>' + cart.product.productName + '</td>';
					str += '<td>' + cart.product.productPrice + '</td>';
					str += '<td><button type="button" class="btn btn-secondary btn-sm" onclick="changeNum(' + cart.productId + ',' + -1 + ')" id="minus" ><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-minus"><line x1="5" y1="12" x2="19" y2="12"></line></svg></button>'
						+ ' <input class="num" [type="number"]  readonly="readonly" value=' + cart.quantity + ' />'
						+ ' <button type="button" class="btn btn-primary btn-sm" onclick="changeNum(' + cart.productId + ',' + 1 + ')" id="add" ><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus"><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg></button></td>';
					str += '<td>' + (cart.product.productPrice * cart.quantity) + '<input type="hidden" id="itemTotal" value=' + (cart.product.productPrice * cart.quantity) + '></td>';
					str += '<td><button onclick="deleteItem(' + cart.product.productId + ')"class="btn btn-dark btn-sm"</td><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg></button>';
					str += '</tr>';
					num += cart.product.productPrice * cart.quantity;
				}
				var temp = goldCoin();
				num -= temp;
				freight(num)
				if (num < 1000) {
					num += 100;
					$("#pay").attr("value", "NT$: " + num + " 元");
				} else {
					$("#pay").attr("value", "NT$: " + num + " 元");
				}
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
			Swal.fire(
				"刪除成功!",
				"(((ﾟдﾟ)))",
				"success"
			)
			showItem();
		}
	})
}

function freight(num) {
	var str = "";
	if (num < 1000) {
		$("#freight").empty();
		str += '運費：<span>100 元</span>';
		$("#freight").append(str);
	} else {
		$("#freight").empty();
		str += '運費：<del style="color: red;">100 元</del>&nbsp;&nbsp;<span>0 元</span>';
		$("#freight").append(str);
	}
}

function goldCoin() {
	var coin = $("#goldCoin").val();
	return coin;
}

function minusNum(num) {
	var coin = goldCoin();
	coin -= Number(num);
	alert(coin);
}

//function addNum(num){
//	var coin = $("$goldCoin").val();
//	coin += Number(num);
//	alert(coin)
//}

$("#button-addon1").click(function() {
	var discount = $("#discount").val();
	discountTotal(discount);
})

function discountTotal(discount) {
	$.ajax({
		url: "/shoppingCart/discountTotal/" + discount,
		type: "GET",
		success: function(priceTotal) {
			$("#pay").attr("value", "NT$: " + priceTotal + " 元");
		}
	})
}