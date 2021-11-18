/**
 * 
 */
package com.gizlo.py.usuario.controller.ifc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import om.gizlo.service.component.TipoUsuarioEnum;
import om.gizlo.service.component.Usuario;

/**
 * @author fauob
 *
 */

public interface IUsuarioController {

	@GetMapping(value = "/usuario/{tipoUsuario}", produces = "application/json")
	ResponseEntity<?> consultarUsuarios(@PathVariable(name = "tipoUsuario", value = "tipoUsuario") TipoUsuarioEnum tipoUsuario);
	
	@PostMapping(value = "/usuario", produces = "application/json", consumes = "application/json")
	ResponseEntity<?> crearUsuario(@RequestBody(required = true) Usuario usuario);
}
