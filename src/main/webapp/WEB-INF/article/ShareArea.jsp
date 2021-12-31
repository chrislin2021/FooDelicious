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

        <nav aria-label="Page navigation">
            <ul class="pagination" id="ulArea"></ul>
        </nav>
        <script src="/js/jquery-3.6.0.min.js"></script>
        <script>
            let thisPage = 1;
            let finPage = 0;
            $.getJSON("/totalArticleData", function(articles) {
                let ArticleData = "";
                let pageTotal = articles.length;
                let page = Math.ceil(articles.length / 10);

                let finPage = (pageTotal < 10) ? pageTotal : 10;

                //console.log(finPage);

                for (let i = 0; i < finPage; i++) {
                    ArticleData += "<tr>";
                    ArticleData += "<th scope='row'>" + (i + 1) + "</th>";
                    ArticleData += "<td>" + articles[i].article_clallify + "</td>";
                    ArticleData += "<td><a href='/intIDFindAll/" + articles[i].share_id + "'>" + articles[i].article_title + "</a></td>";
                    ArticleData += "</tr>";
                }
                $("#articleArea").html(ArticleData);

                var paginationStr = "";
                paginationStr += "<li class='page-item' id='Previous'>";
                paginationStr += " <button class='page-link' id='Previous' aria-label='Previous'>";
                paginationStr += "<span aria-hidden='true'>&laquo;</span></button></li>";

                for (let i = 1; i <= page; i++) {
                    paginationStr += "<li class='page-item'><button class='page-link' value='" + i + "'>" + i + "</button></li>";
                }
                paginationStr += "<li class='page-item' id='Next'>";
                paginationStr += "<button class='page-link'  aria-label='Next'>";
                paginationStr += "<span aria-hidden='true'>&raquo;</span></button></li>";
                $("#ulArea").html(paginationStr);
            });

            function liButtonClick() {
                thisPage = $(this).index();

                $.ajax({
                        url: "/totalArticleData",
                        type: "GET",
                        success: function(articles) {
                            //console.log(articles.length)
                            console.log(thisPage);
                            page = Math.ceil(articles.length / 10);
                            pageTotal = articles.length;
                            finPage = (thisPage == page) ? pageTotal : thisPage * 10;

                            if (thisPage != 0 && $("li").length - 1 != thisPage) {
                                let ArticleData = "";
                                for (let i = (thisPage - 1) * 10; i < finPage; i++) {
                                    ArticleData += "<tr>";
                                    ArticleData += "<th scope='row'>" + (i + 1) + "</th>";
                                    ArticleData += "<td>" + articles[i].article_clallify + "</td>";
                                    ArticleData += "<td><a href='/intIDFindAll/" + articles[i].share_id + "'>" + articles[i].article_title + "</a></td>";
                                    ArticleData += "</tr>";
                                }
                                $("#articleArea").html(ArticleData);
                                (thisPage == 1) ? $("#Previous").prop("class", "page-item disabled"): $("#Previous").prop("class", "page-item");
                                (thisPage == $("li").size() - 2) ? $("#Next").prop("class", "page-item disabled"): $("#Next").prop("class", "page-item");

                            }
                        }
                    }) //ajax結束

            }

            $("body").on("click", "#ulArea li", liButtonClick)
        </script>