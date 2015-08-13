/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

/**
 *
 * @author kottofy
 */
public class PackTester
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        Table movie = new Table("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");

        Comparable[] film0 =
        {
            "Star_Wars", 1977, 124, "sciFi", "Fox", 12345
        };
        Comparable[] film1 =
        {
            "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345
        };
        Comparable[] film2 =
        {
            "Rocky", 1985, 200, "action", "Universal", 12125
        };
        Comparable[] film3 =
        {
            "Rambo", 1978, 100, "action", "Universal", 32355
        };
        System.out.println();
        movie.insert(film0);
        movie.insert(film1);
        movie.insert(film2);
        movie.insert(film3);
        movie.print();

        byte[] b = movie.pack(film0);

        Comparable[] film00 = movie.unpack(b);
        System.out.println();
        movie.insert(film00);
        movie.print();

        Table movieD = new Table("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
        Comparable[] filmd =
        {
            "Star_Wars", 1977, 124, "sciFi", "Fox", 123
        };
        movieD.insert(filmd);
        movieD.print();


        byte[] bd = movieD.pack(filmd);
        Comparable[] tupd = movieD.unpack(bd);
        System.out.println();
        movieD.insert(tupd);
        movieD.print();

        Table movieS = new Table("movie", "title year length genre studioName producerNo",
                "String Float Double String String Long", "title year");

        Comparable[] filmS =
        {
            "Star_Wars", 9.123456789f, -1.0d, "sciFi", "Fox", 9223372036854775807l
        };

        movieS.insert(filmS);

        movieS.print();

        byte[] bS = movieS.pack(filmS);

        /*    for (int i = 0; i < bS.length; i++)
        {
        System.out.print(bS[i] + " ");

        if (i % 8 == 0 && i != 0)
        {
        System.out.println();
        }
        }
        for (int i = 0; i < filmS.length; i++)
        {
        System.out.println(filmS[i] + ", ");
        }
        System.out.println();
         */

        Comparable[] tupS = movieS.unpack(bS);
        System.out.println();
        movieS.insert(tupS);
        movieS.print();

        Table movieStar = new Table("movieStar", "name address gender birthdate",
                "String String Character String", "name");

        Comparable[] star0 =
        {
            "Carrie_Fisher", "Hollywood", 'F', "9/9/99"
        };

        movieStar.insert(star0);

        byte[] bM = movieStar.pack(star0);
        Comparable[] tuppp = movieStar.unpack(bM);
        System.out.println();
        movieStar.insert(tuppp);
        movieStar.print();
    }
}
