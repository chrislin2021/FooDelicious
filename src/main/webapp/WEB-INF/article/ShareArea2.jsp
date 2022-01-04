<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
        <style>
            .topDIV {
                margin-top: 16px;
            }
        </style>
        <div class="topDIV">
            <ul class="nav nav-tabs">
                <li class="nav-item"><button id="navTotal" type="button" class="nav-link active" aria-current="page" href="#">全部文章</button></li>
                <li class="nav-item"><button id="" type="button" class="nav-link" onclick="">廚具開箱</button></li>
                <li class="nav-item"><button id="" type="button" class="nav-link" href="#">食譜分享</button></li>
            </ul>

        </div>

        <table class="table table-hover">
            <tbody id="articleArea"> </tbody>
        </table>

        <nav aria-label="Page navigation">
            <ul class="pagination" id="ulArea"></ul>
        </nav>
        <script src="/js/jquery-3.6.0.min.js"></script>
        <script>
        $.ajax({
        	 url: "/totalArticleData",
             type: "GET",
             success: function(articles){
                //console.log(articles);
                let firstpage = 0;   	 
             }
        })
        </script>