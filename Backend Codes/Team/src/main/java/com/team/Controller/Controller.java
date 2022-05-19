package com.team.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.Entity.Team;

import com.team.Service.TeamService;
import com.team.model.Player;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/teams")

public class Controller {
	
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/add")
	public ResponseEntity<?> saveTeam(@RequestBody Team teamData)
	{
		return teamService.checkValidTeam(teamData);
	}
	
//	@GetMapping("/{id}")
//	public ResponseTemplate getTeamWithPlayer(@PathVariable("id") int teamId) {
//		return service.getTeamWithPlayer(teamId);
//	}
	@GetMapping("/{teamName}")
	public Player[] findPlayerByTeamName(@PathVariable("teamName") String teamName) {
		return teamService.findPlayerByTeamName(teamName);
	}
	
	@GetMapping("/findTeamDetails/{teamName}")
	public Team findTeamDetails(@PathVariable("teamName") String teamName) {
		return teamService.findTeamDetails(teamName);
	}
}
