/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.amanganiello90.javafullstack.app.controllers;

import com.github.amanganiello90.javafullstack.app.models.User;
import com.github.amanganiello90.javafullstack.app.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amanganiello90
 */

@RestController
@RequestMapping(path="/api")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> users() {
		return userService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public String save(@RequestBody User user) {

		return userService.save(user);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public User read(@PathVariable String id) {
		return userService.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public User update(@PathVariable String id, @RequestBody User user) {
		return userService.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public String delete(@PathVariable String id) {
		return userService.delete(id);
	}
}