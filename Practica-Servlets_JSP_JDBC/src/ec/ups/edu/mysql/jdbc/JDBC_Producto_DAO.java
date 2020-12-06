package ec.ups.edu.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.Producto_DAO;
import ec.ups.edu.modelo.Pedido;
import ec.ups.edu.modelo.Producto;
import ec.ups.edu.modelo.Usuario;

public class JDBC_Producto_DAO extends JDBCGenericDAO<Producto, Integer> implements Producto_DAO{

	@Override
	public void createTable() {
		jdbc.update("DROP TABLE IF EXISTS Producto");
		
		
		//Aqui pon el query John para la creacion de la TABLA Producto... 
		
		jdbc.update("CREATE TABLE Producto(\r\n" + 
				"	cod_pro int AUTO_INCREMENT,\r\n" + 
				"	nombre varchar(25) not null,\r\n" + 
				"	precio double null,\r\n" + 
				"	porcentajeIva double null,\r\n" + 
				"	url_imagen varchar(255) null,\r\n" + 
				"	descripcion varchar(255) null,\r\n" + 
				"	cod_categoria int null,\r\n" + 
				"	PRIMARY KEY (cod_pro) \r\n" + 
				"	FOREIGN KEY (cod_categoria)\r\n" +
				"		REFERENCES  Categoria (cod_cat)  ON DELETE CASCADE\r\n" + 
				")");
	}

	@Override
	public void create(Producto producto) {
		//Aqui pon el query John para la creacion de un usuario... 
		//Ejemplo INSERT INTO usuarios (nombre, apellidos) VALUES ('Juan','Garcia Pérez');
		//Falta buscar a la empresa
		
		jdbc.update("INSERT INTO Producto (nombre,precio,porcentajeIva,url_imagen,descripcion,estado,cod_categoria) VALUES"
				+" ( '" + producto.getNombre() + "', '"
				+ producto.getPrecio() + "','"+producto.getIva()
				+"','"+producto.getUrl_imagen()+"','"+producto.getDescripcion()+ "','"+ producto.getEstado()+"'," +1+")");
		
	}

	@Override
	public Producto read(Integer id) {
		
		Producto p =  null;
		//Aqui pon el query John para la lectura de Producto... 
		ResultSet rs = jdbc.query("SELECT * FROM Producto WHERE cod_pro="+id);
		
		
	
		try {
			if(rs != null && rs.next()) {
				
				//Cambiar por los atributos de la tabla usuario... 
				//Metodo constructor del Usuario, contiene los atributos y hereda de persona
				p= new Producto(rs.getInt("cod_pro"), rs.getString("nombre"), rs.getDouble("precio")
						, rs.getInt("porcentajeIva"), rs.getString("url_imagen"), rs.getString("descripcion"),rs.getString("estado"));
				
				
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (UserDAO:read):"+e.getMessage());
		}
		
		return p;

	}

	@Override
	public void update(Producto entety) {
		
		//John coloca aqui el query para actulizar a un usuario
		jdbc.update("UPDATE Producto SET nombre='"+ entety.getNombre() + "',precio='"+ entety.getPrecio() + 
				    "', porcentajeIva='"+ entety.getIva() + "',url_imagen='"+ entety.getUrl_imagen() 
				    + "',descripcion='"+ entety.getDescripcion() 
				    + "' WHERE cod_pro="+entety.getCodigo_pro()+"");
				
	}

	@Override
	public void delete(Producto entity) {
		//John colocar el query para la eliminacion de un usuario. 
		jdbc.update("DELETE FROM Producto WHERE cod_pro="+entity.getCodigo_pro());
	}


	@Override
	public void createArrayList(ArrayList<Producto> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArraysList(ArrayList<Producto> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArrays(ArrayList<Producto> entety) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto findByPedidoProductoCodigo(Integer codigo_pro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> findArrayList() {
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		//John colocar el query para obtener todos los usuarios
		
		ResultSet rs = jdbc.query("SELECT * FROM Producto");
		try {
			while (rs.next()) {
				//John Actualizar por los atributos que tiene la base de datos
				
				Producto p= new Producto(rs.getInt("cod_pro"), rs.getString("nombre"), rs.getDouble("precio")
						, rs.getInt("porcentajeIva"), rs.getString("url_imagen"), rs.getString("descripcion"),rs.getString("estado"));
				productos.add(p);
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBC_UsuarioDAO:find): "+e.getMessage());
		}
		return productos;
	}

	@Override
	public Producto findByPedidoPorEmpresa(Integer codigo_pro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Producto findByPedidoProductoNombre(String nombre) {
		Producto p =  null;
		//Aqui pon el query John para la lectura de Producto... 
		ResultSet rs = jdbc.query("SELECT * FROM Producto WHERE nombre LIKE " + nombre + "%");
		
	
		try {
			if(rs != null && rs.next()) {
				
				//Cambiar por los atributos de la tabla usuario... 
				//Metodo constructor del Usuario, contiene los atributos y hereda de persona
				p= new Producto(rs.getInt("cod_pro"), rs.getString("nombre"), rs.getDouble("precio")
						, rs.getInt("porcentajeIva"), rs.getString("url_imagen"), rs.getString("descripcion"),rs.getString("estado"));
				
				
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (UserDAO:findByPedidoProductoNombre):"+e.getMessage());
		}
		
		return p;

	}
	

}
