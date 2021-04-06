[![Build Status](https://travis-ci.com/lepsistemas/BowlingScoreBoard.svg?branch=master)](https://travis-ci.com/lepsistemas/BowlingScoreBoard) [![codecov](https://codecov.io/gh/lepsistemas/BowlingScoreBoard/branch/master/graph/badge.svg?token=3XTLLVS7E6)](https://codecov.io/gh/lepsistemas/BowlingScoreBoard)

# Bowling Score Board
Bowling Score Board exercise that reads a Score Table from a parametrized text file and prints the Board Game into console.

**In order to run the following tasks for this application, you will need Java 8 or greater installed.**

## Run

```shell
gradlew run --args="/path/to/file"
```

The application will show an error message if the file does not exist for given path or if you try to run it without a path at all. For example:

```shell
Invalid input file: /path/to/file.
Input file cannot be blank.
```

If you provide a valid Score Table file, you will see the results in the console:

```shell
Frame           1               2               3               4               5               6               7               8               9               10
Jeff
Pinfalls                X       7       /       9       0               X       0       8       8       /       F       6               X               X       X       8       1
Score           20              39              48              66              74              84              90              120             148             167
John
Pinfalls        3       /       6       3               X       8       1               X               X       9       0       7       /       4       4       X       9       0
Score           16              25              44              53              82              101             110             124             132             151

```

## Build

If you only want to build a jar file, use the command:

```shell
gradlew build
```

This will generate the artifact in: **build/libs/BowlingScoreBoard-0.0.1-SNAPSHOT.jar**

## Unit tests

If you only want to run the tests, use the command:

```shell
gradlew test
```
This will generate a report located in **build/reports/jacoco/test/html/index.html** where you can find the coverage of the project.

## Acceptance tests

If you want to run the acceptance tests, use the command:

```shell
gradlew acceptanceTest
```

This will run Cucumber acceptance tests for:

1. Sample game
2. Zero game
3. Perfect game

## Bonus

In order to prove the use of the good principles of SOLID, mainly Dependency Inversion, Open-Closed and Liskov Substitution, I've extended the program to accept a json file as well. Some steps to do so:

1. Created a new class that implements [Input](https://github.com/lepsistemas/BowlingScoreBoard/blob/master/src/main/java/com/jobsity/bowlingscoreboard/application/io/Input.java). in this case [JsonInput](https://github.com/lepsistemas/BowlingScoreBoard/blob/master/src/main/java/com/jobsity/bowlingscoreboard/infrastructure/file/JsonInput.java) was the concrete class.
2. Created a new class that implements [ApplicationFactory](https://github.com/lepsistemas/BowlingScoreBoard/blob/master/src/main/java/com/jobsity/bowlingscoreboard/application/ApplicationFactory.java) in order to inject the specifics dependencies for Json handling, like the JsonInput just created, as seen in [JsonFileGameFactory](https://github.com/lepsistemas/BowlingScoreBoard/blob/master/src/main/java/com/jobsity/bowlingscoreboard/application/JsonFileGameFactory.java).
3. To run the application either reading a .txt or a .json file, you could swap between TextFileGameFactory and JsonFileGameFactory in the [Main class](https://github.com/lepsistemas/BowlingScoreBoard/blob/master/src/main/java/com/jobsity/bowlingscoreboard/Application.java).
4. Since having to recompile the application to run with different file extension doesn't make sense, I've created a [InputFileApplicationFactory](https://github.com/lepsistemas/BowlingScoreBoard/blob/master/src/main/java/com/jobsity/bowlingscoreboard/application/InputFileApplicationFactory.java) that will inject one of both factories depending on the file extension passed as parameter in the command line.

After this change, you can run the application with .txt extension:

```shell
gradlew run --args="path/to/text/file.txt"
```

Or with .json format:

```shell
gradlew run --args="path/to/text/file.json"
```
