/**
 * 
 */
package com.gizlo.ms.usuario.service.ifc;

import java.util.List;

import com.gizlo.ms.usuario.utils.BusinessException;

import om.gizlo.service.component.UsuarioInternoDTO;

/**
 * @author fauob
 *
 */
public interface IUsuarioInternoSvc {
	
	/**
	 * 
	 * @return
	 */
	List<UsuarioInternoDTO> consultarUsuario() throws BusinessException;
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	UsuarioInternoDTO crearUsuario(UsuarioInternoDTO usuario);

}
