package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="propuesto3_piloto")
public class Piloto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_piloto",nullable=false)
	private Long id;
	
	private String nombre;
	private int edad;
	
	@OneToOne(cascade=CascadeType.ALL)//cascade en entidad propietaria
    @JoinColumn(name="facturacion_id",referencedColumnName="id_facturacion")
	private Facturacion facturacion;
	
	@OneToOne(cascade=CascadeType.ALL)//cascade en entidad propietaria
    @JoinColumn(name="nif_id",referencedColumnName="id_nif")
	private Nif nif;
	
	@ManyToOne
	@JoinColumn(name="escuderia_id",referencedColumnName="id_escuderia")
	private Escuderia escuderia;
	
	@OneToMany(mappedBy="piloto",cascade=CascadeType.ALL)
	private Set<Telefono> telefonos = new HashSet<Telefono>();
	
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="propuesto3_pilotos_temporadas",
				joinColumns=@JoinColumn(name="piloto_id",
										referencedColumnName="id_piloto"),
				inverseJoinColumns=@JoinColumn(name="temporada_id",
										referencedColumnName="id_temporada"))
	
	private Set<Temporada> temporadas = new HashSet<Temporada>();

	public Piloto() {
	}
	
	public void addTemporada(Temporada t){
		temporadas.add(t);
		t.getPilotos().add(this);
	}
	
	public void addTelefono(Telefono t){
		telefonos.add(t);
		t.setPiloto(this);
	}
	
	public Piloto(String nombre, int edad, Facturacion facturacion,
			Nif nif) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.facturacion = facturacion;
		this.nif = nif;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Facturacion getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}

	public Nif getNif() {
		return nif;
	}

	public void setNif(Nif nif) {
		this.nif = nif;
	}

	public Escuderia getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(Escuderia escuderia) {
		this.escuderia = escuderia;
	}

	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Set<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Set<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Piloto other = (Piloto) obj;
		if (edad != other.edad)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piloto [id=" + id + ", nombre=" + nombre + ", edad=" + edad
				+ ", facturacion=" + facturacion + ", nif=" + nif
				+ ", escuderia=" + escuderia + ", telefonos=" + telefonos
				+ ", temporadas=" + temporadas + "]";
	}

	
}
