const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/';
const dbGetAccount = require('./dbGetAccount')

const dbEditAccount = async (username, accountIDIn, amount) => {
    let client
    try {
        client = await MongoClient.connect(url, { useNewUrlParser: true, useUnifiedTopology: true });
        let accounts = client.db("COMP3700").collection("Accounts");
        let acc
        if (username && accountIDIn == null) {
            let usr = await dbGetUser(username)
            console.log(usr)
            acc = await dbGetAccount(usr.userID)
            console.log(acc)
            let change = acc.balance + amount
            accounts.update({owner: [usr.userID]},{balance: change})
            acc = await dbGetAccount(usr.userID)
            console.log(acc)
        }
    } catch (e) {
        console.log(e);
    }
    if (client) {
        await client.close();
    }
}

module.exports = dbEditAccount;