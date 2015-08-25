/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.util.ArrayList;


public class Genre {

    private String genreName;
    private ArrayList movieList;
    private int id;

    public Genre(String genreName, int id){
        this.movieList = new ArrayList();
        this.genreName = genreName;
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public ArrayList getMovieList() {
        return movieList;
    }

    public int getInt(){
        return this.id;
    }

    public void addMovie(String movieTitle, int id){
        Movie aMovie = new Movie(movieTitle, id);
        this.movieList.add(aMovie);
    }

}
