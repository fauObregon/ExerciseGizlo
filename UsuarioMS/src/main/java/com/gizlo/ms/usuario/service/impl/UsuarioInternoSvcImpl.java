/**
 * 
 */
package com.gizlo.ms.usuario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioInternoSvcImpl.class);

	@Autowired
	IUsuarioInternoRepository repository; 

	@Override
	public List<UsuarioInternoDTO> consultarUsuario() throws BusinessException {
		LOG.info("INICIA LOGICA DE NEGOCIO PARA CONSULTAR USUARIO");
		
		List<UsuarioInterno> listUsuario = repository.findAll();
		if (listUsuario.isEmpty()) {
			throw new BusinessException("404", "NO HAY DATOS");
		}	
		
		List<UsuarioInternoDTO> listUsuariosDTO = listUsuario.stream().map(UsuarioConvert::toDTO)
				.collect(Collectors.toList());
		
		LOG.info("FINALIZA LOGICA DE NEGOCIO PARA CONSULTAR USUARIO");
		return listUsuariosDTO;
	}

	@Override
	public UsuarioInternoDTO crearUsuario(UsuarioInternoDTO usuario) {
		LOG.info("INICIA LOGICA DE NEGOCIO PARA CREAR USUARIO");
		
		usuario.setId(null);
		
		UsuarioInterno usuarioModel = repository.insert(UsuarioConvert.toModel(usuario));
		UsuarioInternoDTO usuarioDTO = UsuarioConvert.toDTO(usuarioModel);
		
		LOG.info("FINALIZA LOGICA DE NEGOCIO PARA CREAR USUARIO");
		return usuarioDTO;

		
	}

}
