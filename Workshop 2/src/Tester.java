// JAC444 - Workshop 2 
// Filename:     Tester.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-09-26

public class Tester {

	public static void main(String[] args) {

		// Create 't1'
		Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));

		// Get the area and perimeter of 't1'
		System.out.println("The area of t1 is " + t1.getArea());
		System.out.println("The perimeter of t1 is " + t1.getPerimeter());

		// Check if 't1' contains arguments.
		System.out.println("Does t1 contain (3,3): "+t1.contains(new MyPoint(3, 3)));
		System.out.println("Does t1 contain Triangle((2.9, 2), (4, 1), (1, 3.4)): " + t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));

		// Check if 't1' overlaps new Triangle2D object.
		System.out.println("Does t1 overlap Triangle((2, 5.5), (4, -3), (2, 6.5)): "+t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))));

		// Create 't2'
		Triangle2D t2 = new Triangle2D(new MyPoint(0, 0), new MyPoint(0, 2), new MyPoint(2, 0));

		// Get the area and perimeter of 't1'
		System.out.println("The area of t2 is " + t2.getArea());
		System.out.println("The perimeter of t2 is "+ t2.getPerimeter());

		// Check if 't2' contains arguments.
		System.out.println("Does t2 contain (1,1): "+ t2.contains(new MyPoint(1, 1)));
		System.out.println("Does t2 contain Triangle((4, 5), (10.5, 3.2), (-0.5, -10.5)): " +
				t2.contains(new Triangle2D(new MyPoint(4, 5), new MyPoint(10.5, 3.2), new MyPoint(-0.5, -10.5))));

		// Check if 't2' overlaps new Triangle2D object.
		System.out.println("Does t2 overlap Triangle((1, 1.7), (-1, 1.7), (0, -3)): "+t2.overlaps(new Triangle2D(new MyPoint(1, 1.7), new MyPoint(-1, 1.7), new MyPoint(0, -3))));
	}
}
