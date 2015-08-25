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
import stub.*;


public class MovieController extends HttpServlet {

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
        GenreList genres = new GenreList();
        request.setAttribute("genres", genres);

        ArrayList genreList = genres.getGenreList();

        if (request.getParameter("movie_id") != null
                && !request.getParameter("movie_id").equals("")){
            int movieID = Integer.parseInt(request.getParameter("movie_id"));

            for (int i=0; i<genreList.size(); i++) {
                Genre aGenre = (Genre)genreList.get(i);
                ArrayList genreMovies = aGenre.getMovieList();
                for (int j=0; j<genreMovies.size(); j++){
                    Movie aMovie = (Movie)genreMovies.get(j);
                    if (movieID == aMovie.getId()){
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
        GenreList genres = new GenreList();
        if (request.getParameter("addMovie") != null
                && !request.getParameter("addMovie").equals("")){
            if (request.getParameter("genreName") != null
                && !request.getParameter("genreName").equals("")
                && request.getParameter("movieTitle") != null
                && !request.getParameter("movieTitle").equals("")){
                ArrayList genreList = genres.getGenreList();
                for(int i=0;i<genreList.size();i++){
                    Genre aGenre = (Genre)genreList.get(i);
                    if(request.getParameter("genreName").equalsIgnoreCase(aGenre.getGenreName())){
                        aGenre.addMovie(request.getParameter("movieTitle"), -1);
                        break;
                    }
                }
            }
        }

        request.setAttribute("genres", genres);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movies.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
