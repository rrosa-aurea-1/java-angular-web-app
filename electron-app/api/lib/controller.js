class Controller {
	constructor(facade) {
		this.facade = facade;
	}

	create(req, res, next) {
		return this.facade.create(req.body)
		.save(function (err, doc) {
			if (err)
				return next(err);
			res.status(201).json(doc)

		});
	}

	find(req, res, next) {
		return this.facade.getModel()
		.find(req.query, function (err, collection) {
			if (err)
				return next(err);
			let resObj = [];
			collection.forEach(function (obj) {

				obj['id'] = obj['_id'];

				resObj.push(obj);
			});
			res.status(200).json(resObj)
		})

	}

	findOne(req, res, next) {
		return this.facade.getModel()
		.findOne(req.query, function (err, doc) {
			if (err)
				return next(err);
			res.status(200).json(doc)
		})
	}

	findById(req, res, next) {
		return this.facade.getModel().findById(req.params.id, function (err, doc) {
			if (!doc) {
				return res.sendStatus(404);
			}
			if (err)
				return next(err);

			doc['id'] = doc['_id'];

			return res.status(200).json(doc);
		});

	}

	update(req, res, next) {
		this.facade.getModel().update({
			_id: req.params.id
		}, req.body, function (err, results) {
			if (err)
				return next(err);

			if (results.n < 1) {
				return res.sendStatus(404);
			}
			if (results.nModified < 1) {
				return res.sendStatus(304);
			}
			res.sendStatus(204);

		})
	}

	remove(req, res, next) {
		this.facade.getModel().remove({
			_id: req.params.id
		}, function (err, doc) {
			if (!doc) {
				return res.sendStatus(404);
			}
			if (err)
				return next(err);

			return res.sendStatus(204);

		})
	}

}
module.exports = Controller;
