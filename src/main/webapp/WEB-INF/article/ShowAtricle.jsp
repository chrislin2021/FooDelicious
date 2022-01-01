<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class='testDiv'></div>

        <script src="/js/jquery-3.6.0.min.js"></script>
        <script>
            $.ajax({
                url: "/responseArticle",
                type: "Get",
                success: function(data) {
                    console.log("data：" + data);
                    console.log("title" + data.title[0].length);
                    console.log("article" + data.article[0]);
                    
                    $(".testDiv").html(data.article[0].article);
                }
            })
        </script>