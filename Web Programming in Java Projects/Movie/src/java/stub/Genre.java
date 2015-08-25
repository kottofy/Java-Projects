/**
 * @title Expression title is undefined on line 2, column 13 in Templates/Classes/Class.java.
 * @date Mar 22, 2011
 * @author kottofy
 */
package stub;

import java.util.ArrayList;

/**
 * @name Genre
 */
public class Genre {

    String genreName;
    ArrayList movieList = new ArrayList();

    //Sets the name of this genre and initializes the list of movie titles
    public Genre(String genreName) {
        this.genreName = genreName;
    }

    //Returns the name of this genre, e.g. "Drama" or "Comedy"
    public String getGenreName() {
        return genreName;
    }

    //Returns a list of movie titles for this genre
    public ArrayList getMovieList() {
        return movieList;
    }

    //Add a new movie title to this genre
    public void addMovie(String title) {
        movieList.add(title);
    }
}
