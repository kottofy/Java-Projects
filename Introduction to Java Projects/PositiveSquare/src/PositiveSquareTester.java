// ****************************************************************
// PositiveSquareTester.java
//
// Uses the PositiveSquare class
//
// ****************************************************************

public class PositiveSquareTester {

    public static void main(String[] args)
	{
        PositiveSquare positiveSquare = null;

		int squareMatrixNo = 1;        // count which positive square we're on
        int sumRows = 0;                // sum of all rows in the positive square
        int sumColumns = 0;            // sum of all columns in the positive square

        positiveSquare = new  PositiveSquare(3);
        if (positiveSquare.sumRow(-1) != 0 || positiveSquare.sumRow(1000) !=0 )
		{
            System.out.println("The sum of an invalid row must be zero.");
        }

        if (positiveSquare.sumColumn(-1) !=0  || positiveSquare.sumColumn(1000) !=0 )
		{
            System.out.println("The sum of an invalid column must be zero.");
        }

		for (int size=2; size < 5 ; size++)
		{

			//create a new Square of the given size
			positiveSquare= new PositiveSquare(size);


			System.out.println("\n******** Positive Square " + squareMatrixNo + " ********");
			System.out.println(positiveSquare);
			//print the square

			//print the sums of its rows
		    sumRows = 0;
		    for (int row=0;row < size; row++)
			{
		         sumRows += positiveSquare.sumRow(row);
		         System.out.println("Sum of Row " + row + ": " + positiveSquare.sumRow(row));
		    }


			//print the sums of its columns

		    sumColumns = 0;
		    for (int column=0; column < size; column++)
			{
		         sumColumns += positiveSquare.sumColumn(column);
		         System.out.println("Sum of Column " + column + ": "+ positiveSquare.sumColumn(column));
		    }

			//print the sum of the main diagonal

		    System.out.println("Sum of Main Diagonal: " + positiveSquare.sumMainDiagonal());

			//print the sum of the secondary diagonal

		    System.out.println("Sum of Secondary Diagonal: " + positiveSquare.sumSecondaryDiagonal());

		    // print the sum of all elements in the positive

			System.out.println("Sum of all elements: " + positiveSquare.sum());

			//print the sum of the subdiagonal of the positive square

			System.out.println("Subdiagonal Sum: " + positiveSquare.sumSubDiagonal());

			//print the sum of the superdiagonal of the positive square

			System.out.println("Superdiagonal Sum: " + positiveSquare.sumSuperDiagonal());

		    if (positiveSquare.sum() != (positiveSquare.sumMainDiagonal() + positiveSquare.sumSubDiagonal() + positiveSquare.sumSuperDiagonal()))
			{
		       System.out.println("\nThe sum of all the elements in the positive square must be equal to the sum of the main diagonal, sudiagonal and superdiagonal.\nIncorrect!!!");
		    }
		    else
			{
		       System.out.println("\nThe sum of all the elements in the positive square is equal to the sum of the main diagonal, sudiagonal and superdiagonal.\nCorrect!!");
		    }


		    if (positiveSquare.sum() != sumRows)
			{
		       System.out.println("\nThe sum of all the elements in the positive square must be equal to the sum of all the rows.\nIncorrect!!!");
		    }
		    else
			{
		       System.out.println("\nThe sum of all the elements in the positive square is equal to the sum to the sum of all the rows.\nCorrect!!");
		    }

		    if (positiveSquare.sum() != sumColumns)
			{
		       System.out.println("\nThe sum of all the elements in the positive square must be equal to the sum of all the columns.\nIncorrect!!!");
		    }
		    else
			{
		       System.out.println("\nThe sum of all the elements in the positive square is equal to the sum to the sum of all the columns.\nCorrect!!");
		    }
		    squareMatrixNo++;
		}
	}
}