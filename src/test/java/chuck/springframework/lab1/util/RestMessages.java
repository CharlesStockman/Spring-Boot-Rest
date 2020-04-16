package chuck.springframework.lab1.util;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import chuck.springframework.lab1.domain.Team;

/**
 * Call the Rest Message and provide the calling 
 * 
 */
public class RestMessages {
	
    private RestTemplate restTemplate;

    /**
     * Creates an instance of Client
     */
    public RestMessages() {
        restTemplate = new RestTemplate();
    }
	
    /**
     * Create a Request Entity 
     * 
     * @param mediaType			The file format
     * @return 					A representation of an HTTP Request
     *
     */
    private  HttpEntity<?> buildResponseEntity(MediaType mediaType) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(mediaType);
    	HttpEntity<?> responseEntity = new HttpEntity<String>(headers);
    	
    	return responseEntity;
    }


    public List<Team> getTeams() {
        
        String url = "http://localhost:8080/teams";
        
        ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.GET, buildResponseEntity(MediaType.APPLICATION_JSON), List.class );

        System.out.println("=============================");
        System.out.println(responseEntity.getBody().toString());
        System.out.println("=============================");
        
        List<Team> teams = responseEntity.getBody();
        
        return teams;
    }
    
	public Team getTeam(int teamId) {
		String url = "http://localhost:8080/teams/1";
		
        ResponseEntity<Team> responseEntity = restTemplate.exchange(url, HttpMethod.GET, buildResponseEntity(MediaType.APPLICATION_JSON), Team.class );
        
        System.out.println("=============================");
        System.out.println(responseEntity.getBody().toString());
        System.out.println("=============================");

		Team team = responseEntity.getBody();
		
		return team;
		
		
	}	

}
