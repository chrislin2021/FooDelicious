$(".checkout").on("click", function() {
	if ($("#flexRadioDefault1").is(":checked")) {	// 金流服務請寫在else
		if ($("#name").val().length == 0) {
			$(".validate1").removeClass("d-none");
		} else if ($("#phone").val().length == 0) {
			$(".validate2").removeClass("d-none");
		} else if ($("#address").val().length == 0) {
			$(".validate3").removeClass("d-none");
		}

		if ($("#name").val().length == 0 && $("#phone").val().length == 0 && $("#address").val().length == 0) {
			$(".validate1").removeClass("d-none");
			$(".validate2").removeClass("d-none");
			$(".validate3").removeClass("d-none");
		}

		if ($("#name").val().length != 0 && $("#phone").val().length != 0 && $("#address").val().length != 0) {
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
							window.location.href = "/ordersEnd"
						}
					})
				}
			})
		}
	} else {
		window.location.href="/ecpay";
	}
})

function goDetail(ordersId) {
	$.ajax({
		url: "/toOrderDetailPage/" + ordersId,
		type: "GET",
		success: function() {
			window.location.href = "/toOrderDetailPage/" + ordersId;
		}
	})
}