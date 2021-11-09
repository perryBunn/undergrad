# https://www.cs.rochester.edu/~brown/173/readings/05_grammars.txt
#
#  "TINY" Grammar
#
# PGM        -->   STMT+
# STMT       -->   ASSIGN   |   "print"  EXP
# ASSIGN     -->   ID  "="  EXP
# EXP        -->   TERM   ETAIL
# ETAIL      -->   "+" TERM   ETAIL  | "-" TERM   ETAIL | EPSILON
# TERM       -->   FACTOR  TTAIL
# TTAIL      -->   "*" FACTOR TTAIL  | "/" FACTOR TTAIL | EPSILON
# FACTOR     -->   "(" EXP ")" | INT | ID
# ID         -->   ALPHA+
# ALPHA      -->   a  |  b  | … | z  or
#                  A  |  B  | … | Z
# INT        -->   DIGIT+
# DIGIT      -->   0  |  1  | …  |  9
# WHITESPACE -->   Ruby Whitespace

#
#  Parser Class
#
load "Token.rb"
load "Lexer.rb"
class Parser < Scanner

  @@error_total = 0
  #for testing
  @@file = ""
	def initialize(filename)
    	super(filename)
      @@file = filename
    	consume()
  end
   	
	def consume()
      	@lookahead = nextToken()
      	while(@lookahead.type == Token::WS)
        	@lookahead = nextToken()
      	end
  end
  	
	def match(dtype)
    if (@lookahead.type != dtype)
     	puts "Expected #{dtype} found #{@lookahead.text}"
      @@error_total = @@error_total + 1
    end
    consume()
  end
   
  # PGM        -->   STMT+
	def program()
    # for testing
    outFile = "%s.out" % [@@file]
    $stdout = File.new(outFile, 'w')
    $stdout.sync = true

    while( @lookahead.type != Token::EOF)
		  statement()  
    end
    puts "There were " + @@error_total.to_s + " parse errors found."
  end

  # STMT       -->   ASSIGN   |   "print"  EXP
	def statement()
    puts "Entering STMT Rule"
		if (@lookahead.type == Token::PRINT)
			puts "Found PRINT Token: #{@lookahead.text}"
			match(Token::PRINT)
			exp()
		else
			assign()
		end
		puts "Exiting STMT Rule"
	end

  # ASSIGN     -->   ID  "="  EXP
  def assign()
    puts "Entering ASSGN Rule"
    id()
    if (@lookahead.type == Token::ASSGN)
      puts "Found ASSGN Token: #{@lookahead.text}"
      # consume()
    end
    match(Token::ASSGN)
    exp()
    puts "Exiting ASSGN Rule"
  end

  # EXP        -->   TERM   ETAIL
  def exp()
    puts "Entering EXP Rule"
    term()
    etail()
    puts "Exiting EXP Rule"
  end

  # ETAIL      -->   "+" TERM   ETAIL  | "-" TERM   ETAIL | EPSILON
  def etail()
    puts "Entering ETAIL Rule"
    if (@lookahead.type == Token::ADDOP)
      puts "Found ADDOP Token: #{@lookahead.text}"
      consume()
      term()
      etail()
    elsif (@lookahead.type == Token::SUBOP)
      puts "Found SUBOP Token: #{@lookahead.text}"
      consume()
      term()
      etail()
    else
      puts "Did not find ADDOP or SUBOP Token, choosing EPSILON production"
    end
    puts "Exiting ETAIL Rule"
  end

  # TERM       -->   FACTOR  TTAIL
  def term()
    puts "Entering TERM Rule"
    factor()
    ttail()
    puts "Exiting TERM Rule"
  end

  # TTAIL      -->   "*" FACTOR TTAIL  | "/" FACTOR TTAIL | EPSILON
  def ttail()
    puts "Entering TTAIL Rule"
    if (@lookahead.type == Token::MULTOP)
      puts "Found MULTOP Token: #{@lookahead.text}"
      consume()
      factor()
      ttail()
    elsif (@lookahead.type == Token::DIVOP)
      puts "Found DIVOP Token: #{@lookahead.text}"
      consume()
      factor()
      ttail()
    else
      puts "Did not find MULTOP or DIVOP Token, choosing EPSILON production"
    end
    puts "Exiting TTAIL Rule"
  end

  # FACTOR     -->   "(" EXP ")" | INT | ID
  def factor()
    puts "Entering FACTOR Rule"
    if (@lookahead.type == Token::ID)
      puts "Found ID Token: #{@lookahead.text}"
      consume()
    elsif (@lookahead.type == Token::INT)
      puts "Found INT Token: #{@lookahead.text}"
      consume()
    elsif (@lookahead.type == Token::LPAREN)
      puts "Found LPAREN Token: #{@lookahead.text}"
      consume()
      exp()
      if (@lookahead.type == Token::RPAREN)
        puts "Found RPAREN Token: #{@lookahead.text}"
        consume()
      else
        puts "Expected to see ). Instead found #{@lookahead.type}"
        consume()
      end
    else
      puts "Expected ( or INT or ID found #{@lookahead.type}"
      @@error_total = @@error_total + 1
      consume()
    end
    puts "Exiting FACTOR Rule"
  end

  # ID         -->   ALPHA+
  def id()
    #puts "Entering ID Rule"
    if (@lookahead.type == Token::ID)
      puts "Found ID Token: #{@lookahead.text}"
    end
    match(Token::ID)
    #puts "Exiting ID Rule"
  end

  # ALPHA      -->   a  |  b  | … | z  or
  #                  A  |  B  | … | Z
  def alpha()
  end

  # INT        -->   DIGIT+
  def int()
  end

  # DIGIT      -->   0  |  1  | …  |  9
  def digit()
  end

  # WHITESPACE -->   Ruby Whitespace
  def whitespace()
  end
end
