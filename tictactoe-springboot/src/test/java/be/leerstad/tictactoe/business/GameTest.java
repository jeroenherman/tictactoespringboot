package be.leerstad.tictactoe.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import be.leerstad.tictactoe.business.Game;
import be.leerstad.tictactoe.business.Player;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GameTest {

private Game classUnderTest;

@Before
public void setup() {
	classUnderTest = new Game();
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
public void testScore() {
	assertNull(classUnderTest.getScore());
}

@Test
public void testDateTime() {
	assertNull(classUnderTest.getDateTime());
}

	@Test
	public void testGameConstructor() throws Exception {
	Player player1 = new Player("player1",10);
	Player player2 = new Player("player2",20);
	classUnderTest = new Game(player1,player2, LocalDateTime.of(2019,2,10,11,18,00));
	assertTrue(classUnderTest.getPlayer1().equals(player1.getName()));
	assertTrue(classUnderTest.getPlayer2().equals(player2.getName()));
	assertTrue(classUnderTest.getScore().getScoreX().equals(player1.getScore()));
	assertTrue(classUnderTest.getScore().getScoreO().equals(player2.getScore()));
	assertTrue(classUnderTest.getDateTime().equals( LocalDateTime.of(2019,2,10,11,18,00)));

	}
}