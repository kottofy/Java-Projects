
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>
    <body>

        <c:forEach items="${genres}" var="genre">
            <h3>${genre.genreName}</h3>
            <c:forEach items="${genre.movieList}" var="movie">
                <p style="margin-left: 20px; color:gray;">${movie.title} <a href="reviews?movie_id=${movie.id}">See reviews</a> <p>
            </c:forEach>
        </c:forEach>

        <a href="index.jsp"><br><br>Home</a>

    </body>
</html>
