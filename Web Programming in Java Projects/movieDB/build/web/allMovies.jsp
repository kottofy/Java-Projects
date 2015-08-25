<%-- 
    Document   : allMovies
    Created on : Apr 20, 2011, 11:18:02 PM
    Author     : kottofy

    displays:
        select to see all movies or movies by genre [genre list]
        link to see reviews by selecting a movie
        link to addMovie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See All Movies or Select a Genre</title>
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
            <table>
                <tr><td><a href="addMovie.jsp">Add A Movie</a></td></tr>
            </table>
        </div>
        <div>
            <table>
                <form action="movies" method="POST">
                    <select name="genre">
                        <option>All</option>
                        <c:forEach items="${genres}" var="genres" >
                            <option>${genres.genreType}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Submit">
                </form>
                <c:forEach items="${moviesList}" var="movies">
                    <tr>
                        <td>
                            <c:out value="${movies.movieName}"></c:out>
                        </td>
                        <td>
                            <c:out value="${movies.genre}"></c:out>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
            <form action="reviews" method="POST">
                <select name="movie">
                    <c:forEach items="${moviesList}" var="moviesList" >
                        <option>${moviesList.movieName}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Get Reviews">
            </form>
        </div>
    </body>
</html>
