package com.lottoland.challenge.domain;

/**
 * A Player of the Rock, Paper, Scissors game that plays a random hand each time 
 */
public class RandomPlayer implements Player {

	@Override
	public PlayerType getType() {		
		return PlayerType.RANDOM_PLAYER;
	}

	@Override
	public Hand playHand() {		
		return Hand.getRandom();
	}

}
