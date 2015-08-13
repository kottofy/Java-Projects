// ****************************************************************
// ProjectScore.java
// Last Edited: 04/15/2009
// Author: Kristin Ottofy
//
// Reads in and stores the project scores of several students.
//.Computes the mean and standard deviation of the
// the project scores. Finally, displays the project scores
// indicating if the student's score is over,or below the average
// 
// ****************************************************************
import java.util.Scanner;

public class ProjectScores {

	public static void main(String[] args) {

		double[] projectScores;
		int nStudents;
		double aScore;
		double average = 0;
		double stdDeviation =0;

		//
		// Creates a sScanner object
		//
		Scanner keyboard = new Scanner(System.in);

		//
		// Prompt the user for the number of students
		//
		System.out.print("Please enter the number of students:");
		nStudents = keyboard.nextInt();

		// Create a new array with nStudents elements and assign it to
		// the array variable projectScores

		projectScores = new double[nStudents];

		//
		// Read the project score of each student
		//
		//
		for (int i = 0; i < projectScores.length;i++) {
			//
			// Read a valid project score between 0 and 100
			// and assign it to the projectScore
			//
			do {
				System.out.print("Enter the project score for student "+i+":");
				aScore = keyboard.nextInt();
				if (aScore < 0 || aScore > 100) {
					System.out.println("The project score must be between 0 and 100");
				}

			} while (aScore < 0 || aScore > 100);

			// Assign the vaule of aScore
			// to the i-th element of the array projectScores
			//
			projectScores[i] = aScore;
		}


		// Compute the average project score
        double sum = 0;
        for (int count=0; count < projectScores.length; count++)
        {
            sum = sum + projectScores[count];
        }
        average = sum / nStudents;

		// Display the average project score

        System.out.println("Projects Score Average: " + average);

		// Compute the standard deviation

        for (int i = 0; i<projectScores.length; i++)
        {
            stdDeviation += Math.pow((projectScores[i] - average),2);
            
        }
        
        stdDeviation = Math.sqrt(stdDeviation / (nStudents - 1));

		// Display the standard deviation

        System.out.println("Projects Standard Deviation: " + stdDeviation);

		// Display the projectScores
        for (int i = 0; i < projectScores.length; i++)
        {
            System.out.print("Student #" + i + ": " + projectScores[i]);

           if (projectScores[i] >= average)
               System.out.println(" (++)");
           else
               System.out.println(" (--)");
        }   
	}
}