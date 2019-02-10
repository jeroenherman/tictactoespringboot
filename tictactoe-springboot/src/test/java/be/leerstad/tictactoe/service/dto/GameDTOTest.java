package be.leerstad.tictactoe.service.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import be.leerstad.tictactoe.service.dto.GameDTO;

import java.time.LocalDateTime;

public class GameDTOTest {

private GameDTO classUnderTest;

@Before
public void setup() {
	classUnderTest = new GameDTO();
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
public void testPlayer1() {
	classUnderTest.setPlayer1("test player1");
	assertEquals("test player1", classUnderTest.getPlayer1());
	classUnderTest.setPlayer1("test2 player1");
	assertEquals("test2 player1", classUnderTest.getPlayer1());

}

@Test
public void testPlayer2() {
	classUnderTest.setPlayer2("test player2");
	assertEquals("test player2", classUnderTest.getPlayer2());
	classUnderTest.setPlayer2("test2 player2");
	assertEquals("test2 player2", classUnderTest.getPlayer2());
}

@Test
public void testScore1() {
	assertNull(classUnderTest.getScore1());
	classUnderTest.setScore1(10);
	assertTrue(classUnderTest.getScore1()==10);
}

@Test
public void testScore2() {
	assertNull(classUnderTest.getScore2());
	classUnderTest.setScore2(10);
	assertTrue(classUnderTest.getScore2()==10);
}

@Test
public void testLocalDateTime() {
	assertNull(classUnderTest.getLocalDateTime());
	classUnderTest.setLocalDateTime(LocalDateTime.of(2019,02,10,11,44,00));
	assertTrue(classUnderTest.getLocalDateTime().equals(LocalDateTime.of(2019,02,10,11,44,00)));
}

}