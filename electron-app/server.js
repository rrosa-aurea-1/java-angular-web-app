
var express = require('express');
var app = express();
var appConfig= require(__dirname+'/electron.app.config.json')

const port = appConfig.port;
 
app.set('port', port);
app.use(express.static(__dirname+'/dist'));
 

app.get('/', function (req, res) {
  res.send('Hello World!');
});

app.listen(app.get('port'), function () {
  console.log('Example app listening on port '+app.get('port'));
});