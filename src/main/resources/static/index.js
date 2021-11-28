$(document).ready( function() {

   var gameId = null;
  
   //Function to run when the main game page loads
   $.ajax({
      type: 'POST',
      url: '/api/game',
      success: function(game) {
        gameId = game.id;        
      },
      error: function() {
        alert('Error while starting game. Please, refresh page and try again');
      }
    });

	//Function to run when the "Play Round" button is clicked
	$('#playButton').click(function(e) {
      $.ajax({
	      type: 'POST',
	      url: '/api/game/' + gameId + '/round',
	      contentType:"application/json",
	      success: function(round) {
	        var roundsPlayed = parseInt($("#roundsPlayed").text());
			$("#roundsPlayed").text(roundsPlayed + 1);
		
	        var newRow = "<tr><td>" + round.player1Hand + "</td><td>" + round.player2Hand + "</td><td>" + round.outcome + "</td></tr>"
	        $("#gameTable > tbody").append(newRow);	
	      },
	      error: function() {
	        alert('Error while processing your request. Please, try again');
	      }
	    });
    	e.preventDefault();
	});
	
	//Function to run when the "Restart Game" button is clicked
	$('#restartButton').click(function(e) {
  		$.ajax({
	      type: 'DELETE',
	      url: '/api/game/' + gameId,
	      contentType:"application/json",
	      success: function() {
			$("#roundsPlayed").text(0);	        
	        $("#gameTable > tbody").empty();
	      },
	      error: function() {
	        alert('Error while processing your request. Please, try again');
	      }
	    });
	    e.preventDefault();
	});

});
