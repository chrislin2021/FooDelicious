// 	function orderandMoney(){
// 		$.ajax({
// 			url : "/shoppingCart/show",
// 			type : "GET",
// 			contentType: "application/json; charset=utf-8",
// 			success: function(carts) {
//			if (carts != null) {
//				$("#cartList").empty();
//				var str = "";
//				for (let cart of carts) {
//					str += '<tr>';
//					str += '<td>' + cart.cartId + '</td>';
//				}
//				$("#cartList").html(str);
//			}
//
//		}
//	})
//}

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
					str += '</tr>';
				}
				$("#cartList").html(str);
			}
			
		}
	})
	
}


function listComfirm(){
	$.ajax({
	url: "/shoppingCart/show",
	type: "GET",
	success: function() {
			const Toast = Swal.mixin({
				toast: true,
				timer: 8000,
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
}

//function showmember() {
//	$.ajax({
//		url: "/members",
//		type: "POST",
//		contentType: "application/json; charset=utf-8",
//		success: function(member) {
//			if (member != null) {
//				$("#memberList").empty();
//				var str = "";
//				for (let members of member) {
//					str += '<tr>';
//					str += '<td>' + members.memberName + '</td>';
//					str += '<td>' + members.memberPhone+ '</td>';
//					str += '<td>' + members.memberMail + '</td>';
//					str += '</tr>';
//				}
//				$("#memberList").html(str);
//			}
//		}
//
//	})
//}


