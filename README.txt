# Anagram

Application to find anagrams.

This application was build with Maven. To install maven on a Mac Os machine:
``bash
brew install maven
```

The target folder can be cleansed with the following command:
``bash
mvn clean
```

To build an executable jar file:
``bash
mvn package
```

The package command will create a build in the target folder. To run the program, enter in the terminal:
``bash
java -jar /target/anagram-0.0.1-SNAPSHOT.jar
```

Alternatively, the program can be execute with:
``bas
java -cp target/anagram-0.0.1-SNAPSHOT.jar andreiei/anagram/Main
```
