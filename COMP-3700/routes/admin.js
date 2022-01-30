var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
    console.log("here0")
    res.render('admin', { error: false });
});

router.post('/results', async function (req, res, next) {
    console.log("here1")
    let username = req.username
    let userInfo = await dbGetUser(username);
    let accInfo = await dbGetAccount(username)
    console.log(userInfo);
    console.log(accInfo);
    if (userInfo) {
        console.log("here2")
        res.render('results', {doc: userInfo})
    } else {
        console.log("here3")
        res.render('admin', { error: true });
    }
})

module.exports = router;