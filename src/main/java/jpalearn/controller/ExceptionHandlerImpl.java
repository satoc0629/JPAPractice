package jpalearn.controller;


import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerImpl {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public String exceptionHandler(Exception e) {

        if (e instanceof ObjectOptimisticLockingFailureException){
            var oolfe = (ObjectOptimisticLockingFailureException) e;
            return oolfe.getPersistentClassName()+", "+oolfe.getIdentifier()+", "+oolfe.getMessage();
        }

        return e.getMessage();
    }
}
