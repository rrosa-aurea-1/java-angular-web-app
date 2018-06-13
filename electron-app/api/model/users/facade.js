const Facade = require(__dirname+'/../../lib/facade');
const userSchema = require(__dirname+'/schema');

class UserFacade extends Facade {}

module.exports = new UserFacade(userSchema);
