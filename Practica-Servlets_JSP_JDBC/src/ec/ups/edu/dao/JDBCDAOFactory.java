package ec.ups.edu.dao;

import ec.ups.edu.mysql.jdbc.JDBC_Administrador_DAO;
import ec.ups.edu.mysql.jdbc.JDBC_Categoria_DAO;
import ec.ups.edu.mysql.jdbc.JDBC_Empresa_DAO;
import ec.ups.edu.mysql.jdbc.JDBC_Pedido_DAO;
import ec.ups.edu.mysql.jdbc.JDBC_Producto_DAO;
import ec.ups.edu.mysql.jdbc.JDBC_Usuario_DAO;

public class JDBCDAOFactory extends DAOFactory{
	
	
	@Override public void createTables() {
		this.getCategoria_DAO().createTable();
		this.getEmpresa_DAO().createTable();
		this.getPedido_DAO().createTable();
		this.getProducto_DAO().createTable();
		this.getUAdministrador_DAO().createTable();
		this.getUsuario_DAO().createTable();
	}
	
	
	@Override
	public Administrador_DAO getUAdministrador_DAO() {
		return new JDBC_Administrador_DAO();
	}
	
	@Override
	public Categoria_DAO getCategoria_DAO() {
		return new JDBC_Categoria_DAO();
	}
	
	@Override
	public Empresa_DAO getEmpresa_DAO() {
		return new JDBC_Empresa_DAO();
	}
	
	@Override
	public Pedido_DAO getPedido_DAO() {
		return new JDBC_Pedido_DAO();
	}
	
	
	@Override
	public Producto_DAO getProducto_DAO() {
		return new JDBC_Producto_DAO();
	}
	@Override
	public Usuario_DAO getUsuario_DAO() {
		return new JDBC_Usuario_DAO();
	}
}
