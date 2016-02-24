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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="propuesto3_temporada")
public class Temporada implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_temporada",nullable=false)
	private Long id;
	
	private int inicio;
	private int fin;
	
	@ManyToMany(mappedBy="temporadas",
			cascade={CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH})
	private Set<Piloto> pilotos= new HashSet<Piloto>();
	
	public Temporada() {
	}
	
	public Temporada(int inicio,int fin) {
		this.inicio=inicio;
		this.fin=fin;
	}
	
	public void addPiloto(Piloto p){
		pilotos.add(p);
		p.getTemporadas().add(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public Set<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(Set<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	
	

}
