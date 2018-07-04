package com.github.amanganiello90.javafullstack.app.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.amanganiello90.javafullstack.app.models.SimpleTime;
import com.github.amanganiello90.javafullstack.app.services.SimpleTimeService;

/**
 *
 * @author amanganiello90
 */

@RestController
@RequestMapping(path = "/api")
public class TimeController {

	@Autowired
	SimpleTimeService simpleTimeService;

	@RequestMapping(path = "/times", method = RequestMethod.GET)
	public List<SimpleTime> times() throws IOException {
		return simpleTimeService.findAll();
	}

	@RequestMapping(value = "/times/{id}", method = RequestMethod.GET)
	public SimpleTime save(@PathVariable String id) {
		return simpleTimeService.save(id);

	}

	@RequestMapping(value = "/times/find/{id}", method = RequestMethod.GET)
	public SimpleTime read(@PathVariable String id) {
		return simpleTimeService.findById(id);

	}

}
