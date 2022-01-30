const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/';
var dbGetUser = require("../controller/dbGetUser");

const dbGetAccount = async (username, accountIDIn) => {
    let client
    try {
        client = await MongoClient.connect(url, { useNewUrlParser: true, useUnifiedTopology: true });
        let accounts = client.db("COMP3700").collection("Accounts");
        let acc
        if (accountIDIn == null && username != null) {
            let userTemp = await dbGetUser(username);
            accountIDIn = userTemp.userID;
        }
        if (accountIDIn) {
            acc = await accounts.find({owner: `${accountIDIn}`}).toArray();
        }
        if (acc) {
            console.log(acc[0])
            return acc[0];
        }
    } catch (e) {
        console.log(e);
    }
    if (client) {
        await client.close();
    }
}

module.exports = dbGetAccount;