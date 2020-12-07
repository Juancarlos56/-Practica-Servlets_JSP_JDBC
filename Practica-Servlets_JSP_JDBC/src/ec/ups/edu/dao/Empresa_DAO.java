package ec.ups.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import ec.ups.edu.modelo.Administrador;
import ec.ups.edu.modelo.Empresa;
import ec.ups.edu.modelo.Producto;
import ec.ups.edu.modelo.Usuario;

public interface Empresa_DAO  extends GenericDAO<Empresa, Integer>{

	public abstract Empresa empresa_de_un__usuario(Usuario usuario);

	public abstract Empresa findByNombreEmpresa(String nombre);

	public abstract Empresa empresa_de_un_admin(Administrador admin);
	
	public abstract ArrayList<Producto> productosEmpresa(String nombreProducto, int idEmpresa);

	public abstract ArrayList<Producto> productosEmpresaTodos(String nombreProducto, int idEmpresa);
}
