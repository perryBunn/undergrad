; Name: Perry Bunn
; Date: Feb 13, 2020
; Project: 2
; Description: The objective of this assignment is to create a program that will read a value from an array, add another value to this, and save the sum of those two values into a specific register.
; Resources: 
; Revision: 2

.386 									; Archetecture
.model flat,stdcall						; Memory model and standard calling
.stack 4096								; Memory allocation
ExitProcess PROTO, dwExitCode:DWORD

.data
	
	; Create a BYTE array with the label ‘input’
	input byte 1,2,3,4,5,6,7,8
	; Create a BYTE variable with the label ‘shift’
	shift byte 2

.code 
	main PROC
		
		; Set the values of the EAX, EBX, ECX, and EDX to 0
		xor eax, eax	; resets EAX to 0
		xor ebx, ebx	; resets EBX to 0
		xor ecx, ecx 	; resets ECX to 0
		xor edx, edx 	; resets EDX to 0

		; You then sum the value of this variable with each of the individual values in the array ‘input’
		; The program should read each of the values from the array ‘input’ one at a time and add the value ‘shift’ to it. 
		; The sum should be stored in the “correct” register

		;6                              3               1 
		;4                              2               6       8       1 byte
		;+------------------------------+---------------+-------+-------+
		;|                             rax                              |
		;+------------------------------+---------------+-------+-------+
  		;      		                    |              eax              |
  		;                       	    +-------+-------+-------+-------+
  		;                               				|       ax      |
		; 	                            				+-------+-------+
		; 	                            				|  ah   |   al  |
		; 	                            				+-------+-------+


		; The first sums should be in high position of the AX register
		mov ah, [input+1]
		add ah, shift
		; The second sums should be in low position of the AX register
		mov al, [input+2]
		add al, shift
		; The third sums should be in high position of BX register
		mov bh, [input+3]
		add bh, shift
		; The fourth sums should be in low position of BX register
		mov bl, [input+4]
		add bl, shift
		; The fifth sums should be in high position of CX register
		mov ch, [input+5]
		add ch, shift
		; The sixth sums should be in low position of CX register
		mov cl, [input+6]
		add cl, shift
		; The seventh sums should be in high position of the DX register
		mov dh, [input+7]
		add dh, shift
		; The eighth sums should be in low position of the DX register
		mov dl, [input+8]
		add dh, shift

		INVOKE ExitProcess, 0
	end MAINP
end main
