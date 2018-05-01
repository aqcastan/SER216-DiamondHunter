package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGamePanel {
	TestGamePanel gp;
	@Before
	public void setUp() throws Exception {
		gp = new TestGamePanel();
	}

	@After
	public void tearDown() throws Exception {
		gp = null;
	}

	@Test
	public void test() {
		assertTrue(gp != null);
	}

}
