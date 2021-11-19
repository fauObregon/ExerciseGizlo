/**
 * 
 */
package com.gizlo.py.usuario.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gizlo.py.usuario.controller.dto.ResponseDTO;
import com.gizlo.py.usuario.controller.ifc.IUsuarioController;
import com.gizlo.py.usuario.service.ifc.IUsuarioSvc;
import com.gizlo.py.usuario.utils.BusinessException;

import om.gizlo.service.component.TipoUsuarioEnum;
import om.gizlo.service.component.Usuario;
import om.gizlo.service.component.UsuarioExternoDTO;
import om.gizlo.service.component.UsuarioInternoDTO;

/**
 * @author fauob
 *
 */
@RestController
@RequestMapping("/v1/api/py")
public class UsuarioController implements IUsuarioController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	IUsuarioSvc service;

	@Override
	public ResponseEntity<?> consultarUsuarios(TipoUsuarioEnum tipoUsuario) {
		LOG.info("INICIA CONSULTAR USUARIOS");
		ResponseEntity<?> response = null;

		try {

			List<Usuario> listUsuarios = service.consultarUsuario(tipoUsuario);

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
	public ResponseEntity<?> crearUsuarioExterno(UsuarioExternoDTO usuario) {
		LOG.info("INICIA CREAR EXTERNO");
		ResponseEntity<?> response = null;

		try {

			Usuario entity = service.crearUsuarioExterno(usuario);

			response = ResponseEntity.ok(entity);
		} catch (BusinessException e) {
			LOG.error("ERROR DE NEGOCIO {} ", e.getMessage());
			response = BusinessException.validateExcetion(e);
			
		} catch (Exception e) {
			response = new ResponseEntity<>(new ResponseDTO().codigo("500").descripcion("ERROR INESPERADO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info("FINALIZA CREAR USUARIO EXTERNO");
		return response;
	}

	@Override
	public ResponseEntity<?> crearUsuarioInterno(UsuarioInternoDTO usuario) {
		LOG.info("INICIA CREAR INTERNO");
		ResponseEntity<?> response = null;

		try {

			Usuario entity = service.crearUsuarioInterno(usuario);

			response = ResponseEntity.ok(entity);
			
		} catch (BusinessException e) {
			LOG.error("ERROR DE NEGOCIO {} ", e.getMessage());
			response = BusinessException.validateExcetion(e);
			
		} catch (Exception e) {
			LOG.error("ERROR INESPERADO {} ", e.getMessage());
			response = new ResponseEntity<>(new ResponseDTO().codigo("500").descripcion("ERROR INESPERADO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOG.info("FINALIZA CREAR USUARIO INTERNO");
		return response;
	}

}
