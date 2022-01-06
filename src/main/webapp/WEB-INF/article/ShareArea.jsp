<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <style>
        .topDIV {
            margin-top: 16px;
        }
        
        #inputGroupSelect01 {
            width: 1em;
        }
    </style>

    <br/>

    <div class="input-group mb-3">
        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
            <li>
                <hr class="dropdown-divider">
            </li>
            <li><a class="dropdown-item" href="#">Separated link</a></li>
        </ul>
        <input type="text" class="form-control" aria-label="Text input with dropdown button">
    </div>

    <div class="w-50 p-3 input-group mb-3">
        <select class="form-select" id="inputGroupSelect01">
            <option selected hidden>請選擇分類</option>
            <option>全部文章</option>
            <option>廚具開箱</option>
            <option>食譜分享</option>
          </select>

        <input type="text" class="form-control" aria-label="Text input with dropdown button">
        <button class="btn btn-outline-secondary" type="button">查詢文章標題</button>
    </div>


    <div class="topDIV">
        <ul class="nav nav-tabs">
            <li class="nav-item"><button id="navTotal" type="button" class="nav-link active" aria-current="page" href="#">全部文章</button></li>
            <li class="nav-item"><button id="navKitchenware" type="button" class="nav-link" onclick="">廚具開箱</button></li>
            <li class="nav-item"><button id="navRecipe" type="button" class="nav-link" href="#">食譜分享</button></li>
        </ul>

    </div>

    <table class="table table-hover">
        <tbody id="articleArea">
        </tbody>
    </table>

    <nav aria-label="Page navigation example ">
        <ul id="page" class="pagination justify-content-center"></ul>
    </nav>
    <script src="/js/popper.min.js"></script>
    <script src="/js/jquery-3.6.0.min.js"></script>
    <script>
        //將值傳到全域
        let ShareData;
        //最大頁數
        var maxPage;
        //目前顯示頁數
        let nowPage = 0;
        //每頁最大筆數
        let maxItems = 10;
        //設定起始編號
        let startItem = 0;
        //設定結束編號
        //let endItem = maxItems;
        let endItem;
        searchShareDate("/totalArticleData");

        function searchShareDate(url) {
            $.ajax({
                url: url,
                type: "GET",
                success: function(articles) {
                    ShareData = articles
                        //得到格式：{session: null, title: Array(18)}        
                        //console.log(ShareData)
                        //=================分頁功能================
                    endItem = (articles.title.length <= 10) ? articles.title.length : 10;
                    //讀回資料時就先顯示
                    showData(startItem, endItem);
                    //計算出最大頁數。
                    maxPage = (articles.title.length % maxItems == 0) ? Math.floor(articles.title.length / maxItems) : (Math.floor(articles.title.length / maxItems)) + 1;

                    //動態生成頁數
                    let pageHtml = `<li class="page-item previous disabled pageMove"><a class="page-link">上一頁</a></li>`;
                    for (let i = 0; i < maxPage; i++) {
                        let pageNum = i + 1;
                        pageHtml += `<li id=` + i + ` class="page-item page pageNum pageMove"><a class="page-link">` + pageNum + `</a></li>`;
                    };
                    pageHtml += `<li class="page-item next pageMove"><a class="page-link" >下一頁</a></li>`;
                    $("#page").html(pageHtml);

                }
            });
        };

        //顯示資料用
        function showData(startItem, endItem) {
            let ArticleData = "";
            //console.log(ShareData);
            console.log("endItem：" + endItem);
            console.log(ShareData.title);
            for (let i = startItem; i < endItem; i++) {
                console.log(ShareData.title[i].article_clallify);
                ArticleData += "<tr>";
                ArticleData += "<th scope='row'>" + (i + 1) + "</th>";
                ArticleData += "<td>" + ShareData.title[i].article_clallify + "</td>";
                ArticleData += "<td><a href='/intIDFindAll/" + ShareData.title[i].share_id + "'>" + ShareData.title[i].article_title + "</a></td>";
                ArticleData += "<td>";
                if (ShareData.session == ShareData.title[i].fk_account_id) {
                    ArticleData += "<button onclick='delfun(" + ShareData.title[i].share_id + ")'>刪除</button>"
                } else {
                    ArticleData += "<a hidden onclick='return confirm('確認刪除?');' href='#'>刪除</a>"
                }
                ArticleData += "</td>";
                ArticleData += "</tr>";
            }
            $("#articleArea").html(ArticleData);
        }

        //綁定click事件
        $("#page").on("click", ".page", function() {
            //alert(ShareData);
            nowPage = ($(this).prop("id")) * 1; //強制轉成數字型態
            $(".pageNum").prop("class", "page-item page pageNum")
            $(this).prop("class", "page-item page pageNum active")
                // alert("nawPage："+nowPage+ "資料型態："+typeof nowPage);
                //恢復上、下頁的功能
            $(".previous").prop("class", "page-item previous");
            $(".next").prop("class", "page-item next");
            // alert("nowPage："+nowPage+"maxPage："+maxPage);
            //計算是否是最後一頁
            if ((nowPage) + 1 >= maxPage) {
                startItem = nowPage * maxItems;
                if (ShareData.title.length % maxItems == 0) {
                    endItem = startItem + maxItems
                } else {
                    endItem = startItem + ShareData.title.length % maxItems;
                }

            } else {
                startItem = nowPage * maxItems;
                endItem = startItem + maxItems;
            }
            // alert("開始："+startItem+"結束："+endItem);
            showData(startItem, endItem);
        });
        //=======上一頁設定========
        $("#page").on("click", ".previous", function() {

            //恢復下一頁的功能
            $(".next").prop("class", "page-item next");

            let page = nowPage - 1;

            $(".pageNum").prop("class", "page-item page pageNum")
            $("#" + page).prop("class", "page-item page pageNum active")

            //判斷是否已經是第一頁了，取消上一頁功能
            if (page <= 0) {
                $(".previous").prop("class", "page-item previous disabled");
                startItem = 0 * maxItems;
                endItem = startItem + maxItems;
            } else {
                startItem = page * maxItems;
                endItem = startItem + maxItems;
            }
            showData(startItem, endItem);
            nowPage = page;
        });

        //========下一頁設定============
        $("#page").on("click", ".next", function() {

            //恢復上一頁的功能
            $(".previous").prop("class", "page-item previous");

            let page = nowPage + 1;

            $(".pageNum").prop("class", "page-item page pageNum")
            $("#" + page).prop("class", "page-item page pageNum active")

            //計算是否是最後一頁，並取消下一頁功能
            if (page >= (maxPage - 1)) {
                $(".next").prop("class", "page-item next disabled")
                startItem = page * maxItems;
                if (ShareData.title.length % maxItems == 0) {
                    endItem = startItem + maxItems
                } else {
                    endItem = startItem + ShareData.title.length % maxItems;
                }
            } else {
                startItem = page * maxItems;
                endItem = startItem + maxItems;
            }
            showData(startItem, endItem);
            nowPage = page;
        });
        //資料刪除
        function delfun(id) {
            if (confirm("確定刪除此筆紀錄嗎 ?")) {
                //var form = document.forms[0];
                //form.action = "<c:url value='/deleteData/' />" + articles.title[i].share_id;
                //form.submit();
                console.log("id：" + id);
                $.ajax({
                    url: "/deleteData/" + id,
                    type: "DELETE",
                    //data: {
                    //   id: id
                    //},
                    //contentType: "application/json;charset=utf-8",
                    //dataType: 'json',
                })
            }
            window.location.href = "/goShareArea";
        }
        //上面分類選擇器
        $("#navTotal").click(function() {
            searchShareDate("/totalArticleData");
            nowPage = 0;
            startItem = 0;
            $("#navTotal").prop("class", "nav-link active")
            $("#navKitchenware").prop("class", "nav-link")
            $("#navRecipe").prop("class", "nav-link")
        })
        $("#navKitchenware").click(function() {
            searchShareDate("/totalKitchenwareData");
            nowPage = 0;
            startItem = 0;
            $("#navTotal").prop("class", "nav-link")
            $("#navKitchenware").prop("class", "nav-link active")
            $("#navRecipe").prop("class", "nav-link")
        })
        $("#navRecipe").click(function() {
            searchShareDate("/totalRecipeData");
            nowPage = 0;
            startItem = 0;
            $("#navTotal").prop("class", "nav-link")
            $("#navKitchenware").prop("class", "nav-link")
            $("#navRecipe").prop("class", "nav-link active")
        })
    </script>