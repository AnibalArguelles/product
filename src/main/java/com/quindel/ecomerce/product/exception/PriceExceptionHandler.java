package com.quindel.ecomerce.product.exception;

import java.text.ParseException;

import javax.persistence.NoResultException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class PriceExceptionHandler {

	/**
	 * Controla la excepci&oacute;n cuando no encuentra registro en la bd
	 * 
	 * @param exception Excepci&oacute;n de tipo NoResultException
	 * @return Response con Excepci&oacute;n
	 */
	@ExceptionHandler(value = { NoResultException.class })
	public ResponseEntity<Object> handleNoResultException(NoResultException exception) {
		log.info("Registro no encontrado");
		return new ResponseEntity<Object>("Registro no encontrado", new HttpHeaders(), HttpStatus.NO_CONTENT);
	}

	/**
	 * Controla la excepci&oacute;n cuando no puede convertir una fecha
	 * 
	 * @param exception Excepci&oacute;n de tipo ParseException
	 * @return Response con Excepci&oacute;n
	 */
	@ExceptionHandler(value = { ParseException.class })
	public ResponseEntity<Object> handleParseException(ParseException exception) {
		log.info("Error al convertir fecha");
		return new ResponseEntity<Object>("Error al convertir fecha", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
