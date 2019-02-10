package be.leerstad.tictactoe.business;

import be.leerstad.tictactoe.business.Board;
import be.leerstad.tictactoe.business.Seed;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

private Board classUnderTest;

@Before
public void setup() {
	classUnderTest = new Board();
}

@Test
public void testCells() {
	assertNotNull(classUnderTest.getCells());
}

@Test
public void testCurrentRow() {
	classUnderTest.setCurrentRow(3);
	assertTrue(3==classUnderTest.getCurrentRow());
	classUnderTest.setCurrentRow(1);
	assertTrue(1==classUnderTest.getCurrentRow());
}

@Test
public void testCurrentCol() {
	classUnderTest.setCurrentCol(3);
	assertTrue(3==classUnderTest.getCurrentCol());
	classUnderTest.setCurrentCol(1);
	assertTrue(1==classUnderTest.getCurrentCol());
	classUnderTest.setCurrentCol(2);
	assertTrue(2==classUnderTest.getCurrentCol());
}

@Test
public void testInit() {
	classUnderTest.init();
	for (int j = 1; j < 3; j++) {
		for (int i = 1; i < 3; i++) {
			assertTrue(classUnderTest.getSeed(i, j).equals(Seed.EMPTY));
		}
	}
}

@Test
public void testXHasWonHorizontal1() {
	classUnderTest.setSeed(0,0,Seed.CROSS);
	classUnderTest.setSeed(0,1,Seed.CROSS);
	classUnderTest.setSeed(0,2,Seed.CROSS);
	assertTrue(classUnderTest.hasWon(Seed.CROSS));
}

	@Test
	public void testXHasWonHorizontal2() {
		classUnderTest.setCurrentRow(1);
		classUnderTest.setSeed(1,0,Seed.CROSS);
		classUnderTest.setSeed(1,1,Seed.CROSS);
		classUnderTest.setSeed(1,2,Seed.CROSS);
		assertTrue(classUnderTest.hasWon(Seed.CROSS));
	}

	@Test
	public void testXHasWonHorizontal3() {
		classUnderTest.setCurrentRow(2);
		classUnderTest.setSeed(2,0,Seed.CROSS);
		classUnderTest.setSeed(2,1,Seed.CROSS);
		classUnderTest.setSeed(2,2,Seed.CROSS);
		assertTrue(classUnderTest.hasWon(Seed.CROSS));
	}
	@Test
	public void testXHasWonVertical1() {

		classUnderTest.setSeed(0,0,Seed.CROSS);
		classUnderTest.setSeed(1,0,Seed.CROSS);
		classUnderTest.setSeed(2,0,Seed.CROSS);
		assertTrue(classUnderTest.hasWon(Seed.CROSS));
	}
	@Test
	public void testXHasWonVertical2() {
		classUnderTest.setCurrentCol(1);
		classUnderTest.setSeed(0,1,Seed.CROSS);
		classUnderTest.setSeed(1,1,Seed.CROSS);
		classUnderTest.setSeed(2,1,Seed.CROSS);
		assertTrue(classUnderTest.hasWon(Seed.CROSS));
	}
	@Test
	public void testXHasWonVertical3() {
		classUnderTest.setCurrentCol(2);
		classUnderTest.setSeed(0,2,Seed.CROSS);
		classUnderTest.setSeed(1,2,Seed.CROSS);
		classUnderTest.setSeed(2,2,Seed.CROSS);
		assertTrue(classUnderTest.hasWon(Seed.CROSS));
	}
	@Test
	public void testXHasWonDiagonal1() {
		classUnderTest.setSeed(0,0,Seed.CROSS);
		classUnderTest.setSeed(1,1,Seed.CROSS);
		classUnderTest.setSeed(2,2,Seed.CROSS);
		assertTrue(classUnderTest.hasWon(Seed.CROSS));
	}
	@Test
	public void testXHasWonDiagonal2() {
		classUnderTest.setSeed(0,2,Seed.CROSS);
		classUnderTest.setSeed(1,1,Seed.CROSS);
		classUnderTest.setSeed(2,0,Seed.CROSS);
		classUnderTest.setCurrentRow(2);
		assertTrue(classUnderTest.hasWon(Seed.CROSS));
	}
	@Test
	public void testOHasWonHorizontal1() {
		classUnderTest.setSeed(0,0,Seed.NOUGHT);
		classUnderTest.setSeed(0,1,Seed.NOUGHT);
		classUnderTest.setSeed(0,2,Seed.NOUGHT);
		assertTrue(classUnderTest.hasWon(Seed.NOUGHT));
	}

	@Test
	public void testOHasWonHorizontal2() {
		classUnderTest.setCurrentRow(1);
		classUnderTest.setSeed(1,0,Seed.NOUGHT);
		classUnderTest.setSeed(1,1,Seed.NOUGHT);
		classUnderTest.setSeed(1,2,Seed.NOUGHT);
		assertTrue(classUnderTest.hasWon(Seed.NOUGHT));
	}

	@Test
	public void testOHasWonHorizontal3() {
		classUnderTest.setCurrentRow(2);
		classUnderTest.setSeed(2,0,Seed.NOUGHT);
		classUnderTest.setSeed(2,1,Seed.NOUGHT);
		classUnderTest.setSeed(2,2,Seed.NOUGHT);
		assertTrue(classUnderTest.hasWon(Seed.NOUGHT));
	}
	@Test
	public void testOHasWonVertical1() {
		classUnderTest.setSeed(0,0,Seed.NOUGHT);
		classUnderTest.setSeed(1,0,Seed.NOUGHT);
		classUnderTest.setSeed(2,0,Seed.NOUGHT);
		assertTrue(classUnderTest.hasWon(Seed.NOUGHT));
	}
	@Test
	public void testOHasWonVertical2() {
		classUnderTest.setCurrentCol(1);
		classUnderTest.setSeed(0,1,Seed.NOUGHT);
		classUnderTest.setSeed(1,1,Seed.NOUGHT);
		classUnderTest.setSeed(2,1,Seed.NOUGHT);
		assertTrue(classUnderTest.hasWon(Seed.NOUGHT));
	}
	@Test
	public void testOHasWonVertical3() {
		classUnderTest.setCurrentCol(2);
		classUnderTest.setSeed(0,2,Seed.NOUGHT);
		classUnderTest.setSeed(1,2,Seed.NOUGHT);
		classUnderTest.setSeed(2,2,Seed.NOUGHT);
		assertTrue(classUnderTest.hasWon(Seed.NOUGHT));
	}
	@Test
	public void testOHasWonDiagonal1() {
		classUnderTest.setSeed(0,0,Seed.NOUGHT);
		classUnderTest.setSeed(1,1,Seed.NOUGHT);
		classUnderTest.setSeed(2,2,Seed.NOUGHT);
		assertTrue(classUnderTest.hasWon(Seed.NOUGHT));
	}
	@Test
	public void testOHasWonDiagonal2() {
		classUnderTest.setSeed(0,2,Seed.NOUGHT);
		classUnderTest.setSeed(1,1,Seed.NOUGHT);
		classUnderTest.setSeed(2,0,Seed.NOUGHT);
		classUnderTest.setCurrentCol(0);
		classUnderTest.setCurrentRow(2);
		assertTrue(classUnderTest.hasWon(Seed.NOUGHT));
	}
}