//*******************************************************
// CircleTester.java
// Author: Kristin Ottofy
// Last Edited: 03/30/2009
//
//  A client to test the functionality of objects
//  of teh class Circle
//
//*******************************************************
public class CircleTester{

	public static void main(String[] args) {

		Circle circle1= new Circle(0.0,0.0,2);
		Circle circle2= new Circle(2.0,1.0,1);
        Circle anotherCircle = new Circle(1.0,1.0,1.0);

		System.out.println("circle1=" + circle1);
		System.out.println("circle2=" + circle2);

		// If the method setRadius is implemented correctly,
		// a call to setRadius with a negative number
		// will not change the value of the circle's radius.
		//
		circle1.setRadius(-2.0);

		//
		// Reset the center of circle1 (-3.0,4.0)
		//
		circle1.setX(-3.0);
		circle1.setY(4.0);


		// print circle1 characteristics (center and radius), use a statement similar to previous println statement
        System.out.println("circle1=" + circle1);
        
		// set the circle2 radius to 5.3
        circle2.setRadius(5.3);

		// print circle2 characteristics (center and radius), use a statement similar to previous println statement
        System.out.println("circle2=" + circle2);

		// print circle1 diameter, area and perimeter
        System.out.println("circle1= diameter: " + circle1.diameter() + ", area: " + circle1.area() + ", perimeter: " + circle1.perimeter());

		// print circle2 diameter, area and perimeter
        System.out.println("circle2= diameter: " + circle2.diameter() + ", area: " + circle2.area() + ", perimeter: " + circle2.perimeter());

		// display whether circle1 is an unitarian circle
        if (circle1.isUnitCircle() == true)
            System.out.println("Circle1 is a unitarian circle");
        else
            System.out.println("Circle1 is not a unitarian circle");

		// display whether circle2 is an unitarian circle
        if (circle2.isUnitCircle() == true)
            System.out.println("Circle2 is a unitarian circle");
        else
            System.out.println("Circle2 is not a unitarian circle");

        double distanceVal = circle1.distance(anotherCircle);

        System.out.println("The distance is " + distanceVal + " between\n" + circle1 + " and\n" + anotherCircle);

        boolean isConcentricVal = circle1.isConcentric(anotherCircle);
        if (isConcentricVal == true)
            System.out.println("The following cirles are concentric\n" + circle1 + "\n" + anotherCircle);
        else
            System.out.println("The following circles are not concentric\n" + circle1 + "\n" + anotherCircle);

        boolean equalsVal = circle1.equals(anotherCircle);
        if (equalsVal == true)
            System.out.println("The circles are equal\n" + circle1 + "\n" + anotherCircle);
        else
            System.out.println("The circles are not equal\n" + circle1 + "\n" + anotherCircle);

        boolean intersectsVal = circle1.intersects(anotherCircle);
        if (intersectsVal == true)
            System.out.println("The circles intersect\n" + circle1 + "\n" + anotherCircle);
        else
            System.out.println("The circles do not intersect\n" + circle1 + "\n" + anotherCircle);
	}

}
