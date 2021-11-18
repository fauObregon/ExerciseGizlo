package om.gizlo.service.component;
/**
 * 
 */

/**
 * @author fauob
 *
 */
public class UsuarioExternoDTO extends Usuario {	

	private String nacionalidad;
	private String genero;
	private Double estatura;

	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the estatura
	 */
	public Double getEstatura() {
		return estatura;
	}

	/**
	 * @param estatura the estatura to set
	 */
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	

}
