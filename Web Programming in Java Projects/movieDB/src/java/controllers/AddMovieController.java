/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import movies.Genre;
import movies.Movie;
import movies.MoviesHelper;

/**
 *
 * @author kottofy
 */
public class AddMovieController extends HttpServlet
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

        sess = request.getSession();
        mh = new MoviesHelper();

        String movie = request.getParameter("movieName");
        String genre = request.getParameter("genre");

        System.out.println("AddMovieController");
        System.out.println("MOVIE: " + movie);
        System.out.println("GENRE: " + genre);

        mh.addMovie(movie, genre);

        List<Movie> movies = null;
        List<Genre> genres = null;

        try
        {
             //movie was added to db
            movies = mh.getMovies();
            genres = mh.getGenres();
            sess.setAttribute("genres", genres);
            sess.setAttribute("movies", movies);
            response.sendRedirect("addMovie.jsp");
        } catch (Exception e)
        {
            System.out.println(e.toString());
            response.sendRedirect("error.jsp");
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
