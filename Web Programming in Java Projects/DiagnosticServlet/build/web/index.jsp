<%-- 
    Document   : index
    Created on : Jan 25, 2011, 2:14:10 PM
    Author     : kottofy
--%>

<%@page import="java.util.Date" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>First Web App</title>
    </head>
    <body>
        <h1>First Web App</h1>
        <% Date today = new Date(); %>
        <p>Today is <%= today.toString() %>

        <h3>Generate a Calendar</h3>
        <form methods ="POST" action="calendar">
            <select name ="month">
                <option>Jan</option><option>Feb</option><option>Mar</option>
                <option>Apr</option><option>May</option><option>Jun</option>
                <option>Jul</option><option>Aug</option><option>Sep</option>
                <option>Oct</option><option>Nov</option><option>Dec</option>
            </select>
                <input type ="text" size ="4" name ="year" value="2011">
                <input type ="submit" name ="command" value ="Generate calendar">
        </form>
    </body>
</html>
