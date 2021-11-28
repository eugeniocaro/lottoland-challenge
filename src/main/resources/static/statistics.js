$(document).ready( function() {

  //Function to run when the statistics page loads
  $.ajax({
      type: 'GET',
      url: '/api/statistics',
      success: function(stats) {
        $("#roundsPlayed").html(stats.totalRoundsPlayed);
        $("#p1Wins").html(stats.totalPlayer1Wins);
        $("#p2Wins").html(stats.totalPlayer2Wins);
        $("#draws").html(stats.totalDraws);
      },
      error: function() {
        alert('Error while obtaining statistics. Please, refresh page and try again');
      }
    });

});

