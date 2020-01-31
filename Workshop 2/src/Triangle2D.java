// JAC444 - Workshop 2 
// Filename:     Triangle2D.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-09-26

import java.awt.geom.Line2D;

public class Triangle2D {
	MyPoint p1, p2, p3;

	// Getter method for the 'p1' variable.
	MyPoint getp1() {
		return this.p1;
	}

	// Getter method for the 'p2' variable.
	MyPoint getp2() {
		return this.p2;
	}

	// Getter method for the 'p3' variable.
	MyPoint getp3() {
		return this.p3;
	}

	// Setter method for the 'p1' variable.
	void setp1(MyPoint newp1) {
		this.p1 = newp1;
	}

	// Setter method for the 'p2' variable.
	void setp2(MyPoint newp2) {
		this.p2 = newp2;
	}

	// Setter method for the 'p3' variable.
	void setp3(MyPoint newp3) {
		this.p3 = newp3;
	}

	// Default no argument constructor which sets values.
	Triangle2D() {
		this.p1 = new MyPoint(0, 0);
		this.p2 = new MyPoint(1, 1);
		this.p3 = new MyPoint(2, 5);
	}

	// Constructor which sets arguments as p1, p2 and p3.
	Triangle2D(MyPoint np1, MyPoint np2, MyPoint np3) {
		this.p1 = np1;
		this.p2 = np2;
		this.p3 = np3;
	}

	// Calculates area for a Triangle2D object.
	double getArea() {
		double s = (this.getPerimeter()) / 2;
		return Math.sqrt((s) * (s - p1.distance(p2)) * (s - p2.distance(p3)) * (s - p3.distance(p1)));
	}

	// Calculates the perimeter for a Triangle2D object.
	double getPerimeter() {
		return (p1.distance(p2) + p2.distance(p3) + p3.distance(p1));
	}

	// Returns true if 'p' is within this Triangle2D object, does this by
	// calculating area of Triangle2D object and then making triangles from
	// 2 points of Triangle2D object and 'p'. If the sum of the 3 created
	// triangles should equal to the area of this Triangle2D object to return true.
	boolean contains(MyPoint p) {
		double a = this.getArea();
		Triangle2D pab = new Triangle2D(p, this.p1, this.p2);
		Triangle2D pbc = new Triangle2D(p, this.p2, this.p3);
		Triangle2D pac = new Triangle2D(p, this.p3, this.p1);

		double a1 = pab.getArea();
		double a2 = pbc.getArea();
		double a3 = pac.getArea();

		if (a >= (a1 + a2 + a3)) // If three triangles are equal or less in size.
			return true;
		else
			return false;
	}

	// Returns true if 't' is within this Triangle2D object. Does this by checking
	// if each point of 't' is contained within this Triangle2D object. If even
	// one point isn't within the Triangle2D object then it returns false.
	boolean contains(Triangle2D t) {
		return (contains(t.getp1()) && contains(t.getp2()) && contains(t.getp3()));
	}

	// Returns true if 't' overlaps with any of the sides within this Triangle2D
	// object. This is done using linesIntersect which tests if the line segment
	// from (x1,y1) to (x2,y2) intersects the line segment from (x3,y3) to (x4,y4).
	boolean overlaps(Triangle2D t) {
		boolean overlap1 = (Line2D.linesIntersect(t.getp1().getX(), t.getp1().getY(), t.getp2().getX(),
				t.getp2().getY(), this.getp1().getX(), this.getp1().getY(), this.getp2().getX(), this.getp2().getY()))
				|| (Line2D.linesIntersect(t.getp1().getX(), t.getp1().getY(), t.getp2().getX(), t.getp2().getY(),
						this.getp2().getX(), this.getp2().getY(), this.getp3().getX(), this.getp3().getY()))
				|| (Line2D.linesIntersect(t.getp1().getX(), t.getp1().getY(), t.getp2().getX(), t.getp2().getY(),
						this.getp3().getX(), this.getp3().getY(), this.getp1().getX(), this.getp1().getY()));

		boolean overlap2 = (Line2D.linesIntersect(t.getp2().getX(), t.getp2().getY(), t.getp3().getX(),
				t.getp3().getY(), this.getp1().getX(), this.getp1().getY(), this.getp2().getX(), this.getp2().getY()))
				|| (Line2D.linesIntersect(t.getp2().getX(), t.getp2().getY(), t.getp3().getX(), t.getp3().getY(),
						this.getp2().getX(), this.getp2().getY(), this.getp3().getX(), this.getp3().getY()))
				|| (Line2D.linesIntersect(t.getp2().getX(), t.getp2().getY(), t.getp3().getX(), t.getp3().getY(),
						this.getp3().getX(), this.getp3().getY(), this.getp1().getX(), this.getp1().getY()));

		boolean overlap3 = (Line2D.linesIntersect(t.getp3().getX(), t.getp3().getY(), t.getp1().getX(),
				t.getp1().getY(), this.getp1().getX(), this.getp1().getY(), this.getp2().getX(), this.getp2().getY()))
				|| (Line2D.linesIntersect(t.getp3().getX(), t.getp3().getY(), t.getp1().getX(), t.getp1().getY(),
						this.getp2().getX(), this.getp2().getY(), this.getp3().getX(), this.getp3().getY()))
				|| (Line2D.linesIntersect(t.getp3().getX(), t.getp3().getY(), t.getp1().getX(), t.getp1().getY(),
						this.getp3().getX(), this.getp3().getY(), this.getp1().getX(), this.getp1().getY()));

		return (overlap1 || overlap2 || overlap3);
	}
}
