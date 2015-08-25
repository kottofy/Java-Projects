/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import order.LineItem;

/**
 *
 * @author kottofy
 */
public class OrderItemServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, NumberFormatException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String quant = request.getParameter("quantity");
        int quantInt = Integer.parseInt(quant);

        try {
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderItemServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            String param = request.getParameter("itemID");

            String[] itemDescription = {"Rocket-powered Roller Skates",
                                        "Exploding tennis balls",
                                        "Dehydrated Boulder",
                                        "Earthquake Pill, bottle of 12",
                                        "Batman Outfit",
                                        "Catapult"};

            int paramInt = Integer.parseInt(param);

            out.println("\nCustomer has ordered " + quantInt + " of item " + itemDescription[paramInt]);

            HttpSession thisSession = request.getSession();

            ArrayList cart = (ArrayList)thisSession.getAttribute("cart");

            /********* STAR *********/
            if (cart == null)
                cart = new ArrayList();

            LineItem blah = new LineItem(paramInt, quantInt);

            cart.add(blah);

            thisSession.setAttribute("cart", cart);

            out.println("<h3>Items in your cart: </h3>\n<table border=1>");
            out.println("<tr><td>Item</td><td>Quantity</td></tr>");

            LineItem temp;

            for(int i = 0; i < cart.size(); i++)//make table to hold cart
            {
                temp = (LineItem)cart.get(i);
                out.println("<tr><td>" + itemDescription[temp.getItemID()] + "</td><td>" + temp.getQuantity() + "</td></tr>");
            }

            out.println("</table>");

            out.println("<a href = \"index.jsp\">Continue Shopping</a>");

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
