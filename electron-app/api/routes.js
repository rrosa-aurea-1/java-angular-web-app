const path = require('path');
const fs = require('fs');
const Router = require('express').Router;
const router = new Router();

// Loads dynamically all endpoints within models directory
const dirs = p => fs.readdirSync(p).filter(f => fs.statSync(path.join(p, f)).isDirectory())
dirs(__dirname+'/model').map((endpoint) => {
  router.use(`/api/${endpoint}`, require(__dirname+`/model/${endpoint}/router`));
})

/*

  To load endpoints manually you can follow the example bellow

    const ENDPOINT = require('./model/ENDPOINT/router');
    router.use('/api/ENDPOINT', ENDPOINT);

*/

router.get('*', function(req, res) {
  res.sendfile(path.resolve('dist/index.html'));
});

module.exports = router;
