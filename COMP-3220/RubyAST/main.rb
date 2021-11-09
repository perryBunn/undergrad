load "Parser.rb"
load "Lexer.rb"
load "Token.rb"
load "AST.rb"

for arg in ARGV
	parse = Parser.new(arg)
	mytree = parse.program()
	puts mytree.toStringList()
end