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
    <div class="row" id="rowSelect">
        <div class="col-12 col-md-2">
            <br>
            <a id="updateBTN" class="btn btn-primary btn-lg" role="button" data-bs-toggle="button">修改</a>
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
        let clallifyAndTitle = "";
        $.ajax({
            url: "/responseArticle",
            type: "Get",
            success: function(data) {

                //                     console.log("data：" + data);
                //                     console.log("title" + data.title[0].length);
                //                     console.log("article" + data.article[0]);
                //$("#clallifyArea").val(data.title[0].article_clallify);
                //$("#titleArea").val(data.title[0].article_title);
                let accId = data.title[0].fk_account_id;
                let loginId = data.LoginId;
                console.log("accId: " + accId);
                console.log("loginId " + loginId);
                console.log(accId == loginId);
                clallifyAndTitle += "<tr>";
                clallifyAndTitle += "<th>" + data.title[0].article_clallify + "</th>";
                clallifyAndTitle += "<th>" + data.title[0].article_title + "</th>";
                clallifyAndTitle += "</tr>";
                $("#clallifyAndTitle").html(clallifyAndTitle);
                $(".textArea").html(data.article[0].article);

                (loginId == accId) ? $("#updateBTN").prop("class", "btn btn-primary btn-lg"): $("#updateBTN").prop("class", "btn btn-primary btn-lg disabled");

                //if (loginId == accId) {
                //    $("#updateBTN").prop("calss", "btn btn-primary btn-lg")
                //} else {
                //    $("#updateBTN").prop("calss", "btn btn-primary btn-lg disabled");
                // }
            }
        })
    </script>