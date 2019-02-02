package be.leerstad.tictactoe.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Score implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "X")
    private Integer scoreX;
    @Column(name = "O")
    private Integer scoreO;

    public Score() {
    }

    public Score(Integer scoreX, Integer scoreO) {
        this.scoreX = scoreX;
        this.scoreO = scoreO;
    }

    public Integer getScoreX() {
        return scoreX;
    }

    public void setScoreX(Integer scoreX) {
        this.scoreX = scoreX;
    }

    public Integer getScoreO() {
        return scoreO;
    }

    public void setScoreO(Integer scoreO) {
        this.scoreO = scoreO;
    }
}
