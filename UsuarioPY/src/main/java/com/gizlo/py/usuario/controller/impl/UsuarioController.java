/**
 * 
 */
package com.gizlo.py.usuario.controller.impl;

import java.util.List;

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

/**
 * @author fauob
 *
 */
@RestController
@RequestMapping("/v1/api/py")
public class UsuarioController implements IUsuarioController {
	
	@Autowired
	IUsuarioSvc service;

	@Override
	public ResponseEntity<?> consultarUsuarios(TipoUsuarioEnum tipoUsuario) {
		ResponseEntity<?> response = null;

		try {

			List<Usuario> listUsuarios = service.consultarUsuario(tipoUsuario);

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
	public ResponseEntity<?> crearUsuario(Usuario usuario) {
		ResponseEntity<?> response = null;

		try {

			Usuario entity = service.crearUsuario(usuario);

			response = ResponseEntity.ok(entity);

		} catch (Exception e) {
			response = new ResponseEntity<>(new ResponseDTO().codigo("500").descripcion("ERROR INESPERADO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
