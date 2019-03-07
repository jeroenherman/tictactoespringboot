package be.leerstad.tictactoe.service.manager.mapper;

import be.leerstad.tictactoe.business.Game;
import be.leerstad.tictactoe.business.Score;
import be.leerstad.tictactoe.service.dto.GameDTO;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class GameMapperTest {

    private Game b;
    private GameDTO d;
    private GameMapper classUnderTest;

    @Before
    public void setup(){
        b = new Game();
        d = new GameDTO();
        classUnderTest = new GameMapper();
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
        b.setPlayer1("speler1");
        b.setPlayer2("speler2");
        Score score = new Score();
        score.setScoreO(10);
        score.setScoreX(20);
        b.setScore(score);
        b.setDateTime(LocalDateTime.of(2019,12,12,9,0));

        d = classUnderTest.mapToDTO(b);

        assertEquals(d.getId(),b.getId());
        assertEquals(d.getLocalDateTime(),b.getDateTime());
        assertEquals(d.getPlayer1(),b.getPlayer1());
        assertEquals(d.getPlayer2(),b.getPlayer2());
        assertEquals(d.getScore1(),b.getScore().getScoreX());
        assertEquals(d.getScore2(),b.getScore().getScoreO());
    }

    @Test
    public void mapToObj() {

        d.setId(10);
        d.setPlayer1("speler1");
        d.setPlayer2("speler2");
        d.setScore1(10);
        d.setScore2(20);
        d.setLocalDateTime(LocalDateTime.of(2019,12,12,9,0));
        b = classUnderTest.mapToObj(d);
        assertEquals(d.getId(),b.getId());
        assertEquals(d.getLocalDateTime(),b.getDateTime());
        assertEquals(d.getPlayer1(),b.getPlayer1());
        assertEquals(d.getPlayer2(),b.getPlayer2());
        assertEquals(d.getScore1(),b.getScore().getScoreX());
        assertEquals(d.getScore2(),b.getScore().getScoreO());

    }
}