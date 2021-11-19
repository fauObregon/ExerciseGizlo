/**
 * 
 */
package com.gizlo.ms.usuario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gizlo.ms.usuario.model.UsuarioInterno;
import com.gizlo.ms.usuario.repository.ifc.IUsuarioInternoRepository;
import com.gizlo.ms.usuario.service.ifc.IUsuarioInternoSvc;
import com.gizlo.ms.usuario.utils.BusinessException;
import com.gizlo.ms.usuario.utils.UsuarioConvert;

import om.gizlo.service.component.UsuarioInternoDTO;

/**
 * @author fauob
 *
 */
@Service
public class UsuarioInternoSvcImpl implements IUsuarioInternoSvc {
	
	@Autowired
	IUsuarioInternoRepository repository; 

	@Override
	public List<UsuarioInternoDTO> consultarUsuario() throws BusinessException {
		List<UsuarioInterno> listUsuario = repository.findAll();
		if (listUsuario.isEmpty()) {
			throw new BusinessException("404", "NO HAY DATOS");
		}	
		return listUsuario.stream().map(UsuarioConvert::toDTO).collect(Collectors.toList());
	}

	@Override
	public UsuarioInternoDTO crearUsuario(UsuarioInternoDTO usuario) {
		
		usuario.setId(null);
		
		UsuarioInterno usuarioModel = UsuarioConvert.toModel(usuario);
		return UsuarioConvert.toDTO(repository.insert(usuarioModel));

		
	}

}
