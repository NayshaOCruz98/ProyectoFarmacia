package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedores database table.
 * 
 */
@Entity
@Table(name="proveedores")
@NamedQuery(name="Proveedore.findAll", query="SELECT p FROM Proveedore p")
public class Proveedore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int proveedor_ID;

	private String direccion;

	private String email;

	private String nombreCompania;

	private String nombreContacto;

	private String telefono;

	//bi-directional many-to-one association to Comprasproveedore
	@OneToMany(mappedBy="proveedore")
	private List<Comprasproveedore> comprasproveedores;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="proveedore")
	private List<Producto> productos;

	public Proveedore() {
	}

	public int getProveedor_ID() {
		return this.proveedor_ID;
	}

	public void setProveedor_ID(int proveedor_ID) {
		this.proveedor_ID = proveedor_ID;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreCompania() {
		return this.nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Comprasproveedore> getComprasproveedores() {
		return this.comprasproveedores;
	}

	public void setComprasproveedores(List<Comprasproveedore> comprasproveedores) {
		this.comprasproveedores = comprasproveedores;
	}

	public Comprasproveedore addComprasproveedore(Comprasproveedore comprasproveedore) {
		getComprasproveedores().add(comprasproveedore);
		comprasproveedore.setProveedore(this);

		return comprasproveedore;
	}

	public Comprasproveedore removeComprasproveedore(Comprasproveedore comprasproveedore) {
		getComprasproveedores().remove(comprasproveedore);
		comprasproveedore.setProveedore(null);

		return comprasproveedore;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setProveedore(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setProveedore(null);

		return producto;
	}

}