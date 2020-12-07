package ec.ups.edu.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.Pedido_DAO;
import ec.ups.edu.modelo.Pedido;
import ec.ups.edu.modelo.Producto;
import ec.ups.edu.modelo.Usuario;

public class JDBC_Pedido_DAO extends JDBCGenericDAO<Pedido, Integer> implements Pedido_DAO{

	@Override
	public void createTable() {
		//Cambiar por query de Pedido
		jdbc.update("DROP TABLE IF EXISTS Pedido");
		
		//Activado la opcion elimnado en cascada no importa las llaves foraneas 
		jdbc.update("CREATE TABLE Pedido(\r\n" + 
				"	cod_ped int AUTO_INCREMENT,\r\n" + 
				"	estado varchar(10) not null,\r\n" + 
				"	cantidad int null,\r\n" + 
				"	total double null,\r\n" + 
				"	cod_usuario int null,\r\n" + 
				"	cod_producto int null,\r\n" + 				
				"	PRIMARY KEY (cod_ped), \r\n" + 
				"	FOREIGN KEY (cod_usuario)  \r\n" +
				"		REFERENCES  Usuario (cod_usu),\r\n" + 
				"	FOREIGN KEY (cod_producto)  \r\n" +
				"		REFERENCES  Producto (cod_pro)        ON DELETE CASCADE\r\n" + 
				")");
		
	}

	@Override
	public void create(Pedido pedido) {
		
		
		jdbc.update("INSERT INTO Pedido (estado,cantidad,total,cod_usuario,cod_producto) VALUES"
				+" ('" + pedido.getEstado() + "', "
				+ pedido.getCantidad() + ","+pedido.getTotal()
				+ ","+pedido.getUsuario().getCodigo_usu()
				+","+pedido.getProducto().getCodigo_pro()+")");
		
		
	}

	@Override
	public Pedido read(Integer id) {
		
		Pedido p =  null;
		//Aqui pon el query John para la lectura de pedidos... 
		ResultSet rs = jdbc.query("SELECT * FROM Pedido WHERE cod_ped="+id);
		
		try {
			if (rs != null && rs.next()) {
				
						
				//Cambiar por los atributos de la tabla usuario... 
				//Metodo constructor del Usuario, contiene los atributos y hereda de persona
				
				p = new Pedido(rs.getInt("cod_ped"), rs.getString("estado"), rs.getInt("cantidad"), rs.getDouble("total"));
				int us =  rs.getInt("cod_usuario");
				
				//John crear un select para recupar todas el  producto que tiene el pedido mediante el id del producto
				ResultSet rsprod = jdbc.query("SELECT * FROM Producto WHERE cod_pro=" + rs.getInt("cod_producto"));
				if (rsprod != null && rsprod.next()) {
					Producto pro = new Producto(rsprod.getInt("cod_pro"), rsprod.getString("nombre"), rsprod.getDouble("precio")
							, rsprod.getInt("porcentajeIva"), rsprod.getString("url_imagen"), rsprod.getString("descripcion"),rsprod.getString("estado"));
					
					p.setProducto(pro);					
				}
				
				
				//John crear un select para recupar el  usuario al que pertenece el pedido con el codigo del usuario.
				ResultSet rsuser = jdbc.query("SELECT * FROM Usuario WHERE cod_usu=" + us);
				
				
				if (rsuser != null && rsuser.next()) {
					
					Usuario u = new Usuario(rsuser.getInt("cod_usu"), rsuser.getString("correo"), rsuser.getString("password")
							, rsuser.getString("nombre"), rsuser.getString("rol"));
					p.setUsuario(u);
				}

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC_Pedido_DAO:read): " + e.getMessage());
		}
		
		if (p == null) {
			return null;
		}
		return p;
	}

