package be.leerstad.tictactoe.service.manager;

import be.leerstad.tictactoe.business.Game;
import be.leerstad.tictactoe.business.GameState;
import be.leerstad.tictactoe.business.Seed;
import be.leerstad.tictactoe.service.TestConfig;
import be.leerstad.tictactoe.service.dto.CellDTO;
import be.leerstad.tictactoe.service.dto.GameDTO;
import be.leerstad.tictactoe.service.dto.GameMode;
import be.leerstad.tictactoe.service.dto.PlayerDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameManagerIT {
    @Autowired
    GameManager gameManager;
    PlayerDTO p1;
    PlayerDTO p2;
    @Before
    public void setUp() throws Exception {
        p1 = new PlayerDTO();
        p1.setName("player1");
        p1.setSeed(Seed.CROSS);
        p2 = new PlayerDTO("player2");
        p2.setSeed(Seed.NOUGHT);
    }

    @After
    public void destroy(){
        gameManager.reset();
    }
    @Test
    public void getPlayer1() throws Exception {
        assertNull(gameManager.getPlayer1());
    }

    @Test
    public void getPlayer2() throws Exception {
        assertNull(gameManager.getPlayer2());
    }

    @Test
    public void testSeedSetting() throws Exception {
        p1.setSeed(Seed.CROSS);
        p2.setSeed(Seed.CROSS);
        gameManager.initGame(p1,p2,GameMode.SINGLE);
        assertTrue(gameManager.getPlayer1().getSeed().equals(Seed.CROSS));
        assertTrue(gameManager.getPlayer2().getSeed().equals(Seed.NOUGHT));
        assertTrue(gameManager.getCurrentState().equals(GameState.PLAYING));
        assertTrue(gameManager.getGameMode().equals(GameMode.SINGLE));
    }

    @Test
    public void testDualPlayer() throws Exception {
        gameManager.initGame(p1,p2, GameMode.DUAL);
        assertTrue(gameManager.getGameMode().equals(GameMode.DUAL));
        assertTrue(gameManager.getCurrentState().equals(GameState.PLAYING));
        assertTrue(gameManager.getCurrentPlayer().equals(p1));
        CellDTO cell = new CellDTO(1,1,Seed.CROSS);
        assertEquals(gameManager.dualPlayer(cell),("Player 2 your move!"));
        assertEquals(gameManager.dualPlayer(cell),("This move at (1,1) is not valid. Try again..."));
        cell = new CellDTO(1,2,Seed.NOUGHT);
        assertEquals(gameManager.dualPlayer(cell),("Player 1 your move!"));
        assertEquals(gameManager.dualPlayer(cell),("This move at (1,2) is not valid. Try again..."));
        cell = new CellDTO(2,1,Seed.CROSS);
        assertEquals(gameManager.dualPlayer(cell),("Player 2 your move!"));
        assertEquals(gameManager.dualPlayer(cell),("This move at (2,1) is not valid. Try again..."));
        cell = new CellDTO(2,2,Seed.NOUGHT);
        assertEquals(gameManager.dualPlayer(cell),("Player 1 your move!"));
        assertEquals(gameManager.dualPlayer(cell),("This move at (2,2) is not valid. Try again..."));
        cell = new CellDTO(3,1,Seed.CROSS);
        assertEquals(gameManager.dualPlayer(cell),("Cross won"));
        assertEquals(gameManager.dualPlayer(cell),("This move at (3,1) is not valid. Try again..."));
    }


    @Test
    public void singlePlayer(){
        gameManager.initGame(p1,p2, GameMode.SINGLE);
        assertTrue(gameManager.getGameMode().equals(GameMode.SINGLE));
        assertTrue(gameManager.getCurrentState().equals(GameState.PLAYING));
        assertTrue(gameManager.getCurrentPlayer().equals(p1));
        CellDTO cell = new CellDTO(1,1,Seed.CROSS);
        assertEquals(gameManager.singlePlayer(cell),("Player 1 your move!"));
        assertEquals(gameManager.singlePlayer(cell),("This move at (1,1) is not valid. Try again..."));
        cell = new CellDTO(2,1,Seed.CROSS);
        assertEquals(gameManager.singlePlayer(cell),("Player 1 your move!"));
        assertEquals(gameManager.singlePlayer(cell),("This move at (2,1) is not valid. Try again..."));
        cell = new CellDTO(3,1,Seed.CROSS);
        assertEquals(gameManager.singlePlayer(cell),("Cross won"));
        assertEquals(gameManager.singlePlayer(cell),("This move at (3,1) is not valid. Try again..."));

    }


    @Test
    public void newGame() throws Exception {
        gameManager.initGame(p1,p2,GameMode.DUAL);
        gameManager.newGame();
        assertEquals(p1,gameManager.getCurrentPlayer());
        assertEquals(GameState.PLAYING,gameManager.getCurrentState());
    }

    @Test
    public void saveGame() throws Exception {
        assertFalse(gameManager.saveGame());
        testDualPlayer();
        assertTrue(gameManager.saveGame());
        List<GameDTO> ranking = gameManager.getRanking();
        assertEquals(1,ranking.size());
        assertEquals(1, ranking.get(0).getScore1(),0);
        assertEquals(0, ranking.get(0).getScore2(),0);

        testDualPlayer();
        assertTrue(gameManager.saveGame());
        ranking = gameManager.getRanking();
        assertEquals(1,ranking.size());
        assertEquals(2, ranking.get(0).getScore1(),0);
        assertEquals(0, ranking.get(0).getScore2(),0);

    }


    @Test
    public void getRanking() throws Exception {
    }

}