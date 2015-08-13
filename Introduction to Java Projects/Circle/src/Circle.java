//*******************************************************
// Circle.java
// Author: Kristin Ottofy
// Last Edited: 03/30/2009
//
//*******************************************************
public class Circle {


	// declare the private double instance  radius
    private double radius;
	// declare the private double instance  x
    private double x;
	// declare the private double instance  y
    private double y;

	// -------------------------------------------------------------
	// constructor- Please do not change the code below
	//-------------------------------------------------------------
	public Circle(double x, double y,double  radius)
    {
    	this.x = x;
    	this.y = y;
    	this.radius = radius;
	}


	//----------------------------------------------
	// getX - returns the value of x
	//----------------------------------------------

    public double getX()
    {
        return this.x;
    }

	//----------------------------------------------
	// getY - returns the value of y
	//----------------------------------------------

    public double getY()
    {
        return this.y;
    }

	//----------------------------------------------
	// getRadius - returns the value of radius
	//----------------------------------------------

    public double getRadius()
    {
        return this.radius;
    }

	//----------------------------------------------
	// setX - assigns a new value to x
	//----------------------------------------------

    public void setX(double x)
    {
        this.x = x;
    }

	//----------------------------------------------
	// setY - assigns a new value to y
	//----------------------------------------------

    public void setY(double y)
    {
        this.y = y;
    }

	//----------------------------------------------
	// setRadius - assign a new value to radius
	//----------------------------------------------

    public void setRadius(double radius)
    {
        if (radius < 0)
            radius = radius;
        else
            this.radius = radius;
    }

	//--------------------------------------------------------
	// diameter - calculates the diameter of the circle
	//--------------------------------------------------------

    public double diameter()
    {
        double diameter = 2 * radius;
        return diameter;
    }

	//--------------------------------------------------------
	// area - calculates the area of the circle
	//--------------------------------------------------------

    public double area()
    {
        double area = Math.PI * (radius * radius);
        return area;
    }

	//--------------------------------------------------------
	// perimeter - calculates the perimeter of the circle
	//--------------------------------------------------------

    public double perimeter()
    {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

	//--------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	//                is 1 and false otherwise.
	//--------------------------------------------------------

    public boolean isUnitCircle()
    {
        boolean isUnitCircle;
        if (radius == 1)
            isUnitCircle = true;
        else
            isUnitCircle = false;

        return isUnitCircle;
    }

	//--------------------------------------------------------
	// toString - return a String representation of
	//            this circle like
	//            center:(x,y)
	//            radius: r
	//--------------------------------------------------------

    public boolean isConcentric (Circle anotherCircle)
    {
        boolean isConcentric = false;
        if (this.x == anotherCircle.x && this.y == anotherCircle.y && this.radius < anotherCircle.radius)
            isConcentric = true;
        return isConcentric;
    }

    public double distance (Circle anotherCircle)
    {
        double distance = Math.sqrt(((this.x - anotherCircle.x) * (this.x - anotherCircle.x)) + ((this.y - anotherCircle.y) - (this.y - anotherCircle.y)));
        return distance;
    }

    public String toString()
    {
        String toString = " center: (" + x + "," + y + ")\nradius: " + radius;
        return toString;
    }

    public boolean intersects (Circle anotherCircle)
    {
        double distanceVal = this.distance(anotherCircle);
        boolean intersects = false;
        if (distanceVal < (this.radius + anotherCircle.radius))
            intersects = true;
        return intersects;
    }

    public boolean equals (Circle anotherCircle)
    {
        boolean equals = false;
        if (this.radius == anotherCircle.radius)
            equals = true;
        return equals;
    }

}
