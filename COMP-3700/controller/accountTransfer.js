const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/';
const dbGetAccount = require("./dbGetAccount");
const dbEditAccount = require("./dbEditAccount")

const accountTransfer = async (accDestinationID, accSourceID, amount) => {
    let client
    try {
        let source = await dbGetAccount(null,accSourceID);
        let destination = await dbGetAccount(null, accDestinationID);

        if (source.balance < amount) {
            console.log("source balance too low for transfer.")
            return false;
        }
        if (source && destination) {
            let sub = 0 - amount;
            await dbEditAccount(null, accSourceID, sub)
            await dbEditAccount(null, accDestinationID, amount)
        }

    } catch (e) {
        console.log(e);
    }
    if (client) {
        await client.close();
    }
}

module.exports = accountTransfer;