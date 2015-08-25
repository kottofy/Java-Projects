/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stub;

import java.util.ArrayList;


public class Genre {

    private String genreName;
    private ArrayList movieList;

    public Genre(String genreName){
        this.movieList = new ArrayList();
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }

    public ArrayList getMovieList() {
        return movieList;
    }

    public void addMovie(String movieTitle, int id){
        Movie aMovie = new Movie(movieTitle, id);
        this.movieList.add(aMovie);
    }

}
