[![Build Status](https://travis-ci.org/CodeAllTheThingsTV/java-console-starter.svg?branch=develop)](https://travis-ci.org/CodeAllTheThingsTV/java-console-starter)
[![Coverage Status](https://coveralls.io/repos/github/CodeAllTheThingsTV/java-console-starter/badge.svg?branch=develop)](https://coveralls.io/github/CodeAllTheThingsTV/java-console-starter?branch=develop)
[![License](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)]()


# java-console-starter
A simple console starter project for Java

## Maven
Release artifact
```xml
<dependency>
    <groupId>io.github.codeallthethingstv</groupId>
    <artifactId>java-console-starter</artifactId>
    <version>NOT YET RELEASED</version>
</dependency>
```
Snapshot artifact
```xml
<dependency>
    <groupId>io.github.codeallthethingstv</groupId>
    <artifactId>java-console-starter</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```

## Reading from the Console should be easy..
.. but sadly its not. I consider reading [this article](https://www.mkyong.com/java/how-to-read-input-from-console-java/) by mkyong about this topic.

There are various ways reading from the console in Java, but none of them are suited for beginners. So instead of exploring the world of programming at your own pace, you need to deal with those strange, yet unknown things like `new BufferedReader(new InputStreamReader(System.in))` or `new Scanner(System.in);` or desperatley failing at using ` System.console().readLine()` for the first time, instead of concentrating on your own first lines of code.

After picking the right way to read the `String` the user has typed into the console, you need to deal with a bunch of `try` statements, catching everything you can while trying to convert the users input into numbers like `int`, `long` or `double`.

All this should be a side issue while taking your first steps in programming, so I wrote this little wrapper/helper for you:

## Usecases
### Reading text from console:
```java
  Console console = new Console();
  String userInput = console.read();
```
which will output to the user only a cursor:
```
|
```
### Reading text from console, providing some information for the user:
```java
  Console console = new Console();
  String name = console.read("Please enter your name: ");
```
which will output to the user:
```
Please enter your name:
|
```
### Reading numbers from console (Integer):
```java
  Console console = new Console();
  Integer age = console.readIntegerOrNull("Please enter your age: ");
```
which will output to the user:
```
Please enter your age:
|
```
and will return the converted age of type `Integer` or `null` if the conversion fails for whatever reason.

### Reading numbers from console (Long):
```java
  Console console = new Console();
  Long age = console.readLongOrNull("Please enter your age: ");
```
which will output to the user:
```
Please enter your age:
|
```
and will return the converted age of type `Long` or `null` if the conversion fails for whatever reason.

### Reading numbers from console (Double):
```java
  Console console = new Console();
  Double weight = console.readDoubleOrNull("Please enter your weight: ");
```
which will output to the user:
```
Please enter your weight:
|
```
and will return the converted age of type `Double` or `null` if the conversion fails for whatever reason.

### Simply writing to the console:
```java
  Console console = new Console();
  String programName = "My First Program";
  console.write("Hey there, welcome to my Program: %s", programName);
```
which will output to the user:
```
Hey there, welcome to my Program: My First Program
```

