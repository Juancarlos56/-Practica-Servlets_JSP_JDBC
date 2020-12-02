package ec.ups.edu.dao;

import ec.ups.edu.modelo.Administrador;

public interface  Administrador_DAO  extends GenericDAO<Administrador, Integer>{

	public abstract Administrador control_logeo_ad(String password, String correo);
	
}
