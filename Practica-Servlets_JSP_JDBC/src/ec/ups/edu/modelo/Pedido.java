package ec.ups.edu.modelo;

import java.io.Serializable;

public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo_pedido;
	private String estado;
	private int cantidad;
	private Double total;
	private Producto producto;
	private Usuario usuario;
	private int codUsu;
	private int codPro;
	
	public Pedido() {
		producto = new Producto();
		usuario = new Usuario();
	}
	
	

	public Pedido(int codigo_pedido, String estado, int cantidad, Double total) {
		super();
		this.codigo_pedido = codigo_pedido;
		this.estado = estado;
		this.cantidad = cantidad;
		this.total = total;
		this.producto = new Producto();
		this.usuario = new Usuario();
	}

	
	
	
	public Pedido(int codigo_pedido, String estado, int cantidad, Double total, int producto, int usuario) {
		super();
		this.codigo_pedido = codigo_pedido;
		this.estado = estado;
		this.cantidad = cantidad;
		this.total = total;
		this.codUsu = producto;
		this.codPro = usuario;
	}

	


	public int getCodUsu() {
		return codUsu;
	}



	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}



	public int getCodPro() {
		return codPro;
	}



	public void setCodPro(int codPro) {
		this.codPro = codPro;
	}



	public double calculoTotal(double c, double p) {
		return c*p;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public double CalcularTotal(int cantidad, double precio) {
		return cantidad*precio;
	}

	@Override
	public String toString() {
		return "Pedido [codigo_pedido=" + codigo_pedido + ", estado=" + estado + ", cantidad=" + cantidad + ", total="
				+ total + ", producto=" + producto + ", usuario=" + usuario + "]";
	}	
}
