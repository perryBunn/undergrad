# Setup

You will need to make sure that `matplotlib`, `pandas`, and `openpyxl` are installed on your system. to do so run the following command in your command prompt or terminal:

 ```pip3 install pandas matplotlib openpyxl```

# Collection

In your terminal you run ping for the servers you want for some amount of runs

  ```ping <server> -c 6```

Copy that information into a text file formatted like below
  ```64 bytes from uam.es (150.244.214.237): icmp_seq=1 ttl=236 time=141 ms
64 bytes from uam.es (150.244.214.237): icmp_seq=2 ttl=236 time=140 ms
64 bytes from uam.es (150.244.214.237): icmp_seq=3 ttl=236 time=139 ms
64 bytes from 47.88.6.38 (47.88.6.38): icmp_seq=1 ttl=47 time=90.1 ms
64 bytes from 47.88.6.38 (47.88.6.38): icmp_seq=2 ttl=47 time=88.0 ms
64 bytes from usc.edu (68.181.5.136): icmp_seq=1 ttl=235 time=77.5 ms
64 bytes from usc.edu (68.181.5.136): icmp_seq=2 ttl=235 time=76.1 ms
  ```

# Code

You need to then change the string on line 50 so that when you run the program it will go to the right file. The program will work for any number of runs just as long as the input file is formatted correctly.

## Run. Profit.