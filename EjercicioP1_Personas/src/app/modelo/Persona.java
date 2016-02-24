package app.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="personas")
@NamedQueries({
    @NamedQuery(name="todas",
                query="select p from Persona p" ),
    @NamedQuery(name="ordenadas",
                query="select p from Persona p ORDER BY p.codigo DESC" )
})
public class Persona implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_persona",nullable=false)
	private Long codigo;
	@Column(length=70)
	private String nombre;
	@Column(length=10)
	private String dni;
	
	
	public Persona() {
	}

	public Persona(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombre=" + nombre + ", dni="
				+ dni + "]";
	}
}
