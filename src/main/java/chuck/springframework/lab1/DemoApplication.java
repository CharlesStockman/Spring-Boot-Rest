package chuck.springframework.lab1;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import chuck.springframework.lab1.bootstrap.DefaultData;
import chuck.springframework.lab1.domain.Team;

import org.springframework.data.repository.CrudRepository;

import lombok.extern.java.Log;

/**
 * The Start point of the Lab
 */
@SpringBootApplication
@Log
public class DemoApplication {

	@Autowired
	CrudRepository<Team, Long> crud;
	
	public static void main(final String[] args) {
		log.info("Charles Stockman: *** Starting Program ***");
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * A routine to be executed after dependency injection is completed to perform any initialization
	 * 
	 * In this case the data is being saved to the database
	 */
	@PostConstruct
	public void init() {
		
		List<Team> teams = DefaultData.getTeams();
		crud.saveAll(teams);
		log.info("Charles Stockman: Saved the following data to the database " + teams.toString());
	}

}
