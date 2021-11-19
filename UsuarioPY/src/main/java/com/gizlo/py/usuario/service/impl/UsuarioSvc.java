/**
 * 
 */
package com.gizlo.py.usuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.gizlo.py.usuario.service.ifc.IUsuarioSvc;
import com.gizlo.py.usuario.utils.BusinessException;

import om.gizlo.service.component.TipoUsuarioEnum;
import om.gizlo.service.component.Usuario;
import om.gizlo.service.component.UsuarioExternoDTO;
import om.gizlo.service.component.UsuarioFactory;
import om.gizlo.service.component.UsuarioInternoDTO;

/**
 * @author fauob
 *
 */
@Service
public class UsuarioSvc implements IUsuarioSvc {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UsuarioFactory usuarioFactory;
	
	@Value("${api.host:http://localhost:8080}")
	String apiHost;

	@Override
	public List<Usuario> consultarUsuario(TipoUsuarioEnum tipo) throws BusinessException {
		try {
			return usuarioFactory.getUsuarios(tipo);
		} catch (HttpStatusCodeException e) {
			throw new BusinessException(String.valueOf(e.getRawStatusCode()), e.getMessage());
		} catch (ResourceAccessException e) {
			throw new BusinessException("503", "RECURSO NO ACCESIBLE");
		}

	}

	@Override
	public UsuarioExternoDTO crearUsuarioExterno(UsuarioExternoDTO usuario) throws BusinessException {

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Usuario> request = new HttpEntity<>(usuario, headers);

			ResponseEntity<UsuarioExternoDTO> response = restTemplate.exchange(apiHost.concat("/v1/api/ms/usuarioExterno"),
					HttpMethod.POST, request, UsuarioExternoDTO.class);

			return Optional.ofNullable(response.getBody()).orElseThrow();

		} catch (HttpStatusCodeException e) {
			throw new BusinessException(String.valueOf(e.getRawStatusCode()), e.getMessage());
		} catch (ResourceAccessException e) {
			throw new BusinessException("503", "RECURSO NO ACCESIBLE");
		}
	}

	@Override
	public UsuarioInternoDTO crearUsuarioInterno(UsuarioInternoDTO usuario) throws BusinessException {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Usuario> request = new HttpEntity<>(usuario, headers);

			ResponseEntity<UsuarioInternoDTO> response = restTemplate.exchange(apiHost.concat("/v1/api/ms/usuarioInterno"),
					HttpMethod.POST, request, UsuarioInternoDTO.class);

			return Optional.ofNullable(response.getBody()).orElseThrow();

		} catch (HttpStatusCodeException e) {
			throw new BusinessException(String.valueOf(e.getRawStatusCode()), e.getMessage());
		} catch (ResourceAccessException e) {
			throw new BusinessException("503", "RECURSO NO ACCESIBLE");
		}
	}

}
