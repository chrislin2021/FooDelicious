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
		<li class="nav-item"><a class="nav-link active"
			aria-current="page" href="#">全部文章</a></li>
		<li class="nav-item"><a class="nav-link" href="#">廚具開箱</a></li>
		<li class="nav-item"><a class="nav-link" href="#">食譜分享</a></li>
	</ul>

</div>

<table class="table">
	<tbody id="articleArea">
		<c:forEach var="statusUpdate" items="${TotalData}">
			<tr>
				<th scope="row">${statusUpdate.share_id}</th>
				<td>${statusUpdate.article_clallify}</td>
				<td>${statusUpdate.article_title}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script src="/js/jquery-3.6.0.min.js"></script>
<script>
	totalArticleData2
	
</script>