/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kottofy
 */
public class EchoServlet extends HttpServlet {
   
    /** 
     * Echoes request parameters and cookies.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EchoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EchoServlet at " + request.getContextPath () + "</h1>");
            out.println("<h3>Request Parameters </h3>");
            out.println("<table border =1>");
            out.println("<tr><th>Name</th><th>Value</th></tr>");

            Enumeration<String> paramName = request.getParameterNames();
            while (paramName.hasMoreElements())
            {
                //print a table row with the next element
                String param = paramName.nextElement();
                String paramValue = request.getParameter(param);
                out.println("<tr><td>" + param + "</td><td>" + paramValue + "</td></tr>");
            }

            Cookie[] cookie = request.getCookies();
            for (int i=0; i<cookie.length;i++)
            {
                out.println("<tr><td>"+ cookie[i]+"</td></tr>");
            }



            out.println("</table>");
            out.println("</body>");
            out.println("</html>");


            
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
