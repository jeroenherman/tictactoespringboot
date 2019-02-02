package be.leerstad.tictactoe.service.manager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

import be.leerstad.tictactoe.business.Game;
import be.leerstad.tictactoe.service.dto.GameDTO;
import be.leerstad.tictactoe.service.manager.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import be.leerstad.tictactoe.business.Board;

import be.leerstad.tictactoe.business.GameState;
import be.leerstad.tictactoe.business.Seed;
import be.leerstad.tictactoe.business.repo.GameRepository;
import be.leerstad.tictactoe.service.dto.CellDTO;
import be.leerstad.tictactoe.service.dto.GameMode;
import be.leerstad.tictactoe.service.dto.PlayerDTO;
import be.leerstad.tictactoe.service.manager.mapper.PlayerMapper;
@Controller
public class GameManager extends Observable {
	private Board board; // the game board
	private GameMode currentGameMode;
	private GameState currentState; // the current state of the game (of enum GameState)
	private PlayerDTO currentPlayer; // the current player (with enum Seed)
	private PlayerDTO player1;
	private PlayerDTO player2;
	@Autowired
	private PlayerMapper playerMapper;
	@Autowired
	private GameMapper gameMapper;
	@Autowired
	private GameRepository gameRepository;
	
	
	public GameManager() {
		board = new Board(); // allocate game-board	
	}


	public String singlePlayer(CellDTO cellDTO) {
		String message = "";
		if (getCurrentPlayer().getSeed().equals(Seed.CROSS))
			message = dualPlayer(cellDTO);
		if (getCurrentPlayer().getSeed().equals(Seed.NOUGHT)) {
			do {
				int row = ThreadLocalRandom.current().nextInt(1, 4);
				int col = ThreadLocalRandom.current().nextInt(1, 4);
				cellDTO = new CellDTO(row, col, Seed.EMPTY);
				message = dualPlayer(cellDTO);
			} while (currentPlayer.getSeed().equals(Seed.NOUGHT) && currentState.equals(GameState.PLAYING));
		}
		return message;
	}

	public PlayerDTO getCurrentPlayer() {
		return currentPlayer;
	}

	public GameState getCurrentState() {
		return currentState;
	}

	public GameMode getGameMode() {
		return currentGameMode;
	}

	/** Initialize the game-board contents and the current states */
	public void initGame(PlayerDTO p1, PlayerDTO p2, GameMode gs) {
		board.init(); // clear the board contents
		setChanged();
		setPlayers(p1,p2);
		resetScore();
		currentGameMode = gs;
		notifyObservers(GameState.RESET);
		currentPlayer = p1; // CROSS plays first
		currentState = GameState.PLAYING; // ready to play

	}

	private void setPlayers(PlayerDTO p1, PlayerDTO p2) {
		this.player1 = p1;
		player1.setSeed(Seed.CROSS);
		this.player2 = p2;
		player2.setSeed(Seed.NOUGHT);	
	}

	private void resetScore() {
		player1.setScore( 0);
		player2.setScore( 0);	
	}

	public void setGameMode(GameMode gameMode) {
		if (currentState.equals(GameState.PLAYING))
			initGame(player1,player2, gameMode);
		setChanged();
		notifyObservers();
	}

	/**
	 * The player with "theSeed" makes one move, with input validation. Update
	 * Cell's content, Board's currentRow and currentCol.
	 */
	public String dualPlayer(CellDTO cellDTO) {
		int row, col;
		String message = "";
		row = cellDTO.getRow() - 1; // arrays are 0 based
		col = cellDTO.getCol() - 1; // arrays are 0 based
		if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS && board.getSeed(row, col) == Seed.EMPTY) {
			board.setSeed(row, col, currentPlayer.getSeed());
			board.setCurrentRow(row);
			board.setCurrentCol(col);
			cellDTO.setSeed(currentPlayer.getSeed());
			setChanged();
			notifyObservers(cellDTO); // change cell image via cellDTO
			updateGame(currentPlayer.getSeed());
			message = currentState.toString();
			if (currentState.equals(GameState.PLAYING))
				message =  switchPlayer().toString();

		} else {
			message = "This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...";
		}
		return message;
	}

	private Seed switchPlayer() {
		 if (currentPlayer.equals(player1))
				 currentPlayer = player2;
		 else
			 currentPlayer = player1;
		setChanged();
		notifyObservers();
		return currentPlayer.getSeed();
	}

	/** Update the currentState after the player with "theSeed" has moved */
	public void updateGame(Seed theSeed) {
		if (board.hasWon(theSeed)) { // check for win
			currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
			keepScore(theSeed);
			setChanged();
		} else if (board.isDraw()) { // check for draw
			currentState = GameState.DRAW;
			setChanged();
		}
		// Otherwise, no change to current state (still GameState.PLAYING).
		notifyObservers();
	}


	private void keepScore(Seed theSeed) {
		if (theSeed.equals(player1.getSeed()))
			player1.setScore(player1.getScore()+1);
		else
			player2.setScore(player2.getScore()+1);
	}


	public void newGame() {
		board.init(); // clear the board contents
		setChanged();
		currentGameMode = currentGameMode;
		notifyObservers(GameState.RESET);
		currentPlayer = player1; // CROSS plays first
		currentState = GameState.PLAYING; // ready to play
	}
	
	public boolean saveGame() {
		if(currentState!=GameState.PLAYING) {
			Game g = new Game(playerMapper.mapToObj(player1), playerMapper.mapToObj(player2), LocalDateTime.now());
			g = gameRepository.save(g);
			resetScore();
			newGame();
			return true;
		}
		return false;
	}


	public PlayerDTO getPlayer1() {
		return player1;
	}


	public PlayerDTO getPlayer2() {
		return player2;
	}
	
	public List<GameDTO> getRanking(){
	return gameMapper.mapToDTO(gameRepository.findAll());
	}

}
