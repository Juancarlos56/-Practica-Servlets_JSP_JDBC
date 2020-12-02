package ec.ups.edu.mysql.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.Administrador_DAO;
import ec.ups.edu.modelo.Administrador;
public class JDBC_Administrador_DAO extends JDBCGenericDAO<Administrador, Integer> implements Administrador_DAO{

	@Override
	public void createTable() {
		jdbc.update("DROP TABLE IF EXISTS Administrador");
		jdbc.update("CREATE TABLE Administrador(\r\n"
					+ "cod_admin int AUTO_INCREMENT,\r\n"
					+ "correo varchar(100) not null,\r\n"
					+ "password varchar(50) not null,\r\n"
					+ "nombre varchar(100) not null,\r\n"
					+ "rol varchar(10) not null,\r\n"
					+ "cod_empresa int null,\r\n"
					+ "PRIMARY KEY (cod_admin)\r\n"
					+ ")");
	}

	@Override
	public void create(Administrador entity) {
		
		jdbc.update("INSERT INTO Administrador (correo, password,nombre,rol, cod_empresa VALUES"
				+ "( '" + entity.getCorreo() + " ',' "
				+ entity.getPassword() + " ',' " + entity.getNombre() + " ',' " + entity.getRol() + " ',' " + 1 + "')");
		
	}

	@Override
	public Administrador read(Integer id) {
		Administrador ad = null;
		ResultSet rs = jdbc.query("SELECT * FROM Administrador WHERE cod_admin="+id);
		
		try {
			if (rs != null && rs.next()) {
				ad = new Administrador(rs.getInt("cod_admin"), rs.getString("correo"), rs.getString("password")
						, rs.getString("nombre"), rs.getString("rol") );
			
			}
		} catch (Exception e) {
			System.out.println(">>>>WARNING (AdministradorDAO:read): " + e.getMessage());
		}
		
		if (ad == null) return null;
		return ad;
		
	}

	

	@Override
	public void delete(Administrador entity) {
		jdbc.update("DELETE FROM Administrador WHERE cod_admin=" + entity.getCodigo_admin());
		
	}

	@Override
	public ArrayList<Administrador> findArrayList() {
		
		ArrayList<Administrador> administradores = new ArrayList<Administrador>();
		
		ResultSet rs = jdbc.query("SELECT * FROM Administrador");
		
		try {
			while (rs.next()) {
				administradores.add(new Administrador(rs.getInt("cod_admin"), rs.getString("correo"), rs.getString("password")
						, rs.getString("nombre"), rs.getString("rol")));
			}
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBC_AdministradorDAO:find):" + e.getMessage());
		}
		return administradores;
	}

	@Override
	public Administrador find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createArrayList(ArrayList<Administrador> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArraysList(ArrayList<Administrador> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArrays(ArrayList<Administrador> entety) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrador control_logeo_ad(String password, String correo) {
		Administrador ad = null;
		ResultSet rs = jdbc.query("Select * From Adminiistrador WHERE correo=" + correo +"'AND password='" + password + "'");
		return ad;
	}

	@Override
	public void update(Administrador entety) {
		//jdbc.update("UPDATE Adminnistrador SET correo='" + entety.getCorreo() + "',password='" + entety.getPassword() + 
		//		"', nombre='" + entety.getNombre() + "',rol='" + entety.getRol(), "' WHERE cod_admin=" + entety.getCodigo_admin());
		
	}

}
