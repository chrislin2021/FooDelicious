<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <style>
            #contentArea {
                pointer-events: none;
            }
        </style>
        <link href="/css/CKEditor.css" rel="stylesheet" />
        <div class="row" id="rowSelect">
            <div class="col-12 col-md-2">
                <br>

                <button type="button" id="updateBTN" class="btn btn-primary btn-lg" role="button" data-bs-toggle="button">修改</button>
            </div>

            <div class="col-12 col-md-9" id="contentArea" disabled>
                <br>
                <table class="table table-hover">
                    <tbody id="clallifyAndTitle"></tbody>

                </table>


                <div id="editor">${articleContent}</div>

            </div>
        </div>
        <script src="/js/ckeditor.js"></script>
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
                    clallifyAndTitle += "<tr><th>分類：" + data.title[0].article_clallify + "</th></tr>";
                    clallifyAndTitle += "<tr><th>標題：" + data.title[0].article_title + "</th></tr>";
                    clallifyAndTitle += "<tr>";
                    clallifyAndTitle += "<td><span>發帖時間：" + data.title[0].postTime + "</span></td>";
                    clallifyAndTitle += "<td><span>閱覽數：" + data.title[0].viewNum + "</span></td>";
                    clallifyAndTitle += "</tr>";
                    $("#clallifyAndTitle").html(clallifyAndTitle);
                    $("#editor").html(data.article[0].article);
                    document.getElementById("updateBTN").style.visibility = (loginId == accId) ? 'visible' : 'hidden';
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