package com.lottoland.challenge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A Rock, Paper, Scissors game 
 */
public class Game {

	private final int id;
	private final Player player1;    
    private final Player player2;    
    private List<Round> rounds;

    /**
     * Creates a game
     * @param id The unique id for this game
     * @param player1 The player 1
     * @param player2 The player 2
     */
  
    public Game(int id, Player player1, Player player2) {
		super();
		this.id = id;
		this.player1 = player1;
		this.player2 = player2;
		this.rounds = new ArrayList<>();
	}
    
    /** 
     * @return The game's unique id
     */
    public int getId() {
        return id;
    }


    /** 
     * @return The game's player 1
     */
    public Player getPlayer1() {
        return player1;
    }


    /** 
     * @return The game's player 2
     */
    public Player getPlayer2() {
        return player2;
    }

    
    /** 
     * @return The rounds played in this game
     */
    public List<Round> getRounds() {
        return rounds;
    }
    


    /**
     * Plays a round for this game, using the game's players moves
     * @return The round played
     */
    
	public Round playRound() {
        Round round = new Round(player1.playHand(), player2.playHand());
        rounds.add(round);
        return round;
    }

    /**
     * Restarts the game, deleting all the rounds played
     */
    public void restart() {
        rounds.clear();
    }

   

}
