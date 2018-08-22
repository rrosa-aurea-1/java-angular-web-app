const express = require('express');
const app = express();
require('dotenv').config();
let appConfig= require(__dirname+'/../config.json');
let port = appConfig.PORT || 8000;
if(process.env.PORT!==undefined){
	port=process.env.PORT;
}
const environment = process.env.NODE_ENV || 'dev';
let configDB = require(__dirname+'/config/database');
if (appConfig.MONGO_EMBEDDED === 'true' && process.env.MONGO_EMBEDDED !== 'false'){
	require('tungus');
}
const morgan = require('morgan');
const bluebird = require('bluebird');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const routes = require(__dirname+'/routes');

mongoose.Promise = bluebird;
mongoose.connect(configDB.mongo.url);

app.use(bodyParser.urlencoded({
		extended: true
	}));
app.use(bodyParser.json());
app.use(morgan(environment));

app.use(express.static(__dirname + '/../dist'));
app.use('/', routes);

app.listen(port, () => {
	console.log(`The magic happens on http://localhost:${port}`)
})

module.exports = app;
