import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MyTestTest {
	
	MyTest mt;
	
	@Before
	public void setUp() {
		mt = new MyTest("");
	}

	@Test
	public void testGetName() {
		if (mt.getName().isEmpty()) fail("Empty name!");
	}

}
