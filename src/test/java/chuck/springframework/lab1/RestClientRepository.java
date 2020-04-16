package chuck.springframework.lab1;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import chuck.springframework.lab1.domain.Team;
import chuck.springframework.lab1.util.RestMessages;
import org.junit.jupiter.api.Assertions.*;

/**
 * The purpose of this class it to test the rest messages for the application.  This involves the following
 * <ol>
 * <li>Provide the Rest Message</li>
 * <li>Return the data provide from the message</li>
 * <li>Analyze the data from the message<li>
 * </ol>
 * 
 * The purpose of this class is to test and analyze the data returned form the Rest Call.  The implementation of 
 * rest call is not a concern of this so the SOLID Principles state that it would be better to remove the code to 
 * call the rest service from the another class so that you don't create a large class and force it to be harder 
 * for the developer to understand the code
 *
 */
public class RestClientRepository {
	
    
    /**
     * Verifies that the url: /teams returns two results
     */
    @Test
    public void testTeamsMessage() {
    	
    	List<Team> teams = (new RestMessages() ).getTeams();
    	assertNotNull(teams, "No Data was returned from the function call");
    	assertTrue( () -> teams.size() == 2, () -> "The list did not contain exactly two numbers");    		
    }
    
    /**
     * Verifies that the url: /teams/{id} returns two results
     */
    @Test
    public void testTeamWithIdMessage() {
    	
    	Team team = ( new RestMessages() ) .getTeam(1);
    	verifyTeam(team);

    }
    
    /**
     * Verify that the team has some data
     * 
     * @param 
     */
    private void verifyTeam(Team team) {
    	assertNotNull(team, "No Data for the team was returned from the function call");
    	assertTrue(team.getName().equals("GlobeTrooters"));
    }
    


}
