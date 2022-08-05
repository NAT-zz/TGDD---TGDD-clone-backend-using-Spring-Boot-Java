package hcmute.edu.tgdd.exception.handler;

import hcmute.edu.tgdd.model.DataResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public DataResponse handleRuntimeException(RuntimeException e){
        return new DataResponse("400",e.getMessage(),200);
    }

}
