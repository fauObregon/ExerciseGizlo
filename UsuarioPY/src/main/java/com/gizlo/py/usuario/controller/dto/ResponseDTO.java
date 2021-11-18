/**
 * 
 */
package com.gizlo.py.usuario.controller.dto;

/**
 * @author fauob
 *
 */
public class ResponseDTO {

	private String codigo;
	private String descripcion;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ResponseDTO codigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ResponseDTO descripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

}
