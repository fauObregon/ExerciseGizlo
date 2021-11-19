/**
 * 
 */
package com.gizlo.py.usuario.service.ifc;

import java.util.List;

import com.gizlo.py.usuario.utils.BusinessException;

import om.gizlo.service.component.TipoUsuarioEnum;
import om.gizlo.service.component.Usuario;
import om.gizlo.service.component.UsuarioExternoDTO;
import om.gizlo.service.component.UsuarioInternoDTO;

/**
 * @author fauob
 *
 */
public interface IUsuarioSvc {

	/**
	 * 
	 * @return
	 */
	List<Usuario> consultarUsuario(TipoUsuarioEnum tipo) throws BusinessException;
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	UsuarioExternoDTO crearUsuarioExterno(UsuarioExternoDTO usuario) throws BusinessException;
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	UsuarioInternoDTO crearUsuarioInterno(UsuarioInternoDTO usuario) throws BusinessException;
}
