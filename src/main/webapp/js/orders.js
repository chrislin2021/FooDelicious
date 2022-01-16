$(".checkout").on("click", function() {
	let proId = document.getElementsByClassName("productId");
	let proQuantity = document.getElementsByClassName("quantity");
	var ordersData = {};
	var ordersDetail = [];

	var orders = {
		ordersName: $("#name").val(),
		ordersPhone: $("#phone").val(),
		ordersAddress: $("#address").val(),
	}

	for (let i = 0; i < proId.length; i++) {
		ordersData.id = proId[i].innerHTML
		ordersData.quantity = proQuantity[i].innerHTML
		ordersDetail.push({ ...ordersData })
	}

	$.ajax({
		url: "/orders/insert",
		type: "POST",
		contentType: "application/json;charset=utf-8;",
		data: JSON.stringify(orders),
		success: function() {
			$.ajax({
				url: "/ordersDetail/insert",
				type: "POST",
				contentType: "application/json;charset=utf-8;",
				data: JSON.stringify(ordersDetail),
				success: function() {
					window.location.href = "/ordersEnd";
				}
			})
		}
	})
})