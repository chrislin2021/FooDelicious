<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <style>
        .textArea {
            margin-top: 24px;
            border: 1px black solid;
            border-radius: 0 0 16px 16px;
            padding: 20px;
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
            <table class="table table-hover">
                <tbody id="clallifyAndTitle"></tbody>

            </table>

            <div class='textArea'></div>
        </div>
    </div>

    <script src="/js/jquery-3.6.0.min.js"></script>
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
                clallifyAndTitle += "<th><span>閱覽數：" + data.title[0].viewNum + "</span></th>";
                clallifyAndTitle += "</tr>";
                $("#clallifyAndTitle").html(clallifyAndTitle);
                $(".textArea").html(data.article[0].article);
                document.getElementById("updateBTN").style.visibility = (loginId == accId) ? 'visible' : 'hidden';
                //(loginId == accId) ? $("#updateBTN").prop("class", "btn btn-primary btn-lg"): $("#updateBTN").prop("class", "btn btn-primary btn-lg hidden");
                //data.article[0].postTime
            }
        })
        $("#updateBTN").click(function() {
            window.location.href = "/goUpdatePage"
        })
    </script>