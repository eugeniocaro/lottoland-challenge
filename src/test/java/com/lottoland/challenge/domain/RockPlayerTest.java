package com.lottoland.challenge.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


class RockPlayerTest {

	private Player player;

    @BeforeEach
    public void before() {
        player = new RockPlayer();
    }
	
	@Test
	void shouldReturnCorrectType() {
		assertTrue(player.getType() == PlayerType.ROCK_PLAYER);
	}
	
	@RepeatedTest(100)
	void shouldPlayCorrectHand() {
		Hand hand = player.playHand();
		assertTrue(hand == Hand.ROCK);
	}
	

}
