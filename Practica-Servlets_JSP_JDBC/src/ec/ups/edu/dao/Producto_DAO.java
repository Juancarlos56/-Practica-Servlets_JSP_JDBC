package ec.ups.edu.dao;

import java.util.ArrayList;

import ec.ups.edu.modelo.Pedido;
import ec.ups.edu.modelo.Producto;

public interface Producto_DAO  extends GenericDAO<Producto, Integer>{

	public abstract Producto findByPedidoProductoCodigo(Integer codigo_pro);
	public abstract Producto findByPedidoPorEmpresa(Integer codigo_pro);
	
}
