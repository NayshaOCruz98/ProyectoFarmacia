package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the comprasproveedores database table.
 * 
 */
@Entity
@Table(name="comprasproveedores")
@NamedQuery(name="Comprasproveedore.findAll", query="SELECT c FROM Comprasproveedore c")
public class Comprasproveedore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cantidad;

	@Temporal(TemporalType.DATE)
	private Date fechaCompra;

	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to Proveedore
	@ManyToOne
	@JoinColumn(name="Proveedor_ID")
	private Proveedore proveedore;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="Producto_ID")
	private Producto producto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Usuario_ID")
	private Usuario usuario;

	public Comprasproveedore() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Proveedore getProveedore() {
		return this.proveedore;
	}

	public void setProveedore(Proveedore proveedore) {
		this.proveedore = proveedore;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}