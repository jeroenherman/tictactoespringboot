package be.leerstad.tictactoe.service.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import be.leerstad.tictactoe.service.dto.GameMode;

public class GameModeTest {

private GameMode classUnderTest;

@Before
public void setup() {
	classUnderTest =  GameMode.SINGLE;
}

@Test
public void testSINGLE() {
	assertTrue(classUnderTest.equals(GameMode.SINGLE));
}

@Test
public void testDUAL() {
	classUnderTest = GameMode.DUAL;
	assertTrue(classUnderTest.equals(GameMode.DUAL));
}

@Test
public void testToString() {
	assertTrue(classUnderTest.toString().equals("Single Player"));
}

}