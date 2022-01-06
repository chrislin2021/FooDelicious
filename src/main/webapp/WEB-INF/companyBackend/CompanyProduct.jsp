<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<body>
	
	<h1 class="tableName">
		商品列表<span class="smallFont">Product List</span>
	</h1>

	<table class="table table-hover">
		<thead class="table-dark">
			<tr>
<!-- 				<th class="col col1 ">商品圖片</th> -->
				<th class="col col2 ">商品名稱</th>
				<th class="col col3 ">商品價格</th>
				<th class="col col4 ">商品庫存</th>
				<th class="col col5 ">商品狀態</th>
				<th class="col col6 ">入庫時間</th>
				<th class="col col7">銷售總量</th>


				<th class="col col8">更新</th>
				<th class="col col9">刪除</th>
			</tr>
		</thead>
		<tbody id="products">

		</tbody>

	</table>
	<span id="productTotal">
	
	</span>
		<nav aria-label="Page navigation example ">
		<ul id="page" class="pagination justify-content-center"></ul>
	</nav>
	
	<c:set var="userID" value="${userID}"/>
	${userID}
	
	


	<script>
        //顯示頁面和分頁
        const productUrl = "http://localhost:8080/companyProducts";
        let productData;
    
        $.ajax({
            url: productUrl,
            type: "GET",
            success: function(products){
                //將值傳到全域
                productData = products;
    
                //=================分頁功能================
                //最大頁數
                var maxPage;
                //目前顯示頁數
                let nowPage = 0;
                //每頁最大筆數
                let maxItems = products.length;
                //設定起始編號
                let startItem = 0;
                //設定結束編號
                let endItem = maxItems;
    
                //讀回資料時就先顯示
                showData(startItem, endItem);
    
            }
        });
    
    
        //顯示資料用
        function showData(startItem,endItem){
            let txt = "<tr>";
            for (let i = startItem; i < endItem; i++) {
                txt += "<td class='align-middle'>"+productData[i].productName+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productPrice+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productStock+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productStatus+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productInsertDate.substring(0,10)+" "+productData[i].productInsertDate.substring(12,16)+"</td>"
                txt += "<td class='align-middle'>"+productData[i].productSalesFigures+"</td>"
              
                txt += '<td class="align-middle">'+
                    '<form method="" >'+
                    '<input type="hidden" type="text" name="memupd" value=?>'+
                    '<input id="updateBtn" class="btn btn-outline-primary " type="button" value="更新">'+
                    '</form>'+
                    '</td>'
                txt += '<td class="mdata">'+
                    '<form method="" action="">'+
                    '<input type="hidden" type="text" name="empdel" value=?>'+
                    '<input id="delBtn" class="btn btn-outline-danger" type="button" value="刪除" onclick="">'+
                    '</form>'+
                    '</td></tr>'  
                    
                                
                 
            }
            $("#products").html(txt);
            $("#productTotal").html(`<h1>${maxItems}</h1>`);
        }
    
    </script>
    </body>
    
    