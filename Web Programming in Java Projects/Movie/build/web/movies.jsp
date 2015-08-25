<%--
    Document   : index
    Created on : Mar 22, 2011, 2:46:26 PM
    Author     : kottofy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>
    <body>
        <c:forEach items="${genres.genreList}" var="genre">
            <c:out value="${genre.genreName}"></c:out>
            <ul>
                <c:forEach items="${genre.movieList}" var="movie">
                    <li><c:out value="${movie}"></c:out></li>
                </c:forEach>
            </ul>
        </c:forEach>
    </body>
</html>
