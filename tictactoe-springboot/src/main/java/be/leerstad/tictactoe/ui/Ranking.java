package be.leerstad.tictactoe.ui;

import be.leerstad.tictactoe.business.GameState;
import be.leerstad.tictactoe.service.dto.GameDTO;
import be.leerstad.tictactoe.service.manager.GameManager;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import java.util.Observable;
import java.util.Observer;

public class Ranking extends VerticalLayout implements Observer{
    private GameManager gameManager;

    public Ranking(GameManager gameManager) {
        this.gameManager = gameManager;
        init();
    }

    private void init() {
         Grid<GameDTO> grid = new Grid<>(GameDTO.class);
         grid.setSizeFull();

         grid.setColumnOrder(grid.getColumn("player1"),
                 grid.getColumn("score1"),
                 grid.getColumn("player2"),
                 grid.getColumn("score2"));
         grid.getColumn("id").setHidden(true);
         grid.setDataProvider(DataProvider.ofCollection(gameManager.getRanking()));
         addComponent(grid);
    }


    @Override
    public void update(Observable o, Object arg) {
        if ((arg!=null)&&arg.equals(GameState.RESET))
            init();
    }
}
