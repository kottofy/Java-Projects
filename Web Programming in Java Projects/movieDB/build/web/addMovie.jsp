<%-- 
    Document   : addMovie
    Created on : Apr 20, 2011, 11:23:09 PM
    Author     : kottofy

    Displays:
        Entry form to add movie
        select genre from list or add new genre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie Page</title>
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
                width: 150px;
                background-color:#04B4AE;
                font-size:14pt;
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
            <a href="allMovies.jsp">See All Movies</a>
        </div>
        <div>
        <h1>Add a movie!</h1>
            <form action="addMovie"  method="POST">
                Movie Name:<input type="text" name="movieName">
                Genre:<input type="text" name="genre">
                <input type="submit" value="Add Movie">
            </form>
        </div>
    </body>
</html>
