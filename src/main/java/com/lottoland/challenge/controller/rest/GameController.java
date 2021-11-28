package com.lottoland.challenge.controller.rest;


import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lottoland.challenge.domain.Game;
import com.lottoland.challenge.domain.Outcome;
import com.lottoland.challenge.domain.RandomPlayer;
import com.lottoland.challenge.domain.RockPlayer;
import com.lottoland.challenge.domain.Round;
import com.lottoland.challenge.domain.Statistics;
import com.lottoland.challenge.exception.GameNotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * Controller that implements the game REST API
 * It supports all operations needed to play games of Rock, Paper, Scissors and also provides global statistics
 * for all the games being played.
 * 
 * Games can be played simultaneously by different users thanks to a ConcurrentHashMap
 * 
 * To ensure thread-safety AtomicIntegers are used for unique gameId generation and statistics calculation
 * 
 */

@RestController
@RequestMapping("/api")

public class GameController {
    
    private final Map<Integer, Game> games = new ConcurrentHashMap<>();    
    private final AtomicInteger gameId = new AtomicInteger();
    
    private final AtomicInteger totalRoundsPlayed = new AtomicInteger();
    private final AtomicInteger totalPlayer1Wins = new AtomicInteger();
    private final AtomicInteger totalPlayer2Wins = new AtomicInteger();
    private final AtomicInteger totalDraws = new AtomicInteger();

    /** Gets all the current games being played
     * @return A Collection with all the games
     */
    @GetMapping("/games")
    @ApiOperation("Get all the current games being played")
    public Collection<Game> getGames() {
        return games.values();
    }
   
    /**
     * Gets a game 
     * @param id The id of the game to get
     * @return The game with the given id
     * @throws GameNotFoundException if a game with the given id does not exist
     */   
    @GetMapping(value = "/game/{id}")
    @ApiOperation("Get the game with id {id}")
    public Game getGame(@ApiParam("Game id") @PathVariable(value = "id") int id) {
        return Optional.ofNullable(games.get(id)).orElseThrow(() -> new GameNotFoundException(id));
    }
   

    /**
     * Starts a new game
     * @return The new game
     */
    @PostMapping("/game")
    @ApiOperation("Start a new game")
    public Game newGame() {
        Game game = new Game(gameId.incrementAndGet(), new RandomPlayer(), new RockPlayer());
        games.put(game.getId(), game);
        return game;
    }


    /**
     * Plays a round for a given game. Global statistics are updated with the round played.
     * @param id The id of the game for which a round will be played
     * @return The round played
     * @throws GameNotFoundException if a game with the given id does not exist
     */
    @PostMapping(value = "/game/{id}/round")
    @ApiOperation("Play a round in game with id {id}")
    public Round playRound(@ApiParam("Game id") @PathVariable(value = "id") int id) {
    	Round round = getGame(id).playRound();
    	updateStatistics(round);
    	return round;
    }

    
    private void updateStatistics(Round round) {
    	totalRoundsPlayed.incrementAndGet();
		if(round.getOutcome() == Outcome.PLAYER1_WINS) totalPlayer1Wins.incrementAndGet();
		else if(round.getOutcome() == Outcome.PLAYER2_WINS) totalPlayer2Wins.incrementAndGet();
		else totalDraws.incrementAndGet();		
	}


    /**
     * Restarts a game, deleting all of its rounds played
     * @param id The id of the game to restart
     * @throws GameNotFoundException if a game with the given id does not exist
     */
	@DeleteMapping(value = "/game/{id}")
	@ApiOperation("Restarts the game with id {id}, deleting all of its rounds played")
    public void restartGame(@ApiParam("Game id") @PathVariable(value = "id") int id) {    	
    	getGame(id).restart();        
    }
	

	/**
	 * Returns global statistics of all the games played so far
	 * @return The global statistics
	 */
	@GetMapping(value = "/statistics")
	@ApiOperation("Return global statistics of all the games played so far")
	public Statistics getStatistics() {
	        return new Statistics(totalRoundsPlayed.get(), totalPlayer1Wins.get(), totalPlayer2Wins.get(), totalDraws.get());
	}

}
