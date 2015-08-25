/**
 * @date Mar 22, 2011
 * @author kottofy
 */
package stub;

import java.util.ArrayList;

/**
 * @name GenreList
 */
public class GenreList {

    ArrayList genreList = new ArrayList();


    public GenreList()
    {
        Genre comedy = new Genre("Comedy");
        Genre scienceFiction = new Genre("Science Fiction");
        Genre drama = new Genre("Drama");

        comedy.addMovie("The Hangover");
        comedy.addMovie("Modern Times");
        scienceFiction.addMovie("Return of the King");
        scienceFiction.addMovie("District 9");
        drama.addMovie("Casablanca");
        drama.addMovie("Ben-Hur");

        genreList.add(comedy);
        genreList.add(scienceFiction);
        genreList.add(drama);
    }

    public ArrayList getGenreList()
    {
        return genreList;
    }
}
