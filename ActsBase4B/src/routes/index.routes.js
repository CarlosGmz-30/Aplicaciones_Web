const {Router} = require('express');
const {indexDb} = require('../controllers/index.controller.js');

const router = Router;

router.get("/getdb", indexDb);

module.exports = router;
