package ec.ups.edu.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.Categoria_DAO;
import ec.ups.edu.modelo.Categoria;
import ec.ups.edu.modelo.Pedido;
import ec.ups.edu.modelo.Producto;
import ec.ups.edu.modelo.Usuario;

public class JDBC_Categoria_DAO extends JDBCGenericDAO<Categoria, Integer> implements Categoria_DAO{

	@Override
	public void createTable() {
		
		jdbc.update("DROP TABLE IF EXISTS Categoria");
		
		
		//Aqui pon el query John para la creacion de la TABLA Producto... 
		
		jdbc.update("CREATE TABLE Categoria(\r\n" + 
				"	cod_cat int AUTO_INCREMENT,\r\n" + 
				"	nombre varchar(25) not null,\r\n" + 
				"	url varchar(255) null,\r\n" + 
				"	cod_empresa int null,\r\n" + 
				"	PRIMARY KEY (cod_cat) \r\n" + 
				"	FOREIGN KEY (cod_empresa)\r\n" +
				"		REFERENCES  Empresa (cod_emp)    ON DELETE CASCADE\r\n" + 
				")");
	}

	@Override
	public void create(Categoria entity) {
		
		//Aqui pon el query John para la creacion de un Categoria... 
		//Ejemplo INSERT INTO usuarios (nombre, apellidos) VALUES ('Juan','Garcia Pérez');
		//Falta buscar a la empresa
		
		jdbc.update("INSERT INTO Categoria (nombre,url,cod_empresa) VALUES"
				+" ( '" + entity.getNombre() + "', '"
				+entity.getUrl()+ "',"+1+" )");
	}

	@Override
	public Categoria read(Integer id) {
		
		Categoria c =  null;
		//Aqui pon el query John para la lectura de pedidos... 
		ResultSet rs = jdbc.query("SELECT * FROM Categoria WHERE cod_cat="+id);
		
		try {
			if (rs != null && rs.next()) {
				
						
				//Cambiar por los atributos de la tabla usuario... 
				//Metodo constructor del Usuario, contiene los atributos y hereda de persona
				
				c = new Categoria(rs.getInt("cod_cat"), rs.getString("nombre"), rs.getString("url"));
				
				//John crear un select para recupar todas el  producto que tiene el pedido mediante el id del producto
				ResultSet rsprod = jdbc.query("SELECT * FROM Producto WHERE cod_categoria=" + c.getCodigo_categoria());
				
				while (rsprod.next()) {
					
					if (rsprod != null) {
						
						Producto pro = new Producto(rsprod.getInt("cod_pro"), rsprod.getString("nombre"), rsprod.getDouble("precio")
								, rsprod.getInt("porcentajeIva"), rsprod.getString("url_imagen"), rsprod.getString("descripcion"));
						
						c.addProducto(pro);					
					}
				}
				

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC_Pedido_DAO:read): " + e.getMessage());
		}
		
		if (c == null) {
			return null;
		}
		return c;
	}

	@Override
	public void update(Categoria entety) {
		
		jdbc.update("UPDATE Categoria SET nombre='"+ entety.getNombre() 
				+ "',url='"+ entety.getUrl() + "' WHERE cod_cat="+entety.getCodigo_categoria()+"");
			
	}

	@Override
	public void delete(Categoria entity) {
		//John colocar el query para la eliminacion de un usuario. 
		jdbc.update("DELETE FROM Categoria WHERE cod_cat="+entity.getCodigo_categoria());
	}

	@Override
	public ArrayList<Categoria> findArrayList() {
		
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		Categoria c;
		//Aqui pon el query John para la lectura de la tabla pedidos con el codigo del usuario... 
		
		ResultSet rs = jdbc.query("SELECT * FROM Categoria");
		
		try {
			while (rs.next()) {
				if (rs != null) {
					
					//Cambiar por los atributos de la tabla Pedido... 
					//Metodo constructor del Pedido, contiene los atributos y hereda de persona
					
					c = new Categoria(rs.getInt("cod_cat"), rs.getString("nombre"), rs.getString("url"));
					int em = rs.getInt("cod_emp");	
					
					//John crear un select para recupar todas el  producto que tiene el pedido mediante el id del producto
					ResultSet rsprod = jdbc.query("SELECT * FROM Producto WHERE cod_categoria=" + c.getCodigo_categoria());
					
					while (rsprod.next()) {
						
						if (rsprod != null) {
							
							Producto pro = new Producto(rsprod.getInt("cod_pro"), rsprod.getString("nombre"), rsprod.getDouble("precio")
									, rsprod.getInt("porcentajeIva"), rsprod.getString("url_imagen"), rsprod.getString("descripcion"));
							
							c.addProducto(pro);					
						}
						categorias.add(c);
					}
					 
				}
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (PedidoDAO:read):"+e.getMessage());
		}
		
		return categorias;
	}

	@Override
	public void createArrayList(ArrayList<Categoria> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArraysList(ArrayList<Categoria> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArrays(ArrayList<Categoria> entety) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria find() {
		// TODO Auto-generated method stub
		return null;
	}

}
