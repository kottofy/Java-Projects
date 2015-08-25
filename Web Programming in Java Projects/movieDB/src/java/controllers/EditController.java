/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class EditController extends HttpServlet
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
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("EditController");

        sess = request.getSession();
        mh = new MoviesHelper();

        List<Movie> movies = mh.getMovies();
        List<Review> reviews = mh.getAllReviews();

        String reviewID = null;

        for (int i = 0; i < reviews.size(); i++)
        {
            System.out.println(1);
            if (request.getParameter(reviews.get(i).getId().toString()) != null)
            {
                System.out.println(2);
                reviewID = reviews.get(i).getId().toString();
                for (int n = 0; n < reviews.size(); n++)
                {
                    System.out.println(3);
                    if (reviews.get(n).getId().toString().matches(reviewID))
                    {
                        System.out.println(4);
                        Review review = reviews.get(n);
                        mh.deleteReview(review.getAuthor(), review.getMovieName(), review.getComment());
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < movies.size(); i++)
        {
            System.out.println(5);
            if (request.getParameter(movies.get(i).getMovieName()) != null)
            {
                System.out.println(6);
                mh.deleteMovie(movies.get(i).getMovieName());
                break;
            }
        }

        movies = mh.getMovies();
        reviews = mh.getAllReviews();
        sess.setAttribute("movies", movies);
        sess.setAttribute("reviews", reviews);

        System.out.println(7);
        response.sendRedirect("edit.jsp");


//        for (int i = 0; i < movies.size(); i++)
//            System.out.println("EditController movie: " + movies.get(i).getMovieName());
//        for (int i = 0; i < reviews.size(); i++)
//            System.out.println("EditController review: " + reviews.get(i).getAuthor());

//        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
//        dispatcher.forward(request, response);
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
