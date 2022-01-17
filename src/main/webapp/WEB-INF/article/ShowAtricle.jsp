<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <style>
            #contentArea {
                pointer-events: none;
            }
            
            #sendMsg {
                margin-bottom: 1.5em;
            }
        </style>
        <link href="/css/CKEditor.css" rel="stylesheet" />
        <div class="row" id="rowSelect">
            <div class="col-12 col-md-2">
                <br>

                <button type="button" id="updateBTN" class="btn btn-primary btn-lg" role="button" data-bs-toggle="button">修改</button>
            </div>

            <div class="col-12 col-md-9">
                <br>
                <!--觀看文章-->
                <div id="contentArea" disabled>
                    <table class="table table-hover">
                        <tbody id="clallifyAndTitle"></tbody>
                    </table>
                    <div id="editor">${articleContent}</div>
                </div>
                <!--留言區-->
                <div id="msgArea">
                    <div>
                        <table class="table table-hover table-sm" id="showMSG">

                        </table>
                        <input id="sendMsg" type="text" class="form-control" placeholder="留言..." aria-label="Username" aria-describedby="addon-wrapping">
                    </div>

                </div>
            </div>
        </div>
        </div>
        <script src="/js/ckeditor.js"></script>
        <script src="/js/jquery-3.6.0.min.js"></script>
        <script>
            var articleId = "";
            let clallifyAndTitle = "";
            let loginId = "";
            $.ajax({
                url: "/responseArticle",
                type: "Get",
                success: function(data) {
                    let accId = data.title[0].fk_account_id;
                    loginId = data.LoginId;
                    articleId = data.title[0].share_id
                    clallifyAndTitle += "<tr><th>分類：" + data.title[0].article_clallify + "</th></tr>";
                    clallifyAndTitle += "<tr><th>標題：" + data.title[0].article_title + "</th></tr>";
                    clallifyAndTitle += "<tr>";
                    clallifyAndTitle += "<td><span>發帖時間：" + data.title[0].postTime + "</span></td>";
                    clallifyAndTitle += "<td><span>閱覽數：" + data.title[0].viewNum + "</span></td>";
                    clallifyAndTitle += "</tr>";
                    $("#clallifyAndTitle").html(clallifyAndTitle);
                    $("#editor").html(data.article[0].article);
                    document.getElementById("updateBTN").style.visibility = (loginId == accId) ? 'visible' : 'hidden';
                    document.getElementById("sendMsg").style.visibility = (loginId != null) ? 'visible' : 'hidden';
                    msgShow();
                }
            })
            $("#updateBTN").click(function() {
                window.location.href = "/goUpdatePage"
            })
        </script>

        <script>
            //ckeditor
            ClassicEditor
                .create(document.querySelector('#editor'), {
                    commentsOnly: true
                })
                .then(editor => {
                    const toolbarElement = editor.ui.view.toolbar.element;
                    toolbarElement.style.display = 'none';

                })
                .catch(error => {
                    console.log(error);
                });
        </script>
        <script>
            //留言功能區域

            $("#sendMsg").keydown(function() {
                if (event.keyCode === 13 & sendMsg.value.length != 0) {
                    //console.log(sendMsg.value)
                    let MsgData = {};
                    MsgData.articleId = articleId;
                    MsgData.text = sendMsg.value;
                    MsgData.loginId = loginId;
                    console.log(MsgData)
                    $.ajax({
                        url: "/insertMsg",
                        type: "Post",
                        dataType: 'json',
                        contentType: "application/json;charset=utf-8",
                        data: JSON.stringify(MsgData),
                        success: function() {
                            sendMsg.value = "";
                        }
                    })
                }
                msgShow();
            })
        </script>

        <script>
            //留言顯示區域
            function msgShow() {
                $.ajax({
                    url: "/showAllMsg/" + articleId,
                    type: "GET",
                    contentType: "application/json; charset=utf-8",
                    success: function(msg) {
                        //console.log(msg)
                        let msgData = "";
                        for (let i = 0; i < msg.length; i++) {
                            msgData += "<tr><td><div>" + msg[i].memberName + "：</div><div>" + msg[i].text + "</div></td><tr>"
                            $("#showMSG").html(msgData);
                            //document.getElementById("showMSG").innerHTML = msgData;
                        }
                    }
                })
            }
        </script>