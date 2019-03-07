package be.leerstad.tictactoe.service.manager.mapper;

import be.leerstad.tictactoe.business.Player;
import be.leerstad.tictactoe.business.Score;
import be.leerstad.tictactoe.service.dto.PlayerDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerMapperTest {

    private Player b;
    private PlayerDTO d;
    private PlayerMapper classUnderTest;

    @Before
    public void setup(){
        b = new Player();
        d = new PlayerDTO();
        classUnderTest = new PlayerMapper();
    }

    @Test
    public void testNullBusinessObject() {
        b = null;
        d = classUnderTest.mapToDTO(b);
        assertNull(d);
    }

    @Test
    public void testNullDTO() {
        d = null;
        b = classUnderTest.mapToObj(d);
        assertNull(b);
    }


    @Test
    public void mapToDTO() {
        b.setId(10);
        b.setName("player1");
        b.setScore(20);
        d = classUnderTest.mapToDTO(b);

        assertEquals(b.getName(),d.getName());
        assertEquals(b.getScore(),d.getScore());

    }

    @Test
    public void mapToObj() {

        d.setName("player1");
        d.setScore(20);
        b = classUnderTest.mapToObj(d);

        assertEquals(b.getName(),d.getName());
        assertEquals(b.getScore(),d.getScore());

    }
}