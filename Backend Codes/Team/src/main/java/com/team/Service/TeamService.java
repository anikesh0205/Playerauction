package com.team.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.team.Entity.Team;

import com.team.Repository.TeamRepository;
import com.team.model.Player;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private RestTemplate template;
	
	public ResponseEntity<?> checkValidTeam(Team teamData){
		if(teamRepository.findByTeamName(teamData.getTeamName())!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
		teamRepository.save(teamData);
		return ResponseEntity.ok(teamData);
	}
	
	public Player[] findPlayerByTeamName(String teamName) {
		ResponseEntity<Player[]> response= 
				template.getForEntity(
						"http://PLAYER-SERVICE/find/" +teamName,
						Player[].class);
		
		Player[] p=response.getBody();
		return p;
	}
	
	public Team findTeamDetails(String teamName)
	{
		return teamRepository.findByTeamName(teamName);
	}


//	public Team findByTeamName(String teamName) {
//		// TODO Auto-generated method stub
//		return teamRepository.findByTeamName(teamName);
//	}
	


}
