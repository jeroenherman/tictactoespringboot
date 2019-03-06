package be.leerstad.tictactoe.service.manager.mapper;

import be.leerstad.tictactoe.business.Game;
import be.leerstad.tictactoe.business.Score;
import be.leerstad.tictactoe.commons.AbstractMapper;
import be.leerstad.tictactoe.service.dto.GameDTO;
import org.springframework.stereotype.Component;

@Component
public class GameMapper extends AbstractMapper<Game, GameDTO> {
    @Override
    public GameDTO mapToDTO(Game b) {
        if (b == null)
            return null;
        GameDTO d = new GameDTO();
        d.setId(b.getId());
        d.setPlayer1(b.getPlayer1());
        d.setPlayer2(b.getPlayer2());
        d.setLocalDateTime(b.getDateTime());
        d.setScore1(b.getScore().getScoreX());
        d.setScore2(b.getScore().getScoreO());
        return d;
    }

    @Override
    public Game mapToObj(GameDTO d) {
        if (d == null)
            return null;
        Game b = new Game();
        b.setId(d.getId());
        b.setPlayer1(d.getPlayer1());
        b.setPlayer2(d.getPlayer2());
        b.setDateTime(d.getLocalDateTime());
        b.setScore(new Score(d.getScore1(),d.getScore2()));
        return b;
    }
}
