package be.leerstad.tictactoe.ui;

import com.vaadin.ui.MenuBar;

import be.leerstad.tictactoe.service.dto.GameMode;
import be.leerstad.tictactoe.service.manager.GameManager;
import com.vaadin.ui.Notification;

public class GameMenu extends MenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6583543972904254710L;
	private GameManager gameManager;
	private final Command newGame = s -> gameManager.newGame();
	private final Command singlePlayer = s -> gameManager.setGameMode(GameMode.SINGLE);
	private final Command dualPlayer = s -> gameManager.setGameMode(GameMode.DUAL);
	private Command options = s -> this.getUI().setContent(new OptionsPanel(gameManager));
	private Command save = s-> {
		if(gameManager.saveGame())
			Notification.show("Game Saved");
		else
			Notification.show("Game is still playing","please finish it first before saving", Notification.Type.ERROR_MESSAGE);
	};

	public GameMenu(GameManager gameManager) {
		super();
		this.gameManager = gameManager;
		init();
	}
	
	private void init() {
		MenuItem mode = addItem("Mode");
		mode.addItem("Single Player", singlePlayer);
		mode.addItem("Dual Player", dualPlayer);
		MenuItem reset = addItem("New Game",newGame);
		MenuItem gameOptions = addItem("Game Options" ,options);
		MenuItem saveGame = addItem("Save Game", save );
	}

}
