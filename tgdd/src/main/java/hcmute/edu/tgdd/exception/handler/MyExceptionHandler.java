package hcmute.edu.tgdd.exception.handler;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import hcmute.edu.tgdd.model.DataResponse;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody
	public DataResponse handleConstraintException(DataIntegrityViolationException e) {
		return new DataResponse("400", "Duplicate data or database error", 200);
	}
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public DataResponse handleRuntimeException(RuntimeException e){
        return new DataResponse("400",e.getMessage(),200);
    }

}
