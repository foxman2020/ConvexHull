package edu.iastate.cs228.hw4;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ConvexTestCases {

	@Before
	public void setup() {
		Point reference = new Point(0,0);
//		PolarAngleComparator hello = new PolarAngleComparator(reference, true);
	}
	
	@Test
	public void crossProductTest1() {
		Point A = new Point(2, 2);
		Point B = new Point(3, 1);
		
//		assertEquals(-4, hello.crossProduct(A, B));
	}
}
