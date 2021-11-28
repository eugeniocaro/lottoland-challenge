# Lottoland Challenge

### Description

Program to play rounds of Rock, Paper, Scissors game. Rounds are played automatically: player 1 chooses a random move and player two always plays rock. It can be played simultaneously by different users (browsers/tabs in local environment) keeping track of each game independently. It also provides a statistics page with data from all the games being played. 

* REST API built using Spring Boot.
* Front end built with thymeleaf (template engine) + jQuery (Ajax API calls) + Bootstrap (responsive UI)
* Spring dev tools used for convenience.
* No database used as per requirements.
* Unit tests written with JUnit.
* Springfox is used to generate Swagger API reference


### How to use

To run, execute "mvn spring-boot:run" from the CLI.

This will make the application accesible from http://localhost:8080.
Clicking on the "Play Round" will play a round for the current game and show the results.
Clicking on the "Restart Game" will reset the results for the current game, but they will still be considered for the global statistics.
These statistics can be accessed at http://localhost:8080/statistics

The REST API can be accessed directly using software such as Postman, SoapUI or similar.
API documentation can be checked from Swagger UI at http://localhost:8080/swagger-ui/ where it can also be tested.


### Considerations

* Front end is extremely simple as the focus was put on back end.

* Ideally service and repository layers should have been used even if data is kept in memory, but since a database was not needed and due to time constraints the creation of these two layers was skipped.

* A @ControllerAdvisor has been implemented to manage exceptions globally in a unified manner.




