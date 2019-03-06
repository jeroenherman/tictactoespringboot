package be.leerstad.tictactoe.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import be.leerstad.tictactoe.business.Score;
import org.junit.Before;
import org.junit.Test;

public class ScoreTest {

private Score classUnderTest;

@Before
public void setup() {
	classUnderTest = new Score();
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
public void testScoreX() {
	assertNull(classUnderTest.getScoreX());
	classUnderTest.setScoreO(10);
	assertEquals(10,classUnderTest.getScoreO(),0);
	classUnderTest.setScoreO(20);
	assertEquals(20,classUnderTest.getScoreO(),0);


}

@Test
public void testScoreO() {
	assertNull(classUnderTest.getScoreO());
	classUnderTest.setScoreX(10);
	assertEquals(10,classUnderTest.getScoreX(),0);
	classUnderTest.setScoreX(20);
	assertEquals(20,classUnderTest.getScoreX(),0);

}



}