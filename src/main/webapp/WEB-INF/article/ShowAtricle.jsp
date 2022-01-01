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

    <table class="table table-hover">
        <tbody id="clallifyAndTitle"></tbody>
    </table>



    <div class='textArea'></div>


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

                clallifyAndTitle += "<tr>";
                clallifyAndTitle += "<th>" + data.title[0].article_clallify + "</th>";
                clallifyAndTitle += "<th>" + data.title[0].article_title + "</th>";
                clallifyAndTitle += "</tr>";
                $("#clallifyAndTitle").html(clallifyAndTitle);
                $(".textArea").html(data.article[0].article);
            }
        })
    </script>