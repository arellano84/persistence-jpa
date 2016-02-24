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
@Table(name="propuesto3_nif")
public class Nif implements Serializable{
	
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_nif",nullable=false)
	private Long id;
	
	private char letra;
	private long numero;
	
	@OneToOne(mappedBy="nif") // igual que en la entidad Piloto
	Piloto p;
	
	public Nif(char letra, long numero) {
		this.letra = letra;
		this.numero = numero;
	}
	
	
	public Nif() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + letra;
		result = prime * result + (int) (numero ^ (numero >>> 32));
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
		Nif other = (Nif) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (letra != other.letra)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Nif [id=" + id + ", letra=" + letra + ", numero=" + numero
				+ "]";
	}
	
}
