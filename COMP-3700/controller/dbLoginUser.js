const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/';


const dbLoginUser = async (usernameIn, passwordIn) => {
    let client
    try {
        client = await MongoClient.connect(url, { useNewUrlParser: true, useUnifiedTopology: true });
        let users = client.db("COMP3700").collection("Users");

        let usr = await users.find({username: `${usernameIn}`}).toArray();
        if (usr) {
            console.log(usr)
            console.log(usr[0].password)
            console.log(usr[0].password === passwordIn);
            return usr[0].password === passwordIn;
        }
    } catch (e) {
        console.log(e);
    }
    if (client) {
        await client.close();
    }
}

module.exports = dbLoginUser;