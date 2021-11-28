package com.lottoland.challenge.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundTest {

	@Test	
	void shouldReturnDraw_WhenRockVsRock() {
		assertTrue(new Round(Hand.ROCK, Hand.ROCK).getOutcome() == Outcome.DRAW);
	}
	
	@Test
	void shouldReturnPlayer2Wins_WhenRockVsPaper() {
		assertTrue(new Round(Hand.ROCK, Hand.PAPER).getOutcome() == Outcome.PLAYER2_WINS);
	}
	
	@Test
	void shouldReturnPlayer1Wins_WhenRockVsScissors() {
		assertTrue(new Round(Hand.ROCK, Hand.SCISSORS).getOutcome() == Outcome.PLAYER1_WINS);
	}
	
	
	@Test	
	void shouldReturnPlayer1Wins_WhenPaperVsRock() {
		assertTrue(new Round(Hand.PAPER, Hand.ROCK).getOutcome() == Outcome.PLAYER1_WINS);
	}
	
	@Test
	void shouldReturnDraw_WhenPaperVsPaper() {
		assertTrue(new Round(Hand.PAPER, Hand.PAPER).getOutcome() == Outcome.DRAW);
	}
	
	@Test
	void shouldReturnPlayer2Wins_WhenPaperVsScissors() {
		assertTrue(new Round(Hand.PAPER, Hand.SCISSORS).getOutcome() == Outcome.PLAYER2_WINS);
	}

	@Test	
	void shouldReturnPlayer2Wins_WhenScissorsVsRock() {
		assertTrue(new Round(Hand.SCISSORS, Hand.ROCK).getOutcome() == Outcome.PLAYER2_WINS);
	}
	
	@Test
	void shouldReturnPlayer1Wins_WhenScissorsVsPaper() {
		assertTrue(new Round(Hand.SCISSORS, Hand.PAPER).getOutcome() == Outcome.PLAYER1_WINS);
	}
	
	@Test
	void shouldReturnDraw_WhenScissorsVsScissors() {
		assertTrue(new Round(Hand.SCISSORS, Hand.SCISSORS).getOutcome() == Outcome.DRAW);
	}	
	

}
