package ec.ups.edu.modelo;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo_admin;
	private Empresa empresa; 

	public Administrador() {
		this.empresa = empresa;
	}
	
	

	public Administrador(int codigo_admin, String correo, String password, String nombre, String rol) {
		super(correo, password, nombre, rol);
		this.codigo_admin = codigo_admin;
		this.empresa = empresa;
	}




	public int getCodigo_admin() {
		return codigo_admin;
	}

	public void setCodigo_admin(int codigo_admin) {
		this.codigo_admin = codigo_admin;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Administrador [codigo_admin=" + codigo_admin + ", empresa=" + empresa + "]";
	}
	
	

	public String getCorreo() {
		return super.getCorreo();
	}
	
	public void setCorreo(String correo) {
		super.setCorreo(correo);
	}
	
	public String getPassword() {
		return super.getPassword();
	}
	
	public void setPassword(String password) {
		super.setPassword(password);
	}
	
	public String getNombre() {
		return super.getNombre();
	}


	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}

	

	public String getRol() {
		return super.getRol();
	}


	public void setRol(String rol) {
		super.setRol(rol);
	}
	
	
}
