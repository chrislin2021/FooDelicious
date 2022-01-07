function check_all(obj, cName) {
	var checkboxs = document.getElementsByName(cName);
	for (var i = 0; i < checkboxs.length; i++) {
		checkboxs[i].checked = obj.checked;
	}
}

//showItem();

function showItem() {
	$.ajax({
		url: "/showCart",
		type: "GET",
		contentType: "application/json; charset=utf-8",
		success: function(carts) {

			if (carts != null) {
				$(".table tbody").empty();
				var str = "";
				for (let cart of carts) {
					//					alert(cart.quantity);
					str += '<tr>';
					str += '<th scope="row"><input type="checkbox" name="c"></th>';
					str += '<td>' + cart.product.productName + '</td>';
					str += '<td>' + cart.product.productPrice + '</td>';
					str += '<td>' + '<input type="number" value=' + cart.quantity + ' min="1" max=' + cart.product.productStock + '></td>';
					str += '<td>' + (cart.product.productPrice * cart.quantity) + '</td>';
					str += '<td><button onclick="deleteItem(' + cart.product.productId + ')"class="link-dark"</td><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg></button>';
					str += '</tr>';
				}
				$("#cartList").html(str);
			}
		}
	})
}

//function insertItem() {
//	$.ajax({
//		url:
//			type:
//	})
//}

function deleteItem(productId) {
	$.ajax({
		url: "/shoppingCart/" + productId,
		type: "DELETE",
		success: function() {
			showItem();
		}
	})
}