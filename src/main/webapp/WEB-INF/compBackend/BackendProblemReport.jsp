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
        const problemUrl = "http://localhost:8080/companyProblems";

        $.ajax({
            url: problemUrl,
            type: "GET",
            success: function(problemData){
                $("#problemReport").html("");
                $("#page").html("");
                let num = problemData.length;
                
                //alert(problemData[0].problemContent);
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
// 		let urlString = "http://localhost:8080/companyProblems";
// 		$("#all").on("click", function() {
// 			alert(urlString);
// 			$("#selectPage a").prop("class", "nav-link");
// 			$("#all").prop("class", "nav-link active");
			
// 			urlString = "http://localhost:8080/companyProblems";
			
// 			$.ajax({
// 				url : urlString,
// 				type : "GET",
// 				success : function(problemData) {
// 					$("#problemReport").html("");
// 					$("#page").html("");
// 					let num = problemData.length;
// 					if (num >= 10) {
// 						pages(10, problemData);
// 					} else {
// 						pages(num, problemData);
// 					}
// 				}
// 			});
// 		})
// 		$("#unresolved").on("click", function() {
// 			$("#selectPage a").prop("class", "nav-link");
// 			$("#unresolved").prop("class", "nav-link active");
// 			urlString = "http://localhost:8080/bkproducts/search/1";
// 			// alert(urlString);
// 			$.ajax({
// 				url : urlString,
// 				type : "GET",
// 				success : function(productFood) {
// 					$("#problemReport").html("");
// 					$("#page").html(" ");
// 					let num = productFood.length;
// 					if (num >= 10) {
// 						pages(10, productFood);
// 					} else {
// 						pages(num, productFood);
// 					}
// 				}
// 			});
// 		})
// 		$("#resolved").on("click", function() {
// 			$("#selectPage a").prop("class", "nav-link");
// 			$("#resolved").prop("class", "nav-link active");
// 			urlString = "http://localhost:8080/bkproducts/search/0";
// 			// alert(urlString);
// 			$.ajax({
// 				url : urlString,
// 				type : "GET",
// 				success : function(productTool) {
// 					$("#problemReport").html("");
// 					$("#page").html("");
// 					let num = productTool.length;
// 					if (num >= 10) {
// 						pages(10, productTool);
// 					} else {
// 						pages(num, productTool);
// 					}
// 				}
// 			});
// 		})
	</script>
	
	<script>
    //=============分頁程式=============
    function pages(maxNum, dataSource){ //輸入單頁最大筆數和資料來源
        //=================分頁功能================
        //alert(dataSource[0].problemId);
        //最大頁數
        let maxPage;
        //目前顯示頁數
        let nowPage = 0;
        //每頁最大筆數
        let maxItems = maxNum;
        //設定起始編號
        let startItem = 0;
        //設定結束編號
        let endItem = maxItems;

        //讀回資料時就先顯示
        showData(startItem, endItem, dataSource);

//         //計算出最大頁數。
//         if(dataSource.length % maxItems == 0){
//             maxPage = Math.floor(dataSource.length / maxItems);
//             // alert("最大頁數1：" + maxPage);
//         }else{
//             maxPage = (Math.floor(dataSource.length / maxItems))+1;
//             // alert("最大頁數2：" + maxPage);
//         }
//         // alert("最大頁數：" + maxPage);
//         //生成前先清空
//         $("#page").html("");
//         //動態生成頁數
//         let pageHtml = `<li class="page-item previous disabled pageMove"><a class="page-link">上一頁</a></li>`;
//         for(let i=0; i<maxPage; i++){
//             let pageNum = i+1;
//             pageHtml += `<li id=`+ i +` class="page-item page pageNum pageMove"><a class="page-link">`+ pageNum +`</a></li>`;
//         };
//         pageHtml += `<li class="page-item next pageMove"><a class="page-link" >下一頁</a></li>`;
//         $("#page").html(pageHtml);

//         //綁定前先清除綁定事件
//         $("#page").unbind("click");
//         //綁定click事件
//         $("#page").on("click",".page", function(){
//             nowPage = ($(this).prop("id"))*1;//強制轉成數字型態
//             $(".pageNum").prop("class","page-item page pageNum")
//             $(this).prop("class","page-item page pageNum active")
//             // alert("nawPage："+nowPage+ "資料型態："+typeof nowPage);
//             //恢復上、下頁的功能
//             $(".previous").prop("class", "page-item previous");
//             $(".next").prop("class", "page-item next");
//             // alert("nowPage："+nowPage+"maxPage："+maxPage);
//             //計算是否是最後一頁
//             if((nowPage)+1 >= maxPage){
//                 startItem = nowPage * maxItems;
//                 if(dataSource.length % maxItems == 0){
//                     endItem = startItem + maxItems
//                 }else{
//                     endItem = startItem + dataSource.length % maxItems;
//                 }

//             }else{
//                 startItem = nowPage * maxItems;
//                 endItem = startItem + maxItems;
//             }
//             // alert("開始："+startItem+"結束："+endItem);
//             showData(startItem, endItem, dataSource);
//         });

//         //=======上一頁設定========
//         $("#page").on("click", ".previous", function (){

//             //恢復下一頁的功能
//             $(".next").prop("class", "page-item next");

//             let page = nowPage-1;

//             $(".pageNum").prop("class","page-item page pageNum")
//             $("#"+page).prop("class","page-item page pageNum active")

//             //判斷是否已經是第一頁了，取消上一頁功能
//             if(page <= 0 ){
//                 $(".previous").prop("class", "page-item previous disabled");
//                 startItem = 0 * maxItems;
//                 endItem = startItem + maxItems;
//             }else{
//                 startItem = page * maxItems;
//                 endItem = startItem + maxItems;
//             }
//             showData(startItem, endItem, dataSource);
//             nowPage = page;
//         });

//         //=============下一頁設定=============
//         $("#page").on("click", ".next", function(){

//             //恢復上一頁的功能
//             $(".previous").prop("class", "page-item previous");

//             let page = nowPage + 1;

//             $(".pageNum").prop("class","page-item page pageNum")
//             $("#"+page).prop("class","page-item page pageNum active")

//             //計算是否是最後一頁，並取消下一頁功能
//             if(page >= (maxPage-1)){
//                 $(".next").prop("class", "page-item next disabled")
//                 startItem = page * maxItems;
//                 if(dataSource.length % maxItems == 0){
//                     endItem = startItem + maxItems
//                 }else{
//                     endItem = startItem + dataSource.length % maxItems;
//                 }
//             }else{
//                 startItem = page * maxItems;
//                 endItem = startItem + maxItems;
//             }
//             showData(startItem, endItem, dataSource);
//             nowPage = page;
//         });
     }
</script>

<script>
    //=============顯示功能=============
     function showData(startItem,endItem,dataSource){
     	alert(dataSource[0].problemContent); // 有顯示了!
//         let txt = "<tr>";
//         for (let i = startItem; i < endItem; i++) {
//             txt += "<td class='align-middle'>"+dataSource[i].problemId+"</td>"
//             let category = dataSource[i].problemCategory;
//             let type = ""
//             switch (category){
//             case '0':
//             	type = "商品";
//             	break;
//             case '1':
//             	type = "訂單";
//             	break;
//             case '2':
//             	type = "系統";
//             	break;
//             case '3':
//             	type = "會員";
//             	break;
//             case '4'
//             	type = "其他";
//            		break;
//             }
            
//             txt += "<td class='align-middle'>"+type+"</td>"
//             txt += "<td class='align-middle'>"+dataSource[i].problemContent+"</td>"
            
//             let newDate = new Date(dataSource[i].problemSubmitDate);
//             let register = newDate.toLocaleString();
            
//             txt += "<td class='align-middle'>"+register+"</td>"
            
//             let st = dataSource[i].problemStatus;
//             let status = "";
//             if( st == "unresolved"){
//                 status = "處理中";
//             }else{
//                 status = "完成";
//             }
           
//             txt += "<td class='align-middle'>"+dataSource[i].companyName+"</td>"
            
           
//             txt += '<td class="align-middle">'+
//                 '<form method="" >'+
//                 '<input id="updateBtn" class="btn btn-outline-primary" type="button" value="更新" data-id='+dataSource[i].problemId+'>'+
//                 '</form>'+
//                 '</td>'
           
//         }
//         $("#products").html(txt);
    }

</script>

</body>