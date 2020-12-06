package ec.ups.edu.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.Pedido_DAO;
import ec.ups.edu.dao.Usuario_DAO;
import ec.ups.edu.modelo.Pedido;
import ec.ups.edu.modelo.Usuario;

public class JDBC_Usuario_DAO extends JDBCGenericDAO<Usuario, Integer> implements Usuario_DAO{

	@Override
	public void createTable() {
		
		jdbc.update("DROP TABLE IF EXISTS Usuario");
		
		/*john*/
		
		//Aqui pon el query John para la creacion de la TABLA Usuario... 
		/*
		jdbc.update("CREATE TABLE Usuario(\r\n" + 
				"	cod_usu int AUTO_INCREMENT,\r\n" + 
				"	correo varchar(100) not null,\r\n" +
				"	password varchar(50) not null,\r\n" +
				"	nombre varchar(100) not null,\r\n" +
				"	rol varchar(10) not null,\r\n" +
				"	cod_empresa int null,\r\n" + 
				"	PRIMARY KEY (cod_usu), \r\n" + 
				"	FOREIGN KEY (cod_empresa)\r\n" +
				"		REFERENCES  Empresa (cod_emp)\r\n" + 
				")");
		*/
		jdbc.update("CREATE TABLE Usuario(\r\n" + 
				"	cod_usu int AUTO_INCREMENT,\r\n" + 
				"	correo varchar(100) not null,\r\n" +
				"	password varchar(50) not null,\r\n" +
				"	nombre varchar(100) not null,\r\n" +
				"	rol varchar(10) not null,\r\n" +
				"	cod_empresa int null,\r\n" + 
				"	PRIMARY KEY (cod_usu) \r\n" + 
				"	FOREIGN KEY (cod_empresa)\r\n" +
				"		REFERENCES  Empresa (cod_emp)\r\n" + 
				")");
		
		//DAOFactory.getFactory().getPedido_DAO().createTable();
	}

	@Override
	public void create(Usuario user) {
		
		//Aqui pon el query John para la creacion de un usuario... 
		//Ejemplo INSERT INTO usuarios (nombre, apellidos) VALUES ('Juan','Garcia Pérez');
		//Falta buscar a la empresa
		
		DAOFactory.getFactory().getEmpresa_DAO().find();
		jdbc.update("INSERT INTO Usuario (correo,password,nombre,rol,cod_empresa) VALUES"
				+" ( '" + user.getCorreo() + "', '"
				+ user.getPassword() + "','"+user.getNombre()+"','"+user.getRol()+ "','"+1+"' )");
		
	}

	@Override
	public Usuario read(Integer id) {
		Usuario u =  null;
		
		//Aqui pon el query John para la lectura de usuarios... 
		ResultSet rsu = jdbc.query("SELECT * FROM Usuario WHERE cod_usu="+id);
		
		try {
			if(rsu != null && rsu.next()) {
				
				//Cambiar por los atributos de la tabla usuario... 
				//Metodo constructor del Usuario, contiene los atributos y hereda de persona
				u = new Usuario(rsu.getInt("cod_usu"), rsu.getString("correo"), rsu.getString("password")
						, rsu.getString("nombre"), rsu.getString("rol"));
				
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (UserDAO:read):"+e.getMessage());
		}
		
		//Bucar los pedidos asociados con el usuario mediante el id del usuario. 
		if(u == null) return null;
		//ArrayList<Pedido> pedidos = DAOFactory.getFactory().getPedido_DAO().findByUsuarioPedidosCodigo(id);
		

		//if (pedidos != null ) {
			//for (Pedido pedido : pedidos) {
				//u.addPedidos(pedido);
			//}
		//}
		
		return u;
	}

	@Override
	public void update(Usuario user) {
		
		
		//John coloca aqui el query para actulizar a un usuario
		jdbc.update("UPDATE Usuario SET correo='"+ user.getCorreo() + "',password='"+ user.getPassword() + 
				    "', nombre='"+ user.getNombre() + "',rol='"+ user.getRol() + "' WHERE cod_usu="+user.getCodigo_usu()+"");
		
		//Eliminacion de pedidos existentes debido a que el cliente a borrado su lista de pedidos
		//if(user.getPedidos() == null) DAOFactory.getFactory().getPedido_DAO().deleteArraysList(pedidosExistentes);
		//Creacion de la lista de pedidos, sino han existido unos creados previamiente
		//else if (user.getPedidos()  != null && pedidosExistentes == null) DAOFactory.getFactory().getPedido_DAO().createArrayList(user.getPedidos());
		//Actualizacion de la lista de pedidos del Usuario
		//else if (user.getPedidos() != null && pedidosExistentes != null) DAOFactory.getFactory().getPedido_DAO().updateArrays(user.getPedidos());
	}

	@Override
	public void delete(Usuario user) {
		
		//John colocar el query para la eliminacion de un usuario. 
		jdbc.update("DELETE FROM Usuario WHERE cod_usu="+user.getCodigo_usu());
	
	}

	@Override
	public ArrayList<Usuario> findArrayList() {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		//John colocar el query para obtener todos los usuarios
		
		ResultSet rs = jdbc.query("SELECT * FROM Usuario");
		try {
			while (rs.next()) {
				//John Actualizar por los atributos que tiene la base de datos
				
				usuarios.add(new Usuario(rs.getInt("cod_usu"), rs.getString("correo"), rs.getString("password")
						, rs.getString("nombre"), rs.getString("rol")));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBC_UsuarioDAO:find): "+e.getMessage());
		}
		return usuarios;
	}

	@Override
	public void createArrayList(ArrayList<Usuario> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArraysList(ArrayList<Usuario> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArrays(ArrayList<Usuario> entety) {
		// TODO Auto-generated method stub
		
	}

	public Usuario find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario control_logeo(String password, String correo) {
	
		Usuario u = null;
		ResultSet rs = jdbc.query("Select * From Usuario Where correo='"+correo+"' AND password='"+password+"'");
		
		
		try {
			if(rs != null && rs.next()) {
				
				System.out.println("nombre: "+rs.getString("nombre"));
				
				u = new Usuario(rs.getInt("cod_usu"), rs.getString("correo"), rs.getString("password")
						, rs.getString("nombre"), rs.getString("rol"));
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:validarU): " + e.getMessage());
		}
		
		return u;
	}

}
