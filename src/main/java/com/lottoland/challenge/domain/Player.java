package com.lottoland.challenge.domain;

/**
 * A Player of the Rock, Paper, Scissors game 
 */
public interface Player {
	/**	 
	 * @return The PlayerType for this player. Currently can only be PlayerType.RANDOM_PLAYER or PlayerType.ROCK_PLAYER
	 */
	PlayerType getType();
	
	/**
	 * @return A Hand played by this player
	 */
	Hand playHand();
}
