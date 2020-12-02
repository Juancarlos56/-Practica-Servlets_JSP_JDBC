package ec.ups.edu.dao;

import java.util.ArrayList;
import java.util.List;


public interface GenericDAO <T, ID> {
	
	public void createTable();
	public void create(T entity);
	public T read (ID id);
	public void update(T entety);
	public void delete(T entity);
	public T find();
	public ArrayList<T> findArrayList();
	public void createArrayList(ArrayList<T> entity);
	public void deleteArraysList(ArrayList<T> entity);
	public void updateArrays(ArrayList<T> entety);

}


