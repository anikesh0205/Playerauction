package com.Player.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Player.Entity.Player;
import com.Player.Repository.PlayerRepository;
import com.Player.VO.ResponseTemplateVO;
import com.Player.VO.Teams;
@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private RestTemplate template;
	
	public List<Player> findByPlayerTeamName(String teamName){
		return playerRepository.findByTeamName(teamName);
	}
	
	public ResponseEntity<?> findByPlayerId(int playerId){
		if(playerRepository.findByPlayerId(playerId)== null)
		{
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
		return ResponseEntity.ok(playerRepository.findByPlayerId(playerId));
	}
	
	public ResponseEntity<?> savePlayer(Player player)
	{
		Teams teamResponse = template.getForObject("http://TEAM-SERVICE/teams/findTeamDetails/" + player.getTeamName(),Teams.class);
		int sum=0;
		List<Player> p=playerRepository.findByTeamName(teamResponse.getTeamName());
		for(Player p1:p)
		{
			sum=sum+p1.getBudget();
		}
		
		if(sum<=teamResponse.getTeamBudget()) {
			sum=sum+player.getBudget();
		}
		if(sum<=teamResponse.getTeamBudget()) {
			playerRepository.save(player);
			return ResponseEntity.ok(player);
		}
		else
		{
			player.setTeamName("NA");
			playerRepository.save(player);
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

//	public ResponseTemplateVO getPlayerWithTeam(int playerId) {
//		ResponseTemplateVO vo=new ResponseTemplateVO();
//		Player player= repository.findByPlayerId(playerId);
//		Teams teams= restTemplate.getForObject("http://TEAM-SERVICE/teams/"+ player.getTeamName(), Teams.class);
//		
//		vo.setPlayer(player);
//		vo.setTeams(teams);
//		return vo;
//	}
}
