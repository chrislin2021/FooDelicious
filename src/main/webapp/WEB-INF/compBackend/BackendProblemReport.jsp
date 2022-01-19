<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
<link rel="stylesheet" href="../../../css/backendProduct.css">
</head>
<body>
	<h1 class="tableName titleName2">
		廠商問題回報 <br> <span class="littleName">Problem Report</span>
	</h1>
	<div class="searchArea">

		<input class="keyWord keyWord1 searchBox" type="text"
			name="accKeyWord" placeholder="請輸入關鍵字..."> <input
			id="searchProb" class="keyWord btn btn-outline-secondary searchBox2 "
			type="button" value="查詢" />
	</div>

	<ul id="selectPage" class="nav nav-tabs">
		<li class="nav-item"><a id="all" class="nav-link active"
			aria-current="page" href="#">全部問題</a></li>
		<li class="nav-item"><a id="unresolved" class="nav-link" href="#">處理中</a>
		</li>
		<li class="nav-item"><a id="resolved" class="nav-link" href="#">完成</a>
		</li>
	</ul>
	<section class="content">
		<div class="col-xs-12">
			<table id="" class='table table-striped table-hover '>
				<thead>
					<tr>
						<th class="col table-success">問題編號</th>
						<th class="col table-success">問題類別</th>
						<th class="col table-success">問題內容</th>
						<th class="col table-success">新增日期</th>
						<th class="col table-success">問題狀態</th>
						<th class="col table-success">廠商名稱</th>

						<th class="col table-success">更新</th>
					</tr>
				</thead>
				<tbody id="problemReport"></tbody>
			</table>
			<nav aria-label="Page navigation example ">
				<ul id="page" class="pagination justify-content-center"></ul>
			</nav>
		</div>
	</section>
	
	<script>
    //=============顯示所有商品資料=============
    window.onload=function(){
        const problemUrl = "/companyProblems"

        $.ajax({
            url: problemUrl,
            type: "GET",
            success: function(problemData){
                $("#problemReport").html("");
                $("#page").html("");
                let num = problemData.length;
                if(num >= 10){
                    pages(10,problemData);
                }else{
                    pages(num,problemData);
                }
            }
        });
    }

</script>

	<script>
		//=============顯示分頁設定=============
		let urlString = "";
		$("#all").on("click", function() {
			$("#selectPage a").prop("class", "nav-link");
			$("#all").prop("class", "nav-link active");
			urlString = "/companyProblems";
			// alert(urlString);
			$.ajax({
				url : urlString,
				type : "GET",
				success : function(productAll) {
					$("#products").html("");
					$("#page").html("");
					let num = productAll.length;
					if (num >= 10) {
						pages(10, productAll);
					} else {
						pages(num, productAll);
					}
				}
			});
		})
		$("#unresolved").on("click", function() {
			$("#selectPage a").prop("class", "nav-link");
			$("#unresolved").prop("class", "nav-link active");
			urlString = "http://localhost:8080/bkproducts/search/1";
			// alert(urlString);
			$.ajax({
				url : urlString,
				type : "GET",
				success : function(productFood) {
					$("#products").html("");
					$("#page").html(" ");
					let num = productFood.length;
					if (num >= 10) {
						pages(10, productFood);
					} else {
						pages(num, productFood);
					}
				}
			});
		})
		$("#resolved").on("click", function() {
			$("#selectPage a").prop("class", "nav-link");
			$("#resolved").prop("class", "nav-link active");
			urlString = "http://localhost:8080/bkproducts/search/0";
			// alert(urlString);
			$.ajax({
				url : urlString,
				type : "GET",
				success : function(productTool) {
					$("#products").html("");
					$("#page").html("");
					let num = productTool.length;
					if (num >= 10) {
						pages(10, productTool);
					} else {
						pages(num, productTool);
					}
				}
			});
		})
	</script>