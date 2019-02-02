package be.leerstad.tictactoe.service.manager.mapper;

import org.springframework.stereotype.Component;

import be.leerstad.tictactoe.business.Player;
import be.leerstad.tictactoe.service.dto.PlayerDTO;
import commons.service.AbstractMapper;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerMapper extends AbstractMapper<Player, PlayerDTO> {
	

	@Override
	public PlayerDTO mapToDTO(Player b) {
		if(b==null)
		return null;
		PlayerDTO d = new PlayerDTO(b.getName());
		d.setScore(b.getScore());
		return d;
	}

	@Override
	public Player mapToObj(PlayerDTO d) {
		if(d==null)
		return null;
		Player b = new Player(d.getName(),d.getScore());
		return b;
	}

}
