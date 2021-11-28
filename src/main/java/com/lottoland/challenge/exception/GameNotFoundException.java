package com.lottoland.challenge.exception;

/**
 * A Exception to be thrown when a game is not found
 */
public class GameNotFoundException extends RuntimeException {
	/**
	 * Creates a new GameNotFoundException
	 * @param id The id of the game that is not found
	 */
	public GameNotFoundException(int id) {
		super("Game with id " + id + " not found");
	}
}
