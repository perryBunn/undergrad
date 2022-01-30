var dbGetUser = require('../dbLoginUser')

var login = async function(user,password){
    console.log(user,password);
    return (await dbGetUser(user, password));
}

module.exports=login;