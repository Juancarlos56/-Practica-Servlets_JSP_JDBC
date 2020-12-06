package ec.ups.edu.modelo;

public class Producto {

	private int codigo_pro;
	private String nombre;
	private Double precio;
	private int iva;
	private String url_imagen;
	private String descripcion;
	private String estado;
	
	
	public Producto() {
		
	}
	
	
	
	public Producto(int codigo_pro, String nombre, Double precio, int iva, String url_imagen, String descripcion, String estado) {
		super();
		this.codigo_pro = codigo_pro;
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
		this.url_imagen = url_imagen;
		this.descripcion = descripcion;
		this.estado = estado;
	}



	public int getCodigo_pro() {
		return codigo_pro;
	}
	public void setCodigo_pro(int codigo_pro) {
		this.codigo_pro = codigo_pro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public String getUrl_imagen() {
		return url_imagen;
	}
	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "Producto [codigo_pro=" + codigo_pro + ", nombre=" + nombre + ", precio=" + precio + ", iva=" + iva
				+ ", url_imagen=" + url_imagen + ", descripcion=" + descripcion + "]";
	}
	
}
