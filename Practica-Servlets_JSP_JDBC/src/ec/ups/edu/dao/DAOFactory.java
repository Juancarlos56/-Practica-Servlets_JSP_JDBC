package ec.ups.edu.dao;

public abstract class DAOFactory {

    protected static DAOFactory factory = new JDBCDAOFactory();
    
    public static DAOFactory getFactory() {
        return factory;
    }

    public void createTables() {
    	
    }
    
    
    public abstract Administrador_DAO getUAdministrador_DAO();
    public abstract Categoria_DAO getCategoria_DAO();
    public abstract Empresa_DAO getEmpresa_DAO();
    public abstract Pedido_DAO getPedido_DAO();
    public abstract Producto_DAO getProducto_DAO();
    public abstract Usuario_DAO getUsuario_DAO();

}