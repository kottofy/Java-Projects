/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stub.Genre;
import stub.GenreList;

/**
 *
 * @author kottofy
 */
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

        GenreList genreList = new GenreList();
        request.setAttribute("genres", genreList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movies.jsp");
        dispatcher.forward(request,response);
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

        GenreList genreList = new GenreList();
        String newMovie, newGenre;
        Genre genre;
         if (request.getParameter("newMovie") != null && request.getParameter("newGenre") != null)
         {
            newMovie = request.getParameter("newMovie").toString();
            newGenre = request.getParameter("newGenre").toString();
            genre = new Genre(newGenre);
            genre.addMovie(newMovie);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
