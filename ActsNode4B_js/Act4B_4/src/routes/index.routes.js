const { Router } = require('express');
const { firstConnect } = require('../controllers/index.controller.js');

const router = Router();

router.get('/getdb', firstConnect);

module.exports = router;