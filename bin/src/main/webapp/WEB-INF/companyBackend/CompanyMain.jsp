<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<h1>${memberMail}</h1>





<%-- <c:forEach items="${userID}" var="session"> --%>
<%-- ${userID} --%>
<%-- </c:forEach> --%>

<c:set var="mail" value="${memberMail}"/>
${mail}

<c:set var="userID" value="${userID}"/>
${userID}

