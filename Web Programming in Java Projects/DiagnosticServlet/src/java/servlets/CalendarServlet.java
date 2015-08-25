/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kottofy
 */
public class CalendarServlet extends HttpServlet {

    private int monthIndex (String monthName)
    {
            if (monthName.equalsIgnoreCase("Jan") == true) return 1;
            else if (monthName.equalsIgnoreCase("Feb") == true) return 2;
            else if (monthName.equalsIgnoreCase("Mar") == true) return 3;
            else if (monthName.equalsIgnoreCase("Apr") == true) return 4;
            else if (monthName.equalsIgnoreCase("May") == true) return 5;
            else if (monthName.equalsIgnoreCase("Jun") == true) return 6;
            else if (monthName.equalsIgnoreCase("Jul") == true) return 7;
            else if (monthName.equalsIgnoreCase("Aug") == true)  return 8;
            else if (monthName.equalsIgnoreCase("Sep") == true) return 9;
            else if (monthName.equalsIgnoreCase("Oct") == true) return 10;
            else if (monthName.equalsIgnoreCase("Nov") == true)  return 11;
            else if (monthName.equalsIgnoreCase("Dec") == true)  return 12;
            else return 0;
        }
    private void makeCalendar(int year, int month, int date){

        GregorianCalendar greg = new GregorianCalendar(year, month, date);
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
            // TODO output your page here
            String Year, Month;
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalendarServlet</title>");  
            out.println("</head>");
            out.println("<body>");

            out.print("<h3>Calendar for </h3>");

            Enumeration<String> paramName = request.getParameterNames();
            while (paramName.hasMoreElements())
            {
                //print a table row with the next element
                String param = paramName.nextElement();
                String paramValue = "blah";
                if (param.compareTo("month") == 0)
                {
                    paramValue = request.getParameter(param);
                    out.println(paramValue);
                    Month=request.getParameter(param);
                }
                if (param.compareTo("year") == 0)
                {
                    paramValue = request.getParameter(param);
                    out.println(paramValue);
                    Year=request.getParameter(param);
                }
            }
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
