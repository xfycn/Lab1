package lab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Lab1Test1 {
	public static Lab1 l1=new Lab1();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSimplify() {
		assertEquals("5*2+4*3",l1.simplify("5*x+4*y","!simplify x=2 y=3"));
		//fail("Not yet implemented");
	}

}