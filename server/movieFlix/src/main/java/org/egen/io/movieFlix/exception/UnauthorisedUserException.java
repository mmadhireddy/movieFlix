package org.egen.io.movieFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.UNAUTHORIZED)
public class UnauthorisedUserException extends RuntimeException{

	private static final long serialVersionUID = 2254142606447513887L;
	
	public UnauthorisedUserException(String message){
		super(message);
	}

}
