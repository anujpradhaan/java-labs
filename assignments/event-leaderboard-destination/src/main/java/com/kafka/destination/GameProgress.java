package com.kafka.destination;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : anuj.kumar
 **/
@Getter
@Setter
@ToString
public class GameProgress {
	private int userId; //0<userId<=100
	private String gameId; //GAME1<=gameId<=GAME10
	private int level; //0<level<=10
	private UserRole userRole; //Assume it could be either ADMIN or PLAYER
	private int timeSpent; //in Mins
	private Double gameCompletionPercent;

	public enum UserRole {
		ADMIN, PLAYER
	}
}
