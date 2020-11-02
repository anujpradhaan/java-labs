package com.kafka.source;

import java.util.Random;

/**
 * @author : anuj.kumar
 **/
public class GameFactory {

	private static Random random = new Random();

	public static class Constants {
		public static int ONE_ABOVE_USER_ID_MAX = 101;
		public static int ONE_ABOVE_GAME_ID_MAX = 11;
		public static int ONE_ABOVE_LEVEL_MAX = 11;
		public static int ONE_ABOVE_TIME_SPENT_MAX = 61;
		public static double PROGRESS_MAX = 100;

	}

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
		return random.nextInt(Constants.ONE_ABOVE_GAME_ID_MAX);
	}

	private static String getRandomGameId() {
		return String.format("%s%d", "GAME", random.nextInt(Constants.ONE_ABOVE_GAME_ID_MAX));
	}

	private static int getRandomLevel() {
		return random.nextInt(Constants.ONE_ABOVE_LEVEL_MAX);
	}

	private static GameProgress.UserRole getRandomUserRole() {
		GameProgress.UserRole[] userRoles = GameProgress.UserRole.values();
		return userRoles[random.nextInt(userRoles.length)];
	}

	private static int getRandomTimeSpent() {
		return random.nextInt(Constants.ONE_ABOVE_TIME_SPENT_MAX);
	}

	private static Double getRandomGameCompletePercentage() {
		double progress = (random.nextDouble() + .1) * 100.0;
		return progress >= 100.0 ? 100.0 : progress;
	}

}
