package ec.ups.edu.modelo;

import java.io.Serializable;

public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo;
	private String password;
	private String nombre;
	private String rol;
	
	public Persona() {
		super();
	}
	
	
	
	public Persona(String correo, String password, String nombre, String rol) {
		super();
		this.correo = correo;
		this.password = password;
		this.nombre = nombre;
		this.rol = rol;
	}



	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return "Persona [correo=" + correo + ", password=" + password + ", nombre=" + nombre + ", rol=" + rol + "]";
	}
	
}
