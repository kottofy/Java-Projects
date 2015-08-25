<%--
    Document   : index
    Created on : Feb 1, 2011, 2:18:10 PM
    Author     : kottofy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>ACME Dangerous Products Inc.</h1>
        <p>Helping to turn your demented schemes into reality</p>
        <div style="width:600px">
              <img src="http://upload.wikimedia.org/wikipedia/en/2/20/Wile_E_Coyote.gif"
             width="226" height="363" alt="Wile E. Coyote" style="float:right"/>
              <h3 style="color:green">Order additional items:</h3>
              <form method="post" action="ShoppingController">
                  <table>
                      <tr><th>  Item: </th><th>Quantity</th>

                  <tr><td><select name="itemID">
                      <option value="0">Rocket-powered Roller Skates</option>
                      <option value="1">Exploding tennis balls, case</option>
                      <option value="2">Dehydrated Boulder</option>
                      <option value="3">Earthquake Pill, bottle of 12</option>
                      <option value="4">Batman Outfit</option>
                      <option value="5">Catapult</option>
                  </select>
                      </td>
                 <td> <input type="text" size="4" name="quantity"></td></tr>
                  <tr><td><input type="submit" value="Add to Cart"></td></tr>

                     </table>
              </form>

              <p>Wile E. Coyote and the ACME Corporation are creations of cartoonist
                  Chuck Jones. The image is from Wikipedia Commons.</p>
        </div>


    </body>
</html>
