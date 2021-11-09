; In class example

.368
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode: dword

.code
	main proc

		xor eax, eax ; Reset EAX to 0

		; For HEX numbers you must put a leading '0' and tailing 'h'
		mov eax, 0F00Dh ; F00D 
		add eax, 0BEEFh ; F00D + BEEF => 1AEFC

		invoke ExitProcess, 0
	main endp
end main