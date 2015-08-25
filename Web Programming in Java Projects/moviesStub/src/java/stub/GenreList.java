/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stub;

import java.util.ArrayList;


public class GenreList {

    private ArrayList genreList;

    public GenreList(){
        this.genreList = new ArrayList();

        Genre horror = new Genre("Horror");
        horror.addMovie("28 Days Later", 1);
        horror.addMovie("Dawn of the Dead", 2);
        ArrayList movies = horror.getMovieList();
        Movie aMovie = (Movie)movies.get(0);
        Movie anotherMovie = (Movie)movies.get(1);
        aMovie.addReview("This is 1st review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review.");
        aMovie.addReview("This is another 1st review.");
        anotherMovie.addReview("This is 2nd review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review.");


        Genre comedy = new Genre("Comedy");
        comedy.addMovie("The Hangover", 3);
        comedy.addMovie("Wedding Crashers", 4);
        movies = comedy.getMovieList();
        aMovie = (Movie)movies.get(0);
        anotherMovie = (Movie)movies.get(1);
        aMovie.addReview("This is 3rd review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review.");

        anotherMovie.addReview("This is 4th review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review.");


        Genre drama = new Genre("Drama");
        drama.addMovie("Magnolia", 5);
        drama.addMovie("Black Swan", 6);
        movies = drama.getMovieList();
        aMovie = (Movie)movies.get(0);
        anotherMovie = (Movie)movies.get(1);
        aMovie.addReview("This is 5th review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review.");

        anotherMovie.addReview("This is 6th review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review. "
                + "This is a review. This is a review. This is a review.");



        this.genreList.add(horror);
        this.genreList.add(comedy);
        this.genreList.add(drama);
    }

    public ArrayList getGenreList(){
        return this.genreList;
    }

}
