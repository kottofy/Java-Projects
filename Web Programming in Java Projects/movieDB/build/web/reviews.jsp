<%-- 
    Document   : reviews
    Created on : Apr 20, 2011, 11:19:47 PM
    Author     : kottofy

    displays:
        the selected movie name and genre
        all reviews for this movie name
        link to add review
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reviews Page</title>
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
                font-size:14pt;
                color:#FFFFFF;
                font-family:Verdana;
                float:left;
                border:solid white;
                padding: 1em;

            }
            p{
                padding-top: 10em;
                padding-right: 10em;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div>
            <table>
                <tr><td><a href="allMovies.jsp">See All Movies</a></td></tr>
            </table>
        </div>
        <div>
            <h1>Reviews</h1>
            <table>
                <c:out value="${movie}"></c:out>
                <c:forEach items="${reviews}" var="reviews">
                    <tr>
                        <td>
                            <c:out value="${reviews.author}"></c:out>
                        </td>
                        <td>
                            <c:out value="${reviews.comment}"></c:out>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <a href="addReview.jsp">Add Review for this movie</a>
            </p>
        </div>
    </body>
</html>