	@Override
	public void update(Pedido pedido) {
		
		//John coloca aqui el query para actulizar a un usuario
		jdbc.update("UPDATE Pedido SET estado='"+ pedido.getEstado() + "',cantidad='"+ pedido.getCantidad() + 
				    "', total='"+ pedido.getTotal() + "',cod_usuario='"+ pedido.getUsuario().getCodigo_usu()
				    + "',cod_producto='"+ pedido.getProducto().getCodigo_pro()+ "' WHERE cod_ped="+pedido.getCodigo_pedido()+"");
		
	}

	@Override
	public void delete(Pedido pedido) {
		
		jdbc.update("DELETE FROM Pedido WHERE (cod_ped = " + pedido.getCodigo_pedido()+") AND cod_usuario="+pedido.getUsuario().getCodigo_usu());
	}

	@Override
	public ArrayList<Pedido> findByUsuarioPedidosCodigo(Integer codigo_usu) {
		
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		Usuario usu = DAOFactory.getFactory().getUsuario_DAO().read(codigo_usu);
		Producto pro = null;
		ArrayList<String> productos = new ArrayList<String>();
		
		int c,p;
		ResultSet rp = jdbc.query("SELECT p.cod_ped, p.estado, p.cantidad, p.total, p.cod_usuario, p.cod_producto \r\n"
				+ "	FROM Pedido p \r\n"
				+ "	WHERE (p.cod_usuario = "+codigo_usu+") AND (p.estado like 'Pendiente')");
		 
			try {
				if (rp != null ) {
					while (rp.next()) {
					
					
						Pedido pedido = new Pedido(rp.getInt("p.cod_ped"), rp.getString("p.estado"), rp.getInt("p.cantidad"), rp.getDouble("p.total"), rp.getInt("p.cod_usuario"), rp.getInt("p.cod_producto"));
						pedidos.add(pedido);
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(">>>WARNING (PedidoDAO):"+e.getMessage());
				System.out.println("Sucedio un problema al buscar los pedidos de un usuario");
			}
			
			
			
			
		return pedidos;
				
				
	}
	
	@Override
	public ArrayList<Pedido> findByAdminPedidosCodigo(Integer codigo_emp) {
		
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		ArrayList<String> productos = new ArrayList<String>();
		
		int c,p;
		ResultSet rp = jdbc.query("SELECT p.cod_ped, p.estado, p.cantidad,p.total,p.cod_usuario,p.cod_producto\r\n"
				+ "FROM Pedido p, Usuario u, Empresa e\r\n"
				+ "WHERE (p.cod_usuario = u.cod_usu) AND (u.cod_empresa = "+codigo_emp+") AND (u.cod_empresa = e.cod_emp);");
		 
			try {
				if (rp != null ) {
					while (rp.next()) {
					
					
						Pedido pedido = new Pedido(rp.getInt("p.cod_ped"), rp.getString("p.estado"), rp.getInt("p.cantidad"), rp.getDouble("p.total"), rp.getInt("p.cod_usuario"), rp.getInt("p.cod_producto"));
						pedidos.add(pedido);
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(">>>WARNING (PedidoDAO):"+e.getMessage());
				System.out.println("Sucedio un problema al buscar los pedidos de un usuario");
			}
			
			
			
			
		return pedidos;
				
				
	}

	@Override
	public ArrayList<Pedido> findByAdminPedidosCodigoPendientes(Integer codigo_emp) {
		
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		ArrayList<String> productos = new ArrayList<String>();
		
		int c,p;
		ResultSet rp = jdbc.query("SELECT p.cod_ped, p.estado, p.cantidad,p.total,p.cod_usuario,p.cod_producto\r\n"
				+ "FROM Pedido p, Usuario u, Empresa e\r\n"
				+ "WHERE (p.cod_usuario = u.cod_usu) AND (u.cod_empresa = "+codigo_emp+") AND (u.cod_empresa = e.cod_emp) AND (p.estado = \"Pendiente\") ;");
		 
			try {
				if (rp != null ) {
					while (rp.next()) {
					
					
						Pedido pedido = new Pedido(rp.getInt("p.cod_ped"), rp.getString("p.estado"), rp.getInt("p.cantidad"), rp.getDouble("p.total"), rp.getInt("p.cod_usuario"), rp.getInt("p.cod_producto"));
						pedidos.add(pedido);
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(">>>WARNING (PedidoDAO):"+e.getMessage());
				System.out.println("Sucedio un problema al buscar los pedidos de un usuario");
			}
			
			
			
			
		return pedidos;
				
				
	}

	
	@Override
	public ArrayList<Pedido> findByUsuarioPedidosCodigoTodos(Integer codigo_usu) {
		
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		Usuario usu = DAOFactory.getFactory().getUsuario_DAO().read(codigo_usu);
		Producto pro = null;
		ArrayList<String> productos = new ArrayList<String>();
		
		int c,p;
		ResultSet rp = jdbc.query("SELECT p.cod_ped, p.estado, p.cantidad, p.total, p.cod_usuario, p.cod_producto \r\n"
				+ "	FROM Pedido p \r\n"
				+ "	WHERE (p.cod_usuario = "+codigo_usu);
		 
			try {
				if (rp != null ) {
					while (rp.next()) {
					
					
						Pedido pedido = new Pedido(rp.getInt("p.cod_ped"), rp.getString("p.estado"), rp.getInt("p.cantidad"), rp.getDouble("p.total"), rp.getInt("p.cod_usuario"), rp.getInt("p.cod_producto"));
						pedidos.add(pedido);
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(">>>WARNING (PedidoDAO):"+e.getMessage());
				System.out.println("Sucedio un problema al buscar los pedidos de un usuario");
			}
			
			
			
			
		return pedidos;
				
				
	}

	
	@Override
	public void createArrayList(ArrayList<Pedido> entity) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Pedido find() {

		return null;
	}

	@Override
	public ArrayList<Pedido> findArrayList() {
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		//Aqui pon el query John para la lectura de la tabla pedidos con el codigo del usuario... 
		
		ResultSet rs = jdbc.query("SELECT * FROM Pedido");
		
		try {
			while (rs.next()) {
				if (rs != null) {
					
					//Cambiar por los atributos de la tabla Pedido... 
					//Metodo constructor del Pedido, contiene los atributos y hereda de persona
					
					
					Pedido p = new Pedido(rs.getInt("cod_ped"), rs.getString("estado"), rs.getInt("cantidad"), rs.getDouble("total"));
					int pr = rs.getInt("cod_producto");
					int us = rs.getInt("cod_usuario");	
					
					
					//John crear un select para recupar todas el  producto que tiene el pedido mediante el id del producto
					ResultSet rsprod = jdbc.query("SELECT * FROM Producto WHERE cod_pro=" + pr);
					
					if (rsprod != null && rsprod.next()) {
						Producto pro = new Producto(rsprod.getInt("cod_pro"), rsprod.getString("nombre"), rsprod.getDouble("precio")
								, rsprod.getInt("porcentajeIva"), rsprod.getString("url_imagen"), rsprod.getString("descripcion"),rsprod.getString("estado"));
						
						
						p.setProducto(pro);					
					}
					
					//John crear un select para recupar el  usuario al que pertenece el pedido con el codigo del usuario.
					ResultSet rsuser = jdbc.query("SELECT * FROM Usuario WHERE cod_usu=" + us);
					
					if (rsuser != null && rsuser.next()) {
						
						Usuario u = new Usuario(rsuser.getInt("cod_usu"), rsuser.getString("correo"), rsuser.getString("password")
								, rsuser.getString("nombre"), rsuser.getString("rol"));
						p.setUsuario(u);
					}

					pedidos.add(p);
					 
				}
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (PedidoDAO:read):"+e.getMessage());
		}
		
		return pedidos;
	}

	@Override
	public void deleteArraysList(ArrayList<Pedido> pedido) {
		if(pedido != null) {
			for (Pedido p : pedido) {
				DAOFactory.getFactory().getPedido_DAO().delete(p);
			}
		}
	}

	@Override
	public void updateArrays(ArrayList<Pedido> entety) {
		// TODO Auto-generated method stub
		
	}

}
