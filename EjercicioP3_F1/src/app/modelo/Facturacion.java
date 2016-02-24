package app.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="propuesto3_facturacion")
public class Facturacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_facturacion",nullable=false)
	private Long id;
	
	private int sueldo;
	private int publicidad;
	
	@OneToOne(mappedBy="facturacion") // igual que en la entidad Piloto
	Piloto piloto;


	public Facturacion(int sueldo, int publicidad) {
		this.sueldo = sueldo;
		this.publicidad = publicidad;
	}

	public Facturacion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getPublicidad() {
		return publicidad;
	}

	public void setPublicidad(int publicidad) {
		this.publicidad = publicidad;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + publicidad;
		result = prime * result + sueldo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facturacion other = (Facturacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (publicidad != other.publicidad)
			return false;
		if (sueldo != other.sueldo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Facturacion [id=" + id + ", sueldo=" + sueldo + ", publicidad="
				+ publicidad + ", piloto=" + piloto + "]";
	}
	
}
