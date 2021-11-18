/**
 * 
 */
package com.gizlo.ms.usuario.controller.ifc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import om.gizlo.service.component.UsuarioExternoDTO;

/**
 * @author fauob
 *
 */
public interface IUsuarioExternoController {
	
	@GetMapping(value = "/usuarioExterno", produces = "application/json")
	ResponseEntity<?> consultarUsuarios();
	
	@PostMapping(value = "/usuarioExterno", produces = "application/json", consumes = "application/json")
	ResponseEntity<?> crearUsuario(@RequestBody(required = true) UsuarioExternoDTO usuario);

}
