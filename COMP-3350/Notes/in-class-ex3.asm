.368
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode: dword

.data
	array dword 1,2,3

.code
	main proc
		
		xor eax, eax ; clear EAX

		mov eax, array 		; Move array to EAX 	-> 1,2,3
		xchg eax, [array+4] ; 				  	 	-> 2,1,3
		xchg eax, [array+8]	; 						-> 3,1,2
		mov array, eax 		; Array is now eaqual to   3,1,2

		ExitProcess, 0
	main endp	
end