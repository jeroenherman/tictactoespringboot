package be.leerstad.tictactoe.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component
//
@Entity
@Table(name = "player")
//To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Player {
@Id
@GeneratedValue
private int id;
private String name;
private Integer Score;

public Player() {
	// TODO Auto-generated constructor stub
}


public Player(String name, Integer score) {
	super();
	this.name = name;
	Score = score;
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public Integer getScore() {
	return Score;
}
public void setScore(Integer score) {
	Score = score;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
} 


}
