Feature: Application should read Score Table from input files and create a Game Board

  Scenario: Should print a Game Board from a Score Table
    Given An existing Score Table in path "<path>"
    When I run the game
    Then I should see the Game Board "<result>"

    Examples:
    | path                   | result                    |
    | sample-game-input.txt  | sample-game-output.txt    |
    | zero-game-input.txt    | zero-game-output.txt      |
    | perfect-game-input.txt | perfect-game-output.txt   |