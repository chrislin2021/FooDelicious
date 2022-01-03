<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, com.lcpan.bean.ProjectBean" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="../css/fontawesome-free-5.15.4-web/css/all.min.css">
<title>訂單資訊</title>
</head>
<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>訂單資訊</h2>
		<h2>付款完成!!</h2>
		<table border="1">
			<span style="margin: 250px">訂單編號 : A123B456
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
				總金額 : $10000</span>

			<tr style="background-color: #a8fefa">
				<th>會員編號
				<th>商品編號
				<th>商品名稱
				<th>商品數量
				<th>購買價格
				<th>總購價格
				<th>下單時間
				<th>付款狀態
				<th>更新
				<th>刪除 <c:forEach items="${emps}" var="emp" varStatus="s">
						<tr>
							<td>${emp.member_id}
							<td>${emp.order_id}
							<td>${emp.product_name}
							<td>${emp.product_sales_figures}
							<td>${emp.product_price}
							<td>${emp.product_total_price}
							<td>${emp.order_date}
							<td>${emp.order_state}
							<td><form method="post" action="UpdateFirst">
									<input type="submit" value="更新" /> <input type="hidden"
										name="Member_id" value="${emp.member_id}" />
								</form>
							<td><form method="post" action="DelData">
									<input type="submit" value="刪除" onclick='confirmBox("確定要刪除嗎?")' />
									<input type="hidden" name="Member_id" value="${emp.member_id}" />
								</form> <c:set var="count" value="${s.count}" />
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
				<th><input type="checkbox" class="description"
					id="showBuyerName" name="showBuyerName" value="1">收貨地址顯示購買人姓名&nbsp;
					<a href="javascript:void(0);" id="btn_openReceiverBook">收貨人通訊錄請按此</a>&nbsp;&nbsp;
				
		</table>
		<table>
			<tr>
				<input class="js-demeter-tw-zipcode-selector" data-city="#city"
					data-dist="#dist" placeholder="郵遞區號" size="5" />
				<select id="city" placeholder="請選擇縣市" name="city"></select>
				<select id="dist" placeholder="請選擇鄉鎮區" name="dist"></select>
			</tr>

			<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://demeter.5fpro.com/tw/zipcode-selector.js"></script>
	<input id="ReceiverAddr" name="ReceiverAddr" type="text" size="30"
		maxlength="150">
	</span>

	<span class="description">&nbsp;(不接受郵政信箱)</span>
	<label id="addContactLabel"><input type="checkbox"
		id="addContact" name="addContact">資料加入收貨人通訊錄&nbsp;&nbsp;</label>

	<span class="description">離島地區需收取$100運費 (滿千免運優惠實施中)</span>
	</table>

	<input type="button" value="確定"
		onclick="javascript:location.href='/JSP/project2/GetProject.html'" />
	</div>
</body>
</html>