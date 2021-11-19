/**
 * 
 */
package com.gizlo.py.usuario.controller.ifc;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gizlo.py.usuario.controller.dto.ResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import om.gizlo.service.component.TipoUsuarioEnum;
import om.gizlo.service.component.Usuario;
import om.gizlo.service.component.UsuarioExternoDTO;
import om.gizlo.service.component.UsuarioInternoDTO;

/**
 * @author fauob
 *
 */
@Validated
@Tag(name = "Usuario v1.0", description = "Usuario API")
public interface IUsuarioController {

	/**
	 * CONSULTA DE USUARIOS
	 * 
	 * @return
	 */
	@Operation(summary = "Consultar Lista de Usuarios Segun su Tipo", operationId = "consultarUsuarios", description = "Consultar Lista de Usuarios Segun su Tipo", tags = {
			"Usuario v1.0", })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Usuario.class)))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = ResponseDTO.class))) })
	@Parameter(name = "tipoUsuario", schema = @Schema(implementation = TipoUsuarioEnum.class))
	@GetMapping(value = "/usuario/{tipoUsuario}", produces = "application/json")
	ResponseEntity<?> consultarUsuarios(
			@PathVariable(name = "tipoUsuario", value = "tipoUsuario") TipoUsuarioEnum tipoUsuario);

	/**
	 * CREACION DE USUARIO EXTERNO
	 * 
	 * @param usuario
	 * @return
	 */
	@Operation(summary = "Crear Usuario Externo", operationId = "crearUsuarioExterno", description = "Crear Usuario Externo", tags = {
			"UsuarioExterno v1.0", })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UsuarioExternoDTO.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = ResponseDTO.class))) })
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la entidad", content = @Content(schema = @Schema(implementation = UsuarioExternoDTO.class)))
	@PostMapping(value = "/usuario", produces = "application/json", consumes = "application/json")
	ResponseEntity<?> crearUsuarioExterno(@RequestBody(required = true) UsuarioExternoDTO usuario);

	/**
	 * CREACION DE USUARIO INTERNO
	 * 
	 * @param usuario
	 * @return
	 */
	@Operation(summary = "Crear Usuario Interno", operationId = "crearUsuarioInterno", description = "Crear Usuario Interno", tags = {
			"UsuarioInterno v1.0", })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UsuarioInternoDTO.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = ResponseDTO.class))) })
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la entidad", content = @Content(schema = @Schema(implementation = UsuarioInternoDTO.class)))
	@PostMapping(value = "/usuarioInterno", produces = "application/json", consumes = "application/json")
	ResponseEntity<?> crearUsuarioInterno(@RequestBody(required = true) UsuarioInternoDTO usuario);

}
