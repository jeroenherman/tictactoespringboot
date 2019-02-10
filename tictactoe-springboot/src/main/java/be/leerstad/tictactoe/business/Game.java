package be.leerstad.tictactoe.business;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//Spring
@Component
// JPA
@Entity
@Table(name ="Game")
//To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Game implements Serializable {
@Id
@GeneratedValue
private int id;
private String player1;
private String player2;
@OneToOne(cascade = CascadeType.ALL)
private Score score;
private LocalDateTime dateTime;
public Game() {
	
}


public Game(Player player1, Player player2, LocalDateTime dateTime) {
	super();
	this.player1 = player1.getName();
	this.player2 = player2.getName();
	this.dateTime = dateTime;
	this.score = new Score(player1.getScore(),player2.getScore());
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public LocalDateTime getDateTime() {
	return dateTime;
}
public void setDateTime(LocalDateTime dateTime) {
	dateTime = dateTime;
}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}


