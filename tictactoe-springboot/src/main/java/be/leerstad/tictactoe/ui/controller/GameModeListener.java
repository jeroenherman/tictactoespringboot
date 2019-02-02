package be.leerstad.tictactoe.ui.controller;

import be.leerstad.tictactoe.service.dto.GameDTO;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.ui.ComboBox;

import be.leerstad.tictactoe.service.dto.GameMode;
import be.leerstad.tictactoe.service.dto.PlayerDTO;
import be.leerstad.tictactoe.service.manager.GameManager;
import be.leerstad.tictactoe.ui.OptionsPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class GameModeListener implements ValueChangeListener<GameMode> {
	
	private OptionsPanel optionsPanel;
	private GameManager gameManager;

	
	

	public GameModeListener(OptionsPanel optionsPanel, GameManager gameManager) {
		super();
		this.optionsPanel = optionsPanel;
		this.gameManager = gameManager;
	}



	@Override
	public void valueChange(ValueChangeEvent<GameMode> event) {
		 PlayerDTO player1 = new PlayerDTO(optionsPanel.getPlayer1().getValue());
			PlayerDTO player2;
		if (optionsPanel.getGameMode().getValue().equals(GameMode.SINGLE))
		 player2 = new PlayerDTO("Computer");
		else 
		 player2 = new PlayerDTO(optionsPanel.getPlayer2().getValue());
		GameDTO game = new GameDTO();
		game.setPlayer1(player1.getName());
		game.setPlayer2(player2.getName());
		game.setScore1(player1.getScore());
		game.setScore2(player2.getScore());

		gameManager.initGame(player1,player2, optionsPanel.getGameMode().getValue());



	}

}
