const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/';
const client = new MongoClient(url, { useNewUrlParser: true, useUnifiedTopology: true });

let dbCreateUsers = async function (usernameIn, passwordIn) {
    try {
        await client.connect(err => {
            const users = client.db("COMP3700").collection("Users");

            users.createIndex({
                username: `${usernameIn}`,
                password: `${passwordIn}`
            });
        })
    } catch (e) {
        console.log(e);
    }
    if (client) {
        await client.close();
    }
}

module.exports=dbCreateUsers;