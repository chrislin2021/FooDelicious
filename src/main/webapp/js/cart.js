function check_all(obj, cName) {
	var checkboxs = document.getElementsByName(cName);
	for (var i = 0; i < checkboxs.length; i++) {
		checkboxs[i].checked = obj.checked;
	}
}

function deleteItem(productId) {
	var deleteData = { "productId": productId };
	$.ajax({
		url: "/shoppingCart/" + productId,
		data: JSON.stringify(deleteData),
		type: "DELETE",
		contentType: "application/json;charset=utf-8",
		success: function() {
			window.location.reload();
		}

	})
}