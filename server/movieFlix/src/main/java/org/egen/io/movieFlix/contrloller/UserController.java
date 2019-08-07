package org.egen.io.movieFlix.contrloller;


import java.util.List;

import org.egen.io.movieFlix.entity.User;
import org.egen.io.movieFlix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="user",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="{id}")
	public User findOne(String id){
		return service.findOne(id);
	}
	@RequestMapping(method = RequestMethod.POST,value="{id}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User login(@PathVariable("id") String action,@RequestBody User usr){
		return service.login(action,usr);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User usr) {
		return service.create(usr);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String usrid,@RequestBody User usr) {
		return service.update(usrid, usr);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="{id}")
	public void delete(@PathVariable("id") String usrid) {
		 service.delete(usrid);
	}
	
}
