<%-- 
    Document   : viewMenu
    Created on : Mar 30, 2011, 9:32:18 AM
    Author     : kottofy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${MenuSection}" var="section" >
            <h3>${menu.menuItem}</h3>
            <c:forEach items="${genre.movieList}" var="movie">
                <p style="margin-left: 20px; color:gray;">${movie.title} <a href="reviews?movie_id=${movie.id}">See reviews</a> <p>
            </c:forEach>
        </c:forEach>
    </body>
</html>
