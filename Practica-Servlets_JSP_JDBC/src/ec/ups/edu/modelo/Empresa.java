package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int codigo_empresa;
	private String nombre;
	private String horario;
	private String descripcion;
	private String logo_url;
	private ArrayList<Usuario> usuarios; 
	private ArrayList<Categoria> categorias;
	
	
	
	
	public Empresa() {
		usuarios = new ArrayList<Usuario>();
		categorias = new ArrayList<Categoria>();
	}
	
	
	
	
	public Empresa(int codigo_empresa, String nombre, String horario, String descripcion, String logo_url) {
		super();
		this.codigo_empresa = codigo_empresa;
		this.nombre = nombre;
		this.horario = horario;
		this.descripcion = descripcion;
		this.logo_url = logo_url;
		this.usuarios = new ArrayList<Usuario>();
		this.categorias = new ArrayList<Categoria>();
	}




	public int getCodigo_empresa() {
		return codigo_empresa;
	}
	public void setCodigo_empresa(int codigo_empresa) {
		this.codigo_empresa = codigo_empresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public void addUsuarios(Usuario usuario) {
		this.usuarios.add(usuario); 
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	public void addCategoria(Categoria categoria) {
		this.categorias.add(categoria); 
	}
	
	
	@Override
	public String toString() {
		return "Empresa [codigo_empresa=" + codigo_empresa + ", nombre=" + nombre + ", horario=" + horario
				+ ", descripcion=" + descripcion + ", logo_url=" + logo_url + ", usuarios=" + usuarios + ", categorias="
				+ categorias + "]";
	} 
	
	
	
}
