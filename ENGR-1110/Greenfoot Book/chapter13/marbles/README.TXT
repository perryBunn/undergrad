          === Marbles ===

This scenario is part of the book 

    "Introduction to Programming with Greenfoot"
    (Second edition)
    by Michael Kölling
    ISBN: 0134054296

This scenario is discussed in chapter 13.

Copyright (c) Michael Kölling.

----
This scenario was written to show smooth movement and collision detection.

How to play:
    Press 'Run' and then click-and-drag the golden ball. Clear the
    board within the given number of moves. Bonus points are awarded
    for keeping the golden ball on the board when it is cleared, and 
    for finishing in fewer moves than indicated.
    
Implementation:
    Especially interesting is the SmoothMover class. It serves as a 
    superclass for an actor that needs easy and smooth movement animation.
    The SmoothMover uses fields of type 'double' for storing the coordinates,
    instead of the standard 'int' fields in Actor. Even though the display
    on screen will always be in whole pixels, remembering fractions of 
    positions results in smoother looking animation. It also holds a vector
    of it's current movement and implements an easy-to-call 'move' method.
    
    The Vector class is needed for the SmoothMover.