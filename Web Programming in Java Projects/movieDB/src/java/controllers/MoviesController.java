/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import movies.*;
import movies.MoviesHelper;

/**
 *
 * @author kottofy
 */
public class MoviesController extends HttpServlet
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
        System.out.println("\nMoviesController ProcessRequest\n");

        response.setContentType("text/html;charset=UTF-8");

        String genre = request.getParameter("genre");
//        System.out.println("\ngenre: " + genre + "\n");

        mh = new MoviesHelper();
        List<Movie> movies = mh.getMovies();
        List<Movie> moviesList;

//        for (int i = 0; i < movies.size(); i++)
//            System.out.println("movies: " + movies.get(i).getMovieName());

        //if get all movies was not selected
        if (!genre.matches("All"))
        {
            System.out.println("!All");
            moviesList = mh.getMoviesByGenre(genre);
        }
        else
            moviesList = movies;

        sess = request.getSession();
        sess.setAttribute("moviesList", moviesList);
        
        List<Genre> genres = mh.getGenres();
        sess.setAttribute("genres", genres);

        for (int i = 0; i < moviesList.size(); i++)
            System.out.println("moviesList: " + moviesList.get(i).getMovieName());

        RequestDispatcher dispatcher = request.getRequestDispatcher("allMovies.jsp");
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
