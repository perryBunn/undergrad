# COMP-3700
Group Project

## Banking Information System: 
A large bank has multiple branches. A person may have multiple accounts of each type – checking / savings, etc. Each account may have a home branch where it is primarily associated with / created. Personal details are required when user creates an account for the first time with bank. Amount in savings account will accrue interest at regular intervals. Fixed deposits can be created from account balances for a specific given amount, which will have higher interest returns – but only at end of the term period, if cancelled before that, it will be considered as part of the corresponding checking / savings account – will provide some return if it was from savings account, will not provide any return if the money was from checking account; provide various kinds of reports, periodic transaction summaries. All transaction should be stored in database and should be available for online access for seven years. Transactions once posted to an account can never be deleted. Provide varied levels of access privileges for accounts by customers, bank tellers, bank managers, etc. Restrict some kinds of operations at base branch only.


## Getting Started
prerequisites:
Node `v12.16.2`,
npm `v6.14.4`,
git `latest`

Linux:
    
- install: [MongoDB Compass](https://www.mongodb.com/download-center/compass), [MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/)
- import DB files from `./data` into a collection called `COMP3700`


    git clone https://github.com/perryBunn/COMP-3700.git COMP3700
    cd COMP3700
    sudo npm install express --save
    sudo npm install
    npm start
    
- navigate to `localhost:3000` in whatever browser.

Windows:
- Install: [Node](https://nodejs.org/en/download/), [MongoDB Compass](https://www.mongodb.com/download-center/compass), [MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/)


    git clone https://github.com/perryBunn/COMP-3700.git COMP3700
    cd COMP3700
    npm install express --save
    npm install
    npm start
    
    
## Commands
1. `npm start` - starts web server.