<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>

<link rel="stylesheet" href="../../../css/backendAge.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>

</head>

<body>

	<h1 class="titleName2 titleName">猶豫商品 <br> <span class="littleName">Hesitant Product</span></h1>
	<div class="reportArea">
		<div id="report1" class="col-sm-5">
			<canvas id="myChart"></canvas>
		</div>

		<div id="report2" class="col-sm-5">
			<canvas id="myChart2"></canvas>
		</div>
	</div>
	<div id="textArea" class="col-sm-11">
		<h1 class="textName">統計數據</h1>
		<table class="table align-middle table-striped table-hover">
			<thead>
				<tr>
					<th scope="col" class="table-info">產品編號</th>
					<th scope="col" class="table-info">產品名稱</th>
					<th scope="col" class="table-info">產品數量</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="carts" items="${carts}">
				<tr>				
					<th scope="row">${carts.productId}</th>
					<td>${carts.product.productName}</td>
					<td id="age1x">${carts.product.productStock}</td>
				</tr>
				</c:forEach>				
			</tbody>
		</table>

	</div>

	<script>
		$.ajax({
			url : "/report/age",
			type : "GET",
			success : function(list) {
				let listData = list;
				let data1 = listData[0];
				let data2 = listData[1];
				let data3 = listData[2];
				let data4 = listData[3];
				let data5 = listData[4];
				let data6 = listData[5];

				//=========統計數據=========
				$("#age1x").text(data1);
				$("#age2x").text(data2);
				$("#age3x").text(data3);
				$("#age4x").text(data4);
				$("#age5x").text(data5);
				$("#age6x").text(data6);

				//=========長條圖=========
				let ctx = $('#myChart');
				let myChart = new Chart(ctx,
						{
							type : 'bar', //圖表類型
							data : {
								//標題
								labels : [ '19歲以下', '20~29歲', '30~39歲',
										'40~49歲', '50~59歲', '60歲以上' ],
								datasets : [ {
									label : '會員年齡層分析', //標籤
									data : [ data1, data2, data3, data4, data5,
											data6 ], //資料
									//圖表背景色
									backgroundColor : [
											'rgba(255, 99, 132, 0.2)',
											'rgba(54, 162, 235, 0.2)',
											'rgba(255, 206, 86, 0.2)',
											'rgba(75, 192, 192, 0.2)',
											'rgba(153, 102, 255, 0.2)',
											'rgba(255, 159, 64, 0.2)' ],
									//圖表外框線色
									borderColor : [ 'rgba(255, 99, 132, 1)',
											'rgba(54, 162, 235, 1)',
											'rgba(255, 206, 86, 1)',
											'rgba(75, 192, 192, 1)',
											'rgba(153, 102, 255, 1)',
											'rgba(255, 159, 64, 1)' ],
									//外框線寬度
									borderWidth : 1
								} ]
							},
							options : {
								scales : {
									yAxes : [ {
										ticks : {
											beginAtZero : true,

										}
									} ]
								}
							}

						});

				//=========長條圖=========
				let ctx2 = $('#myChart2');
				let myChart2 = new Chart(ctx2,
						{
							type : 'doughnut', //圖表類型
							data : {
								//標題
								labels : [ '19歲以下', '20~29歲', '30~39歲',
										'40~49歲', '50~59歲', '60歲以上' ],
								datasets : [ {
									label : '會員年齡層分析', //標籤
									data : [ data1, data2, data3, data4, data5,
											data6 ], //資料
									//圖表背景色
									backgroundColor : [
											'rgba(255, 99, 132, 0.2)',
											'rgba(54, 162, 235, 0.2)',
											'rgba(255, 206, 86, 0.2)',
											'rgba(75, 192, 192, 0.2)',
											'rgba(153, 102, 255, 0.2)',
											'rgba(255, 159, 64, 0.2)' ],
									//圖表外框線色
									borderColor : [ 'rgba(255, 99, 132, 1)',
											'rgba(54, 162, 235, 1)',
											'rgba(255, 206, 86, 1)',
											'rgba(75, 192, 192, 1)',
											'rgba(153, 102, 255, 1)',
											'rgba(255, 159, 64, 1)' ],
									//外框線寬度
									borderWidth : 1
								} ]
							},

						});

			}
		})
	</script>

</body>
</html>
