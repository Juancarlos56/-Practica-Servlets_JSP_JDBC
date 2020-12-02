package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int codigo_categoria;
	private String nombre;
	private String url;
	private ArrayList<Producto> productos;
	
	
	
	public Categoria() {
		productos = new ArrayList<Producto>();
	}
	
	
	
	
	public Categoria(int codigo_categoria, String nombre, String url) {
		super();
		this.codigo_categoria = codigo_categoria;
		this.nombre = nombre;
		this.url = url;
		this.productos = new ArrayList<Producto>();
	}




	public int getCodigo_categoria() {
		return codigo_categoria;
	}
	public void setCodigo_categoria(int codigo_categoria) {
		this.codigo_categoria = codigo_categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}
	
}
