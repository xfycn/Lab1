package lab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Lab1Test {
	public static Lab1 l1=new Lab1();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSimplify() {
		assertEquals("5*2+4*y",l1.simplify("5*x+4*y","!simplify"));
		//fail("Not yet implemented");
	}

}