; Name: Perry Bunn
; Date: March 6, 2020
; Project: 3
; Description: The objective of this assignment is to create a program that will read a value from an array, and then place this value in another array with the location shifted by a certain amount. The array may be of any length from 2 to 100.
; Resources: https://stackoverflow.com/questions/4976636/whats-the-purpose-of-the-rotate-instructions-rol-rcl-on-x86, 4-2 Handout
; Revision: 0.1

; Your program must be flexible enough to produce the correct solution regardless of the array size. You have to provide documentation for your program in the form of comments.

.386 									; Archetecture
.model flat,stdcall						; Memory model and standard calling
.stack 4096								; Memory allocation
ExitProcess PROTO, dwExitCode:DWORD

.data
	; Create a BYTE array with the label ‘input’. ‘input’ should have eight elements. You should place values 1,2,3,4,5,6,7,8 in each of the elements of this array.
	input byte 1,2,3,4,5,6,7,8

	; Create a BYTE array with the label ‘output’. This array should be the same length as  ‘input’.
	output byte LENGTHOF input DUP(?)
	
	; Create a DWORD variable with the label ‘shift’. ‘shift’ s hould hold a single value. The value of ‘shift’ must be less than the length of ‘input’.
	shift dword ? ; Does this mean that it can be any int less than 8?

.code 
	; The program should then read each of the values from the array ‘input’ and place the values into the ‘output’ array but the location should be shifted by the amount in the ‘shift’ variable. If the shift would cause a value to be outside of the bounds of ‘output’, then the values should “wrap around” to the front of ‘output’.
	main proc

		; Begin code....
		xor eax, eax		; clear EAX
		xor ebx, ebx		; clear EBX
		mov ecx, shift 		; mov the Shift variable to ECX

		M1:
			neg ecx 
			mov al, input[LENGTHOF input + ecx]
			mov output[ebx], al
			neg ecx
			inc ebx
		loop M1

		mov ecx, LENGTHOF input
		sub ecx, shift
		xor edx, edx

		M2:
			mov al, input[edx]
			mov output[ebx], al
			inc ebx
			inc edx
		loop M2

		INVOKE ExitProcess, 0
	end MAINP
end main