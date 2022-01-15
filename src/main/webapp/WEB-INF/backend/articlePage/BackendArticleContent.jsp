<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <head>
        <link rel="stylesheet" href="../../../css/backendManager.css">
    </head>

    <body>
        <h1 class="tableName">
            文章內容
            <span class="littleName">Article Content</span>
        </h1>
        <table aria-readonly="true" class="table table-hover">
            <tbody id="clallifyAndTitle"></tbody>
        </table>


        <div class='textArea'></div>


        <input id="delBtn" class="btn btn-outline-danger" type="button" value="刪除" onclick=delfun(${ArticleId})>


        <script>
            var articleId = "";
            let clallifyAndTitle = "";
            $.ajax({
                url: "/responseArticle",
                type: "Get",
                success: function(data) {

                    let accId = data.title[0].fk_account_id;
                    let loginId = data.LoginId;
                    articleId = data.title[0].share_id
                    clallifyAndTitle += "<tr>";
                    clallifyAndTitle += "<th>" + data.title[0].article_clallify + "</th>";
                    clallifyAndTitle += "<th>" + data.title[0].article_title + "</th>";
                    clallifyAndTitle += "</tr>";
                    $("#clallifyAndTitle").html(clallifyAndTitle);
                    $(".textArea").html(data.article[0].article);

                }
            })
        </script>
        <script>
            //=============刪除確認=============

            function delfun(id) {
                if (confirm("確定刪除此筆紀錄嗎 ?")) {
                    $.ajax({
                        url: "/adminDeleteData/" + id,
                        type: "DELETE",
                        success: function() {
                            window.location.href = "/backend/article";
                        }
                    })

                }
            }
        </script>
    </body>