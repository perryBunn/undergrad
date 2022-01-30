var express = require('express');
var router = express.Router();
var login = require('../controller/authenticate/login');
var dbGetUser = require("../controller/dbGetUser");
/* GET users listing. */
router.get('/', function (req, res, next) {
  res.send('respond with a resource');
});

/* Login user */
router.post('/login', async function (req, res, next) {
  const username = req.body.username;

  // This is a async return so its not working right. Currently only reading Promise{<pending>}
  let loginResult = await login(username, req.body.password);
  let userInfo = await dbGetUser(username);
  console.log(userInfo);
  console.log(loginResult);
  if (loginResult === true) {
    if (userInfo.type === "teller") {
      res.render('teller', {})
    } else if (userInfo.type === "admin") {
      res.render('admin', {username: username})
    } else {
      res.render('users', {username: username});
    }
  }
  else {
    res.render('index', {error: true});
  }
});
module.exports = router;