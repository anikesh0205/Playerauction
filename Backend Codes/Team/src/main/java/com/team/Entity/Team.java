package com.team.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teamId;
	private int teamBudget;
	private String teamName;
	public Team() {
		super();
	}
	public Team(int teamId, int teamBudget, String teamName) {
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
