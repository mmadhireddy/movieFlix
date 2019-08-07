package org.egen.io.movieFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class EntityAlreadyExistException extends RuntimeException {

	
	private static final long serialVersionUID = -2833945534381180218L;

	public EntityAlreadyExistException(String message){
		super(message);
	}
}
