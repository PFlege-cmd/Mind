# Mind
File repository of Patrick.
The following information is available for the assignments (Copied from academy.sogyo.nl)!

Leap year:
A program that has a year as input and then checks if this year is a leap year.
A year is a leap year when:
  every fourth year is a leap year.
  a new century is only a leap year when it is dividable by 400.

Lists:
Here, lists and arrays are manipulated with operations as outlined below:

  -Creates a program that will initialize an array with 10 random numbers between 0 and 100. Display the list.
  -The highest. Expands program so that the highest value in your array will be displayed.
  -The lowest two. Expands program so that the result of adding the two lowest values in the array will be displayed.
  -Filter. Expands program to display all values that are even.
  -Split. Expands program to generate four list. In the first list contains all numbers that can be divided by 2, the second numbers tha can be divided by 3, the third list contains numbers that can be divided by 5, and the final list contains the remaining numbers.
  -Sort. Expands program so that it will display the result of sorting the numbers in the array in ascending order. Uses the BubbleSort algorithm.
  
  
Hangman:
Hangman is a guessing game in which the user guesses a word randomly picked from a list of words. The user guesses a letter. If it’s contained in the word, the corresponding letters in the word are shown. If it’s not in the word, the user loses a guess. After 10 wrong guesses, the computer wins. Contains:

  -Conditional statements
  -Input and ouput
  -Loops (Iteration statements)
  -State; remembering values
  -Randomisation based on a given collection
  -Converting non-numeric logic to code
  
  
  
Quote of the day:
A short program that, when started, prints a quote of the day on the screen.
A quote is printed between quotation marks, starts with a capital letter and ends with a full stop.
It selects the quote by taking the day of the year and take the day as the index of the list. January 2nd is the second day of the year, so the quote should be "Eureka!" -- Archimedes, while January 3th gives the quote from Erasmus. If the list runs out of quotes, start again on the first quote. This means that January 1th, January 7th and January 13th all give the Galileo quote.


Fractional calculation:
Some numbers cannot be represented accurately in the decimal system, think of 1/3rd. A class "Fraction" is made that is constructed with a numerator and a denominator. The program should be able to get the values of the numerator and the denominator, but should not be able to modify them. It implements following functions:

double toDecimalNotation() -> 1/3 should return 0.33333
string toString() -> 1/3 should return “1/3”
Fraction add(int number) -> 1/3 + 1 should become 4/3
Fraction add(Fraction fraction) -> 1/3 + 1/6 should become 1/2
Fraction subtract(int number) -> 4/3 - 1 should become 1/3
Fraction subtract(Fraction fraction) -> 1/2 - 1/6 should become 1/3
Fraction multiply(int number) -> 3/4 * 2 should become 3/2
Fraction multiply(Fraction fraction) -> 3/4 * 2/5 should become 3/10
Fraction divide(int number) -> 3/2 / 2 should become 3/4
Fraction divide(Fraction fraction) -> 3/10 / 2/5 should become 3/4

Decision tree:
A decision tree is a graph consisting of nodes and edges, where each node is a question and each edge is a decision. The goal of this exercise is to create a program that has a decision tree as input from a file and executes this for the user.

File Format
The file is a UTF-8 text file that has an edge or a node on each line. A node consists of a name and a question. An edge consists of an origin node, destination node and an answer. Node and edge are mixed throughout the file.

This programme can read in a file in the above mentioned format. It also translates the lines to node and edge objects. The nodes are built in a way that they represent the problem at hand, the decision tree.
The decision tree is executed by asking the questions from the decision tree and to navigating through the tree until an answer is found. The starting question is the node which is not a destination for any edge and an answer is a node where no edges originate from.

Exceptional Users:

We are creating a user management system. We need to be able to add users to our database. A user has a username and a password. The password should not be easy to guess, so it should consist of one lowercase character, one uppercase character and one number.
While the programm can handle exceptions, a good design should prevent that. Thus, if the user enters invalid input, it will
simply query him/her to handle valid input.
