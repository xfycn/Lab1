package lab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Lab1Test {
	public static Lab1 l2=new Lab1();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDerivative() {
		assertEquals("5*1+0",l2.derivative("5*x+4*y",'x'));
		//fail("Not yet implemented");
	}

}