package hcmute.edu.tgdd.exception.handler;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.exceptions.SignatureVerificationException;

import hcmute.edu.tgdd.model.DataResponse;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody
	public DataResponse handleConstraintException(DataIntegrityViolationException e) {
		return new DataResponse("400", "Duplicate data or database error", 200);
	}
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseBody
	public DataResponse handleUserNotFoundException(UsernameNotFoundException e){
		return new DataResponse("400",e.getMessage(),200);
	}
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public DataResponse handleRuntimeException(RuntimeException e){
        return new DataResponse("400",e.getMessage(),200);
    }
    // catch invalid signature exception
    @ExceptionHandler(SignatureVerificationException.class)
    @ResponseBody
    public DataResponse handleAuthenticationException(SignatureVerificationException e){
        return new DataResponse("400","Invalid token",200);
    }
    // incorrect identical
    // invalid token
    // token not found
    // token not allowed (token is correct but not allow for the role)
}
