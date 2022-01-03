<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">

<title>訂單資訊</title>

<div align="center">
	<h2>訂單資訊</h2>
	<h2>付款完成!!</h2>
	<form:form method="GET"
		action="${pageContext.request.contextPath}/CashflowList">
		<table border="1">
			<span style="margin: 250px">訂單編號 :
				<th>${CartBean.cart_id}
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					總金額 :
			<th>${OrdersBean.orders_total}
			</span>

			<tr style="background-color: #a8fefa">
				<th>會員編號
				<th>商品編號
				<th>商品名稱
				<th>商 品
				<th>商品數量
				<th>購買價格
				<th>總 價 格 <c:forEach items="${paytablelist}" var="paytablelist"
						varStatus="s">
						<tr>
							<td>${paytablelist.member_id}
							<td>${paytablelist.product_id}
							<td>${pro.product_name}
							<td>${paytablelist.quantity}
							<td>${paytablelist.product_price}
							<td>${paytablelist2.orders_total}
					</c:forEach>
		</table>
		<table>
			<tr>
				<!-- <th><a id="syncData" data-act="sync"
					href="javascript:void(0)" style="color: #c90026;" issynccust="N" >清除重填</a> -->
				<th>姓名&nbsp;<input id="ReceiverName" name="ReceiverName"
					type="text" size="6" maxlength="120"><span
					class="description">(中文全名)</span>
				<th>手機&nbsp;<input id="ReceiverMobile" name="ReceiverMobile"
					type="text" size="9" maxlength="12">
				<th>市話&nbsp;<input id="ReceiverTel" name="ReceiverTel"
					type="text" size="10" maxlength="20"><span
					class="description">&nbsp;(可不填)&nbsp;&nbsp;</span>
				<th>信箱&nbsp;<input id="ReceiverTel" name="ReceiverMail"
					type="text" size="30" maxlength="30"><span
					class="description">&nbsp;</span>
		</table>
		<table>
			<tr>
				<th>寄送地址&nbsp; <input class="js-demeter-tw-zipcode-selector"
					data-city="#city" data-dist="#dist" placeholder="郵遞區號" size="5" />
					<select id="city" placeholder="請選擇縣市" name="city"></select> <select
					id="dist" placeholder="請選擇鄉鎮區" name="dist"></select>
			</tr>
		</table>

		<input type="button" value="確定"
			onclick="javascript:location.href='/JSP/homepage/home.jsp'" />
	</form:form>
</div>

<span> 
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://demeter.5fpro.com/tw/zipcode-selector.js"></script>
	<input id="ReceiverAddr" name="ReceiverAddr" type="text" size="30"
	maxlength="150">
</span>
<script>
		var CashFlowDetail = [];
			for(var i=0; i<6; i++){
				var postData = {購物籃有幾種商品 : 
			  	  {
					member_id: $("#memberid").val(),
					product_id: $("#productid").val(),
					product_name: $("#product").val(),
					quantity: $("#quantity").val(),
					product_price: $("#productprice").val(),
					orders_total: $("#orderstotal").val()
			      }
				CashFlowDetail.push(postData);
			}
		var jsonList = JSON.stringify(CashFlowDetail);
		
		$.ajax({
			url : "/productListData/",
			data : {jsonList:jsonList},
			cache : false,
			dataType : 'json',
		});
	}
		</script>

</html>



