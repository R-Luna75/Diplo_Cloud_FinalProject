package unam.diplomado.pixup.usuariomicroservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import unam.diplomado.pixup.usuariomicroservice.domain.UsuarioAlreadyExistsException;

@RestControllerAdvice
public class UsuarioControllerAdvice {
	
	@ExceptionHandler(UsuarioAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	private String usuarioAlreadyExistHandler(
			UsuarioAlreadyExistsException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	private String validationHandler(
			MethodArgumentNotValidException exception) {
		return "Existen errores de validacion en el payload";
	}
	
}
