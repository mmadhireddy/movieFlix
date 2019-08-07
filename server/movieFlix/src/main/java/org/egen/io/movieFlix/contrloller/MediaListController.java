package org.egen.io.movieFlix.contrloller;

import java.util.List;

import org.egen.io.movieFlix.UserReviewsPK;
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
@RequestMapping(value="{userid}/medialist",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MediaListController {
	
	@Autowired
	private MediaListService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MediaList> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="{imdbid}")
	public MediaList findOne(@PathVariable("imdbid")  String imdbid){
		return service.findOne(imdbid);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MediaList create(@PathVariable("userid")  String userid,@RequestBody MediaList mdl) {
		return service.create(userid,mdl);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="{imdbid}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MediaList update(@PathVariable("userid")  String userid,@PathVariable("imdbid") String imdbid,@RequestBody MediaList mdl) {
		UserReviewsPK urw_pk=new UserReviewsPK();
		urw_pk.setUserid(userid);
		urw_pk.setImdbid(imdbid);
		return service.update(urw_pk, mdl);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="{imdbid}")
	public void delete(@PathVariable("userid")  String userid,@PathVariable("imdbid") String imdbid) {
		UserReviewsPK urw_pk=new UserReviewsPK();
		urw_pk.setUserid(userid);
		urw_pk.setImdbid(imdbid);
		 service.delete(urw_pk);
	}

}
