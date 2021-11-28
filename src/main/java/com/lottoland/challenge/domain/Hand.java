package com.lottoland.challenge.domain;

import java.util.Random;

/**
 * Different possible hands that a player can use in a round of the Rock, Paper, Scissors game
 * This enum also includes utility methods for returning a random hand and checking if a hand beats another  
 */

public enum Hand {	
	    ROCK,
	    SCISSORS,
	    PAPER;

	    static {
	        ROCK.beats = SCISSORS;
	        SCISSORS.beats = PAPER;
	        PAPER.beats = ROCK;	        
	    }

	    private static final Hand[] VALUES = values();	    
	    private static final int SIZE = VALUES.length;	    
	    private static final Random RANDOM = new Random();

	    private Hand beats;
	    
	    /**
	     * Checks if this hand beats another hand
	     * @param hand The hand to beat
	     * @return True if this hand beats the hand passed as an argument
	     */
	    public boolean beats(Hand hand) {
	        return beats == hand;
	    }
	    
	    /** 
	     * @return A random Hand
	     */
	    public static Hand getRandom() {
	        return VALUES[RANDOM.nextInt(SIZE)];
	    }
	
}
