/**
 * 
 */
package com.gizlo.py.usuario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gizlo.py.usuario.service.ifc.IUsuarioSvc;
import com.gizlo.py.usuario.utils.BusinessException;

import om.gizlo.service.component.TipoUsuarioEnum;
import om.gizlo.service.component.Usuario;
import om.gizlo.service.component.UsuarioExternoDTO;

/**
 * @author fauob
 *
 */
@Service
public class UsuarioSvc implements IUsuarioSvc {

	@Autowired
	RestTemplate restTemplate;

	private static final String BASE_PATH = "http://localhost:8080/v1/api/ms";

	@Override
	public List<Usuario> consultarUsuario(TipoUsuarioEnum tipo) throws BusinessException {

		String contextResource = TipoUsuarioEnum.EXTERNO.equals(tipo) ? "/usuarioExterno" : "/usuarioInterno";

		ResponseEntity<List<UsuarioExternoDTO>> response = restTemplate.exchange(BASE_PATH.concat(contextResource),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<UsuarioExternoDTO>>() {
				});
		
		List<Usuario> listUser = response.getBody().stream().collect(Collectors.toList());

		return listUser;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		
		String contextResource = TipoUsuarioEnum.EXTERNO.equals(usuario.getTipo()) ? "/usuarioExterno" : "/usuarioInterno";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		HttpEntity<Usuario> request = new HttpEntity<>(usuario, headers);

		ResponseEntity<UsuarioExternoDTO> response = restTemplate.exchange(BASE_PATH.concat(contextResource),
				HttpMethod.POST, request, UsuarioExternoDTO.class);

		
		return response.getBody();
	}

}
