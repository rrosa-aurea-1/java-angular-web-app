package com.github.amanganiello90.javafullstack.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.amanganiello90.javafullstack.models.SimpleTime;
import com.github.amanganiello90.javafullstack.services.SimpleTimeService;

/**
 *
 * @author amanganiello90
 */

@RestController
@RequestMapping(path="/api")
public class TimeController {

	@Autowired
	SimpleTimeService simpleTimeService;

	@RequestMapping(path = "/times", method = RequestMethod.GET)
	public List<SimpleTime> findTimes() throws IOException {
		return simpleTimeService.findAll();
	}

	@RequestMapping(value = "/times/{value}", method = RequestMethod.GET)
	public SimpleTime saveTime(@PathVariable String value) {
		return simpleTimeService.save(value);

	}
	
	@RequestMapping(value = "/times/find/{value}", method = RequestMethod.GET)
	public SimpleTime findTimeById(@PathVariable String value) {
		return simpleTimeService.findById(value);

	}

}
