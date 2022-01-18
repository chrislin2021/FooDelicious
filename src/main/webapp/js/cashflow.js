//$.ajax({
//	url: "/orders/insert",
//	type: "POST",
//	contentType: "application/json; charset=utf-8",
//	data: JSON.stringify(orders),
//	success: function() {
//		$.ajax({
//			url: "/ordersDetail/insert",
//			type: "POST",
//			contentType: "application/json;charset=utf-8;",
//			data: JSON.stringify(ordersDetail),
//			success: function() {
//				if (orders != null) {
//
//
//					for (let order of orders) {
//						str += '<tr>';
//						str += '<td>' + order.ordersId + '</td>';
//						str += '<td>' + order.ordersTotal + '</td>';
//						strorde += '</tr>';
//
//					}
//				}
//			}
//		})
//	}
//})

function showList() {
	$.ajax({
		url: "/shoppingCart/show",
		type: "GET",
		contentType: "application/json; charset=utf-8",
		success: function(carts) {
			alert(carts);
			if (carts != null) {
				$("#cartList").empty();
				var str = "";
				for (let cart of carts) {
					str += '<tr>';
					str += '<td>' + cart.memberId + '</td>';
					str += '<td>' + cart.productId + '</td>';
					str += '<td>' + cart.product.productName + '</td>';
					str += '<td>' + cart.quantity + '</td>';
					str += '<td>' + cart.product.productPrice + '</td>';
					str += '<td>' + (cart.product.productPrice * cart.quantity) + '</td>';
					str += '<td>' + cart.member.memberName + '</td>';
					str += '<td>' + cart.member.memberPhone + '</td>';
					str += '<td>' + cart.member.memberMail + '</td>';
					str += '<td>' + cart.member.memberAddress + '</td>';
					str += '<td>' + cart.member.memberId + '</td>';

				}
				$("#cartList").html(str);
			}

		}
	})
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
			discountMoney(discounts, coin);
		}
	})
}


function listComfirm() {
	$.ajax({
		url: "/shoppingCart/show",
		type: "GET",
		success: function() {
			const Toast = Swal.mixin({
				toast: true,
				timer: 2500,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			})
			Toast.fire({
				icon: 'success',
				title: 'sucess！！！',
				text: '訂單資訊以寄至信箱！！！',
			})
			showItem();
		}
	})
	$.ajax({
		url: "/shoppingCart/show",
		type: "GET",
		success: function countDown() {
			setTimeout("location.href ='http://localhost:8080'", 2500)

		}

	})
}

window.onload = function() {
	$.ajax({
		url: "/CashflowAddress",
		type: "GET",
		contentType: "application/json; charset=utf-8",
		success: function(address) {
			let str = "";
			$("#memberMail").val(address.memberMail);
			$("#memberName").val(address.userName);
			$("#memberAddress").val(address.memberAddress);
			for (let i = 0; i < address.title.length; i++) {
				$("#memberId").val(address.title[i].memberId);
				$("#commonAddress").val(address.title[i].commonAddress);
			}
		}
	})
}