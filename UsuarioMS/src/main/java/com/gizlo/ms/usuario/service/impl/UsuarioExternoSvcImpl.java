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

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioExternoSvcImpl.class);

	@Autowired
	IUsuarioExternoRepository repository;

	@Override
	public List<UsuarioExternoDTO> consultarUsuario() throws BusinessException {

		LOG.info("INICIA LOGICA DE NEGOCIO PARA CONSULTAR USUARIO");

		List<UsuarioExterno> listUsuario = repository.findAll();
		if (listUsuario.isEmpty()) {
			throw new BusinessException("404", "NO HAY DATOS");
		}

		List<UsuarioExternoDTO> listUsuariosDTO = listUsuario.stream().map(UsuarioConvert::toDTO)
				.collect(Collectors.toList());
		
		LOG.info("FINALIZA LOGICA DE NEGOCIO PARA CONSULTAR USUARIO");
		return listUsuariosDTO;
	}

	@Override
	public UsuarioExternoDTO crearUsuario(UsuarioExternoDTO usuario) {
		LOG.info("INICIA LOGICA DE NEGOCIO PARA CREAR USUARIO");

		usuario.setId(null);

		UsuarioExterno usuarioModel = repository.insert(UsuarioConvert.toModel(usuario));
		UsuarioExternoDTO usuarioDTO = UsuarioConvert.toDTO(usuarioModel);
		
		LOG.info("FINALIZA LOGICA DE NEGOCIO PARA CREAR USUARIO");
		return usuarioDTO;

	}

}
