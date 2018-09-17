# Mortgage Matcher

## My thoughts 

I have really enjoyed working on this challenge. This exercise allowed me to demonstrate my understanding of
object oriented design and put me outside of my comfort zone as I haven't created anything like this before using
Java.

In solving this challenge and producing the code in this repository I sifted pages after pages of StackOverflow questions, 
blogs and articles. I have included below examples of few of these useful articles.

## Test Driven Development

I set out with the aim that I was going to test drive the development of this feature. However I found myself fairly confused
as most things I tried were new to me and it was more the case of complete the project and add unit test once you have
a better understanding of Java.

I have tried to test the main methods and use stubbing and mocks using Mockito. I feel that some of the tests were unnecessary, 
such as the getter methods. But I couldn't really make up my mind if it was useful or not!

## Technical Debt

I suppose every project does build up a level of technical debt usually time being the main factor. Ensuring that I kept 
an eye on progress and improvements to this feature I used the github issues tab.

You will find that I have left some open to revisit in the future. I would say namely the parts which need refactoring and 
enhancing are around the mocking and stubbing out of some classes in my unit tests.

## In brief 

The aim of this application is to take in two sources of data that contain information which correlate with the defined models `Investor` and `Loan`.
In designing this app I have considered the object oriented developments main principals as per below:


##### Encapsulation

Using private methods and variables where necessary to hide the internal workings of a class. This is more obviously mainly demonstrated
in the getter and setter methods

##### Abstraction

I have used interfaces to create a blue print to dictate the behaviors that are expected in certain classes. However implementation of those methods were specific
to the type of Object I was dealing with. Example of this is demonstrated in the DAO directory. I have a specific implementation for 
my Investor Object and Loan Object being created using a CSV. 

However, if this data source does change in the future as long as the implementation returns the type of data I expect my code shouldn't break.


##### Inheritance

Although I haven't specifically used inheritance in this project. I have identified an aread that I could've demonstrated
this principal. 

In my model directory my `FundedLoan` class could've inherited from both `Investor` and `Loan`.


#### Polymorphism

Creating overloaded constructors although I appreciate this principal is more closely associated with overloaded methods.


## Questions to clarify with client

• Is the term calculated in years or months?
    Answer: months

## Design and Performance Decisions

### Useful Articles and Reading

###### Setter methods or constructors 

• I found this stackoverflow [ARTICLE](https://stackoverflow.com/questions/19359548/setter-methods-or-constructors) interesting as I was not sure what are the advantages
or using either a setter or a constructor. 

• ```Private fields + Public accessors == Encapsulation;```

• This can be used as a way of creating json object 

```` 
// instance method
public String toString() { //overriding the toString() method 
  return ("Customer name: " + getName() 
  + ", SSN#: " + getSSN() ); // concatenating the name and SSN

}
 ````
 
###### Gson 

• [ARTICLE](http://www.vogella.com/tutorials/JavaLibrary-Gson/article.html) on using Gson for 
creating json from Java objects

###### CSV File Reader

• [ARTICLE](https://www.callicoder.com/java-read-write-csv-file-opencsv/) on using csv file reader
without the use of annotations

###### Sort List Of Objects by Field


• [ARTICLE](https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java) which helped me simplify the process of sorting object by field


###### Logging

• [ARTICLE](https://stackoverflow.com/questions/5950557/good-examples-using-java-util-logging) how to use logger in Java class

### Performance

###### Opencsv library says: 

- If memory is not a problem, read using CsvToBean.parse(), which will read all beans at once 
and is multi-threaded. If your memory is limited, use CsvToBean.iterator() and iterate over the input. Only one bean 
is read at a time, making multi-threading impossible and slowing down reading, but only one object is in memory at a
time (assuming you process and release the object for the garbage collector immediately).


## Requirements

Context
Landbay is in the peer-to-peer business. As part of this, when a borrower applies for a mortgage and Landbay provides 
an offer, Landbay needs to be able to guarantee that we have enough investment from our investors to fund the borrowers 
mortgage. In order to do this, we allow our lenders to request investments.

#### You have been given two files:

• investments.csv. In this file, you will find a number of requests that investors have made. For example, line 1 means 
"Alice wants to invest £100 for up to 12 months in the FIXED product". Each line represents a separate request that was 
placed on the Landbay platform.

• loans.csv. In this file, you will find a number of loans that Landbay would like to find funds for. Initially no loan 
has any investment against it. The amount field simply shows the amount the borrower wishes to borrow. We must match every 
penny on this amount with investor funds.


#### Please write a program that will match the investments to the loans following the business rules listed below. 

• The program should be written in Java. 

• Once the program has run, the program must output the loans that are fully funded

• the names of the people funding the loans and the amount of money they have invested in the loan.


##### Business Rules
• A valid "funded" loan must be fully funded from the investments.csv file. If a loan does not have all the funds 
necessary, then it cannot qualify.

• Partially funded loans are of no value to Landbay (we can't give our borrowers less money than they need to 
buy the property)

• Over-funded loans are also not useful (we can't give our borrowers more money than they want as this means they will 
have to eventually pay more interest).

• If someone wants to invest in TRACKER, you can't place their money into a Loan that is FIXED - and vice-versa.

• Loans should be processed in the order of their completed date (oldest to newest)

• The term of the investment must be greater than the term of the loan (i.e. the investor needs to
be willing to put money in for longer than the loan needs it for).

#### Technical requirements

Bonus points for

• The input can be hard coded

• Everything can be done in memory. There is no need to write the result to a database, a file, etc.

• This is an opportunity to demonstrate your understanding of OOP

• If it's easy to extend the matching rules (the rules you run to match an investment to a loan)

• Produce a JSON representation (using some library) of the result when you print it out

• Read in the CSV files from disk. We sometimes use [opencsv.sourceforge.net](http://opencsv.sourceforge.net/) internally but
you can use whatever means you find easiest