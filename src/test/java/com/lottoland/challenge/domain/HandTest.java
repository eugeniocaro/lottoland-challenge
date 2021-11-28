package com.lottoland.challenge.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandTest {

	@Test
	void shouldReturnFalse_WhenRockBeatsRock() {
		assertFalse(Hand.ROCK.beats(Hand.ROCK));
	}
	
	@Test
	void shouldReturnFalse_WhenRockBeatsPaper() {
		assertFalse(Hand.ROCK.beats(Hand.PAPER));
	}
	
	@Test
	void shouldReturnTrue_WhenRockBeatsScissors() {
		assertTrue(Hand.ROCK.beats(Hand.SCISSORS));
	}
	
	@Test
	void shouldReturnTrue_WhenPaperBeatsRock() {
		assertTrue(Hand.PAPER.beats(Hand.ROCK));
	}
	
	@Test
	void shouldReturnFalse_WhenPaperBeatsPaper() {
		assertFalse(Hand.PAPER.beats(Hand.PAPER));
	}
	
	@Test
	void shouldReturnFalse_WhenPaperBeatsScissors() {
		assertFalse(Hand.PAPER.beats(Hand.SCISSORS));
	}
	
	@Test
	void shouldReturnFalse_WhenScissorsBeatsRock() {
		assertFalse(Hand.SCISSORS.beats(Hand.ROCK));
	}
	
	@Test
	void shouldReturnTrue_WhenScissorsBeatsPaper() {
		assertTrue(Hand.SCISSORS.beats(Hand.PAPER));
	}
	
	@Test
	void shouldReturnFalse_WhenScissorsBeatsScissors() {
		assertFalse(Hand.SCISSORS.beats(Hand.SCISSORS));
	}

}
