<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <style>
            .topDIV {
                margin-top: 16px;
            }
        </style>
        <div class="topDIV">
            <ul class="nav nav-tabs">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">全部文章</a></li>
                <li class="nav-item"><a class="nav-link" href="#">廚具開箱</a></li>
                <li class="nav-item"><a class="nav-link" href="#">食譜分享</a></li>
            </ul>

        </div>

        <table class="table">
            <tbody id="articleArea"> </tbody>
        </table>
        <script src="/js/jquery-3.6.0.min.js"></script>
        <script>
            $.getJSON("/totalArticleData", function(articles) {
                let ArticleData = "";
                for (let i = 0; i < articles.length; i++) {
                    ArticleData += "<tr>";
                    ArticleData += "<th scope='row'>" + (i + 1) + "</th>";
                    ArticleData += "<td>" + articles[i].article_clallify + "</td>";
                    ArticleData += "<td><a href='/intIDFindAll/" + articles[i].share_id + "'>" + articles[i].article_title + "</a></td>";
                    ArticleData += "</tr>";
                }
                $("#articleArea").html(ArticleData);
            });
        </script>