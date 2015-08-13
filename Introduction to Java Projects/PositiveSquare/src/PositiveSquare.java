// ****************************************************************
// PositiveSquare.java
// Author: Kristin  Ottofy
// Last Edited: 04/28/2009
//
// Define a Positive Square class with methods to create and compute
// the sum of the square, a row, a col, either diagonal,
// and whether the positive square is diagonal.
//
// ****************************************************************

import java.util.Random;

public class PositiveSquare
{
    final static Random randomGenerator = new Random();

    private int[][] positiveSquare;

    //--------------------------------------------------------------
    //create new positive square of given size
    //--------------------------------------------------------------
    public PositiveSquare(int size)
	{
    	//
    	// Create a 2D int array with size rows and size columns
    	// and assign its reference to the array variable positiveSquare
        this.positiveSquare = new int [size][size];


		//
		// Initializes all the elements of the 2D array positiveSquare
		// to random number between 1 and 99 using the Random object
		// randomGenerator
        for (int count = 0; count < this.positiveSquare.length; count++)
        {
            for (int i = 0; i < this.positiveSquare.length; i++)
            {
                this.positiveSquare[count][i] = randomGenerator.nextInt(99)+1;
            }
        }
    }

    //--------------------------------------------------------------
    // return the sum of the values in the given row
    // if the value in the parameter row is a valid
    // row index or zero otherwise.
    //--------------------------------------------------------------
    public int sumRow(int row)
	{
        if (row < this.positiveSquare.length && row >= 0)
        {
            int sumRow = 0;

            for (int col = 0; col < this.positiveSquare.length; col++)
            {
                sumRow = sumRow + this.positiveSquare[row][col];
            }

            return sumRow;
        }
        else
            return 0;

    }

    //--------------------------------------------------------------
    // return the sum of the values in the given column
    // if the value in the parameter row is a valid
    // column index or zero otherwise.
    //--------------------------------------------------------------
    public int sumColumn(int col)
	{
    	if (col < this.positiveSquare.length && col >= 0)
        {
            int sumColumn = 0;

            for (int row = 0; row < this.positiveSquare.length; row++)
            {
                sumColumn = sumColumn + this.positiveSquare[row][col];
            }

            return sumColumn;
        }
        else
            return 0;

    }

    //--------------------------------------------------------------
    // return the sum of all the elements
    // of the positive square matrix.
    //--------------------------------------------------------------
    public int sum()
	{

    	int sum = 0;
        for (int count = 0; count < this.positiveSquare.length; count++)
            {
                sum = sum + this.sumRow(count);
            }
        return sum;
    }

    //--------------------------------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------------------------------
    public int sumMainDiagonal()
	{

        int sumMainDiagonal = 0;

        for (int count = 0; count <= this.positiveSquare.length - 1; count++)
            sumMainDiagonal = sumMainDiagonal + this.positiveSquare[count][count];

        return sumMainDiagonal;

    }

    //--------------------------------------------------------------
    // return the sum of the values in the secondary diagonal
    // The secondary diagonal of a matrix is the diagonal of
    // elements in the northeast direction.
    //--------------------------------------------------------------
    public int sumSecondaryDiagonal()
	{
        int sumSecondaryDiagonal = 0;
        int row = 0;
        for (int count = this.positiveSquare.length - 1; count >= 0; count--, row++)
            sumSecondaryDiagonal += this.positiveSquare[row][count];

        return sumSecondaryDiagonal;
    }

    //--------------------------------------------------------------
    // return the sum of all the elements under
    // the main diagonal.The subdiagonalof a square
    // matrix is the elements directly under the elements
    // in the  main diagonal
    //--------------------------------------------------------------
    public int sumSubDiagonal()
	{
        int sumSubDiagonal = 0;

        for (int row = 1; row < this.positiveSquare.length; row++)
        {
            for (int col = 0; col < row; col++)
            {
                sumSubDiagonal += this.positiveSquare[row][col];
            }
        }
        return sumSubDiagonal;
    }


    //--------------------------------------------------------------
    // return the sum of all the elements
    // under the main diagonal.The superdiagonal
    // of a square matrix is the elements
    // directly abovethe elements in
    // the  main diagonal
    //--------------------------------------------------------------
    public int sumSuperDiagonal()
	{
        int sumSuperDiagonal = 0;

        for (int row = 0; row < this.positiveSquare.length; row++)
        {
            for (int col = row + 1; col < this.positiveSquare.length; col++)
                sumSuperDiagonal += this.positiveSquare[row][col];
        }
        return sumSuperDiagonal;
	}

    //--------------------------------------
    // return a string with the contents of
    // the positive square, neatly formatted
    // Use the static method format of the String
    // class to obtain the string representation
    // of the element positiveSquare[i][j]
    // with three characters as follows:
    //
    // String.format("%3d",positiveSquare[i][j])
    //
    // The method format of the String class returns
    // a String.
    //--------------------------------------
    public String toString()
	{
        String toString = "";
        for (int row = 0; row < this.positiveSquare.length; row++)
        {
            for (int col = 0; col < this.positiveSquare.length; col++)
            {
                toString += String.format("%3d",positiveSquare[row][col]);
            }
            toString += "\n";
        }
        return toString;
    }
}