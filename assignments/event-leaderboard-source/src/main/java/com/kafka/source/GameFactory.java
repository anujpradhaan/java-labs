package com.kafka.source;

import java.util.Random;

/**
 * @author : anuj.kumar
 **/
public class GameFactory {

	private static Random random = new Random();

	public static GameProgress getRandomGameProgressEvent() {
		return GameProgress
				.builder()
				.userId(getRandomUserId())
				.gameId(getRandomGameId())
				.level(getRandomLevel())
				.userRole(getRandomUserRole())
				.timeSpent(getRandomTimeSpent())
				.gameCompletionPercent(getRandomGameCompletePercentage())
				.build();
	}

	//0<userId<=100
	private static int getRandomUserId() {
		return random.nextInt(101);
	}

	private static String getRandomGameId() {
		return String.format("%s%d", "GAME", random.nextInt(11));
	}

	private static int getRandomLevel() {
		return random.nextInt(11);
	}

	private static GameProgress.UserRole getRandomUserRole() {
		GameProgress.UserRole[] userRoles = GameProgress.UserRole.values();
		return userRoles[random.nextInt(2)];
	}

	private static int getRandomTimeSpent() {
		return random.nextInt(61);
	}

	private static Double getRandomGameCompletePercentage() {
		double progress = (random.nextDouble() + 1) * 100.0;
		return progress >= 100.0 ? 100.0 : progress;
	}

}
