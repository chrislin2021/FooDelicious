$(".checkout").on("click", function() {
	var orders = {
		ordersName: $("#name").val(),
		ordersPhone: $("#phone").val(),
		ordersAddress: $("#address").val(),
	}

	$.ajax({
		url: "/orders/insert",
		type: "POST",
		contentType: "application/json;charset=utf-8;",
		data: JSON.stringify(orders),
		success: function() {
			window.location.href = "ordersEnd";
		}
	})
})