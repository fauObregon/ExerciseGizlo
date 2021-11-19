/**
 * 
 */
package com.gizlo.py.usuario.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import om.gizlo.service.component.UsuarioFactory;

/**
 * @author fauob
 *
 */
@Configuration
public class BeansConfig {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	UsuarioFactory usuarioFactory() {
		return new UsuarioFactory();
	}

}
