/**
 * 
 */
package om.gizlo.service.component;

/**
 * @author fauob
 *
 */
public class UsuarioFactory {
	
	public static Usuario getUsuario(TipoUsuarioEnum tipo) {
		Usuario usuario = null;
		switch (tipo) {
		case INTERNO:
			usuario = new UsuarioInternoDTO();
			break;

		case EXTERNO:
			usuario = new UsuarioExternoDTO();
			break;
		default:
			break;
		}
		return usuario;
	}
	
	

}
