
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
public class TestTupleGenerator
{
    public static void main(String[] args)
    {
        long startTime;

        for (int m =0; m< 20; m++)
        {

            TupleGenerator test = new TupleGeneratorImpl();

            test.addRelSchema("Student",
                    "id name address status",
                    "Integer String String String",
                    "id",
                    null);

            test.addRelSchema("Professor",
                    "id name deptId",
                    "Integer String String",
                    "id",
                    null);

            test.addRelSchema("Course",
                    "crsCode deptId crsName descr",
                    "String String String String",
                    "crsCode",
                    null);

            test.addRelSchema("Teaching",
                    "crsCode semester profId",
                    "String String Integer",
                    "crcCode semester",
                    new String[][]
                    {
                        {
                            "profId", "Professor", "id"
                        },
                        {
                            "crsCode", "Course", "crsCode"
                        }
                    });

            test.addRelSchema("Transcript",
                    "studId crsCode semester grade",
                    "Integer String String String",
                    "studId crsCode semester",
                    new String[][]
                    {
                        {
                            "studId", "Student", "id"
                        },
                        {
                            "crsCode", "Course", "crsCode"
                        },
                        {
                            "crsCode semester", "Teaching", "crsCode semester"
                        }
                    });

            Table Student = new Table("Student",
                    "id name address status",
                    "Integer String String String",
                    "id");

            Table Transcript = new Table("Transcript",
                    "studId crsCode semester grade",
                    "Integer String String Integer",
                    "studId crsCode semester");

            Table Professor = new Table("Professor",
                    "id name deptId",
                    "Integer String String",
                    "id");

            Table Teaching = new Table("Teaching",
                    "crsCode semester profId",
                    "String String Integer",
                    "crsCode semester");

            Table Course = new Table("Course",
                    "crsCode deptId crsName descr",
                    "String String String String",
                    "crsCode");

            int[] yep =
            {
                4, 3, 4, 4, 3
            };

            String[] tables =
            {
                "Student", "Professor", "Course", "Transcript", "Teaching"
            };

            Table[] t =
            {
                Student, Professor, Course, Transcript, Teaching
            };

            int tups[] = new int[]
            {
                10000, 100, 200, 10000, 500
            };

            //int counter = 0;
            Comparable[][][] resultTest = test.generate(tups);
            Random random = new Random();

            for (int i = 0; i < resultTest.length; i++)
            {
                //out.println(tables[i]);
                for (int j = 0; j < resultTest[i].length; j++)
                {
                    for (int k = 0; k < resultTest[i][j].length; k++)
                    {
                        Comparable[] tup = new Comparable[yep[i]];
                        //out.print(counter++ + ": ");

                        if (t[i] == Transcript)
                        {
                            tup[0] = random.nextInt(1000000);
                            tup[1] = resultTest[i][j][k];

                            for (int n = 2; n < yep[i]; n++)
                            {
                                //out.print(counter++ + ": ");
                                tup[n] = resultTest[i][j][k += 1];
                            }
                            t[i].insert(tup);
                        }
                        else
                        {
                            if (t[i] == Teaching || t[i] == Course || t[i] == Professor)
                            {
                                k += 1;
                            }
                            else
                            {
                                tup[0] = resultTest[i][j][k];
                                for (int n = 1; n < yep[i]; n++)
                                {
                                    //out.print(counter++ + ": ");
                                    tup[n] = resultTest[i][j][k += 1];
                                }
                                t[i].insert(tup);
                            }
                        }

                    } // for
                    // out.println();
                } // for
                // out.println();
            } // for

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
            Indexed Select - FileList, LinHash
            Indexed Select - ArrayList, LinHash

            3. Join: Student join id = studId Transcript
            Nested Loop Join - FileList
            Nested Loop Join - ArrayList
            Indexed Join - FileList, TreeMap
            Indexed Join - FileList, LinHash
            Indexed Join - ArrayList, TreeMap
            Indexed Join - ArrayList, LinHash
             */

            //Student.printIndex();
            // Transcript.print();
            /*
            startTime = System.nanoTime();
            Table test1 = Student.select("id == " + random.nextInt(1000000));
            out.println((System.nanoTime() - startTime));
            //test1.print();
             *
             */
          
            startTime = System.nanoTime();
            Table test12 = Student.iSelect("id == 900000");
            out.println((System.nanoTime() - startTime));
            //test12.print();
/*
            startTime = System.nanoTime();
            Table test2 = Student.rSelect("60000 <= id & id <= 70000");
            out.println((System.nanoTime() - startTime));
            //test2.print();

            startTime = System.nanoTime();
            Table test3 = Student.iJoin("id == studId", Transcript);
            out.println((System.nanoTime() - startTime));
            //test3.print();
            */
        }
    } // main
} // TestTupleGenerator

