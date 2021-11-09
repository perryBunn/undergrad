# Notes: Data and expressions

#### Strings maybe?
did not take notes.
#### Escape Sequences
For example to print a quotation mark "  use a '\' 
this is called and escape sequence
some other escape sequences are....

| Escape Sequence | Meaning |
|-----------------|---------|
|`\t`|tab|
|`\n`|Newline|
|`\r`|carriage return|
|`\"`| print double quote|
|`\'`| print single quote|
|`\\`| print backslash|

In Windows `\r\n` are used together by *println* and *enter* to move to the next line; in Mac OS, Linux, Unix, only `\n`

see: _**EsacpeSeq.java**_


#### Primitive Data
8 types of *"variables"* or Primitive data types in java
- integer
	- byte
	- short
	- *int*				`int age = 19;`
	- long
- Floating Point
	- float
	- *double*			`double avg = 94.8';`
- character
	- char				`char letter = 'A';`
- Boolean
	- boolean			`boolean isCold = false;`

see: _**VariablesExample.java**_
 

#### Expressions
arithmetic expressions compute numeric results making use of the operators:

| Operations | Symbol |
|----------|----------|
| Addition | `+` |
| Subtraction | `-` |
| Multiplication|`*`|
| Division |`/`|
| Remainder (Modulus) |`%`|

the *increment* operator `++` adds one to the operand
the *decrement* operator `--` subtracts one to the operand

`count++;` is equal to `count = count + 1;`    
`count--;` is equal to `count = count - 1;`

these can also be used before the variable name.

_______________________________________________

# Jan 25, 2017
### Notes Data and Expressions continued:

#### Assignment Operators

|Operator| Example| Equivalent to|
|--------|--------|--------------|
|+=|x += y|x = x + y|
|-=|x -= y|x = x - y|
|*=|x *= y|x = x * y|
|/=|x /= y|x = x / y|
|%=|x %= y|x = x % y|

#### Relational Operators

|Operator|Meaning|
|--------|-------|
|==| Equal|
|!=| Not equal|
|<| Less than|
|<=| Les than or equal|
|>| Greater than|
|>=| Greater than or equal


#### Interactive using Standard Input

Scanner class in Java class library provides methods for reading input
it is imported into a program by placing:
>`import java.util.Scanner;`

a Scanner object can be set up to read input from various sources including the keyboard input which is represented by the `System.in` object.   

`Scanner scan = new Scanner(System.in);` creates an Scanner Object that reads input from the keyboard.

for example *nextInt* retrieves an integer value:   
>`int numberItems = scan.nextint();`

#### Data Conversion

Java handles data conversion in three ways
- Assignment conversion
- promotion
- casting

##### Assignment Conversion

a value of one type is assigned to a variable of another:
- variable *money* is type **double**. Variable *dollars* is type **int**.    
The assignment below converts the value in *dollars* to a **double** as it assigns to *money*  `money = dollars`

the type and value of *dollars did not change

Java only allows the "promoting" of data types so you do not lose information.

##### Promotion

happens when operators in expressions convert their operands
- *sum* is a **double**   
*count* is a **int**    
The value of *count* is converted (or promoted) to a **double** value in the expression on the right before division is done:   
`result = sum / count;`

##### Casting

Allows narrowing conversions and widening conversion *be careful*
To cast the type (in parentheses) is places in front of the value being converted
- if *total* and *count* are integers, the value of *total* could be converted to a **double** with the cast to avoid integer division:   
`result = (double) total / count;`

#### Constants

a *constant* is similar to a variable, but is placed a the class level (above the method), written in all caps with underscores and its initial value cannot be changed

the static modifier allows it to be shared among the methods in the class; the *final* modifier prevents the initial value from changing.
>`static final int MIN_HEIGHT = 69;`

the compiler will send an error if you try to change the value of a constant

#### Reading Input

The Scanner class is part of the Java .util package in the Java class library, and bust be imported into a program to be used.   
the *nextLine* method reads all of the input until the end of the line is found.  
the *nest* method reads the next token; by default tokens are delimited by spaces or end of the line.

#### Input Tokens

Unless specified otherwise, *white space* is used to separate the elements (*tokens*) of the input.   
White space includes spaces, tabs, and new lines









