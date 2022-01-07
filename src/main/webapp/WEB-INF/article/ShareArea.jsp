<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
    <style>
        .topDIV {
            margin-top: 16px;
        }

        #inputGroupSelect01 {
            width: 1em;
        }
        .messageArea{
            border: 1px rgb(165, 162, 162) solid;
            width: 100%;
            height: 415px;
            padding: 10px;
            border-radius: 10px;
        }
    </style>

    <br />
    <div class="w-50 p-3 input-group mb-3" style="margin: 0% auto;">
        <select class="btn btn-outline-secondary dropdown" id="clasify">
            <option selected>全部文章</option>
            <option>廚具開箱</option>
            <option>食譜分享</option>
        </select> <input type="text" class="form-control" aria-label="Text input with dropdown button"
            id="titleKeyWord">
        <button class="btn btn-outline-secondary" type="button" id="articleSearch">查詢文章</button>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12 col-md-2">
                <!--版面配置左方-->
            </div>
            <div class="col-12 col-md-6">
                
                <div class="topDIV">
                    <ul class="nav nav-tabs">
                        <li class="nav-item"><button id="navTotal" type="button" class="nav-link active"
                                aria-current="page">全部文章</button></li>
                        <li class="nav-item"><button id="navKitchenware" type="button" class="nav-link">廚具開箱</button>
                        </li>
                        <li class="nav-item"><button id="navRecipe" type="button" class="nav-link">食譜分享</button></li>
                    </ul>

                </div>

                <table class="table table-hover">
                    <tbody id="articleArea">
                    </tbody>
                </table>
            </div>
            <div class="col">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="請輸入聊天內容" aria-label="請輸入聊天內容" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
                </div>
                <div class="messageArea">

                </div>
            </div>
        </div>

    </div>

    <nav aria-label="Page navigation example ">
        <ul id="page" class="pagination justify-content-center"></ul>
    </nav>
    <script src="/websocket/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/websocket/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
    
    <script>
        //使用者ID
        let UserId;
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
        searchShareDate("/totalArticleData", "GET");

        function searchShareDate(url, type) {
            $.ajax({
                url: url,
                type: type,
                contentType: "application/json; charset=utf-8",
                success: function (articles) {
                    ShareData = articles
                    UserId = articles.session;
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
            //console.log("endItem：" + endItem);
            //console.log(ShareData.title);
            for (let i = startItem; i < endItem; i++) {
                //console.log(ShareData.title[i].article_clallify);
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
        $("#page").on("click", ".page", function () {
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
        $("#page").on("click", ".previous", function () {

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
        $("#page").on("click", ".next", function () {

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
                //console.log("id：" + id);
                $.ajax({
                    url: "/deleteData/" + id,
                    type: "DELETE",
                    success: function () {
                        searchShareDate("/totalArticleData");
                    }
                })
            }
        }
        //上面分類選擇器
        $("#navTotal").click(function () {
            searchShareDate("/totalArticleData", "GET");
            nowPage = 0;
            startItem = 0;
            $("#navTotal").prop("class", "nav-link active")
            $("#navKitchenware").prop("class", "nav-link")
            $("#navRecipe").prop("class", "nav-link")
        })
        $("#navKitchenware").click(function () {
            searchShareDate("/totalKitchenwareData", "GET");
            nowPage = 0;
            startItem = 0;
            $("#navTotal").prop("class", "nav-link")
            $("#navKitchenware").prop("class", "nav-link active")
            $("#navRecipe").prop("class", "nav-link")
        })
        $("#navRecipe").click(function () {
            searchShareDate("/totalRecipeData", "GET");
            nowPage = 0;
            startItem = 0;
            $("#navTotal").prop("class", "nav-link")
            $("#navKitchenware").prop("class", "nav-link")
            $("#navRecipe").prop("class", "nav-link active")
        })
    </script>

    <script>
        //==================模糊搜尋==================
        $("#articleSearch").on("click", function () {
            let clasify = $("#clasify").val();
            //console.log(clasify)
            let titleKeyWord = $("#titleKeyWord").val()
            //console.log(titleKeyWord)

            //searchShareDate("/fuzzySearch/" + clasify + "/" + titleKeyWord, "GET")
            let fuzzySearch = {
                "clasify": clasify,
                "AssociateString": titleKeyWord
            }
            console.log(fuzzySearch)

            $.ajax({
                url: "/fuzzySearch/" + clasify + "/" + titleKeyWord,
                type: "GET",
                //data: JSON.stringify(fuzzySearch),
                contentType: "application/json; charset=utf-8",
                success: function (articles) {
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
            })

        })
    </script>
    <!--WebSocket區域-->
    <script type="text/javascript">


    </script>