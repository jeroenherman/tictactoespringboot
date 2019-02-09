package be.leerstad.tictactoe.ui;

import com.vaadin.ui.*;

import be.leerstad.tictactoe.service.dto.GameMode;
import be.leerstad.tictactoe.service.manager.GameManager;
import be.leerstad.tictactoe.ui.controller.GameModeListener;

public class OptionsPanel extends FormLayout  {
private GameManager gameManager;
private TextField player1;
private TextField player2;
private ComboBox<GameMode> gameMode;

public OptionsPanel(GameManager gameManager) {
	super();
	this.gameManager = gameManager;
	init();
}

private void init() {
	setMargin(true);
	if (gameManager.getPlayer1()!=null)
		player1 = new TextField("Player 1", gameManager.getPlayer1().getName());
	else
	player1 = new TextField("Player 1", "speler 1");
	if (gameManager.getPlayer2()!=null)
		player2 = new TextField("Player 2", gameManager.getPlayer2().getName());	
	else
	player2 = new TextField("Player 2", "speler 2");
	gameMode = new ComboBox<GameMode>("Game Mode");
	gameMode.setEmptySelectionAllowed(false);
	gameMode.setValue(gameManager.getGameMode());
	gameMode.setItems(GameMode.values());
	gameMode.addValueChangeListener(new GameModeListener(this,gameManager));
	Button start = new Button("Start",event -> {
		if (gameMode.getValue()!=null)
			gameManager.newGame();
		else
			Notification.show("Please select a game mode");
	});
	addComponents(player1,player2,gameMode,start);

}

public TextField getPlayer1() {
	return player1;
}

public TextField getPlayer2() {
	return player2;
}

public ComboBox<GameMode> getGameMode() {
	return gameMode;
}

}


