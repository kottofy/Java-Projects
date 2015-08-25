/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.*;

public class MovieController extends HttpServlet {

    DBHelper dbHelper = new DBHelper();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ArrayList genres = dbHelper.getGenreList();
        request.setAttribute("genres", genres);

        if (request.getParameter("movie_id") != null
                && !request.getParameter("movie_id").equals("")){
            int movieID = Integer.parseInt(request.getParameter("movie_id"));

            // Search for a movie with given id.
            // If found, set it as attribute for jsp
            // and check for reviews.
            for (int i=0; i<genres.size(); i++) {
                Genre aGenre = (Genre)genres.get(i);
                ArrayList genreMovies = aGenre.getMovieList();
                for (int j=0; j<genreMovies.size(); j++){
                    Movie aMovie = (Movie)genreMovies.get(j);
                    if (movieID == aMovie.getId()){
                        ArrayList reviews = dbHelper.getReviewList(aMovie.getId());

                        if(reviews.isEmpty()){
                            aMovie.addReview("There are no reviews for this movie.");
                        }else{
                            for (int k=0;k<reviews.size();k++)
                                aMovie.addReview((String)reviews.get(k));
                        }

                        request.setAttribute("selectedMovie", aMovie);
                        break;
                    }
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("reviews.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("movies.jsp");
            dispatcher.forward(request, response);
        }

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
        if (request.getParameter("addMovie") != null
                && !request.getParameter("addMovie").equals("")){
            if (request.getParameter("genreName") != null
                    && !request.getParameter("genreName").equals("")
                    && request.getParameter("movieTitle") != null
                    && !request.getParameter("movieTitle").equals("")){
                String movieTitle = request.getParameter("movieTitle");
                String genreName = request.getParameter("genreName");
                dbHelper.insertMovie(movieTitle,genreName);
            }
        }

        ArrayList genres = dbHelper.getGenreList();
        request.setAttribute("genres", genres);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movies.jsp");
        dispatcher.forward(request, response);
    }
}
