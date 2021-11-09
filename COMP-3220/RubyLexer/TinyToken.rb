# frozen_string_literal: true
#
#  Class Token - Encapsulates the tokens in TINY
#
#   @type - the type of token (Category)
#   @text - the text the token represents (Lexeme)
#
class Token
  attr_accessor :type
  attr_accessor :text

  # This is the only part of this class that you need to
  # modify.
  EOF = 'eof'
  LPAREN = '('
  RPAREN = ')'
  ADDOP  = '+'
  SUBOP = '-'
  TIMESOP = '*'
  DIVOP = '/'
  ASSIGN = '='
  WS = 'whitespace'
  INT = 'int'
  ID = 'id'
  PRINT = 'print'
  # add the rest of the tokens needed based on the grammar
  # specified in the Scanner class "TinyScanner.rb"

  # constructor
  def initialize(type, text)
    @type = type
    @text = text
  end

  def get_type
		return @type
  end

  def get_text
		return @text
  end

  # to string method
  def to_s
    print "Next token is: #{@type} Next lexeme is: #{@text}\n"
  end
end
