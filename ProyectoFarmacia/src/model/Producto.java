package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int producto_ID;

	private int cantidad;

	@Temporal(TemporalType.DATE)
	private Date fechaFabri;

	@Temporal(TemporalType.DATE)
	private Date fechaVenci;

	private String nombre;

	private BigDecimal precio;

	//bi-directional many-to-one association to Comprasproveedore
	@OneToMany(mappedBy="producto")
	private List<Comprasproveedore> comprasproveedores;

	//bi-directional many-to-one association to Detalleventa
	@OneToMany(mappedBy="producto")
	private List<Detalleventa> detalleventas;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="EstadoID")
	private Estado estado;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="Categoria_ID")
	private Categoria categoria;

	//bi-directional many-to-one association to Proveedore
	@ManyToOne
	@JoinColumn(name="Proveedor_ID")
	private Proveedore proveedore;

	public Producto() {
	}

	public int getProducto_ID() {
		return this.producto_ID;
	}

	public void setProducto_ID(int producto_ID) {
		this.producto_ID = producto_ID;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaFabri() {
		return this.fechaFabri;
	}

	public void setFechaFabri(Date fechaFabri) {
		this.fechaFabri = fechaFabri;
	}

	public Date getFechaVenci() {
		return this.fechaVenci;
	}

	public void setFechaVenci(Date fechaVenci) {
		this.fechaVenci = fechaVenci;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Comprasproveedore> getComprasproveedores() {
		return this.comprasproveedores;
	}

	public void setComprasproveedores(List<Comprasproveedore> comprasproveedores) {
		this.comprasproveedores = comprasproveedores;
	}

	public Comprasproveedore addComprasproveedore(Comprasproveedore comprasproveedore) {
		getComprasproveedores().add(comprasproveedore);
		comprasproveedore.setProducto(this);

		return comprasproveedore;
	}

	public Comprasproveedore removeComprasproveedore(Comprasproveedore comprasproveedore) {
		getComprasproveedores().remove(comprasproveedore);
		comprasproveedore.setProducto(null);

		return comprasproveedore;
	}

	public List<Detalleventa> getDetalleventas() {
		return this.detalleventas;
	}

	public void setDetalleventas(List<Detalleventa> detalleventas) {
		this.detalleventas = detalleventas;
	}

	public Detalleventa addDetalleventa(Detalleventa detalleventa) {
		getDetalleventas().add(detalleventa);
		detalleventa.setProducto(this);

		return detalleventa;
	}

	public Detalleventa removeDetalleventa(Detalleventa detalleventa) {
		getDetalleventas().remove(detalleventa);
		detalleventa.setProducto(null);

		return detalleventa;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedore getProveedore() {
		return this.proveedore;
	}

	public void setProveedore(Proveedore proveedore) {
		this.proveedore = proveedore;
	}

}