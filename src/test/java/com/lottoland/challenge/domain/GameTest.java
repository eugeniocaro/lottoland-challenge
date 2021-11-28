package com.lottoland.challenge.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GameTest {

	private Game game;
	
	@BeforeEach
    public void before() {
        game = new Game(1, new RandomPlayer(), new RockPlayer());
    }
	
	@Test
	void shouldHaveNoRounds_WhenGameStarts() {
		assertTrue(game.getRounds().isEmpty());
	}
	
	@Test
	void shouldHaveCorrectPlayers_WhenGameStarts() {
		assertAll(
			() -> assertTrue(game.getPlayer1().getType() == PlayerType.RANDOM_PLAYER),
			() -> assertTrue(game.getPlayer2().getType() == PlayerType.ROCK_PLAYER)
		);
	}
	
	@Test
	void shouldHaveRounds_WhenRoundsPlayed() {
		game.playRound();
		game.playRound();
		
		assertTrue(game.getRounds().size() == 2);		
	}
	
	
	@Test
	void shouldHaveNoRounds_WhenGameRestarted() {
		game.playRound();
		game.playRound();
		game.restart();
		
		assertTrue(game.getRounds().isEmpty());		
	}

}
