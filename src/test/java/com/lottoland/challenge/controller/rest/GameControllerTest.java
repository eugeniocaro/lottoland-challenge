package com.lottoland.challenge.controller.rest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.lottoland.challenge.domain.Game;
import com.lottoland.challenge.domain.Hand;
import com.lottoland.challenge.domain.Outcome;
import com.lottoland.challenge.domain.PlayerType;
import com.lottoland.challenge.domain.Round;
import com.lottoland.challenge.domain.Statistics;
import com.lottoland.challenge.exception.GameNotFoundException;


class GameControllerTest {

	private GameController gameController;

    @BeforeEach
    public void before() {
        gameController = new GameController();
    }
	
	@Test
	void shouldReturnNoGames_WhenApplicationStarts() {
		assertTrue(gameController.getGames().isEmpty());
	}
	
	@Test
	void shouldHaveZeroStatistics_WhenApplicationStarts() {
		Statistics stats = gameController.getStatistics();
		assertAll(
				() -> assertTrue(stats.getTotalRoundsPlayed() == 0),
				() -> assertTrue(stats.getTotalPlayer1Wins() == 0),
				() -> assertTrue(stats.getTotalPlayer2Wins() == 0),
				() -> assertTrue(stats.getTotalRoundsPlayed() == 0)
		);
	}
	
	@Test
	void getGame_shouldThrowGameNotFoundException_WhenGameNotFound() {
		assertThrows(GameNotFoundException.class, () -> gameController.getGame(1));
	}
	
	@Test
	void playRound_shouldThrowGameNotFoundException_WhenGameNotFound() {
		assertThrows(GameNotFoundException.class, () -> gameController.playRound(1));
	}
	
	@Test
	void restartGame_shouldThrowGameNotFoundException_WhenGameNotFound() {
		assertThrows(GameNotFoundException.class, () -> gameController.restartGame(1));
	}
	
	@Test
	void shouldReturnGames_WhenGamesExist() {
		gameController.newGame();
		assertTrue(gameController.getGames().size() != 0);
	}
	
	@Test
	void shouldReturnCorrectGames_WhenGamesExist() {
		gameController.newGame();
		gameController.newGame();
		assertAll(
			() -> assertTrue(gameController.getGames().size() == 2),
			() -> assertTrue(gameController.getGame(1).getId() == 1),
			() -> assertTrue(gameController.getGame(2).getId() == 2)
		);
	}
	
	@Test
	void shouldReturnCorrectGame_WhenGameExists() {	
		gameController.newGame();
		assertTrue(gameController.getGame(1).getId() == 1);
	}
	
	@Test
	void shouldHaveCorrectValues_WhenGameCreated() {	
		Game game = gameController.newGame();
		assertAll(
			() -> assertTrue(game.getPlayer1().getType() == PlayerType.RANDOM_PLAYER),
			() -> assertNotNull(game.getPlayer1().playHand()),
			() -> assertTrue(game.getPlayer2().getType() == PlayerType.ROCK_PLAYER),
			() -> assertTrue(game.getPlayer2().playHand() == Hand.ROCK)
		);
	}
	
	@Test
	void shouldReturnCorrectRound_WhenRoundPlayed() {
		Game game = gameController.newGame();
		Round roundPlayed = gameController.playRound(1);
		assertAll(			
			() -> assertTrue(game.getRounds().size() == 1),
			() -> assertTrue(game.getRounds().get(0).getPlayer1Hand() == roundPlayed.getPlayer1Hand()),
			() -> assertTrue(game.getRounds().get(0).getPlayer2Hand() == roundPlayed.getPlayer2Hand())
		);
	}
	
	@Test
	void shouldDeleteRounds_WhenGameRestarted() {
		Game game = gameController.newGame();
		gameController.playRound(1);
		gameController.playRound(1);
		gameController.restartGame(1);		
		
		assertTrue(game.getRounds().isEmpty());
	}
	
	@RepeatedTest(100)
	void shouldCalculateStatisticsCorrectly_WhenGamesPlayed() {
		Random random = new Random();
		int roundsPlayedGame1 = random.nextInt(10);
		int roundsPlayedGame2 = random.nextInt(10);
		gameController.newGame();
		gameController.newGame();
		List<Round> roundsPlayed = new ArrayList<>();
		
		for(int i=0; i<roundsPlayedGame1; i++)
			roundsPlayed.add(gameController.playRound(1));
	
		for(int i=0; i<roundsPlayedGame2; i++)
			roundsPlayed.add(gameController.playRound(2));

		Map<Outcome, Long> outcomes = roundsPlayed.stream()
				.collect(Collectors.groupingBy(Round::getOutcome, Collectors.counting()));
		
		long player1wins = Optional.ofNullable(outcomes.get(Outcome.PLAYER1_WINS)).orElse(0L);
		long player2wins = Optional.ofNullable(outcomes.get(Outcome.PLAYER2_WINS)).orElse(0L);
		long draws = Optional.ofNullable(outcomes.get(Outcome.DRAW)).orElse(0L);
		
		Statistics stats = gameController.getStatistics();
		
		assertAll(
				() -> assertTrue(roundsPlayed.size() == stats.getTotalRoundsPlayed()),
				() -> assertTrue(player1wins == stats.getTotalPlayer1Wins()),
				() -> assertTrue(player2wins == stats.getTotalPlayer2Wins()),
				() -> assertTrue(draws == stats.getTotalDraws())
		);
				
	}
	

}
