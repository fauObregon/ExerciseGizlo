/**
 * 
 */
package com.gizlo.ms.usuario.utils;

import org.modelmapper.ModelMapper;

import com.gizlo.ms.usuario.model.UsuarioExterno;
import com.gizlo.ms.usuario.model.UsuarioInterno;

import om.gizlo.service.component.UsuarioExternoDTO;
import om.gizlo.service.component.UsuarioInternoDTO;

/**
 * @author fauob
 *
 */
public final class UsuarioConvert {

	private UsuarioConvert() {

	}

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public static UsuarioInterno toModel(UsuarioInternoDTO dto) {
		return new ModelMapper().map(dto, UsuarioInterno.class);

	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public static UsuarioInternoDTO toDTO(UsuarioInterno model) {
		return new ModelMapper().map(model, UsuarioInternoDTO.class);
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public static UsuarioExterno toModel(UsuarioExternoDTO dto) {
		return new ModelMapper().map(dto, UsuarioExterno.class);

	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public static UsuarioExternoDTO toDTO(UsuarioExterno model) {
		return new ModelMapper().map(model, UsuarioExternoDTO.class);
	}

}
