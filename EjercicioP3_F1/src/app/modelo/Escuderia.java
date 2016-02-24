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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="propuesto3_escuderia")
public class Escuderia implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_escuderia",nullable=false)
	private Long id;
	
	private String nombre;
	private String pais;
	
	@OneToMany(mappedBy="escuderia",cascade=CascadeType.ALL)
	private Set<Piloto> pilotos = new HashSet<Piloto>();
	
	public Escuderia() {
	}
	
	public Escuderia(String nombre,String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public void addPilotos(Piloto p){
		pilotos.add(p);
		p.setEscuderia(this);
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(Set<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	
	
}
