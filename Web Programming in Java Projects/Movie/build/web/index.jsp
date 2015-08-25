<%-- 
    Document   : index
    Created on : Mar 22, 2011, 2:46:26 PM
    Author     : kottofy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="genres" class="stub.GenreList"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <p>
            <a href="/Movie/movies">Movies</a>
        </p>

        <form method="post" action="movies">
            <h3>Enter a new movie</h3>
            <p> Name</p>
            <input type="text" size="200" name="newMovie">
            <p>Genre</p>
            <input type="text" size="200" name="newGenre">
            <input type="submit" value="Submit">
        </form>

    </body>
</html>
