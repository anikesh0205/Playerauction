package com.Player.VO;

public class Teams {
	
	private int teamId;
	private int teamBudget;
	private String teamName;
	//private int playerId;
	public Teams() {
		super();
	}
	public Teams(int teamId, int teamBudget, String teamName) {
		super();
		this.teamId = teamId;
		this.teamBudget = teamBudget;
		this.teamName = teamName;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getTeamBudget() {
		return teamBudget;
	}
	public void setTeamBudget(int teamBudget) {
		this.teamBudget = teamBudget;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	

}
