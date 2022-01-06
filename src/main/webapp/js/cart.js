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
				$(".table tbody").empty();
				var obj = JSON.parse(carts);
				var str = "";
				for (let carts of obj) {
					str += '<tr><th scope="row"><input type="checkbox" name="c"></th><td>'
						+ carts.product.productName + '</td><td>' + carts.product.productPrice +
						'</td><td><input type="number" value=' + carts.quantity + 'min=1 max=' + carts.product.productStock +
						'></td><td>' + (carts.product.productPrice * carts.quantity) + '</td><td><button onclick=deleteItem(' + carts.product.productId + ')+class=link-dark</tr>'
				}
				$(".table tbody").append(str);
			}
		}
	})
}

function deleteItem(productId) {
	$.ajax({
		url: "/shoppingCart/" + productId,
		type: "DELETE",
		success: function() {
			showItem();
		}
	})
}