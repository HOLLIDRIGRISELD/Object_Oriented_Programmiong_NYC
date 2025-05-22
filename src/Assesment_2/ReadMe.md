# Assessment 2 - README

#### The Assessment 2 is basicly a hungman game, with login and register function, score tracking, and the ability to view leaderboard statistics. This program uses a MySQL database for user accounts and game statistics and has a GUI view using Swing. 

## Overview
#### This is a Hangman game that allows users to log in or register through a MySQL database. Users can play the game, track their scores over multiple sessions, and view leaderboard statistics of the top 10 users. The game retrieves random words from an online API but will use a default word in case the API is down. 

## Features
#### The Hangman game allows the user to register or login to a personal account so their game stats can be stored. Each time the player wins or loses a game, the information is updated in the database, enabling progress to be stored from session to session. The game has a leaderboard window that displays the top 10 players based upon the highest number of games won. Each game round, the game will automatically retrieve a new random word using an API, providing users with numerous different game sessions. 

## Technologies Used
#### This project was developed using core java technologies and external Libraries. For the graphical user interface and user interactions, Java Swing was utilized. The backend communicates with a MySQL database using JDBC  to manage user accounts and game statistics. Furthermore, there is also the use of an API for the game to award random words. The parsing of the API response is done via JSON.


## Design Details
#### The Programm follows a modular structure that clearly separates its components.Mainly  the DatabaseManager class handles all the database operations thet have to do with SQL including registration, login, and updating user stats. The GameWindow class handles the game's interface and user input.The core game logic such as checking guesses is handled by the HangmanLogic class. The LoginWindow and LeaderboardWindow classes are separate interfaces for logging in and viewing top players. The User class stores user information such as username and game stats that at the end of the gsme are stored in the database. The WordAPI class retrieves random words from an Api link in order for the game to be dynamic and not repetitive.
