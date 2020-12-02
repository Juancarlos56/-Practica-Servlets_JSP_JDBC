package ec.ups.edu.dao;

import ec.ups.edu.modelo.Empresa;
import ec.ups.edu.modelo.Usuario;

public interface Empresa_DAO  extends GenericDAO<Empresa, Integer>{

	public abstract Empresa empresa_de_un__usuario(Usuario usuario);
}
