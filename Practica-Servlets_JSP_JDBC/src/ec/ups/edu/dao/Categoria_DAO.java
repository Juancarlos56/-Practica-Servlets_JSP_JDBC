package ec.ups.edu.dao;
import java.util.ArrayList;

import ec.ups.edu.modelo.Categoria;

public interface Categoria_DAO  extends GenericDAO<Categoria, Integer>{

	public abstract ArrayList<Categoria> findCategoriasEmpresa(int idEmp);

}
