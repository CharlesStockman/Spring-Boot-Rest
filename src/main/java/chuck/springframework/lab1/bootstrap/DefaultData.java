package chuck.springframework.lab1.bootstrap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import chuck.springframework.lab1.domain.Player;
import chuck.springframework.lab1.domain.Team;

/**
 * Contains Data to be used to develop and unit test the application
 */
 public class DefaultData {

     /**
      * Return the default players
      *
      * @return A list of <code>Player</code>
      */
    public static Set<Player> getPlayers() {
        Set<Player> players = new HashSet<>();

	    Player player1 = Player.builder().name("Big Easy").position("Showman").build();
        players.add(player1);
        
	    Player player2 = Player.builder().name("Buckets").position("Guard").build();
        players.add(player2);
        
        Player player3 = Player.builder().name("Dizzy").position("Guard").build();
        players.add(player3);

        return players;
    }

    /**
     * Data for Team one
     * 
     * @param A team with all initialized data
     * @return <code>Team</code>
     */
    private static Team getTeam1Data(Set<Player> players ) {
        Team team = Team.builder().location("Harlem").name("GlobeTrooters").players(players).build();
        return team;
    }

    /***
     * Data from Team two
     * 
     * @param A team with initialized data
     * @return <code>Team</code>
     */
    private static Team getTeam2Data(Set<Player> players) {
        Team team2 = Team.builder().location("Washington").name("Generals").players(null).build();
        return team2;    
    }

    /**
     * Return the default teams
     * 
     * @return A list of teams with all the players on the team.
     */
    public static List<Team> getTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(getTeam1Data(getPlayers()));
        teams.add(getTeam2Data(null));

        return teams;
    }
 }