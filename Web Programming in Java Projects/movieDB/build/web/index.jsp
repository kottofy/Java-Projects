<%-- 
    Document   : index
    Created on : Apr 19, 2011, 8:17:59 PM
    Author     : kottofy

    display:
        link to see all movies
        login form for admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entry View</title>
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
                <tr><td><a href="addMovie.jsp">Add A Movie</a></td></tr>
            </table>
        </div>
        <div>
            <form method="GET" action="login">
                <h3>Admin</h3>
                <h4>Username:<input type="text" name="username"></h4>
                <h4>Password:<input type="password" name="password"></h4>
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>