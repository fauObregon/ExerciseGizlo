/**
 * 
 */
package com.gizlo.ms.usuario.controller.ifc;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gizlo.ms.usuario.controller.dto.ResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import om.gizlo.service.component.UsuarioExternoDTO;

/**
 * @author fauob
 *
 */
@Validated
@Tag(name = "UsuarioExterno v1.0", description = "Usuario Externo API")
public interface IUsuarioExternoController {
	
	/**
	 * CONSULTA DE USUARIOS EXTERNOS
	 * @return
	 */
	@Operation(summary = "Consultar Lista de Usuarios Externos", operationId = "consultarUsuarios", description = "Consultar Lista de Usuarios Externos", tags = {
			"UsuarioExterno v1.0", })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = UsuarioExternoDTO.class)))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = ResponseDTO.class))) })
	@GetMapping(value = "/usuarioExterno", produces = "application/json")
	ResponseEntity<?> consultarUsuarios();
	
	/**
	 * CREACION DE USUARIO EXTERNO
	 * @param usuario
	 * @return
	 */
	@Operation(summary = "Crear Usuario Externo", operationId = "crearUsuario", description = "Crear Usuario Externo", tags = {
			"UsuarioExterno v1.0", })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UsuarioExternoDTO.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = ResponseDTO.class))) })
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la entidad", content = @Content(schema = @Schema(implementation = UsuarioExternoDTO.class)))	
	@PostMapping(value = "/usuarioExterno", produces = "application/json", consumes = "application/json")
	ResponseEntity<?> crearUsuario(@RequestBody(required = true) UsuarioExternoDTO usuario);

}
