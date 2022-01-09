<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<head>
    <link rel="stylesheet" href="../../../css/backendAge.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
</head>
<body>
<h1 class="tableName">
    年齡層分析
    <span class="littleName">Age Distribution</span>
</h1>
<div class="reportArea">
    <div id="report1" class="col-sm-5">
        <canvas id="myChart" data-data1=88 data-data2=456 data-data3=568
                data-data4=312 data-data5=175 data-data6=62></canvas>
    </div>

    <div id="report2" class="col-sm-5">
        <canvas id="myChart2" data-data1=88 data-data2=105 data-data3=568
                data-data4=312 data-data5=175 data-data6=62></canvas>
    </div>
</div>
<div id="textArea" class="col-sm-11">
    <h1 class="textName">TOP 3</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">年齡層</th>
            <th scope="col">會員數量</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>30~39歲</td>
            <td>568</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>20~29歲</td>
            <td>456</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>40~49歲</td>
            <td>312</td>
        </tr>
        </tbody>
    </table>

</div>

<script>
    let ctx = $('#myChart');
    let data1 = $("#myChart").data("data1");
    let data2 = $("#myChart").data("data2");
    let data3 = $("#myChart").data("data3");
    let data4 = $("#myChart").data("data4");
    let data5 = $("#myChart").data("data5");
    let data6 = $("#myChart").data("data6");

    let myChart = new Chart(ctx, {
        type: 'bar', //圖表類型
        data: {
            //標題
            labels: ['19歲以下', '20~29歲', '30~39歲', '40~49歲', '50~59歲', '60歲以上'],
            datasets: [{
                label: '會員年齡層分析', //標籤
                data: [data1, data2, data3, data4, data5, data6], //資料
                //圖表背景色
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                //圖表外框線色
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                //外框線寬度
                borderWidth: 1
            }]
        },

    });
</script>
<script>
    let ctx2 = $('#myChart2');
    let myChart2 = new Chart(ctx2, {
        type: 'doughnut', //圖表類型
        data: {
            //標題
            labels: ['19歲以下', '20~29歲', '30~39歲', '40~49歲', '50~59歲', '60歲以上'],
            datasets: [{
                label: '會員年齡層分析', //標籤
                data: [data1, data2, data3, data4, data5, data6], //資料
                //圖表背景色
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                //圖表外框線色
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                //外框線寬度
                borderWidth: 1
            }]
        },

    });
</script>
</body>
</html>
