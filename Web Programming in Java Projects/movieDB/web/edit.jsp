<%-- 
    Document   : editMovie
    Created on : Apr 20, 2011, 11:20:25 PM
    Author     : kottofy

    if login for admin worked, direct to here
    display all movies and reviews
    must be able to edit or delete movies and or reviews
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
        <style type="text/css">
            BODY {
                background-color:#BEF781;
                text-align: center;
            }
            a
            {
                font-size:12pt;
                color:#FFFF00;
                font-family:Verdana;
                text-decoration:none
            }
            div
            {
                background-color:#04B4AE;
                font-size:12pt;
                color:#FFFFFF;
                font-family:Verdana;
                float:left;
                border:solid white;
                padding: 1em;
            }
            .special
            {
                width: 350px;
                background-color: #990099;
                text-align: right;
            }
            p
            {
                padding-top: 10em;
                padding-right: 10em;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div>
            <form action="edit" method="post">
                <table>
                    <c:forEach items="${movies}" var="movies" >
                        <tr><td><c:out value="${movies.movieName}"></c:out></td>
                            <td><input type="submit" value="Delete" name="${movies.movieName}"></td></tr>
                            </c:forEach>
                </table>
            </form>
        </div>

        <div>
            <form action="edit" method="post">
                <table>
                    <tr><td>Author</td><td>Movie</td><td>Comment</td></tr>
                    <c:forEach items="${reviews}" var="reviews" >
                        <tr><td><c:out value="${reviews.author}"></c:out></td>
                            <td><c:out value="${reviews.movieName}"></c:out></td>
                            <td><c:out value="${reviews.comment}"></c:out></td>
                            <td><input type="submit" value="Delete" name="${reviews.id}"></td></tr>
                            </c:forEach>
                </table>
            </form>
        </div>
    </body>
</html>
