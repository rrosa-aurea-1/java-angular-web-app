const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const userSchema = new Schema({
		id: {
			type: String,
			required: true
		},
		username: {
			type: String,
			required: true
		},
		email: {
			type: String
		},
		firstname: {
			type: String,
			required: true
		},
		lastname: {
			type: String,
			required: true
		}
	});

module.exports = mongoose.model('User', userSchema);
