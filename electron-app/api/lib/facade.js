
class Facade {
	constructor(schema) {
		this.model = schema;
	}

	create(body) {
		let model = new this.model(body);
		return model;
	}

	getModel() {
		return this.model;
	}

}

module.exports = Facade;
