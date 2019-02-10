package be.leerstad.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("be.leerstad.tictactoe")
public class TictactoeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TictactoeApplication.class, args);
	}

}

