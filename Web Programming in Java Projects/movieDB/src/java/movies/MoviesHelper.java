
/**
 * @nameAndExt MoviesHelper.java
 * @date Apr 20, 2011
 * @author Kristin Ottofy
 */
package movies;

import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 */
public class MoviesHelper
{
//    Session session = null;
//    org.hibernate.Transaction tx = null;

    SessionFactory sessionFactory = null;

    public MoviesHelper()
    {
        try
        {
            this.sessionFactory = HibernateUtil.getSessionFactory();
//           this.session = HibernateUtil.getSessionFactory().getCurrentSession();
//           tx = session.beginTransaction();
        }
        catch (Exception e)
        {
            System.out.println("MoviesHelper Catch Block");
            System.out.println(e.toString());
//           session.close();
        }
    }

    public List getGenres()
    {
        List<Genre> genres = null;
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Genre");
            genres = (List<Genre>) q.list();
             ListIterator i = genres.listIterator();
            while (i.hasNext())
                session.saveOrUpdate(i.next());
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
        return genres;
    }

    public List getMovies()
    {
        List<Movie> movies = null;
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Movie");
            movies = (List<Movie>) q.list();
             ListIterator i = movies.listIterator();
            while (i.hasNext())
                session.saveOrUpdate(i.next());
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
        return movies;
    }

    public List getAllReviews()
    {
        List<Review> reviews = null;
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Review");
            reviews = (List<Review>) q.list();
             ListIterator i = reviews.listIterator();
            while (i.hasNext())
                session.saveOrUpdate(i.next());
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
        return reviews;
    }

    public List getReviews(String movieName)
    {
        List<Review> reviews = null;
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Review as r where r.movieName=\"" + movieName + "\"");
            reviews = (List<Review>) q.list();
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
        return reviews;
    }

    public List getMoviesByGenre(String genre)
    {
        List<Movie> movies = null;
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Movie as m where m.genre=\"" + genre + "\"");
            movies = (List<Movie>) q.list();

            ListIterator i = movies.listIterator();
            while (i.hasNext()) {
                session.saveOrUpdate(i.next());
            }
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
        return movies;
    }

    /*
     * add a movie to the database
     * if the movie already exists, false will be returned
     * if the movie is sucessfully added, true will be returned
     * this method also checks if the genre being added already exists--
     *      it adds it if it does not exist
     */
    public void addMovie(String movieName, String genre)
    {
        List<Movie> movies = getMovies();
        List<Genre> genres = getGenres();

        boolean genreFound = false;
        boolean movieFound = false;

        System.out.println("addMovie(" + movieName + ", " + genre + ")");

        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();

            for (int i = 0; i < movies.size(); i++)
            {
                if (((movies.get(i)).getMovieName()).matches(movieName))
                {
                    System.out.println("Movie Found!");
                    movieFound = true;
                    break;
                }
            }

            if (!movieFound)
            {
                System.out.println("Movie Not Found!");
                Movie movie = new Movie(movieName, genre);
                movies.add(movie);
                session.saveOrUpdate(movie);
            }

            for (int i = 0; i < genres.size(); i++)
            {
                if (((genres.get(i)).getGenreType()).matches(genre))
                {
                    System.out.println("Genre Found!");
                    genreFound = true;
                    break;
                }
            }

            if (!genreFound)
            {
                System.out.println("Genre Not Found!");
                Genre g = new Genre(genre);
                genres.add(g);
                session.saveOrUpdate(g);
            }
        }
        catch (Exception e)
        {
            System.out.println("addMovie() rollback");
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
    }

    public void addReview(String author, String movieName, String comment)
    {
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Review> reviews = getReviews(movieName);
            Review review = new Review(author, movieName, comment);
            reviews.add(review);

            session.saveOrUpdate(review);
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
    }

    public void deleteReview(String author, String movieName, String comment)
    {
        List<Review> reviews = getReviews(movieName);
        Session session = null;
        Review review = null;

        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();

            for (int i = 0; i < reviews.size(); i++)
            {
                if (reviews.get(i).getAuthor().matches(author)
                        && reviews.get(i).getComment().matches(comment)
                        && reviews.get(i).getMovieName().matches(movieName))
                {
                    review = reviews.get(i);
                    session.delete(review);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
    }

    public void deleteMovie(String movieName)
    {
         List<Movie> movies = getMovies();
        Session session = null;
        Movie movie = null;

        try
        {
            session = sessionFactory.openSession();
            session.beginTransaction();

            for (int i = 0; i < movies.size(); i++)
            {
                if (movies.get(i).getMovieName().matches(movieName))
                {
                    movie = movies.get(i);
                    session.delete(movie);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally
        {
            if (session.isOpen())
            {
                session.close();
            }
        }
    }

    public static void main(String[] args)
    {
        MoviesHelper mh = new MoviesHelper();

        //  mh.addMovie("One", "Three");

        List<Movie> moviesList = mh.getMovies();
        List<Genre> genresList = mh.getGenres();
        for (int i = 0; i < genresList.size(); i++)
        {
            System.out.println("Genres: " + ((Genre) genresList.get(i)).getGenreType());
        }

        mh.addReview("KO", "The Hangover", "COMMENT");

        for (int i = 0; i < moviesList.size(); i++)
        {
            //out statements for debugging purposes
            System.out.println("Movie: " + ((Movie) moviesList.get(i)).getMovieName());
            System.out.println("Genre: " + ((Movie) moviesList.get(i)).getGenre());

            String movieName = ((Movie) moviesList.get(i)).getMovieName();
            List<Review> reviewsList = mh.getReviews(movieName);

            for (int n = 0; n < reviewsList.size(); n++)
            {
                System.out.println("Author: " + ((Review) reviewsList.get(n)).getAuthor());
                System.out.println("Comment: " + ((Review) reviewsList.get(n)).getComment());
            }
        }
    }
//
//    public void persist(Object object)
//    {
//        /* Add this to the deployment descriptor of this module (e.g. web.xml, ejb-jar.xml):
//         * <persistence-context-ref>
//         * <persistence-context-ref-name>persistence/LogicalName</persistence-context-ref-name>
//         * <persistence-unit-name>movieDBPU</persistence-unit-name>
//         * </persistence-context-ref>
//         * <resource-ref>
//         * <res-ref-name>UserTransaction</res-ref-name>
//         * <res-type>javax.transaction.UserTransaction</res-type>
//         * <res-auth>Container</res-auth>
//         * </resource-ref> */
//        try
//        {
//            Context ctx = new InitialContext();
//            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
//            utx.begin();
//            EntityManager em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
//            em.persist(object);
//            utx.commit();
//        }
//        catch (Exception e)
//        {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
//            throw new RuntimeException(e);
//        }
//    }
}
