
/**
 * @nameAndExt TestTupleGenerator.java
 * @date Jul 17, 2011
 * @author Kristin Ottofy
 */
package db;

import java.util.Random;
import static java.lang.System.out;

/**
 *
 */
public class Tester
{
    public static void main(String[] args)
    {
        long startTime;

            TupleGenerator test = new TupleGeneratorImpl();

            test.addRelSchema("Student",
                    "id name address status",
                    "Integer String String String",
                    "id",
                    null);

            test.addRelSchema("Transcript",
                    "studId crsCode semester grade",
                    "Integer String String String",
                    "studId crsCode semester",
                    new String[][]
                    {
                        {
                            "studId", "Student", "id"
                        }
                    });

            Table Student = new Table("Student",
                    "id name address status",
                    "Integer String String String",
                    "id");

            Table Transcript = new Table("Transcript",
                    "studId crsCode semester grade",
                    "Integer String String String",
                    "studId crsCode semester");

            Table[] t =
            {
                Student, Transcript
            };

            int tups[] = new int[]
            {
                100-1, 100
            };

            //int counter = 0;
            Comparable[][][] resultTest = test.generate(tups);

            for (int i = 0; i < resultTest.length; i++)
            {
                for (Comparable[] tup : resultTest[i])
                {
                    t[i].insert(tup);
                }
            }

            Comparable[] temp = {10101, "name", "address", "status"};
            Student.insert(temp);

            /*
            1.  Select - Point Query: σ id = v (Student)
            Table Scan - FileList
            Table Scan - ArrayList
            Indexed Select - FileList, TreeMap
            Indexed Select - FileList, LinHash
            Indexed Select - ArrayList, TreeMap
            Indexed Select - ArrayList, LinHash

            2. Select - Range Query: σ v1 <= id & id <= v2 (Student)
            Table Scan - FileList
            Table Scan - ArrayList
            Indexed Select - FileList
            Indexed Select - ArrayList

            3. Join: Student join id = studId Transcript
            Nested Loop Join - FileList
            Nested Loop Join - ArrayList
            Indexed Join - FileList, TreeMap
            Indexed Join - FileList, LinHash
            Indexed Join - ArrayList, TreeMap
            Indexed Join - ArrayList, LinHash
             */

            //Student.print();
            //Transcript.print();
            /*
            startTime = System.nanoTime();
            Table test1 = Student.select("id == " + random.nextInt(1000000));
            out.println((System.nanoTime() - startTime));
            //test1.print();
             *
             */

        for (int m =0; m < 30; m++)
        {
            /*
            startTime = System.nanoTime();
            Table test12 = Student.iSelect("id == 10101");
            out.println((System.nanoTime() - startTime));
            //test12.print();
*/
            /*
        startTime = System.nanoTime();
            Table test21 = Student.select("id == 10101");
            out.println((System.nanoTime() - startTime));
             *
             */
/*
            startTime = System.nanoTime();
            Table test21 = Student.select("60000 <= id & id <= 70000");
            out.println((System.nanoTime() - startTime));
*/
            /*

            startTime = System.nanoTime();
            Table test2 = Student.rSelect("60000 <= id & id <= 70000");
            out.println((System.nanoTime() - startTime));
            //test2.print();
             *
             */

        /*
            startTime = System.nanoTime();
            Table test3 = Student.iJoin("id == studId", Transcript);
            out.println((System.nanoTime() - startTime));
*/
             startTime = System.nanoTime();
            Table test32 = Student.join("id == studId", Transcript);
            out.println((System.nanoTime() - startTime));
//test32.print();
        }
    } // main
} // TestTupleGenerator

