package ec.ups.edu.dao;


import java.util.ArrayList;

import ec.ups.edu.modelo.Pedido;

public interface Pedido_DAO  extends GenericDAO<Pedido, Integer>{

	public abstract ArrayList<Pedido> findByUsuarioPedidosCodigo(Integer codigo_usu);
}
