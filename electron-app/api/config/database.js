const database = {
	mongo: {
		url: getDbUrl()
	}
};

function getDbUrl() {

	if (process.env.MONGO_EMBEDDED === 'true')
		return 'mongodb://' + __dirname;

	return process.env.MONGO_DB_URI;
}

module.exports = database;