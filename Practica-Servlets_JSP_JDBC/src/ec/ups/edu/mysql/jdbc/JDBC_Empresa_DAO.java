package ec.ups.edu.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.dao.Empresa_DAO;
import ec.ups.edu.modelo.Administrador;
import ec.ups.edu.modelo.Empresa;
import ec.ups.edu.modelo.Producto;
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
	
	@Override
	public Empresa empresa_de_un_admin(Administrador admin) {
		Empresa em = null;
		ResultSet rs = jdbc.query("Select * From Administrador Where cod_amd="+admin.getCodigo_admin()+"");
		
		
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
			System.out.println(">>>WARNING (JDBCAdministraddorDAO:validarAdmin): " + e.getMessage());
		}
		
		return em;
	}

	@SuppressWarnings("null")
	@Override
	public ArrayList<Producto> productosEmpresa(String nombreProducto, int idEmpresa) {
		
		ArrayList<Producto> prod = new ArrayList<Producto>();
		
		
		Producto p = null;
		
		System.out.println("Nombre producto: "+nombreProducto+" id Empresa: "+idEmpresa);
		
		
		
		ResultSet pe = jdbc.query("SELECT  p.cod_pro, p.nombre, p.precio, p.porcentajeIva, p.url_imagen, p.descripcion \r\n"
				+ "            FROM Producto p, Categoria c, Empresa e \r\n"
				+ "            WHERE p.nombre LIKE '%"+nombreProducto+"%' AND c.cod_cat = p.cod_categoria AND c.cod_empresa = "+idEmpresa+" AND e.cod_emp = "+idEmpresa+"\r\n"
				+ "");
		
		try {
			if (pe != null) {
				while (pe.next()) {
					System.out.println("Aquiiiiii.....");
					p = new Producto(pe.getInt("p.cod_pro"), pe.getString("p.nombre"), pe.getDouble("p.precio"), pe.getInt("p.porcentajeIva"), pe.getString("p.url_imagen"), pe.getString("p.descripcion"));
					prod.add(p);
				}
			}
			
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBC_EmpresaDAO:find): " + e.getMessage());
		}
		
		
		return prod;
	}
	
	
public ArrayList<Producto> todosLosProductosEmpresa(int idEmpresa) {
		
		ArrayList<Producto> prod = new ArrayList<Producto>();
		
		
		Producto p = null;
		
		System.out.println("id Empresa: "+idEmpresa);
		
		ResultSet pe = jdbc.query("SELECT  p.cod_pro, p.nombre, p.precio, p.porcentajeIva, p.url_imagen, p.descripcion, p.cod_categoria, e.cod_emp \r\n"
				+ "            FROM Producto p, Categoria c, Empresa e \r\n"
				+ "            WHERE (e.cod_emp ="+idEmpresa+") AND (c.cod_empresa = "+idEmpresa+") \r\n"
				+ "");
		
		
		try {
			if (pe != null) {
				while (pe.next()) {
					p = new Producto(pe.getInt("p.cod_pro"), pe.getString("p.nombre"), pe.getDouble("p.precio"), pe.getInt("p.porcentajeIva"), pe.getString("p.url_imagen"), pe.getString("p.descripcion"));
					prod.add(p);
				}
			}
			
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBC_EmpresaDAO:find): " + e.getMessage());
		}
		
		
		return prod;
	}
}
