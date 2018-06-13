const Controller = require(__dirname+'/../../lib/controller');
const userFacade = require(__dirname+'/facade');

class UserController extends Controller {}

module.exports = new UserController(userFacade);
