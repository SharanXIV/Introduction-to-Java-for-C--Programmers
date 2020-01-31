// JAC444 - Workshop 2 
// Filename:     MyPoint.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-09-26

public class MyPoint {
	double x,y;
	
	// Default no argument constructor which sets values to 0.
	MyPoint(){
		x=0;
		y=0;
	}
	
	// Constructor which sets arguments as x and y.
	MyPoint(double newX,double newY){
		this.x=newX;
		this.y=newY;
	}
	
	// Getter method for the 'x' variable.
	double getX() {
		return this.x;
	}

	// Getter method for the 'y' variable.
	double getY() {
		return this.y;
	}
	
	// Returns the distance from this point to a specified point of the MyPoint type.
	double distance(MyPoint p) {
		double d= Math.sqrt(Math.pow((p.getX()-this.getX()),2) + Math.pow((p.getY()- this.getY()),2));
		return d;
	}
	
	// Returns the distance  the distance from this point to another point with specified x and y coordinates using above function.
	double distance(double nextX, double nextY) {
		return distance(new MyPoint(nextX,nextY));
	}
}
