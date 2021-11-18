/**
 * 
 */
package com.gizlo.ms.usuario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gizlo.ms.usuario.model.UsuarioExterno;
import com.gizlo.ms.usuario.repository.ifc.IUsuarioExternoRepository;
import com.gizlo.ms.usuario.service.ifc.IUsuarioExternoSvc;
import com.gizlo.ms.usuario.utils.BusinessException;
import com.gizlo.ms.usuario.utils.UsuarioConvert;

import om.gizlo.service.component.UsuarioExternoDTO;

/**
 * @author fauob
 *
 */
@Service
public class UsuarioExternoSvcImpl implements IUsuarioExternoSvc {
	
	@Autowired
	IUsuarioExternoRepository repository;

	@Override
	public List<UsuarioExternoDTO> consultarUsuario() throws BusinessException {
		
		List<UsuarioExterno> listUsuario = repository.findAll();
		if (listUsuario.isEmpty()) {
			throw new BusinessException("404", "NO HAY DATOS");
		}
		
		return listUsuario.stream().map(UsuarioConvert::toDTO).collect(Collectors.toList());
	}

	@Override
	public UsuarioExternoDTO crearUsuario(UsuarioExternoDTO usuario) {
		
		usuario.setId(null);
		
		UsuarioExterno usuarioModel = UsuarioConvert.toModel(usuario);
		return UsuarioConvert.toDTO(repository.insert(usuarioModel));
		
	}

}
