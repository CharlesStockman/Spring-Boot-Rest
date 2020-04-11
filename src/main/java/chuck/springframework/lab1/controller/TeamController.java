package chuck.springframework.lab1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import chuck.springframework.lab1.domain.Team;
import chuck.springframework.lab1.service.TeamService;
import lombok.extern.java.Log;

/**
 * A routine that accepts a HTTP Request and uses the URL to find the correct controller
 * and extract the needed data the Service Layer needs to produce the results.  When 
 * the data is returned then it will packaged into the respone and sent towards the back
 * end.
 */
@Profile("controller")
@Log
@RestController
public class TeamController {

        @Autowired 
        TeamService teamService;

        /**
         * Returns a list of all the teams.
         * 
         * @return   Returns the JSON for 0 or more teams
         */
        @GetMapping("/teams")
        public List<Team> getTeams() {

            log.info("Charles Stockman: Entered getTeams");

            List<Team> teams = teamService.getTeams();

            log.info("Charles Stockman: Exited getTeams");

            return teams;


        }

        /**
         * Returns a single team 
         * 
         * @param id        The id of the team to be returned
         * @return          Returns the JSON for the team specified by the parameter id
         * 
         * @exception       The id could be matched with a team in the database
         * 
         */
        @GetMapping("/team/{id}")
        public Team getTeam(@PathVariable final Long id) {

            log.info("Charles Stockman: entered getTeam with id = " + id);

            Team team = teamService.getTeam(id);
    
            log.info("Charles Stockman: exited getTeam");

            return team;
        }
} 