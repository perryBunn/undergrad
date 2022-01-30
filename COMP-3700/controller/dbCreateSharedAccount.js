const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/';
const client = new MongoClient(url, { useNewUrlParser: true, useUnifiedTopology: true });

let dbCreateSharedAccount = async function (userIds, balanceIn) {
    try {
        await client.connect(err => {
            const accounts = client.db("COMP3700").collection("Accounts");
            if (balanceIn) {
                accounts.createIndex({
                    "owner": userIds,
                    balance: balanceIn
                });
            } else {
                accounts.createIndex({
                    "owner": [
                        `${userIdIn}`
                    ],
                    balance: 0
                });
            }
        })
    } catch (e) {
        console.log(e);
    }
    if (client) {
        await client.close();
    }
}

module.exports=dbCreateSharedAccount;