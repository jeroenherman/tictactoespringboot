package be.leerstad.tictactoe;

import java.util.Observable;
import java.util.Observer;

import be.leerstad.tictactoe.ui.*;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import be.leerstad.tictactoe.business.GameState;
import be.leerstad.tictactoe.service.manager.GameManager;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("TicTacToeTheme")
public class TicTacToeUI extends UI implements Observer{
//private GameManager gameManager = new GameManager();
	@Autowired
	private GameManager gameManager;

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
		VerticalLayout root = new VerticalLayout();
		root.addComponent(new GameMenu(gameManager));
		HorizontalLayout hlayout = new HorizontalLayout();
		Panel leftPanel = new Panel("Game Board");
		HorizontalLayout gameLayout = new HorizontalLayout();
		gameLayout.setMargin(true);
		gameLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		gameLayout.addComponents(new GameBoard(gameManager),new InfoPanel(gameManager));
		leftPanel.setContent(gameLayout);
		Panel rightPanel = new Panel("Rankings");
		rightPanel.setContent(new Ranking(gameManager));
		hlayout.addComponentsAndExpand(leftPanel,rightPanel);
    	root.addComponent(hlayout);

//		   GridLayout root = new GridLayout(3,3);
//		   root.setMargin(true);
//		   root.setMargin(new MarginInfo(false,true,true,false));
//	        root.addComponent(new GameMenu(gameManager),0,0);
//	        root.
//	        root.addComponents(new Label("Tic Tac Toe"),new GameBoard(gameManager),0,1);
//	        root.addComponent(new InfoPanel(gameManager),0,2);
//	        root.addComponent(new Ranking(gameManager),1,1);
	        setContent(root);
	}

}
