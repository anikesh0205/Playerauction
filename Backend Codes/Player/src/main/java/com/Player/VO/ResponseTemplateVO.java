package com.Player.VO;

import com.Player.Entity.Player;

public class ResponseTemplateVO {
	
	private Player player;
	private Teams teams;
	
	
	public ResponseTemplateVO() {
		super();
	}
	
	public ResponseTemplateVO(Player player, Teams teams) {
		super();
		this.player = player;
		this.teams = teams;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Teams getTeams() {
		return teams;
	}
	public void setTeams(Teams teams) {
		this.teams = teams;
	}
	
	

}
