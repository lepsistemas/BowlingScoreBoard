# Bowling Score Board
Bowling Score Board exercise that reads a Score Table from a parametrized text file and prints the Board Game into console.

**In order to run the following tasks for this application, you will need Java 8 or greater installed.**

## Run

```shell
./gradlew run --args="/path/to/file"
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
./gradlew build
```

This will generate the artifact in: **build/libs/BowlingScoreBoard-0.0.1-SNAPSHOT.jar**

## Tests

If you only want to run the tests, use the command:

```shell
./gradlew test
```
