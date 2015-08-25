/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.AppenderAttachable;

/**
 *
 * @author kottofy
 */
public class ShoppingController extends HttpServlet {


    org.apache.log4j.Logger logger = null;

    @Override
    public void init()
    {
        try {
            logger = Logger.getRootLogger();
            logger.setLevel(Level.ALL);
            /*    To create a FileAppender, you need a Layout and a filename.
            Let’s start by using the SimpleLayout class, which
            implements the Layout interface.  */
            Layout layout = new SimpleLayout();
            String filename = "/Users/kottofy/NetBeansProjects/ACME Order Form/log.txt";
            FileAppender fileAppender = new FileAppender(layout, filename);
            logger.addAppender(fileAppender);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ShoppingController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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

            Enumeration params = request.getParameterNames();
            String infoMessage = "Request: ";
            while (params.hasMoreElements())
            {
                infoMessage.concat(params.toString());
            }

            logger.info(infoMessage);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingController at " + request.getContextPath () + "</h1>");
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
