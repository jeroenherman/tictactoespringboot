package be.leerstad.tictactoe.ui;

import java.util.Observable;
import java.util.Observer;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

import be.leerstad.tictactoe.service.dto.GameMode;
import be.leerstad.tictactoe.service.manager.GameManager;
import be.leerstad.tictactoe.ui.controller.GameModeListener;

public class OptionsPanel extends FormLayout implements Observer {
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
	addComponents(player1,player2,gameMode);
}

@Override
public void update(Observable o, Object arg) {
	
	
}

public TextField getPlayer1() {
	return player1;
}

public void setPlayer1(TextField player1) {
	this.player1 = player1;
}

public TextField getPlayer2() {
	return player2;
}

public void setPlayer2(TextField player2) {
	this.player2 = player2;
}

public ComboBox<GameMode> getGameMode() {
	return gameMode;
}

public void setGameMode(ComboBox<GameMode> gameMode) {
	this.gameMode = gameMode;
}




}
