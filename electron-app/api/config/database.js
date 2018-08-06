const database = {
	mongo: {
		url: getDbUrl()
	}
};

function getDbUrl() {
let appConfig= require(__dirname+'/../../electron.app.config.json');
	if (appConfig.MONGO_EMBEDDED === 'true' && process.env.MONGO_EMBEDDED !== 'false')
		return 'mongodb://' + __dirname;
	
	if(process.env.MONGO_DB_URI!==undefined)
		return process.env.MONGO_DB_URI

	return appConfig.MONGO_DB_URI;
}

module.exports = database;