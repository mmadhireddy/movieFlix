package org.egen.io.movieFlix.contrloller;

import java.util.List;

import org.egen.io.movieFlix.entity.MediaList;
import org.egen.io.movieFlix.service.MediaListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="medialist",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MediaListController {
	
	@Autowired
	private MediaListService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MediaList> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="{id}")
	public MediaList findOne(String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MediaList create(@RequestBody MediaList mdl) {
		return service.create(mdl);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MediaList update(@PathVariable("id") String imdbID,@RequestBody MediaList mdl) {
		return service.update(imdbID, mdl);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="{id}")
	public void delete(@PathVariable("id") String imdbID) {
		 service.delete(imdbID);
	}

}
