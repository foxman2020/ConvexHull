package edu.iastate.cs228.hw4;

import java.awt.Point;

/**
 *  
 * @author
 *
 */

import java.util.Comparator;

/**
 * 
 * This class compares two points p1 and p2 by polar angle with respect to a
 * reference point.
 * 
 */
public class PolarAngleComparator implements Comparator<Point> {
	private Point referencePoint;
	private boolean flag; // used for breaking a tie between two points that have
							// the same polar angle with respect to referencePoint

	/**
	 * 
	 * @param p
	 *            reference point
	 */
	public PolarAngleComparator(Point p, boolean flag) {
		referencePoint = p;
		this.flag = flag;
	}

	/**
	 * Use cross product and dot product to implement this method.  Do not take square roots 
	 * or use trigonometric functions. Calls private methods crossProduct() and dotProduct(). 
	 * 
	 * Precondition: both p1 and p2 are different from referencePoint. 
	 * 
	 * @param p1
	 * @param p2
	 * @return  0 if p1 and p2 are the same point
	 *         -1 if one of the following three conditions holds: 
	 *                a) the cross product between p1 - referencePoint and p2 - referencePoint 
	 *                   is greater than zero. 
	 *                b) the above cross product equals zero, flag == true, and p1 is closer to 
	 *                   referencePoint than p2 is. 
	 *                c) the above cross product equals zero, flag == false, and p1 is further 
	 *                   from referencePoint than p2 is.   
	 *          1  otherwise. 
	 *                   
	 */
	public int compare(Point p1, Point p2)
	{
		
		if(p1.equals(referencePoint) || p2.equals(referencePoint))
			return 0;
		int p1Distance = (int) (Math.abs(p1.getX() - referencePoint.getX()) + Math.abs(p1.getX() - referencePoint.getY()));
		int p2Distance = (int) (Math.abs(p2.getX() - referencePoint.getX()) + Math.abs(p2.getX() - referencePoint.getY()));
		
		int crossProduct = crossProduct(p1, p2);
		if(p1.equals(p2))
			return 0;
		if(crossProduct > 0 || (crossProduct == 0 && ((flag == true && p1Distance < p2Distance) || (flag == false && p1Distance > p2Distance)))) 
			return -1;
		return 1;

	}

	/**
	 * 
	 * @param p1
	 * @param p2
	 * @return cross product of two vectors: p1 - referencePoint and p2 -
	 *         referencePoint
	 */
	private int crossProduct(Point p1, Point p2) {
		int xDif = (int) (p1.getX() - referencePoint.getX());
		int yDif =  (int) (p1.getY() - referencePoint.getY());
		Point p1New = new Point(xDif, yDif);
		
		xDif = (int) ((int) p2.getX() - referencePoint.getX());
		yDif =  (int) ((int) p2.getY() - referencePoint.getY());
		Point p2New = new Point(xDif, yDif);
		
		return (int) (p1New.getX() * p2New.getY() - p1New.getY() * p2New.getX());
	}

	/**
	 * 
	 * @param p1
	 * @param p2
	 * @return dot product of two vectors: p1 - referencePoint and p2 -
	 *         referencePoint
	 */
	private int dotProduct(Point p1, Point p2) {
		int xDif = (int) (p1.getX() - referencePoint.getX());
		int yDif =  (int) (p1.getY() - referencePoint.getY());
		Point p1New = new Point(xDif, yDif);
		
		xDif = (int) ((int) p2.getX() - referencePoint.getX());
		yDif =  (int) ((int) p2.getY() - referencePoint.getY());
		Point p2New = new Point(xDif, yDif);
		
		return (int) (p1New.getX() * p2New.getX() + p1New.getY() * p2New.getY());
	}
}
