# Midterm 1 Review
## Feb 21, 2020
Time: 3-3:50

6 pages - 6 questions

## cover page:
- Last, First
- Date
- ID
- Printed name

## Q1 SM/ 1's/ 2's calculations
###Five parts
	1.1
	- example: (765)_sm = converted value
	- example: (765)_1's = converted value
	- example: (765)_2's = converted value
	1.2
	- example: can digit fit in size register?????
	1.3
	- ???
	1.4/1.5
	- More number conversion with SM/1's/2's


## Q2 Subtractions
	- example: 	`num1 - num2`
				Show SM, 1's, 2's values for result

## Q3 Registers
	- example: given EDX value 7FC5Dh, what is proper value DH. Give proper value for EACH bit.
```
		6                              3               1 
		4                              2               6       8       1 byte
		+------------------------------+---------------+-------+-------+
		|                             rax                              |
		+------------------------------+---------------+-------+-------+
  		      		                   |              eax              |
  		                       	       +-------+-------+-------+-------+
  		                               				   |       ax      |
		 	                            			   +-------+-------+
		 	                            			   |  ah   |   al  |
		 	                            			   +-------+-------+
```
## Q4 Sample Code
Use MASM syntax. Questions are coming from handouts. *not said explicitly but implied*

## Q5 Offset
Know how to use offset and direct_offset to get proper value from array. Know how to use xch, movzx, and movsx.

## Q6 Loops
direct_offset, loops, add/sub, EDI/ESI.
OFFSET, TYPE, LENGTHOF, SIZEOF

