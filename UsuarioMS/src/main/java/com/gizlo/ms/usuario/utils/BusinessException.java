/**
 * 
 */
package com.gizlo.ms.usuario.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gizlo.ms.usuario.controller.dto.ResponseDTO;

/**
 * @author fauob
 *
 */
public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String codigoError;

	public BusinessException(String codigoError, String mensaje) {
		super(mensaje);
		this.codigoError = codigoError;

	}

	/**
	 * @return the codigoError
	 */
	public String getCodigoError() {
		return codigoError;
	}

	public static ResponseEntity<?> validateExcetion(BusinessException ex) {

		return new ResponseEntity<>(new ResponseDTO().codigo(ex.getCodigoError()).descripcion(ex.getMessage()),
				HttpStatus.resolve(Integer.parseInt(ex.getCodigoError())));
	}

}
