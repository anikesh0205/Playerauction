package com.Player.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Player.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	Player findByPlayerId(int playerId);

	List<Player> findByTeamName(String teamName);

	//Player findByPlayerId(int playerId);

}
