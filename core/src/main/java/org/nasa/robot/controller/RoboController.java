package org.nasa.robot.controller;

import org.nasa.robot.domain.Robo;
import org.nasa.robot.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoboController {
	
	private RoboService roboService;
	
	@Autowired
	public RoboController(RoboService roboService) {
		this.roboService = roboService;
	}
	
	@RequestMapping(value = "/rest/mars/{commands}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String post(@PathVariable final String commands) {
		return roboService.mover(commands, new Robo());
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBadRequestException(IndexOutOfBoundsException ex) {
	  return ex.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(Exception ex) {
	  return ex.getMessage();
	}
	
	
}
