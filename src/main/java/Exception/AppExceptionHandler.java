package Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{	
	@ExceptionHandler(value = {BowlingException.class})
	public ResponseEntity<Object> handleException(BowlingException e, WebRequest request){
		String message = e.getLocalizedMessage();
		return new ResponseEntity<>(new Error(message), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
