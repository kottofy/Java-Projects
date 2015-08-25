<%-- 
    Document   : index
    Created on : Mar 31, 2011, 2:13:57 PM
    Author     : kottofy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="beans.StockQuoteBean" scope="session" ></jsp:useBean>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <input type="text" name="stockSymbol">
            <input type="submit" value="submit">
            <jsp:setProperty property="stockSymbol" name="bean"></jsp:setProperty>
        </form>
        <div>
            <c:out value="${bean.quote.date}"></c:out>
            <c:out value="${bean.quote.high}"></c:out>
            <c:out value="${bean.quote.low}"></c:out>
            <c:out value="${bean.quote.last}"></c:out>
            <c:out value="${bean.quote.mktCap}"></c:out>
        </div>
    </body>
</html>
