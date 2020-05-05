const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const PORT = process.env.PORT || 3000;

const {mongoose} = require('./driver.js');
let userController = require('../controllers/userController.js');

const app = express();
app.use(bodyParser.json());
app.use(cors());
app.use('/', userController);

app.listen(PORT, ()=> console.log('Server started'));