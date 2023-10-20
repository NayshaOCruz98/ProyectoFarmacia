package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalleventas database table.
 * 
 */
@Entity
@Table(name="detalleventas")
@NamedQuery(name="Detalleventa.findAll", query="SELECT d FROM Detalleventa d")
public class Detalleventa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cantidad;

	private BigDecimal precioUnitario;

	private BigDecimal subtotal;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="Venta_ID")
	private Venta venta;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="Producto_ID")
	private Producto producto;

	public Detalleventa() {
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

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}