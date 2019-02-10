package be.leerstad.tictactoe.service.dto;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import be.leerstad.tictactoe.business.Seed;
import be.leerstad.tictactoe.service.dto.CellDTO;
import org.junit.Before;
import org.junit.Test;

public class CellDTOTest {

	private CellDTO classUnderTest;

	@Before
	public void setup() {
		classUnderTest = new CellDTO();
	}

	@Test
	public void testConstructor() throws Exception {
		classUnderTest = new CellDTO(1,3, Seed.CROSS);
		assertTrue(classUnderTest.getRow()==1);
		assertTrue(classUnderTest.getCol()==3);
		assertTrue(classUnderTest.getSeed().equals(Seed.CROSS));
		classUnderTest.setSeed(Seed.NOUGHT);
		assertTrue(classUnderTest.getSeed().equals(Seed.NOUGHT));
	}

	@Test
	public void testRow() {
		classUnderTest.setRow(100);
		assertTrue(100 == classUnderTest.getRow());
		classUnderTest.setRow(-10);
		assertTrue(-10 == classUnderTest.getRow());
		classUnderTest.setRow(0);
		assertTrue(0 == classUnderTest.getRow());
	}

	@Test
	public void testCol() {
		classUnderTest.setCol(100);
		assertTrue(100 == classUnderTest.getCol());
		classUnderTest.setCol(-10);
		assertTrue(-10 == classUnderTest.getCol());
		classUnderTest.setCol(0);
		assertTrue(0 == classUnderTest.getCol());
	}

	@Test
	public void testSeed() {
		assertNull(classUnderTest.getSeed());
	}
}
