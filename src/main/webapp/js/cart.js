function check_all(obj, cName) {
	var checkboxs = document.getElementsByName(cName);
	for (var i = 0; i < checkboxs.length; i++) {
		checkboxs[i].checked = obj.checked;
	}
}

function showItem() {
	$.ajax({
		url: "/showCart",
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
					str += '<td><input type="hidden" value=' + cart.quantity + '><button type="button" class="btn btn-secondary btn-sm" onclick="changeNum(' + cart.productId + ',' + -1 + ')" id="minus" ><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-minus"><line x1="5" y1="12" x2="19" y2="12"></line></svg></button>'
						+ '<input class="" [type="number1"]  style="width: 2.5rem;text-align: center;border: none;background-color: transparent;" readonly="readonly" value=' + cart.quantity + ' />'
						+ '<button type="button" class="btn btn-primary btn-sm" onclick="changeNum(' + cart.productId + ',' + 1 + ')" id="add" ><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus"><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg></button></td>';
					str += '<td>' + (cart.product.productPrice * cart.quantity) + '</td>';
					str += '<td><button onclick="deleteItem(' + cart.product.productId + ')"class="link-dark"</td><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg></button>';
					str += '</tr>';
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
		success: function(result) {
			if (result) {
				$(add).prev().val(quantity);
				showItem();
				//				var productPrice = parseInt($(add).parent().prev().html());
				//				$(add).parent().next().html(productPrice * quantity);
				//								$("#total").html(parseInt($("#total").html()) + productPrice);
			}
		}
	});
}

//function changeMinusNum(productId, quantity) {
//	if (quantity > 1) {
//		quantity--;
//		var productId = productId;//$(minus).data("id");
//		$.ajax({
//			url: "/shoppingCart/" + productId + "/" + quantity,
//			type: "PUT",
//			success: function(result) {
//				if (result) {
//					//					$(minus).next().val(quantity);
//					//					var preprice = parseInt($(minus).parent().prev().html());
//					//					$(minus).parent().next().html(preprice * minusNum);
//					//					$("#total").html(parseInt($("#total").html()) - preprice);
//					showItem();
//				}
//			}
//		});
//	}
//}

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