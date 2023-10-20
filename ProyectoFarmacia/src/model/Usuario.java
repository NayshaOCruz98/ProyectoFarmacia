package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int usuario_ID;

	private String contraseña;

	private String nombreUsuario;

	//bi-directional many-to-one association to Comprasproveedore
	@OneToMany(mappedBy="usuario")
	private List<Comprasproveedore> comprasproveedores;

	public Usuario() {
	}

	public int getUsuario_ID() {
		return this.usuario_ID;
	}

	public void setUsuario_ID(int usuario_ID) {
		this.usuario_ID = usuario_ID;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Comprasproveedore> getComprasproveedores() {
		return this.comprasproveedores;
	}

	public void setComprasproveedores(List<Comprasproveedore> comprasproveedores) {
		this.comprasproveedores = comprasproveedores;
	}

	public Comprasproveedore addComprasproveedore(Comprasproveedore comprasproveedore) {
		getComprasproveedores().add(comprasproveedore);
		comprasproveedore.setUsuario(this);

		return comprasproveedore;
	}

	public Comprasproveedore removeComprasproveedore(Comprasproveedore comprasproveedore) {
		getComprasproveedores().remove(comprasproveedore);
		comprasproveedore.setUsuario(null);

		return comprasproveedore;
	}

}