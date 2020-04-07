package chuck.springframework.lab1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import chuck.springframework.lab1.domain.Team;
import chuck.springframework.lab1.repository.DatabaseTeamRepository;
import lombok.extern.java.Log;

@Log
@Service
@Profile("controller")
public class TeamService {

    @Autowired
    DatabaseTeamRepository teamRepository;

    /**
     * Retrieve the teams from the database
     *
     * @return All the teams retrieved from the database.
     */
    public List<Team> getTeams() {

        List<Team> teams = new ArrayList<>();
        teamRepository.findAll().forEach( team -> teams.add(team));

        log.info("\tRetrieved the following information from the database" + teams.toString());

        return teams;
        
    }  
    
    /** 
     * Retrieve a team by retrieving the id 
     * 
     * @param id    The primary key of the team
     * @return the Team associated with the parameter id
     * @exception NoSuchElementExcetption -- The id did not provide a team
     */
    public Team getTeam(Long id) {
        final Team team = teamRepository.findById(id).get();
        log.info("\tCharles Stockman: Team with " + id + "contains " + team.toString());

        return team;
    }


}