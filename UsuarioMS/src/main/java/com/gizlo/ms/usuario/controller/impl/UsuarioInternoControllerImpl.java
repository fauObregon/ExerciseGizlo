/**
 * 
 */
package com.gizlo.ms.usuario.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.ms.usuario.controller.dto.ResponseDTO;
import com.gizlo.ms.usuario.controller.ifc.IUsuarioInternoController;
import com.gizlo.ms.usuario.service.ifc.IUsuarioInternoSvc;
import com.gizlo.ms.usuario.utils.BusinessException;

import om.gizlo.service.component.UsuarioInternoDTO;

/**
 * @author fauob
 *
 */
@RestController
@RequestMapping("/v1/api/ms")
public class UsuarioInternoControllerImpl implements IUsuarioInternoController {

	@Autowired
	IUsuarioInternoSvc service;

	@Override
	public ResponseEntity<?> consultarUsuarios() {
		ResponseEntity<?> response = null;

		try {

			List<UsuarioInternoDTO> listUsuarios = service.consultarUsuario();

			response = ResponseEntity.ok(listUsuarios);

		} catch (BusinessException e) {
			response = BusinessException.validateExcetion(e);

		} catch (Exception e) {
			response = new ResponseEntity<>(new ResponseDTO().codigo("500").descripcion("ERROR INESPERADO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> crearUsuario(UsuarioInternoDTO usuario) {
		ResponseEntity<?> response = null;

		try {

			UsuarioInternoDTO entity = service.crearUsuario(usuario);

			response = ResponseEntity.ok(entity);

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(new ResponseDTO().codigo("500").descripcion("ERROR INESPERADO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
