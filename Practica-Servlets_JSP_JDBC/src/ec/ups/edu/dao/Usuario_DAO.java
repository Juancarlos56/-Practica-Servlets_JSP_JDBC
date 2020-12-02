package ec.ups.edu.dao;

import org.apache.catalina.User;

import ec.ups.edu.modelo.Usuario;

public interface Usuario_DAO  extends GenericDAO<Usuario, Integer>{

	//public abstract Usuario findByCodigoPedido(Integer codigo_pedido);
	
	public abstract Usuario control_logeo(String password, String  correo);
}
