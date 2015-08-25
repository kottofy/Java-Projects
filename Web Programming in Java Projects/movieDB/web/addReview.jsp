<%-- 
    Document   : addReview
    Created on : Apr 20, 2011, 11:22:34 PM
    Author     : kottofy

    displays:
        movie name and genre
        form to add comment for movie
        and author
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Review Page</title>
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
            p{
                padding-top: 10em;
                padding-right: 10em;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div>
            <h1>Add Review for
                <c:out value="${movie}"></c:out>
            </h1>
            <form method="POST" action="addReview">
                <h4>Author: <input type="text" name="author"></h4>
                <h4>Comment: <input type="text" size="100" name="comment"></h4>
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
