package lab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Lab1Test3 {
	public static Lab1 l1=new Lab1();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSimplify() {
		assertEquals("5*3+4*-0.2",l1.simplify("5*x+4*y","!simplify x=3 y=-0.2"));
		//fail("Not yet implemented");
	}

}