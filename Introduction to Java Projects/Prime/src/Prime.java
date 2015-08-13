import java.util.Scanner;
public class Prime
{
	public static void main (String [] args)
	{
		Scanner scan = new Scanner (System.in);
		System.out.print ("Please enter a number: " );
		int num = scan.nextInt();
		int count = 2;
		do
		{
			count++;
		}
        while ( num % count != 0 );
		if (num == count)
			System.out.println (num+ " is a prime number.");
		else
			System.out.println (num + " is not a prime number. ");

		// As one of your classmate described in class, this is another way to find a prime number:
		// I just want to mention that System.exit (0) is usually used for the purpose of terminating a program in case an error/ problem occurs. Using System.exit in this case is
		// not recommended. We will learn how to terminate a loop sometimes this week or next week.
		/*
		while ( count < num)
		{
			if ( num%count == 0)
			{
				System.out.println (num +" is not a prime number ");
				System.exit(0);
			}
			count ++;
		}
		System.out.println (num +" is a prime number");
		*/

	}
}