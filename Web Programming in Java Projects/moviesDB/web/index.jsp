

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
        <a href="movies">See movies</a>

        <h3 style="color: green"><br>Add movie</h3>
        <form method="post" action="movies">
            <table>
                <tr><th>Movie Title</th><th>Genre</th></tr>
                <tr>
                    <td><input type="text" size="10" name="movieTitle"></td>
                    <td><input type="text" size="10" name="genreName"></td>
                    <td><input type="submit" value="Add Movie" name="addMovie"></td>
                </tr>
            </table>
        </form>


    </body>

</html>
