package be.leerstad.tictactoe.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import be.leerstad.tictactoe.business.Player;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest {

private Player classUnderTest;

@Before
public void setup() {
	classUnderTest = new Player();
}

@Test
public void testId() {
	classUnderTest.setId(100);
	assertTrue(100==classUnderTest.getId());
	classUnderTest.setId(-10);
	assertTrue(-10==classUnderTest.getId());
	classUnderTest.setId(0);
	assertTrue(0==classUnderTest.getId());
}

@Test
public void testName() {
	classUnderTest.setName("test name");
	assertEquals("test name", classUnderTest.getName());
	classUnderTest.setName("test2 name");
	assertEquals("test2 name", classUnderTest.getName());
}

@Test
public void testScore() {
	assertNull(classUnderTest.getScore());
}

}