const { Router } = require("express");
const { firstConnect } = require("../controllers/index.controller");

const router = Router();

router.get('/getdb', firstConnect);

module.exports = router;