

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reviews</title>
    </head>
    <body>

        <h2>${selectedMovie.title}</h2>

        <c:forEach items="${selectedMovie.reviews}" var="review">
            <h3 style="color:gray; max-width: 450px;">${review}<br><br></h3>
        </c:forEach>

            <a href="movies">Back to movies</a>

    </body>
</html>
