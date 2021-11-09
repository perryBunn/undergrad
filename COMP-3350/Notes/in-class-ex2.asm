; In class example

.368
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode: dword

.data

	variableOne byte 1
	variableTwo dword 2

.code 
	main proc 

		xor ebx, ebx			; Clear register
		movzx ebx, variableOne	; mov variable one to register
		add ebx, variableTwo	; add variable teo to 'variable one'

		; or...

		xor ebx, ebx			; Clear register
		xor, eax, example		; Clear register
		mov al, variableOne		; add variable to correct size register
		mov ebx, variableTwo	; add variable to destination adn correct size register
		add ebx, eax 			; add variables together

		invoke ExitProcess, 0
	main endp
end main