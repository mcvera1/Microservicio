package co.com.webService.mainAplicacion;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.webService.dto.ErrorDetailDTO;
import co.com.webService.exception.PersonaNoContentException;
import co.com.webService.exception.PersonaNotFoundException;

@ControllerAdvice
@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetailDTO> handleAllException(Exception ex, WebRequest request){
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorDetailDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PersonaNotFoundException.class)
	public final ResponseEntity<ErrorDetailDTO> handlePersonaNotFoundException(PersonaNotFoundException ex, WebRequest request){
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorDetailDTO, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PersonaNoContentException.class)
	protected ResponseEntity<ErrorDetailDTO> handleMethodArgumentNotValid(PersonaNoContentException ex, WebRequest request) {
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value());
	    return new ResponseEntity<>(errorDetailDTO, HttpStatus.NOT_FOUND);
	  } 
}
