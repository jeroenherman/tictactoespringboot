package be.leerstad.tictactoe.service.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import be.leerstad.tictactoe.business.Seed;
import be.leerstad.tictactoe.service.dto.PlayerDTO;
import org.junit.Before;
import org.junit.Test;


public class PlayerDTOTest {

private PlayerDTO classUnderTest;

@Before
public void setup() {
	classUnderTest = new PlayerDTO();
}

	@Test
	public void testConstructor() throws Exception {
		classUnderTest = new PlayerDTO("player1");
		assertTrue(classUnderTest.getName().equals("player1"));
	}

	@Test
public void testName() {
	classUnderTest.setName("test name");
	assertEquals("test name", classUnderTest.getName());
	classUnderTest.setName("test2 name");
	assertEquals("test2 name", classUnderTest.getName());
}

@Test
public void testSeed() {
	assertNull(classUnderTest.getSeed());
	classUnderTest.setSeed(Seed.CROSS);
	assertTrue(classUnderTest.getSeed().equals(Seed.CROSS));
}

@Test
public void testScore() {
	assertNull(classUnderTest.getScore());
	classUnderTest.setScore(10);
	assertTrue(classUnderTest.getScore()==10);
}

@Test
public void testToString() {
	classUnderTest.setName("test name");
	assertEquals("test name", classUnderTest.toString());
	classUnderTest.setName("test2 name");
	assertEquals("test2 name", classUnderTest.toString());
}

}
