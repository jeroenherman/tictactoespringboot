package be.leerstad.tictactoe.business.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.leerstad.tictactoe.business.Game;
import be.leerstad.tictactoe.business.Player;

public interface GameRepository extends JpaRepository<Game, Integer> {

	List<Game> findByDateTime(LocalDateTime dateTime);
	List<Game> findByPlayer1(String name);
	List<Game> findByPlayer2(String name);
}
