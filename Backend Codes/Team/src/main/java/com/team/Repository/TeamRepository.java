package com.team.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.Entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

	

	Team findByTeamName(String teamName);

	

	
}
