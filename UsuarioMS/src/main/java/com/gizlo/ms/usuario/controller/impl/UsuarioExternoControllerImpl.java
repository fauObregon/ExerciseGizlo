/**
 * 
 */
package com.gizlo.ms.usuario.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.ms.usuario.controller.dto.ResponseDTO;
import com.gizlo.ms.usuario.controller.ifc.IUsuarioExternoController;
import com.gizlo.ms.usuario.service.ifc.IUsuarioExternoSvc;
import com.gizlo.ms.usuario.utils.BusinessException;

import om.gizlo.service.component.UsuarioExternoDTO;

/**
 * @author fauob
 *
 */

@RestController
@RequestMapping("/v1/api/ms")
public class UsuarioExternoControllerImpl implements IUsuarioExternoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioExternoControllerImpl.class);

	@Autowired
	IUsuarioExternoSvc service;

	@Override
	public ResponseEntity<?> consultarUsuarios() {
		LOG.info("INICIA CONSULTAR USUARIOS");

		ResponseEntity<?> response = null;

		try {

			List<UsuarioExternoDTO> listUsuarios = service.consultarUsuario();

			response = ResponseEntity.ok(listUsuarios);

		} catch (BusinessException e) {
			LOG.error("ERROR DE NEGOCIO {} ", e.getMessage());
			response = BusinessException.validateExcetion(e);

		} catch (Exception e) {
			LOG.error("ERROR INESPERADO {} ", e.getMessage());
			response = new ResponseEntity<>(new ResponseDTO().codigo("500").descripcion("ERROR INESPERADO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOG.info("FINALIZA CONSULTAR USUARIOS");
		return response;
	}

	@Override
	public ResponseEntity<?> crearUsuario(UsuarioExternoDTO usuario) {
		LOG.info("INICIA CREAR USUARIO");
		
		ResponseEntity<?> response = null;

		try {

			UsuarioExternoDTO entity = service.crearUsuario(usuario);

			response = ResponseEntity.ok(entity);

		} catch (Exception e) {
			LOG.error("ERROR INESPERADO {} ", e.getMessage());
			response = new ResponseEntity<>(new ResponseDTO().codigo("500").descripcion("ERROR INESPERADO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOG.info("FINALIZA CREAR USUARIO");
		return response;
	}

}
