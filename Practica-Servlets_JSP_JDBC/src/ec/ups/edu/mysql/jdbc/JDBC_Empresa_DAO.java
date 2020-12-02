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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Empresa entety) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Empresa entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Empresa> findArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createArrayList(ArrayList<Empresa> entity) {
		// TODO Auto-generated method stub
		
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

	@Override
	public Empresa empresa_de_un__usuario(Usuario usuario) {
		Empresa em = null;
		try {
			ResultSet rs = jdbc.query("Select * From Usuario Where cod_usu="+usuario.getCodigo_usu()+"");
			int codUsuEmp = rs.getInt("cod_empresa");
			
			if(rs != null && rs.next()) {
				System.out.println("Si existe un usuario con ese codigo"+codUsuEmp);
				ResultSet rsem = jdbc.query("Select * From Empresa Where cod_emp ="+codUsuEmp+";");
				
				if(rsem != null && rsem.next()) {
					
					em = new Empresa(rsem.getInt("cod_emp"), rsem.getString("nombre"), rsem.getString("horario"),
							rsem.getString("descripcion"), rsem.getString("logoURL")); 
					System.out.println("Si existe la Empresa: "+em.getNombre());
					//Proceso de revision
				}else {
					System.out.println("NO existe una empresa");
				}
			}else {
				
				System.out.println("NO existe una empresa");
				
			}
		}catch(SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:validarU): " + e.getMessage());
		}
		
		return em;
	}

}
