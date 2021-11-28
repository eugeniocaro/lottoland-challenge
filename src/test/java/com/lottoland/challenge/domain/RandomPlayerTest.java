package com.lottoland.challenge.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


class RandomPlayerTest {

	private Player player;

    @BeforeEach
    public void before() {
        player = new RandomPlayer();
    }
	
	@Test
	void shouldReturnCorrectType() {
		assertTrue(player.getType() == PlayerType.RANDOM_PLAYER);
	}
	
	@RepeatedTest(100)
	void shouldPlayCorrectHand() {
		Hand hand = player.playHand();
		assertTrue(hand == Hand.PAPER || hand == Hand.ROCK || hand == Hand.SCISSORS);
	}
	

}
