function showList(){
		$.ajax({
			url : "/shoppingCart/show",
			type : "GET",
			contentType: "application/json; charset=utf-8",
			success: function(carts) {
				alert(carts);
				if (carts != null) {
					$("#cartList").empty();
					var str = "";
					for (let cart of carts) {					
						str +='<tr>';
 						str +='<td>'+cart.product.memberId+'</td>';
						str +='<td>'+cart.productId+'</td>';
						str +='<td>'+cart.product.productName+'</td>';
						str +='<td>'+cart.quantity+'</td>';
						str +='<td>'+cart.product.productPrice+'</td>';
						str +='<td>'+(cart.product.productPrice*cart.quantity)+'</td>';
						str +='</tr>';
					}
					$("#cartList").html(str);	
				}

			}
	  	})
	}


