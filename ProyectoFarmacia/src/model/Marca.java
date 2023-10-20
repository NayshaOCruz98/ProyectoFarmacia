package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int marcaId;

	private String descripcionMarca;

	private int estadoID;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	public Marca() {
	}

	public int getMarcaId() {
		return this.marcaId;
	}

	public void setMarcaId(int marcaId) {
		this.marcaId = marcaId;
	}

	public String getDescripcionMarca() {
		return this.descripcionMarca;
	}

	public void setDescripcionMarca(String descripcionMarca) {
		this.descripcionMarca = descripcionMarca;
	}

	public int getEstadoID() {
		return this.estadoID;
	}

	public void setEstadoID(int estadoID) {
		this.estadoID = estadoID;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}