package lab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Lab1Test1 {
	public static Lab1 l2=new Lab1();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDerivative() {
		//fail("Not yet implemented");
		assertEquals("5*3*x*x+0",l2.derivative("5*x*x*x+6*y",'x'));
	}

}