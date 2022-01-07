<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel='stylesheet' href="../../css/websocketstyle.css" />
<style>
.topDIV {
	margin-top: 16px;
}

#inputGroupSelect01 {
	width: 1em;
}
</style>

<br />

<div class="row" id="rowSelect">
	<!--版面配置左方-->
	<div class="col-12 col-md-1"></div>

	<div class="col-12 col-md-9">
		<div class="w-50 p-3 input-group mb-3">
			<select class="w-0 form-select dropdown-toggle" id="clasify">
				<option selected>全部文章</option>
				<option>廚具開箱</option>
				<option>食譜分享</option>
			</select> <input type="text" class="form-control"
				aria-label="Text input with dropdown button" id="titleKeyWord">
			<button class="btn btn-outline-secondary" type="button"
				id="articleSearch">查詢文章</button>
		</div>


		<div class="topDIV">
			<ul class="nav nav-tabs">
				<li class="nav-item"><button id="navTotal" type="button"
						class="nav-link active" aria-current="page">全部文章</button></li>
				<li class="nav-item"><button id="navKitchenware" type="button"
						class="nav-link">廚具開箱</button></li>
				<li class="nav-item"><button id="navRecipe" type="button"
						class="nav-link">食譜分享</button></li>
			</ul>

		</div>

		<table class="table table-hover">
			<tbody id="articleArea">
			</tbody>
		</table>

	</div>
	<div class="col">
		<!--         聊天代號： -->
		<!--             <div> -->
		<!--                 聊天代號：<input type="text" id="chatId" placeholder="請輸入一個代號：" /> -->
		<!--             </div> -->
		<!--             <div style="height: 30px;" id='promptArea'>&nbsp;</div> -->


		<!--             <div> -->
		<!--                 <button id="btnConnect">加入聊天室</button> -->
		<!--                 <button id="btnDisconnect" disabled="disabled"> -->
		<!--                     退出聊天室</button> -->
		<!--             </div> -->
		<!--             <br /> -->
		<!--             <div id="conversationDiv"> -->
		<!--                 <input type="text" id="inputMessageArea" placeholder="輸入聊天訊息..." /> -->
		<!--                 <button id="sendToChatRoom2">傳送</button> -->
		<!--                 <hr> -->
		<!--                 <textarea id="responseArea" cols="90" rows="12" readonly></textarea> -->
		<!--             </div> -->
	</div>



</div>



<nav aria-label="Page navigation example ">
	<ul id="page" class="pagination justify-content-center"></ul>
</nav>
<script src="/websocket/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/websocket/webjars/stomp-websocket/stomp.min.js"></script>
<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
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
        searchShareDate("/totalArticleData", "GET");

        function searchShareDate(url, type) {
            $.ajax({
                url: url,
                type: type,
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

<script type="text/javascript">
        let stompClient = null;
        let url = "http://" + window.location.host + '/websocket/chatting';
        let chatId = null;				// 聊天代號
        let to = null;					// 
        let responseArea = null;		// 聊天訊息顯示區
        let inputMessageArea = null;	// 聊天訊息輸入區
        let btnConnect = null;
        let btnDisconnect = null;
        let promptArea = null;			// 系統訊息提示區	

        let btnSendToChatRoom2 = null;


        window.addEventListener('load', function () {
            btnConnect = document.getElementById('btnConnect');
            btnDisconnect = document.getElementById('btnDisconnect');
            chatId = document.getElementById('chatId');
            responseArea = document.getElementById('responseArea');
            promptArea = document.getElementById('promptArea');
            inputMessageArea = document.getElementById('inputMessageArea');

            btnSendToChatRoom2 = document.getElementById('sendToChatRoom2');



            btnConnect.onclick = function () {
                let chatIdValue = chatId.value;
                if (chatIdValue == null || chatIdValue == "") {
                    promptArea.innerHTML = "<font size='-1' color='red'>必須先輸入聊天代號才能加入聊天室</font>";
                    return;
                } else {
                    promptArea.innerHTML = "";
                }
                var socket = new SockJS(url);
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function (frame) {
                    setConnected(true);
                    inputMessageArea.focus();
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/topic/messages', function (messageOutput) {
                        showMessageOutput(JSON.parse(messageOutput.body));

                    });
                });
            };
            btnDisconnect.onclick = function () {
                if (stompClient != null) {
                    stompClient.disconnect();
                }
                setConnected(false);
                chatId.value = "";
                console.log("Disconnected");

            };

            inputMessageArea.onkeyup = function () {
                if (event.keyCode === 13) {
                    let text = inputMessageArea.value;
                    if (text.length > 0) {
                        console.log(text.length);
                        stompClient.send("/app/chat", {}, JSON.stringify({
                            'from': chatId.value,
                            'text': text
                        }));
                    }
                }
            }

            btnSendToChatRoom2.onclick = function () {
                let text = inputMessageArea.value;
                if (text.length > 0) {
                    console.log(text.length);
                    stompClient.send("/app/chat", {}, JSON.stringify({
                        'from': chatId.value,
                        'text': text
                    }));
                }
            }


            setConnected(false);
            chatId.focus();
        })
        function setConnected(connected) {
            // 		btnConnect = document.getElementById('connect');
            btnDisconnect.disabled = !connected;
            btnConnect.disabled = connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible'
                : 'hidden';
            document.getElementById('responseArea').innerHTML = '';
        }


        function showMessageOutput(messageOutput) {
            let line = "";
            console.log(JSON.stringify(messageOutput));
            line += JSON.stringify(messageOutput) + "\n";
            /* 更新聊天訊息顯示區 */
            responseArea.value += "" + line;


            // 		var p = document.createElement('p');
            // 		p.style.wordWrap = 'break-word';
            // 		p.appendChild(document.createTextNode(messageOutput.from + ": "
            // 				+ messageOutput.text + " (" + messageOutput.time + ")"));
            // 		response.appendChild(p);
        }

    </script>