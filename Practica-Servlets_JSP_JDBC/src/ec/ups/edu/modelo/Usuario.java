package ec.ups.edu.modelo;

import java.util.ArrayList;

public class Usuario extends Persona{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo_usu;
	

	public Usuario() {
		super();
	}

	
	
	public Usuario(int codigo_usu, String correo, String password, String nombre, String rol) {
		super(correo, password, nombre, rol);
		// TODO Auto-generated constructor stub
		this.codigo_usu = codigo_usu;
	}

	

	public int getCodigo_usu() {
		return codigo_usu;
	}

	public void setCodigo_usu(int codigo_usu) {
		this.codigo_usu = codigo_usu;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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



	@Override
	public String toString() {
		return "Usuario [codigo_usu=" + codigo_usu +", Nombre= "+getNombre()
		+", Password= "+getPassword()+", Correo= "+getCorreo()+", ROL= "+getRol()+ "]";
	}
	
	
	
}
