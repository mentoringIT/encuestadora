package com.mentoring.proyectos.encuesta.model.catalogo;

public enum ResultadoUsuario {

	OK(1, "OK", "El usuario se registro exitosamente"), 
	FALTA_DATO(2, "FALTA DATO", "Falta el nombre de usuario o la contraseña"), 
	USUARIO_EXISTE(3, "USUARIO EXISTE", "Ya existe un registro con ese nombre de usuario"), 
	OTRO_ERROR(4, "OTRO ERROR", "No se pudo completar la operacion, intente mas tarde"),
	ELIMINADO(5, "USUARIO ELIMINADO", "El usuario ha sido eliminado"),
	NO_EXISTE(6, "USUARIO NO EXISTE", "No se pudo identificar al usuario"),
	ACTUALIZADO(7, "USUARIO ACTUALIZADO", "El usuario se actualizo correctamente");
	
	private int codigo;
	
	private String clave;
	
	private String descripcion;

	private ResultadoUsuario(int codigo, String clave, String descripcion) {
		this.codigo = codigo;
		this.clave = clave;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getClave() {
		return clave;
	}

	public String getDescripcion() {
		return descripcion;
	}
		
}