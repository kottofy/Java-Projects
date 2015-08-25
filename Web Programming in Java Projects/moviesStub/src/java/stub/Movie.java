/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stub;

import java.util.ArrayList;


public class Movie {
    private int id;
    private String title;
    private ArrayList reviews;

    public Movie(String title, int id){
        this.reviews = new ArrayList();
        this.title = title;
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public void addReview(String review){
        this.reviews.add(review);
    }

    public ArrayList getReviews(){
        return this.reviews;
    }

}
