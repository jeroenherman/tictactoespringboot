package be.leerstad.tictactoe.business;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Autowired
@OneToOne
private Player player1;
@Autowired
@OneToOne
private Player player2;
private LocalDateTime dateTime;
public Game() {
	
}


public Game(Player player1, Player player2, LocalDateTime dateTime) {
	super();
	this.player1 = player1;
	this.player2 = player2;
	dateTime = dateTime;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Player getPlayer1() {
	return player1;
}
public void setPlayer1(Player player1) {
	this.player1 = player1;
}
public Player getPlayer2() {
	return player2;
}
public void setPlayer2(Player player2) {
	this.player2 = player2;
}
public LocalDateTime getDateTime() {
	return dateTime;
}
public void setDateTime(LocalDateTime dateTime) {
	dateTime = dateTime;
}


@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Game id=");
	builder.append(id);
	builder.append(" player1=");
	builder.append(player1);
	builder.append(" player2=");
	builder.append(player2);
	builder.append(" DateTime=");
	builder.append(dateTime);
	return builder.toString();
}






}
