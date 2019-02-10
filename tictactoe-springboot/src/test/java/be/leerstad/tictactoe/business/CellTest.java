package be.leerstad.tictactoe.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import be.leerstad.tictactoe.business.Cell;
import be.leerstad.tictactoe.business.Seed;
import org.junit.Before;
import org.junit.Test;


public class CellTest {

private Cell classUnderTest;

@Before
public void setup() {
	classUnderTest = new Cell();
}

@Test
public void testContent() {
	assertNull(classUnderTest.getContent());
}

@Test
public void testRow() {
	classUnderTest.setRow(100);
	assertTrue(100==classUnderTest.getRow());
	classUnderTest.setRow(-10);
	assertTrue(-10==classUnderTest.getRow());
	classUnderTest.setRow(0);
	assertTrue(0==classUnderTest.getRow());
}

@Test
public void testCol() {
	classUnderTest.setCol(100);
	assertTrue(100==classUnderTest.getCol());
	classUnderTest.setCol(-10);
	assertTrue(-10==classUnderTest.getCol());
	classUnderTest.setCol(0);
	assertTrue(0==classUnderTest.getCol());
}

@Test
public void testClear() {
	classUnderTest.clear();
	assertTrue(classUnderTest.getContent().equals(Seed.EMPTY));
}

}