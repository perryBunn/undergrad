% A5 Lab Report
% Perry Bunn
% Nov 4th, 2017

# Benchmarking the ArrayStrand implementation

## Show that ArrayStrand.cutAndSplice() is O(N)
Record your response here.

	ArrayStrand:	 splice length	                  256 	 time 	 0.079 recombinant length            4,800,471
	ArrayStrand:	 splice length	                  512 	 time 	 0.085 recombinant length            4,965,591
	ArrayStrand:	 splice length	                1,024 	 time 	 0.063 recombinant length            5,295,831
	ArrayStrand:	 splice length	                2,048 	 time 	 0.058 recombinant length            5,956,311
	ArrayStrand:	 splice length	                4,096 	 time 	 0.090 recombinant length            7,277,271
	ArrayStrand:	 splice length	                8,192 	 time 	 0.084 recombinant length            9,919,191
	ArrayStrand:	 splice length	               16,384 	 time 	 0.171 recombinant length           15,203,031
	ArrayStrand:	 splice length	               32,768 	 time 	 0.164 recombinant length           25,770,711
As the number of items to caclulate goes up the time increases linearly
## Determine the largest power-of-two splice supported with 512M heap
Record your response here.
the largest power of 2 is 32,768
## Determine the largest power-of-two splice supported with 1024M heap
Record your response here.
the largest power of 2 is 131,072
## Determine the largest power-of-two splice supported as heap doubles
Record your response here.
the largest power of 2 that my system can support is 1,048,576

# Verifying the LinkedStrand implementation

## Show that LinkedStrand.cutAndSplice() is O(1)
Record your response here.

	LinkedStrand:	 splice length	                  256 	 time 	 2.388 recombinant length            4,800,471
	LinkedStrand:	 splice length	                  512 	 time 	 2.138 recombinant length            4,965,591
	LinkedStrand:	 splice length	                1,024 	 time 	 1.975 recombinant length            5,295,831
	LinkedStrand:	 splice length	                2,048 	 time 	 1.923 recombinant length            5,956,311
	LinkedStrand:	 splice length	                4,096 	 time 	 1.963 recombinant length            7,277,271
	LinkedStrand:	 splice length	                8,192 	 time 	 1.867 recombinant length            9,919,191
	LinkedStrand:	 splice length	               16,384 	 time 	 1.891 recombinant length           15,203,031
	LinkedStrand:	 splice length	               32,768 	 time 	 1.862 recombinant length           25,770,711
	LinkedStrand:	 splice length	               65,536 	 time 	 1.865 recombinant length           46,906,071
	LinkedStrand:	 splice length	              131,072 	 time 	 1.875 recombinant length           89,176,791
	LinkedStrand:	 splice length	              262,144 	 time 	 1.874 recombinant length          173,718,231
	LinkedStrand:	 splice length	              524,288 	 time 	 1.860 recombinant length          342,801,111
	LinkedStrand:	 splice length	            1,048,576 	 time 	 1.859 recombinant length          680,966,871
	LinkedStrand:	 splice length	            2,097,152 	 time 	 1.892 recombinant length        1,357,298,391
	LinkedStrand:	 splice length	            4,194,304 	 time 	 1.981 recombinant length        2,709,961,431
	LinkedStrand:	 splice length	            8,388,608 	 time 	 1.896 recombinant length        5,415,287,511
	LinkedStrand:	 splice length	           16,777,216 	 time 	 1.868 recombinant length       10,825,939,671
	LinkedStrand:	 splice length	           33,554,432 	 time 	 1.880 recombinant length       21,647,243,991
	LinkedStrand:	 splice length	           67,108,864 	 time 	 1.903 recombinant length       43,289,852,631
As the number of items calculated increases the time says relativly consistant around 1.85sec 
## Determine the largest power-of-two splice supported with 512M heap
Record your response here.
67,108,864 is the largest power of 2
## Determine the largest power-of-two splice supported with 1024M heap
Record your response here.
134,217,728 is the largest power of 2
## Determine the largest power-of-two splice supported as heap doubles
Record your response here.
536,870,912 is the largest power of 2 that my system can handle
																																																																																																																																																																																																																																																																																																																																																																																																												
