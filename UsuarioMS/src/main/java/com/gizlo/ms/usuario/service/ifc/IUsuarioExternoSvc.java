/**
 * 
 */
package com.gizlo.ms.usuario.service.ifc;

import java.util.List;

import com.gizlo.ms.usuario.utils.BusinessException;

import om.gizlo.service.component.UsuarioExternoDTO;

/**
 * @author fauob
 *
 */
public interface IUsuarioExternoSvc {
	
	/**
	 * 
	 * @return
	 */
	List<UsuarioExternoDTO> consultarUsuario() throws BusinessException;
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	UsuarioExternoDTO crearUsuario(UsuarioExternoDTO usuario);

}
