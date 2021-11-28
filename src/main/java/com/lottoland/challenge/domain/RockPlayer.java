package com.lottoland.challenge.domain;

/**
 * A Player of the Rock, Paper, Scissors game that always plays ROCK 
 */
public class RockPlayer implements Player {

	@Override
	public PlayerType getType() {		
		return PlayerType.ROCK_PLAYER;
	}

	@Override
	public Hand playHand() {		
		return Hand.ROCK;
	}

}
