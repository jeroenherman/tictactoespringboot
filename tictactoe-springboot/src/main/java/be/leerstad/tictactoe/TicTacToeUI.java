package be.leerstad.tictactoe;

import java.util.Observable;
import java.util.Observer;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import be.leerstad.tictactoe.business.GameState;
import be.leerstad.tictactoe.service.manager.GameManager;
import be.leerstad.tictactoe.ui.GameBoard;
import be.leerstad.tictactoe.ui.GameMenu;
import be.leerstad.tictactoe.ui.InfoPanel;
import be.leerstad.tictactoe.ui.OptionsPanel;
@SpringUI
@Theme("TicTacToeTheme")
public class TicTacToeUI extends UI implements Observer{
private GameManager gameManager = new GameManager();
	

    @Override
    protected void init(VaadinRequest vaadinRequest) {
      gameManager.addObserver(this);
      GridLayout root = new GridLayout(3,3);
	   root.setMargin(true);
      root.addComponent(new OptionsPanel(gameManager),1,1);

      setContent(root);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		if((arg1!=null)&&arg1.equals(GameState.RESET))
			newGame();
		
	}
	private void newGame() {
		   GridLayout root = new GridLayout(3,3);
		   root.setMargin(true);
	        root.addComponent(new GameMenu(gameManager),1,0);
	        root.addComponent(new GameBoard(gameManager),1,1); 
	        root.addComponent(new InfoPanel(gameManager),1,2);
	        setContent(root);
	}

}
