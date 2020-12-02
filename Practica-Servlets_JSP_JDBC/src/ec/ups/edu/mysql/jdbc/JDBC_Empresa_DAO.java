package ec.ups.edu.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.Empresa_DAO;
import ec.ups.edu.modelo.Empresa;
import ec.ups.edu.modelo.Usuario;

public class JDBC_Empresa_DAO extends JDBCGenericDAO<Empresa, Integer> implements Empresa_DAO{

	@Override
	public void createTable() {
		jdbc.update("CREATE TABLE Empresa(\r\n" + 
				"	cod_emp int AUTO_INCREMENT,\r\n" + 
				"	nombre varchar(100) not null,\r\n" +
				"	horario varchar(50) not null,\r\n" +
				"	descripcion varchar(100) not null,\r\n" +
				"	logoURL varchar(10) not null,\r\n" +
				"	PRIMARY KEY (cod_emp) \r\n" + 
				")");
	}
	
	@Override
	public void create(Empresa entity) {
		jdbc.update("INSERT INTO Categoria (nombre,url,horario, descripcion) VALUES"
				+" ( '" + entity.getNombre() + "', '"
				+entity.getLogo_url()+ "',"
				+"'" + entity.getHorario() + "', '"
				+"'" + entity.getDescripcion()+" )");
	}

	@Override
	public Empresa read(Integer id) {
		Empresa emp = null;
		
		ResultSet rs = jdbc.query("SELECT * FROM Empresa WHERE cod_emp=" + id);
		
		try {
			if (rs != null && rs.next()) {
				emp = new Empresa(rs.getInt("cod_emp"), rs.getString("nombre"), rs.getString("horario"), rs.getString("descripcion")
						, rs.getString("logoURL"));
			}
		} catch (Exception e) {
			System.out.println(">>>WARNING (EmpresaDAO:read):" + e.getMessage());
		}
		
		return emp;
	}

	@Override
	public void update(Empresa entety) {
		jdbc.update("UPDATE Empresa SET nombre='" + entety.getNombre() +  "',horario='" + entety.getHorario() + "',descripcion='" + entety.getDescripcion()
		+ "',logoURL='" + entety.getLogo_url() + "' WHERE cod_emp=" + entety.getCodigo_empresa());
	}

	@Override
	public void delete(Empresa entity) {
		jdbc.update("DELETE FROM Empresa WHERE cod_emp=" + entity.getCodigo_empresa());
	}

	@Override
	public ArrayList<Empresa> findArrayList() {
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		
		ResultSet rs = jdbc.query("SELECT * FROM Empresa");
		try {
			while (rs.next()) {
				empresas.add(new Empresa(rs.getInt("cod_emp"), rs.getString("nombre"), rs.getString("horario"), rs.getString("descripcion")
										,rs.getString("logoURL")));
			}
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBC_EmpresaDAO:find): " + e.getMessage());
		}
		
		return empresas;
	}

	@Override
	public void createArrayList(ArrayList<Empresa> entity) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Empresa empresa_de_un__usuario(Usuario usuario) {
		Empresa em = null;
		ResultSet rs = jdbc.query("Select * From Usuario Where cod_usu="+usuario.getCodigo_usu()+"");
		
		
		try {
			if(rs != null && rs.next()) {
				
				ResultSet rsem = jdbc.query("Select * From Empresa Where cod_emp ="+rs.getInt("cod_empresa"));
				
				if(rsem != null && rsem.next()) {
					em = new Empresa(rsem.getInt("cod_emp"), rsem.getString("nombre"), rsem.getString("horario"),
							rsem.getString("descripcion"), rsem.getString("logoURL")); 
					
					//Proceso de revision
				}
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:validarU): " + e.getMessage());
		}
		
		return em;
	}
	
	@Override
	public Empresa findByNombreEmpresa(String nombre) {
		Empresa emp = null;
		
		ResultSet rs = jdbc.query("SELECT * FROM Empresa WHERE nombre LIKE" + nombre + "%");
		
		try {
			if (rs != null && rs.next()) {
				emp = new Empresa(rs.getInt("cod_emp"), rs.getString("nombre"), rs.getString("horario"), rs.getString("descripcion")
						, rs.getString("logoURL"));
			}
		} catch (Exception e) {
			System.out.println(">>>WARNING (EmpresaDAO:findByNombreEmpresa):" + e.getMessage());
		}
		
		return emp;

	}

	@Override
	public void deleteArraysList(ArrayList<Empresa> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArrays(ArrayList<Empresa> entety) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empresa find() {
		// TODO Auto-generated method stub
		return null;
	}

}
