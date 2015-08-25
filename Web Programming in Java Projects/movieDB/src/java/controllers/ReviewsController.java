
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import movies.Movie;
import movies.MoviesHelper;
import movies.Review;

/**
 *
 * @author kottofy
 */
public class ReviewsController extends HttpServlet
{

    MoviesHelper mh = null;
    HttpSession sess = null;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("ReviewController");
        response.setContentType("text/html;charset=UTF-8");
        sess = request.getSession();
        mh = new MoviesHelper();
        String movie = request.getParameter("movie");
        System.out.println("movie: " + movie);

        List<Review> reviews = mh.getReviews(movie);

        for (int i = 0; i < reviews.size(); i++)
        {
            System.out.println("Movie: " + reviews.get(i).getMovieName()
                    + ", Author: " + reviews.get(i).getAuthor() + " ,Comment: "
                    + reviews.get(i).getComment());
        }

        sess.setAttribute("reviews", reviews);
        sess.setAttribute("movie", movie);

        RequestDispatcher dispatcher = request.getRequestDispatcher("reviews.jsp");
        dispatcher.forward(request, response);
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}
