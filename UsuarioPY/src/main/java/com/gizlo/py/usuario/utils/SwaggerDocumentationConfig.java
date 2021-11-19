/**
 * 
 */
package com.gizlo.py.usuario.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @author fobregon
 *
 */
@Configuration
public class SwaggerDocumentationConfig {
	
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(
				new Info().title("UsuarioPY").description("API PY Usuario")
						.termsOfService("http://www.gizlo.com/termoOfService").version("1.0.0")
						.license(new License().name("Apache 2.0").url("http://www.gnu.org/licenses/gpi-3.0.html"))
						.contact(new Contact().email("info@gizlo.com").name("Gizlo").url("http://www.gizlo.com")));
	}

}
