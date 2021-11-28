package com.lottoland.challenge.domain;

/**
 * Class used as a DTO when statistics are requested from the REST API 
 */

public class Statistics {
	private final int totalRoundsPlayed;
	private final int totalPlayer1Wins;
	private final int totalPlayer2Wins;
	private final int totalDraws;

	/**
	 * Creates a new Statistics object
	 * @param totalRoundsPlayed The total number of rounds played in all the current games
	 * @param totalPlayer1Wins The total number of rounds won by player 1 in all the current games
	 * @param totalPlayer2Wins The total number of rounds won by player 2 in all the current games
	 * @param totalDraws The total number of rounds that ended in a draw in all the current games
	 */
	public Statistics(int totalRoundsPlayed, int totalPlayer1Wins, int totalPlayer2Wins, int totalDraws) {
		super();
		this.totalRoundsPlayed = totalRoundsPlayed;
		this.totalPlayer1Wins = totalPlayer1Wins;
		this.totalPlayer2Wins = totalPlayer2Wins;
		this.totalDraws = totalDraws;
	}

	/**
	 * @return The total number of rounds played in all the current games
	 */
	public int getTotalRoundsPlayed() {
		return totalRoundsPlayed;
	}

	/**
	 * @return The total number of rounds won by player 1 in all the current games
	 */
	public int getTotalPlayer1Wins() {
		return totalPlayer1Wins;
	}

	/**
	 * @return The total number of rounds won by player 2 in all the current games
	 */
	public int getTotalPlayer2Wins() {
		return totalPlayer2Wins;
	}

	/**
	 * @return The total number of rounds that ended in a draw in all the current games
	 */
	public int getTotalDraws() {
		return totalDraws;
	}
	
}
