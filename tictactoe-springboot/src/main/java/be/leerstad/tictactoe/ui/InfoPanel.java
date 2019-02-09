package be.leerstad.tictactoe.ui;

import java.util.Observable;
import java.util.Observer;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import be.leerstad.tictactoe.business.GameState;
import be.leerstad.tictactoe.service.dto.PlayerDTO;
import be.leerstad.tictactoe.service.manager.GameManager;
import com.vaadin.ui.themes.ValoTheme;

public class InfoPanel extends Panel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6901363380531551162L;
	private GameManager gameManager;

	public InfoPanel(GameManager gamemanager) {
		this.gameManager = gamemanager;
		gamemanager.addObserver(this);
		init();

	}

	private void init() {
		 this.setCaption("Info Panel");
		setSizeFull();
		addStyleName(ValoTheme.LABEL_BOLD);
		final VerticalLayout layout = new VerticalLayout();

		layout.setSpacing(false);
		if (gameManager.getCurrentState().equals(GameState.PLAYING))
			layout.addComponent(new Label("Current player is: "+gameManager.getCurrentPlayer().toString()));
		else
			layout.addComponent(new Label("Please restart Game"));
		layout.addComponent(new Label("Game Mode: "+gameManager.getGameMode().toString()));
		layout.addComponent(new Label(gameManager.getCurrentState().toString()));
		layout.addComponent(setScore(gameManager.getPlayer1()));
		layout.addComponent(setScore(gameManager.getPlayer2()));
		setContent(layout);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		init();
	}

	private Component setScore(PlayerDTO player) {
		StringBuilder sb = new StringBuilder();
		sb.append("Score : ").append(player.getName()).append(" : ").append(player.getScore());
			return new Label (sb.toString());
	}

}