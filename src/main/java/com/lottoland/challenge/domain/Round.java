package com.lottoland.challenge.domain;

/**
 * A round played in a game of Rock, Paper, Scissors 
 */
public class Round {
	private final Hand player1Hand;
	private final Hand player2Hand;
	
	/**
	 * Creates a new round
	 * @param player1Hand The hand played by player 1
	 * @param player2Hand The hand played by player 2
	 */
	public Round(Hand player1Hand, Hand player2Hand) {
		super();
		this.player1Hand = player1Hand;
		this.player2Hand = player2Hand;
	}

	/**
	 * @return The hand played by player 1
	 */
	public Hand getPlayer1Hand() {
		return player1Hand;
	}	

	/**
	 * @return The hand played by player 2
	 */
	public Hand getPlayer2Hand() {
		return player2Hand;
	}	
	
	/** 
	 * @return The outcome of the round, which can be PLAYER1_WINS, PLAYER2_WINS or DRAW 
	 */
	public Outcome getOutcome() {
		if(player1Hand.beats(player2Hand)) return Outcome.PLAYER1_WINS;
		else if(player2Hand.beats(player1Hand)) return Outcome.PLAYER2_WINS;
		return Outcome.DRAW;
	}
}
