# Notes: Classes and Objects

#### Objects - basics

Objects are defined by classes; the type for an object is the class rather than a primitive.   
- Variables for objects are *declared* using the class name: consider a variable for a String object
`String title;`

- objects are created with _**new**_ operator; and a variable can then be assigned to reference that object:  
`title = new String("A Book");`

- or both *declared* and *initialized* with a *new* object:
`String team = new String("Red Socks");`

- the string is used so often that Java allows:
`String location = "Shelby Center";`

#### Invoking Methods

Objects (unlike primitives) can have methods
- the *nextint()* method in the Scanner class reads the input as an Int.
- invoking using the _**dot operator**_ - myScan.nextInt()
- a method my return a value:  
`int count = title.length();  
System.out.println("length is " + title.length());`
- a method may accept *parameters* (or args) as input:  
`myScan.useDelimiter(",");`  
- or have both a return value and parameters:
`char singleLetter = title.charAt(2);`

#### Aliases

Two or more references that refer to the same object are called *aliases* of each other   
`Scanner scan1 = new Scanner(System.in);
Scanner scan2 = scan1;`

#### Garbage Collection

When a object no longer has any references to it (i.e, no  variables pointing to it), it cant be accessed.  
The object is useless, and therefore is called *garbage*  
Java performs *automatic garbage collection* periodically, returning an objects memory to the system for future use.  
Languages like C and C++ require the programmer to perform garbage collection
- allocation and de-allocation of memory


#### String class
Has two forms: 1 the *new* operator and 2 the string literal  
`title = new String("intro to Computing I");
title = "Intro to Computing I";`  
Each string literal (enclosed in double quotes) represents a *string* object.  
All other reference types use the *new* operator for object creating.

String objects are *immutable* (the cannot be changed in memory once created)
The replace() method returns a whole new String object (the target String is unchanged)   
`String title2 = titile.replace("I", "1");`   
The following may appear to replace all characters 'e' with 't', but effectively does nothing.   
`title.replace("e", "t");`   
You probably meant to do this:   
`title = title replace("e", "t");`

#### String Indexes

Characters are indexed starting at 0   
You can get a particular character from a Sting using the *charAt* method and a substring of a Sting using the substring method by using the indexes of the string.

##### Random Class
The *random* class is part of the *Java.util.* package.    
It provides methods that generate pseudorandom numbers.

--------

# Notes: Classes and Objects continued

##### Math class

*Math* is part of the java.lang package
math includes the methods:
- absolute value
- square root
- exponentiation (to a power)
- trig functions
- pseudorandom number genration


















