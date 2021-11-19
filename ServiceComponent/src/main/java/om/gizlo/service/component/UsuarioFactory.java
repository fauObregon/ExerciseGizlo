/**
 * 
 */
package om.gizlo.service.component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author fauob
 *
 */
@Component
public class UsuarioFactory {
	
	@Value("${api.host:localhost}")
	String apiHost;
	
	public List<Usuario> getUsuarios(TipoUsuarioEnum tipo)  {
		
		
		List<Usuario> usuarios = null;
				
		if(TipoUsuarioEnum.EXTERNO.equals(tipo)) {
			ResponseEntity<List<UsuarioExternoDTO>> response = new  RestTemplate().exchange(apiHost.concat("/v1/api/ms/usuarioExterno"),
					HttpMethod.GET, null, new ParameterizedTypeReference<List<UsuarioExternoDTO>>() {
					});
			
			usuarios = Optional.ofNullable(response.getBody()).orElseThrow().stream().collect(Collectors.toList());
		}else {
			ResponseEntity<List<UsuarioInternoDTO>> response = new  RestTemplate().exchange(apiHost.concat("/v1/api/ms/usuarioInterno"),
					HttpMethod.GET, null, new ParameterizedTypeReference<List<UsuarioInternoDTO>>() {
					});
			
			usuarios = Optional.ofNullable(response.getBody()).orElseThrow().stream().collect(Collectors.toList());
		}
		return usuarios;
	}
	
	

}
