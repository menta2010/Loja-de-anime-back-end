package com.natalino.lojaanime.controller.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.natalino.lojaanime.services.exceptions.DataIntegrityException;
import com.natalino.lojaanime.services.exceptions.ObjetoNaoEncontrado;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	//indica que é um tratador de excessão do tipo objetonaoencontrado
	@ExceptionHandler(ObjetoNaoEncontrado.class)
	//recebe a excessão e as informações da requisição
	public ResponseEntity<StandardError> objetoNaoEncontrado(ObjetoNaoEncontrado e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
