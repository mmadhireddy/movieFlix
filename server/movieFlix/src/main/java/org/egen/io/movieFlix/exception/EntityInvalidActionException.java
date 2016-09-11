package org.egen.io.movieFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class EntityInvalidActionException extends RuntimeException{

	private static final long serialVersionUID = -2800637204749562982L;
	
	public EntityInvalidActionException(String message){
		super(message);
	}

}
