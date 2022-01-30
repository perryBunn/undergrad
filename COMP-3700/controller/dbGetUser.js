const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/';


const dbGetUser = async (emailIn) => {
    let client
    try {
        client = await MongoClient.connect(url, { useNewUrlParser: true, useUnifiedTopology: true });
        let users = client.db("COMP3700").collection("Users");

        let usr = await users.find({username: `${emailIn}`}).toArray();
        if (usr) {
            console.log(usr[0])
            return usr[0];
        }
    } catch (e) {
        console.log(e);
    }
    if (client) {
        await client.close();
    }
}

module.exports = dbGetUser;